package com.pt.flights.price.app.dev.job;

import com.pt.flights.price.app.dev.controller.CurrencyExchangeController;
import com.pt.flights.price.app.dev.model.JobDate;
import com.pt.flights.price.app.dev.model.ThirdTaskParameter;
import com.pt.flights.price.app.dev.properties.PropertiesConfiguration;
import com.pt.flights.price.app.util.others.Common;
import com.pt.flights.price.app.util.others.EnumUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class JobStart {

    private final static Logger LOGGER = java.util.logging.Logger.getLogger(JobStart.class.getName());

    @Autowired
    private Common common;
    @Autowired
    private JobCommon jobCommon;
    @Autowired
    private PropertiesConfiguration properties;
    @Autowired
    private JobCombinationFlight flight;
    @Autowired
    private CurrencyExchangeController currency;

    private final int DOLLAR = Integer.parseInt(EnumUtil.DOLLAR_OPTION.getKeyValue());
    private final int REAL = Integer.parseInt(EnumUtil.REAL_OPTION.getKeyValue());


    /**
     * Thread to get jobs by day.
     * @return
     * @throws Exception
     */
    public List<JobDate> firstTask() throws Exception {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        List<JobDate> scheduleByDays =  new ArrayList<>();
        Future<List<JobDate>> future = executorService.submit(() -> jobCommon.getJobsByDay(countDownLatch));
        if ( !future.get().isEmpty() ) 
            scheduleByDays = future.get();             
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            LOGGER.log(Level.SEVERE, e.toString());
        } finally {
            executorService.shutdown();
            return scheduleByDays;
        }
    }

    /**
     * With date interval. Build a index interval to get values from list.
     * @param total
     * @param percentage
     * @return Set List With List Interval Integer.
     * @throws Exception
     */
    public Set<List<Integer>> secondTask(double total, double percentage) throws Exception {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Set<List<Integer>> indexSet = new HashSet();
        Future<Set<List<Integer>>> future = executorService.submit(() -> jobCommon.getFirstAndSecondIndex(total, percentage, countDownLatch));
        if ( !future.get().isEmpty() ) 
            indexSet = future.get();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            LOGGER.log(Level.SEVERE, e.toString());
        } finally {
            executorService.shutdown();
            return indexSet;
        }
    }

    /**
     * Currency exchange. Used to save Real and Dollar flight prices. The number of tasks is created with half value
     * from the index list. After the system will search on SkyScanner API.
     * @param indexSet
     * @param jobDates
     * @throws InterruptedException
     */
    public void thirdTask(Set<List<Integer>> indexSet, List<JobDate> jobDates) throws InterruptedException {
        List<Float> currencyList = null;
        try {
            currencyList = currency.currencyExchange();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.toString());
        }
        int nThreads = indexSet.size() / 2;
        ExecutorService executorService = Executors.newFixedThreadPool(nThreads);
        Iterator<List<Integer>> iterator = indexSet.iterator();
        while (iterator.hasNext()) {
            List<Integer> indexList = iterator.next();
            int firstIndex = indexList.get(0);
            int lastIndex = indexList.get(1);
            float dollar = currencyList.get(DOLLAR);
            float real   = currencyList.get(REAL);
            ThirdTaskParameter thirdTaskParameter = new ThirdTaskParameter(firstIndex, lastIndex, jobDates, dollar, real);
            flight.jobCombinationFlight(thirdTaskParameter);
            executorService.submit(()->flight);
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            LOGGER.log(Level.SEVERE, e.toString());
        }
    }

    /**
     * Start process to find flight prices
     * @throws Exception
     */
    public void startProcess() throws Exception {
        synchronized (this) {
            List<JobDate> jobDates = firstTask();
            if (!jobDates.isEmpty()) {
                double percentage = Double.parseDouble(String.valueOf(properties.getGenericProperties(EnumUtil.PERCENTAGE_THREAD.getKeyValue())));
                Set<List<Integer>> indexSet = secondTask(jobDates.size(), percentage);
                if (!indexSet.isEmpty()) {
                    thirdTask(indexSet, jobDates);
                }
            }
        }
    }
}

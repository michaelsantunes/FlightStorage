package com.pt.flights.price.app.dev.job;

import com.pt.flights.price.app.dev.interfaces.JobCombinationFlightInterface;
import com.pt.flights.price.app.dev.model.CombinationFlight;
import com.pt.flights.price.app.dev.model.JobDate;
import com.pt.flights.price.app.dev.model.ThirdTaskParameter;
import com.pt.flights.price.app.dev.service.CombinationFlightImp;
import com.pt.flights.price.app.dev.service.SkyScannerPriceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class JobCombinationFlight implements JobCombinationFlightInterface {

    private final static Logger LOGGER = java.util.logging.Logger.getLogger(JobStart.class.getName());

    @Autowired
    private CombinationFlightImp flight;

    @Autowired
    private SkyScannerPriceImp skyScannerPriceImp;

    @Autowired
    private CombinationFlightImp combinationFlight;

    private List<Long> integerList = new ArrayList<>();

    private List<Long> longs = new ArrayList<>();

    /**
     * With interval index, get date from this interval to used with filter in skyscanner api.
     * @param parameter
     */
    @Override
    public void jobCombinationFlight(ThirdTaskParameter parameter) {
        int nThreads = (parameter.getLastIndex() - parameter.getFirstIndex()) / 2;
        ExecutorService executorService = Executors.newFixedThreadPool(nThreads);
        for ( int i = parameter.getFirstIndex(); i <= parameter.getLastIndex(); i++) {
            JobDate jobDate = parameter.getJobDateList().get(i);
            ThirdTaskParameter thirdTaskParameter = new ThirdTaskParameter(jobDate,parameter.getDollar(),parameter.getReal());
            executorService.submit(()-> findCombinationFlight(thirdTaskParameter));
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
        } catch (InterruptedException ex) {
            LOGGER.log(Level.SEVERE, ex.toString());
        }
    }

    /**
     * Start process to search in SkyScanner API
     * @param thirdTaskParameter
     */
    public synchronized void findCombinationFlight(ThirdTaskParameter thirdTaskParameter) {
        List<CombinationFlight> flightList = new ArrayList<>();
        Date d1 = java.sql.Date.valueOf(thirdTaskParameter.getJobDate().getInitialRange());
        Date d2 = java.sql.Date.valueOf(thirdTaskParameter.getJobDate().getFinalRange());
        flightList = combinationFlight.findCombinationFlightByInitialAndFinalDate(d1, d2);
        int countDown = 0;
        for (CombinationFlight combinationFlight : flightList ) {
            try {
                skyScannerPriceImp.getMainParameter(combinationFlight, thirdTaskParameter);
                skyScannerPriceImp.getPriceAndSave();
                countDown++;
                //countdown to avoid many API access
                if ( countDown % 100 == 0 ) {
                    System.out.println("COUNT DOWN " + countDown);
                    TimeUnit.MINUTES.sleep(3);
                }
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, e.toString());
            }
        }
    }
}
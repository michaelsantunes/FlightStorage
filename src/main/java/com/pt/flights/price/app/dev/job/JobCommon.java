package com.pt.flights.price.app.dev.job;


import com.pt.flights.price.app.dev.model.JobDate;
import com.pt.flights.price.app.util.others.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class JobCommon {

    @Autowired
    private JobListDate jobDate;
    @Autowired
    private Common common;

    private final static Logger LOGGER = java.util.logging.Logger.getLogger(JobCommon.class.getName());

    /**
     * Build job date day to find flights prices
     * @param countDownLatch
     * @return
     */
    public synchronized List<JobDate> getJobsByDay(CountDownLatch countDownLatch) {
        List<JobDate> list = new ArrayList<>();
        boolean _wait = true;
        try {
            int count = 0;
            while ( _wait ) {
                list = jobDate.createIntervalDate();
                TimeUnit.SECONDS.sleep(3);
                count++;
                if ( !list.isEmpty() || count == 10 ) {
                    _wait = false;
                }
            }
            countDownLatch.countDown();
        } catch (Exception e ) {
            LOGGER.log(Level.SEVERE, e.toString());
        }
        
         return list;
    }

    /**
     * Get List Index to use with filter in date list
     * @param totalList
     * @param percentage
     * @param countDownLatch
     * @return Set with List Integer
     * @throws Exception
     */
    public synchronized Set<List<Integer>> getFirstAndSecondIndex(double totalList, double percentage, CountDownLatch countDownLatch) throws Exception {
        int indexInitial = 0;
        int indexFinal   = (int) totalList;
        if ( totalList > percentage ) {
            double result = common.getPercentage(percentage, totalList);
            indexFinal    = (int) Math.round(totalList / result);
        }
        Set<List<Integer>> integerListHashMap = new HashSet<>();
        while ( totalList >= indexFinal ) {
            integerListHashMap.add(new ArrayList(Arrays.asList(indexInitial, indexFinal-1)));
            indexInitial = indexFinal;
            if ( totalList > (indexInitial * 2)) {
                indexFinal = indexFinal * 2;
            } else if ( indexFinal < totalList) {
                indexFinal = (int) totalList;
            } else {
                indexFinal++;
            }
            countDownLatch.countDown();
        }

        return integerListHashMap;
    }
}

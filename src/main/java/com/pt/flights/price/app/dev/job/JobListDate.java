package com.pt.flights.price.app.dev.job;

import com.pt.flights.price.app.dev.model.CombinationFlight;
import com.pt.flights.price.app.dev.model.JobDate;
import com.pt.flights.price.app.dev.properties.PropertiesConfiguration;
import com.pt.flights.price.app.dev.service.CombinationFlightImp;
import com.pt.flights.price.app.util.dates.DateOption;
import com.pt.flights.price.app.util.others.EnumUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class JobListDate {

    private final static Logger LOGGER = Logger.getLogger(JobListDate.class.getName());

    @Autowired
    private CombinationFlightImp combinationFlightImplements;
    @Autowired
    private PropertiesConfiguration propertiesConfiguration;

    /**
     * Build day interval. This method create a date interval list that will by used to filter.
     * number of days = 4
     * first date: 2019-01-01 last date 2019-01-05
     * first date: 2019-01-05 last date 2019-01-09
     * n  times..
     * and finally, last date.
     *
     * @return List type JobDate
     */
    public List<JobDate> createIntervalDate() {
        List<JobDate> scheduleByDays = null;
        try {
            //Get first and last date to build interval
            List<CombinationFlight> flightList = combinationFlightImplements.findByDateFirstAndLastEntityByCombinationFlight(new Date());
            if (flightList == null || flightList.isEmpty()) {
                throw new Exception("Combination Flight Date Not Found");
            }
            scheduleByDays = new ArrayList<>();
            //first date >= NOW()
            Date dateOne = flightList.get(0).getInitialDate();
            //number of days to increase to last date.
            int numberOfDays = Integer.parseInt(String.valueOf(propertiesConfiguration.getGenericProperties(EnumUtil.INTERVAL_BETWEEN_DATES_TO_SEARCH.getKeyValue())));
            DateOption option = new DateOption(dateOne, numberOfDays);
            Date dateTwo = new Date(option.increaseDate().getTime());
            Date maxDate = flightList.get(1).getFinalDate();
            long countOrder = 1;
            boolean maxVerification = false;
            while (maxDate.getTime() >= dateTwo.getTime()) {
                JobDate scheduleByDay = new JobDate(countOrder,
                        dateOne.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                        dateTwo.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                scheduleByDays.add(scheduleByDay);
                ++countOrder;
                option = new DateOption(dateTwo, numberOfDays);
                dateOne = new Date(option.getDateValue().getTime());
                dateTwo = new Date(option.increaseDate().getTime());
                if (dateTwo.getTime() > maxDate.getTime() && maxVerification == false) {
                    dateTwo.setTime(maxDate.getTime());
                    maxVerification = true;
                }
            }
            Collections.sort(scheduleByDays, Comparator.comparing(JobDate::getIdScheduleByDay));
            return scheduleByDays;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.toString());
        }
        
        return null;
    }
}

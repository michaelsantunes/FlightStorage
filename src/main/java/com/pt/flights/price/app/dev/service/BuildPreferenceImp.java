package com.pt.flights.price.app.dev.service;

import com.pt.flights.price.app.dev.model.AirPort;
import com.pt.flights.price.app.dev.model.CombinationFlight;
import com.pt.flights.price.app.dev.model.EmailCombination;
import com.pt.flights.price.app.util.dates.*;
import com.pt.flights.price.app.util.others.IataDefault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class BuildPreferenceImp {

    private final static Logger LOGGER = Logger.getLogger(BuildPreferenceImp.class.getName());

    @Autowired
    AirPortImp airPortImplements;
    @Autowired
    CombinationFlightImp combinationFlightImplements;
    @Autowired
    IataDefault iataDefault;

    /**
     * Creating a flight preference list between initial date and final date. Current date more one year.
     *
     * @return HashSet DateCombination Model
     */
    public Set<DateToCombination> preferenceListDate() {
        Set<DateToCombination> toCombinationList = new HashSet<>();
        Date initialDate = new Date();
        Date finalDate = new Date();
        DateCommon dateCommon = new DateCommon(365, initialDate);
        Date maxDate = new Date(dateCommon.increaseDate().getTime());
        int addDay = 0;
        try {
            while (finalDate.getTime() <= maxDate.getTime()) {
                DateToCombination combination;
                do {
                    combination = preferenceDate(initialDate, addDay);
                    addDay++;
                } while (combination == null);
                toCombinationList.add(combination);
                finalDate = new Date(combination.getFinalDate().getTime());
                initialDate = new Date(combination.getInitialDate().getTime());
                addDay = 1;
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.toString());
        }
        return toCombinationList;
    }

    /**
     * Receive a initial date and verify if this date is in specific day of week. Depending of day the method increase
     * one by one until you find the specific day.
     *
     * @param dateValue
     * @param increaseDay
     * @return
     */
    public DateToCombination preferenceDate(Date dateValue, int increaseDay) {
        DateCommon dateCommon = new DateCommon(increaseDay, dateValue);
        dateValue = new Date(dateCommon.increaseDate().getTime());
        int day = new DateCommon(dateValue).getNumberDayByDate();
        DateToBuildPreference dateToBuildPreference;
        switch (day) {
            case Calendar.SUNDAY:
                dateToBuildPreference = new Sunday(dateValue, day, 7);
                break;
            case Calendar.MONDAY:
                dateToBuildPreference = new Monday(dateValue, day, 6);
                break;
            case Calendar.WEDNESDAY:
                dateToBuildPreference = new Wednesday(dateValue, day, 4);
                break;
            case Calendar.THURSDAY:
                dateToBuildPreference = new Thursday(dateValue, day, 3);
                break;
            case Calendar.FRIDAY:
                dateToBuildPreference = new Friday(dateValue, day, 3);
                break;
            case Calendar.SATURDAY:
                dateToBuildPreference = new Saturday(dateValue, day, 8);
                break;
            default:
                return null;
        }

        return (dateToBuildPreference != null) ? dateToBuildPreference.getDateToCombination() : null;
    }

    /**
     * build flight preferences and save in database
     */
    public void flightPreference() {
        try {
            List<AirPort> airPorts = airPortImplements.findByPersonalPreferenceIsTrue();
            Set<DateToCombination> dateToCombinations = preferenceListDate();
            AirPort airPortDefault = iataDefault.getAirPort();
            for (AirPort airPort : airPorts) {
                for (DateToCombination dateToCombination : dateToCombinations) {
                    CombinationFlight combinationFlight = new CombinationFlight();
                    combinationFlight.setInitialDate(dateToCombination.getInitialDate());
                    combinationFlight.setFinalDate(dateToCombination.getFinalDate());
                    combinationFlight.setWeekDayInitial(dateToCombination.getInitialDay().substring(0, 2));
                    combinationFlight.setWeekDayFinal(dateToCombination.getFinalDay().substring(0, 2));
                    combinationFlight.setAirPortFrom(airPortDefault);
                    combinationFlight.setAirPortTo(airPort);
                    EmailCombination emailCombination = new EmailCombination("michaelsantunes@gmail.com");
                    emailCombination.setCombinationFlight(combinationFlight);
                    List<EmailCombination> emailCombinations = new ArrayList<EmailCombination>(Arrays.asList(emailCombination));
                    combinationFlight.setEmailCombinations(emailCombinations);
                    combinationFlightImplements.save(combinationFlight);
                }
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.toString());
        }
    }
}

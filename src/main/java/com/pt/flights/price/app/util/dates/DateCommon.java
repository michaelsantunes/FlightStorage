package com.pt.flights.price.app.util.dates;

import java.util.Calendar;
import java.util.Date;

public class DateCommon {

    private int numberOfDays;
    private Date dateValue;

    public DateCommon(int numberOfDays, Date dateValue) {
        this.numberOfDays = numberOfDays;
        this.dateValue = dateValue;
    }

    public DateCommon(Date dateValue) {
        this.dateValue = dateValue;
    }

    public Date increaseDate() {
        Calendar calendarIncrease = Calendar.getInstance();
        calendarIncrease.setTime(this.dateValue);
        calendarIncrease.add(Calendar.DATE, this.numberOfDays);
        return calendarIncrease.getTime();
    }

    public String getNameDayByDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.dateValue);
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        return days[calendar.get(Calendar.DAY_OF_WEEK) - 1];
    }

    public int getNumberDayByDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.dateValue);
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

}

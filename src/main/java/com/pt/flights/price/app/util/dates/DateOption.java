package com.pt.flights.price.app.util.dates;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateOption {

    private int day;
    private String dayName;
    private Calendar calendar;
    private Date dateValue;
    private int numberOfDays;
    private String pattern;
    private DateOption optionForDate;


    public DateOption() {
    }

    public DateOption(Calendar calendar) {
        this.calendar = calendar;
    }

    public DateOption(int day, String dayName) {
        this.day = day;
        this.dayName = dayName;
    }

    public DateOption(Date dateValue, int numberOfDays) {
        this.dateValue = dateValue;
        this.numberOfDays = numberOfDays;
    }

    public DateOption(Calendar calendar, String pattern) {
        this.calendar = calendar;
        this.pattern = pattern;
    }

    public String shortName() {
        return this.dayName.substring(0,2);
    }

    public Date increaseDate() {
        Calendar calendarIncrease = Calendar.getInstance();
        calendarIncrease.setTime(this.dateValue);
        calendarIncrease.add(Calendar.DATE, this.numberOfDays);
        return calendarIncrease.getTime();
    }

    public DateOption(DateOption optionForDate) {
        this.optionForDate = optionForDate;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public DateOption getOptionForDate() {
        return optionForDate;
    }

    public void setOptionForDate(DateOption optionForDate) {
        this.optionForDate = optionForDate;
    }

    public String formateDate() {
        return new SimpleDateFormat(this.pattern).format(this.calendar.getTime());
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public Date getDateValue() {
        return dateValue;
    }

    public void setDateValue(Date dateValue) {
        this.dateValue = dateValue;
    }
}

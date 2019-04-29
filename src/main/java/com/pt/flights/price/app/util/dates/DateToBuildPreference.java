package com.pt.flights.price.app.util.dates;

import java.util.Date;

public class DateToBuildPreference {
    private Date dateValue;
    private int  dayNumber;
    private int  numberOfDays;
    private DateToCombination dateToCombination;

    public DateToBuildPreference(Date dateValue, int dayNumber, int numberOfDays) {
        this.dateValue    = dateValue;
        this.dayNumber    = dayNumber;
        this.numberOfDays = numberOfDays;
    }

    public void setDateToCombination(DateToCombination dateToCombination) {
        this.dateToCombination = dateToCombination;
    }

    public DateToCombination getDateToCombination() {
        DateCommon dateCommon           = new DateCommon(this.numberOfDays, this.dateValue);
        Date initialDate                = this.dateValue;
        Date finalDate                  = dateCommon.increaseDate();
        String initialDay               = dateCommon.getNameDayByDate();
        String finalDay                 = new DateCommon(finalDate).getNameDayByDate();
        DateToCombination combination   = new DateToCombination(initialDate, finalDate, initialDay, finalDay);
        this.setDateToCombination(combination);

        return dateToCombination;
    }
}

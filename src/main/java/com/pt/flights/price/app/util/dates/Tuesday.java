package com.pt.flights.price.app.util.dates;

import java.util.Date;

public class Tuesday extends DateToBuildPreference {
    public Tuesday(Date dateValue, int dayNumber, int numberOfDays) {
        super(dateValue, dayNumber, numberOfDays);
    }

    @Override
    public DateToCombination getDateToCombination() {
        return super.getDateToCombination();
    }
}

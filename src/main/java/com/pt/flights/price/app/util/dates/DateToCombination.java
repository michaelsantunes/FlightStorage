package com.pt.flights.price.app.util.dates;

import java.util.Date;

public class DateToCombination {

    private Date initialDate;
    private Date finalDate;
    private String initialDay;
    private String finalDay;

    public DateToCombination() {
    }

    public DateToCombination(Date initialDate, Date finalDate, String initialDay, String finalDay) {
        this.initialDate = initialDate;
        this.finalDate = finalDate;
        this.initialDay = initialDay;
        this.finalDay = finalDay;
    }

    public Date getInitialDate() {
        return initialDate;
    }

    public Date getFinalDate() {
        return finalDate;
    }

    public String getInitialDay() {
        return initialDay;
    }

    public String getFinalDay() {
        return finalDay;
    }
}

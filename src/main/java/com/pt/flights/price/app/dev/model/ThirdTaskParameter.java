package com.pt.flights.price.app.dev.model;

import java.util.List;

public class ThirdTaskParameter {
    int firstIndex;
    int lastIndex;
    List<JobDate> jobDateList;
    JobDate jobDate;
    float dollar;
    float real;


    public ThirdTaskParameter(int firstIndex, int lastIndex, List<JobDate> jobDateList, float dollar, float real) {
        this.firstIndex = firstIndex;
        this.lastIndex = lastIndex;
        this.jobDateList = jobDateList;
        this.dollar = dollar;
        this.real = real;
    }

    public ThirdTaskParameter(JobDate jobDate, float dollar, float real) {
        this.jobDate = jobDate;
        this.dollar = dollar;
        this.real = real;
    }

    public int getFirstIndex() {
        return firstIndex;
    }

    public int getLastIndex() {
        return lastIndex;
    }

    public List<JobDate> getJobDateList() {
        return jobDateList;
    }

    public JobDate getJobDate() {
        return jobDate;
    }

    public float getDollar() {
        return dollar;
    }

    public float getReal() {
        return real;
    }
}

package com.pt.flights.price.app.dev.model;

import java.io.Serializable;

public class GenericFlightModel implements Serializable {

    private Long combinationId;
    private String iataFrom;
    private String iataTo;
    private SkyScanner skyScanner;

    public GenericFlightModel(Long combinationId, String iataFrom, String iataTo, SkyScanner skyScanner) {
        this.combinationId = combinationId;
        this.iataFrom = iataFrom;
        this.iataTo = iataTo;
        this.skyScanner = skyScanner;
    }

    public Long getCombinationId() {
        return combinationId;
    }

    public void setCombinationId(Long combinationId) {
        this.combinationId = combinationId;
    }

    public String getIataFrom() {
        return iataFrom;
    }

    public void setIataFrom(String iataFrom) {
        this.iataFrom = iataFrom;
    }

    public String getIataTo() {
        return iataTo;
    }

    public void setIataTo(String iataTo) {
        this.iataTo = iataTo;
    }

    public SkyScanner getSkyScanner() {
        return skyScanner;
    }

    public void setSkyScanner(SkyScanner skyScanner) {
        this.skyScanner = skyScanner;
    }
}

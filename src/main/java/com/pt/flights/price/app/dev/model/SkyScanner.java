package com.pt.flights.price.app.dev.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SkyScanner {

    @JsonProperty("Quotes")
    public List<SkyScannerQuotes> quotes;

    @JsonProperty("Carriers")
    public List<SkyScannerCarriers> carriers;

    public List<SkyScannerQuotes> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<SkyScannerQuotes> quotes) {
        this.quotes = quotes;
    }

    public List<SkyScannerCarriers> getCarriers() {
        return carriers;
    }

    public void setCarriers(List<SkyScannerCarriers> carriers) {
        this.carriers = carriers;
    }
}

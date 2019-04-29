package com.pt.flights.price.app.dev.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SkyScannerCarriersQuotes {

    @JsonProperty("CarrierIds")
    List<Integer> carrierIds;

    public List<Integer> getCarrierIds() {
        return carrierIds;
    }

    public void setCarrierIds(List<Integer> carrierIds) {
        this.carrierIds = carrierIds;
    }
}

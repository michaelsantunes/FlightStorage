package com.pt.flights.price.app.dev.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SkyScannerCarriers {
    @JsonProperty("CarrierId")
    private Long carrierId;
    @JsonProperty("Name")
    private String name;

    public Long getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(Long carrierId) {
        this.carrierId = carrierId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package com.pt.flights.price.app.dev.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SkyScannerInboundOutbound {

    @JsonProperty("CarrierIds")
    public Object carrierIds;

    public Object getCarrierIds() {
        return carrierIds;
    }

    public void setCarrierIds(Object carrierIds) {
        this.carrierIds = carrierIds;
    }
}

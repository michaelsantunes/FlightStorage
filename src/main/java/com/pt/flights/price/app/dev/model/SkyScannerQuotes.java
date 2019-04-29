package com.pt.flights.price.app.dev.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class SkyScannerQuotes {

    @SerializedName("QuoteId")
    private Long queoteId;
    @JsonProperty("MinPrice")
    private Float miniPrice;
    @JsonProperty("Direct")
    private Boolean direct;
    @JsonProperty("OutboundLeg")
    private SkyScannerCarriersQuotes outboundLeg;
    @JsonProperty("InboundLeg")
    private SkyScannerCarriersQuotes inboundLeg;

    public Long getQueoteId() {
        return queoteId;
    }

    public void setQueoteId(Long queoteId) {
        this.queoteId = queoteId;
    }

    public Float getMiniPrice() {
        return miniPrice;
    }

    public void setMiniPrice(Float miniPrice) {
        this.miniPrice = miniPrice;
    }

    public Boolean getDirect() {
        return direct;
    }

    public void setDirect(Boolean direct) {
        this.direct = direct;
    }

    public SkyScannerCarriersQuotes getOutboundLeg() {
        return outboundLeg;
    }

    public void setOutboundLeg(SkyScannerCarriersQuotes outboundLeg) {
        this.outboundLeg = outboundLeg;
    }

    public SkyScannerCarriersQuotes getInboundLeg() {
        return inboundLeg;
    }

    public void setInboundLeg(SkyScannerCarriersQuotes inboundLeg) {
        this.inboundLeg = inboundLeg;
    }
}

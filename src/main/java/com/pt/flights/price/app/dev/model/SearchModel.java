package com.pt.flights.price.app.dev.model;

import com.pt.flights.price.app.util.others.Common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SearchModel extends Common {

    String country;
    String currency;
    String locale;
    String destination;
    String origen;
    Date outboundPartialDate;
    Date inboundPartialDate;
    String patternDate;
    String apiUsed;

     public void setCountry(String country) {
        this.country = country;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public void setOutboundPartialDate(Date outboundPartialDate) {
        this.outboundPartialDate = outboundPartialDate;
    }

    public void setInboundPartialDate(Date inboundPartialDate) {
        this.inboundPartialDate = inboundPartialDate;
    }

    public void setPatternDate(String patternDate) {
        this.patternDate = patternDate;
    }

    public void setApiUsed(String apiUsed) {
        this.apiUsed = apiUsed;
    }

    public String getCountry() {
        return country;
    }

    public String getCurrency() {
        return currency;
    }

    public String getLocale() {
        return locale;
    }

    public String getDestination() {
        return destination;
    }

    public String getOrigen() {
        return origen;
    }

    public String getPatternDate() {
        return patternDate;
    }

    public String getApiUsed() {
        return apiUsed;
    }


    public String getOutboundPartialDate() {
       return new SimpleDateFormat(getPatternDate()).format(this.outboundPartialDate);
    }

    public String getInboundPartialDate() {
        return new SimpleDateFormat(getPatternDate()).format(this.inboundPartialDate);
    }

}

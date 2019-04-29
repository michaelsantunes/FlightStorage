package com.pt.flights.price.app.dev.model;

public class SkyScannerParameter {

    private String country;
    private String currency;
    private String locale;
    private String destinationPlace;
    private String origenPlace;
    private String outboundPartialDate;
    private String inboundPartialDate;

    public SkyScannerParameter(SearchModel defaultToSearch) {
        this.country = defaultToSearch.getCountry();
        this.currency = defaultToSearch.getCurrency();
        this.locale = defaultToSearch.getLocale();
        this.destinationPlace = defaultToSearch.getDestination();
        this.origenPlace = defaultToSearch.getOrigen();
        this.outboundPartialDate = defaultToSearch.getOutboundPartialDate();
        this.inboundPartialDate = defaultToSearch.getInboundPartialDate();
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

    public String getDestinationPlace() {
        return destinationPlace;
    }

    public String getOrigenPlace() {
        return origenPlace;
    }

    public String getOutboundPartialDate() {
        return outboundPartialDate;
    }

    public String getInboundPartialDate() {
        return inboundPartialDate;
    }
}

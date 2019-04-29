package com.pt.flights.price.app.dev.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pt.flights.price.app.dev.service.AirLineImp;
import com.pt.flights.price.app.dev.service.AirPortImp;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "combination_price")
@SequenceGenerator(name = "combination_price_sequence", sequenceName = "combination_price_seq", initialValue = 1, allocationSize = 1)
public class CombinationPrice implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "combination_price_sequence")
    @Column(name = "id_combination_price")
    @JsonProperty("id_combination")
    private Long idCombinationPrice;

    @Column(name = "euro_price")
    @JsonProperty("euro")
    private Float euroPrice;

    @Column(name = "brl_price")
    @JsonProperty("real")
    private Float realPrice;

    @Column(name = "usd_price")
    @JsonProperty("dollar")
    private Float dollarPrice;

    @Column(name = "exchange_euro_currency")
    @JsonIgnore
    private String exchangeEuroCurrency;     //base value euro. EUR_USD=0,392-EUR_BRL=4,302

    @Column(name = "direct")
    @JsonProperty("direct")
    private Boolean directFlight;

    @Column(name = "flight_number")
    @JsonIgnore
    private String flightFromNumber;

    //inboundpartialdate  - 0  - when you back (from) - outboundpartialdate - 1  - when you go (to)  -
    @Column(name = "origin_destination")
    @JsonIgnore
    private int originDestination;

    @Column(name = "iata_code")
    @JsonIgnore
    private String iataCode;
    //use to group price

    @Column(name = "code_combination")
    @JsonProperty("code_combination")
    private String codeCombination;

    @Column(name = "api")
    @JsonIgnore
    private String api;

    @CreationTimestamp
    @Column(name = "register_date")
    @JsonProperty("register_date_time")
    private LocalDateTime registerDate;


    @ManyToOne
    @JoinColumn(name = "airline_id", foreignKey = @ForeignKey(name = "airline_combination_price_fk"))
    @JsonProperty("airline")
    @JsonManagedReference
    private AirLine airLine;

    @ManyToOne
    @JoinColumn(name = "combination_flight_id", foreignKey = @ForeignKey(name = "combination_flight_combination_price_fk"))
    @JsonProperty("combination_flight")
    @JsonBackReference
    private CombinationFlight combinationFlight;

    public CombinationPrice() {
    }

    public Long getIdCombinationPrice() {
        return idCombinationPrice;
    }

    public void setIdCombinationPrice(Long idCombinationPrice) {
        this.idCombinationPrice = idCombinationPrice;
    }

    public Float getEuroPrice() {
        return euroPrice;
    }

    public void setEuroPrice(Float euroPrice) {
        this.euroPrice = euroPrice;
    }

    public Float getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(Float realPrice) {
        this.realPrice = realPrice;
    }

    public Float getDollarPrice() {
        return dollarPrice;
    }

    public void setDollarPrice(Float dollarPrice) {
        this.dollarPrice = dollarPrice;
    }

    public String getExchangeEuroCurrency() {
        return exchangeEuroCurrency;
    }

    public void setExchangeEuroCurrency(String exchangeEuroCurrency) {
        this.exchangeEuroCurrency = exchangeEuroCurrency;
    }

    public AirLine getAirLine() {
        return airLine;
    }

    public void setAirLine(AirLine airLine) {
        this.airLine = airLine;
    }

    public Boolean getDirectFlight() {
        return directFlight;
    }

    public void setDirectFlight(Boolean directFlight) {
        this.directFlight = directFlight;
    }

    public String getFlightFromNumber() {
        return flightFromNumber;
    }

    public void setFlightFromNumber(String flightFromNumber) {
        this.flightFromNumber = flightFromNumber;
    }

    public int getOriginDestination() {
        return originDestination;
    }

    public void setOriginDestination(int originDestination) {
        this.originDestination = originDestination;
    }

    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    public String getCodeCombination() {
        return codeCombination;
    }

    public void setCodeCombination(String codeCombination) {
        this.codeCombination = codeCombination;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }

    public CombinationFlight getCombinationFlight() {
        return combinationFlight;
    }

    public void setCombinationFlight(CombinationFlight combinationFlight) {
        this.combinationFlight = combinationFlight;
    }
}


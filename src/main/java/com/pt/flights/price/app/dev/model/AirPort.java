package com.pt.flights.price.app.dev.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "airport")
@SequenceGenerator(name = "airport_sequence", sequenceName = "airport_seq", initialValue = 1486, allocationSize = 1)
public class AirPort implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "airport_sequence")
    @Column(name = "id_airport")
    @JsonProperty("id_airport")
    private Long idAirPort;
    @NotNull
    @Column(name = "name")
    @JsonProperty("airport_name")
    private String name;
    @NotNull
    @Column(name = "iata")
    @JsonProperty("iata")
    private String iata;
    @Column(name = "icao")
    @JsonIgnore
    private String icao;
    @Column(name = "city_id")
    @JsonIgnore
    private int cityId;
    @Column(name = "flight_from")
    @JsonIgnore
    private Boolean flightFrom;
    @Column(name = "flight_to")
    @JsonIgnore
    private Boolean flightTo;
    @Column(name = "personal_preference", columnDefinition = "boolean default false")
    @JsonIgnore
    private Boolean personalPreference = false;
    @OneToMany(mappedBy = "airPortTo", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<CombinationFlight> combinationFlightsTo;
    @OneToMany(mappedBy = "airPortFrom", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonProperty("combination_flight")
    @JsonBackReference
    private List<CombinationFlight> combinationFlightsFrom;

    public AirPort() {
    }

    public AirPort(String name, String iata, String icao, Boolean flightFrom, int cityId) {
        this.name = name;
        this.iata = iata;
        this.icao = icao;
        this.flightFrom = flightFrom;
        this.cityId = cityId;
    }

    public AirPort(String iata) {
        this.iata = iata;
    }

    public Long getIdAirPort() {
        return idAirPort;
    }

    public void setIdAirPort(Long idAirPort) {
        this.idAirPort = idAirPort;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public String getIcao() {
        return icao;
    }

    public void setIcao(String icao) {
        this.icao = icao;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public Boolean getFlightFrom() {
        return flightFrom;
    }

    public void setFlightFrom(Boolean flightFrom) {
        this.flightFrom = flightFrom;
    }

    public Boolean getFlightTo() {
        return flightTo;
    }

    public void setFlightTo(Boolean flightTo) {
        this.flightTo = flightTo;
    }

    public Boolean getPersonalPreference() {
        return personalPreference;
    }

    public void setPersonalPreference(Boolean personalPreference) {
        this.personalPreference = personalPreference;
    }

    public List<CombinationFlight> getCombinationFlightsTo() {
        return combinationFlightsTo;
    }

    public void setCombinationFlightsTo(List<CombinationFlight> combinationFlightsTo) {
        this.combinationFlightsTo = combinationFlightsTo;
    }

    public List<CombinationFlight> getCombinationFlightsFrom() {
        return combinationFlightsFrom;
    }

    public void setCombinationFlightsFrom(List<CombinationFlight> combinationFlightsFrom) {
        this.combinationFlightsFrom = combinationFlightsFrom;
    }
}

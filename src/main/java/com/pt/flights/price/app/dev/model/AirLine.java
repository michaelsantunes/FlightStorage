package com.pt.flights.price.app.dev.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "airline")
@SequenceGenerator(name = "airline_sequence", sequenceName = "airline_seq", allocationSize = 1)
public class AirLine implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "airline_sequence")
    @Column(name = "id_airline")
    @JsonIgnore
    private Long idAirLine;

    @Column(name = "api_save")
    @JsonProperty("api")
    private String apiSave;

    @Column(name = "name", unique = true)
    @JsonProperty("airline_name")
    private String name;

    @OneToMany(mappedBy = "airLine", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<CombinationPrice> combinationPrices;

    public AirLine() {
    }

    public AirLine(String name, String apiSave) {
        this.apiSave = apiSave;
        this.name = name;
    }

    public AirLine(Long idAirLine, String apiSave, String name) {
        this.idAirLine = idAirLine;
        this.apiSave = apiSave;
        this.name = name;
    }

    public Long getIdAirLine() {
        return idAirLine;
    }

    public void setIdAirLine(Long idAirLine) {
        this.idAirLine = idAirLine;
    }

    public String getApiSave() {
        return apiSave;
    }

    public void setApiSave(String apiSave) {
        this.apiSave = apiSave;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CombinationPrice> getCombinationPrices() {
        return combinationPrices;
    }

    public void setCombinationPrices(List<CombinationPrice> combinationPrices) {
        this.combinationPrices = combinationPrices;
    }
}

package com.pt.flights.price.app.dev.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "email_combination")
@SequenceGenerator(name = "email_combination_sequence", sequenceName = "email_combination_seq",  allocationSize = 1)
public class EmailCombination implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "email_combination_sequence")
    @SerializedName("id")
    @Column(name = "id_email_combination")
    @JsonIgnore
    public Long idEmailCombination;

    @SerializedName("email")
    @Column(name = "email")
    @JsonProperty("email")
    public String email;

    @ManyToOne
    @JoinColumn(name = "combination_flight_id", foreignKey = @ForeignKey(name = "combination_flight_email_combination_fk"))
    @JsonProperty("combination_email")
    @JsonManagedReference
    private CombinationFlight combinationFlight;

    public EmailCombination() {
    }

    public EmailCombination(String email) {
        this.email = email;
    }

    public Long getIdEmailCombination() {
        return idEmailCombination;
    }

    public void setIdEmailCombination(Long idEmailCombination) {
        this.idEmailCombination = idEmailCombination;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CombinationFlight getCombinationFlight() {
        return combinationFlight;
    }

    public void setCombinationFlight(CombinationFlight combinationFlight) {
        this.combinationFlight = combinationFlight;
    }
}

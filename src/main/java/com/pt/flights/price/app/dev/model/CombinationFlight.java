package com.pt.flights.price.app.dev.model;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "combination_flight", uniqueConstraints = @UniqueConstraint(columnNames = {"initial_date", "final_date", "airport_from_id", "airport_to_id"}))
@SequenceGenerator(name = "combination_flight_sequence", sequenceName = "combination_flight_seq", allocationSize = 1)
public class CombinationFlight implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "combination_flight_sequence")

    @Column(name = "id_combination")
    @JsonProperty("id_combination")
    private Long idCombination;

    @Column(name = "weekday_initial")
    @JsonProperty("outbound_day")
    private String weekDayInitial;

    @Column(name = "weekday_final")
    @JsonProperty("return_day")
    private String weekDayFinal;

    @NotNull
    @Column(name = "initial_date")
    @JsonProperty("outbound_date")
    private Date initialDate;

    @NotNull
    @Column(name = "final_date")
    @JsonProperty("return_date")
    private Date finalDate;

    @ManyToOne
    @JoinColumn(name = "airport_to_id", foreignKey = @ForeignKey(name = "air_port_to_combination_flight_fk"))
    @JsonProperty("flight_to")
    @JsonManagedReference
    private AirPort airPortTo;

    @ManyToOne
    @JoinColumn(name = "airport_from_id", foreignKey = @ForeignKey(name = "air_port_from_combination_flight_fk"))
    @JsonManagedReference
    @JsonProperty("flight_from")
    private AirPort airPortFrom;

    @Column(name = "my_preferences", columnDefinition = "boolean default false")
    @JsonIgnore
    private Boolean myPreferences = false;

    @CreationTimestamp
    @Column(name = "register_date")
    @JsonProperty("register_date_time")
    private LocalDateTime registerDate;

    @Transient
    @JsonIgnore
    private Integer numberOfDays = 0;

    @OneToMany(mappedBy = "combinationFlight", orphanRemoval = true, cascade = CascadeType.ALL)
    @JsonProperty("email")
    @JsonBackReference
    private List<EmailCombination> emailCombinations;

    @OneToMany(mappedBy = "combinationFlight", orphanRemoval = true, cascade = CascadeType.ALL)
    @JsonProperty("price")
    @JsonManagedReference
    private List<CombinationPrice> combinationPrices;

    @JsonGetter("final_price")
    public Map<String, Float> getFinalPrice() {
        Float euro = 0F, dollar = 0F, real = 0F;
        int total = combinationPrices.size();
        for (CombinationPrice cp : combinationPrices) {
            euro += cp.getEuroPrice();
            dollar += cp.getDollarPrice();
            real += cp.getRealPrice();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("euro", euro / total);
        hashMap.put("dollar", dollar / total);
        hashMap.put("real", real / total);

        return hashMap;
    }

    public Long getIdCombination() {
        return idCombination;
    }

    public void setIdCombination(Long idCombination) {
        this.idCombination = idCombination;
    }

    public String getWeekDayInitial() {
        return weekDayInitial;
    }

    public void setWeekDayInitial(String weekDayInitial) {
        this.weekDayInitial = weekDayInitial;
    }

    public String getWeekDayFinal() {
        return weekDayFinal;
    }

    public void setWeekDayFinal(String weekDayFinal) {
        this.weekDayFinal = weekDayFinal;
    }

    public Date getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(Date initialDate) {
        this.initialDate = initialDate;
    }

    public Date getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }

    public AirPort getAirPortTo() {
        return airPortTo;
    }

    public void setAirPortTo(AirPort airPortTo) {
        this.airPortTo = airPortTo;
    }

    public AirPort getAirPortFrom() {
        return airPortFrom;
    }

    public void setAirPortFrom(AirPort airPortFrom) {
        this.airPortFrom = airPortFrom;
    }

    public Boolean getMyPreferences() {
        return myPreferences;
    }

    public void setMyPreferences(Boolean myPreferences) {
        this.myPreferences = myPreferences;
    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }

    public Integer getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(Integer numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public List<EmailCombination> getEmailCombinations() {
        return emailCombinations;
    }

    public void setEmailCombinations(List<EmailCombination> emailCombinations) {
        this.emailCombinations = emailCombinations;
    }

    public List<CombinationPrice> getCombinationPrices() {
        return combinationPrices;
    }

    public void setCombinationPrices(List<CombinationPrice> combinationPrices) {
        this.combinationPrices = combinationPrices;
    }
}
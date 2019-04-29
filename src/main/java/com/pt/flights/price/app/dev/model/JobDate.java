package com.pt.flights.price.app.dev.model;

import java.io.Serializable;
import java.time.LocalDate;

public class JobDate implements Serializable {


    private Long idJobDate;
    private LocalDate initialRange;
    private LocalDate finalRange;

    public JobDate(Long idScheduleByDay, LocalDate initialRange, LocalDate finalRange) {
        this.idJobDate = idScheduleByDay;
        this.initialRange = initialRange;
        this.finalRange = finalRange;
     }

    public Long getIdScheduleByDay() {
        return idJobDate;
    }

    public void setIdScheduleByDay(Long idScheduleByDay) {
        this.idJobDate = idScheduleByDay;
    }

    public LocalDate getInitialRange() {
        return initialRange;
    }

    public void setInitialRange(LocalDate initialRange) {
        this.initialRange = initialRange;
    }

    public LocalDate getFinalRange() {
        return finalRange;
    }

    public void setFinalRange(LocalDate finalRange) {
        this.finalRange = finalRange;
    }
}


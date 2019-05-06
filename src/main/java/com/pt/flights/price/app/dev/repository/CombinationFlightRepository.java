package com.pt.flights.price.app.dev.repository;

import com.pt.flights.price.app.dev.model.CombinationFlight;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import javax.swing.*;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public interface CombinationFlightRepository extends JpaRepository<CombinationFlight, Long> {
    
    CombinationFlight findFirstOneInitialDateByInitialDateGreaterThanEqualOrderByInitialDate(Date parameter);
    CombinationFlight findTopFinalDateByFinalDateGreaterThanEqualOrderByFinalDateDesc(Date parameter);
    List<CombinationFlight> findByInitialDateGreaterThanEqualAndFinalDateLessThanEqual(Date initialDate, Date finalDate);
}


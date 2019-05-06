package com.pt.flights.price.app.dev.repository;

import com.pt.flights.price.app.dev.model.AirPort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirPortRepository extends JpaRepository<AirPort, Long> {
    
    AirPort findByIata(String iata);
    List<AirPort> findByPersonalPreferenceIsTrue();
}

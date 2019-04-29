package com.pt.flights.price.app.dev.repository;

import com.pt.flights.price.app.dev.model.AirLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirLineRepository extends JpaRepository<AirLine, Long> {
    AirLine findAirLineByName(String name);
}


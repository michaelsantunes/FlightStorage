package com.pt.flights.price.app.dev.repository;

import com.pt.flights.price.app.dev.model.CombinationPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CombinationPriceRepository extends JpaRepository<CombinationPrice, Long> {
}

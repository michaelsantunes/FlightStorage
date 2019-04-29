package com.pt.flights.price.app.dev.controller;

import com.pt.flights.price.app.dev.model.CombinationFlight;
import com.pt.flights.price.app.dev.service.CombinationFlightImp;
import com.pt.flights.price.app.util.others.REST;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("combination/flight")
public class CombinationFlightController {

    @Autowired
    CombinationFlightImp combinationFlightImplements;

    @GetMapping
    public ResponseEntity<Page<CombinationFlight>> findAll(Pageable pageable) {
        return new REST<CombinationFlight>().contentPageableCollection(combinationFlightImplements.findAll(pageable));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CombinationFlight> findById(@PathVariable(value = "id") Long id) {
        return new REST<CombinationFlight>().contentEntity(combinationFlightImplements.findById(id));
    }
}

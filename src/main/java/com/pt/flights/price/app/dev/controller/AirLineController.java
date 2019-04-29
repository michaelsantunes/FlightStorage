package com.pt.flights.price.app.dev.controller;

import com.pt.flights.price.app.dev.model.AirLine;
import com.pt.flights.price.app.dev.service.AirLineImp;
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
@RequestMapping("airline")
public class AirLineController {

    @Autowired
    private AirLineImp airLineImp;

    @GetMapping(value = "find/all")
    public ResponseEntity<Page<AirLine>> findAll(Pageable pageable) {
        return new REST<AirLine>().contentPageableCollection(airLineImp.findAll(pageable));
    }

    @GetMapping(value = "find/by/{id}")
    public ResponseEntity<AirLine> findById(@PathVariable(value = "id") Long id) {
        return new REST<AirLine>().contentEntity(airLineImp.findById(id));
    }
}

package com.pt.flights.price.app.dev.service;

import com.pt.flights.price.app.dev.model.AirLine;
import com.pt.flights.price.app.dev.repository.AirLineRepository;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AirLineImpTest {

    @Autowired
    AirLineImp airLineImp;

    @Autowired
    AirLineRepository airLineRepository;

    @Test
    @Ignore
    public void saveIfNotExist() {
    }

    @Test
    @Ignore
    public void findByName() {
        Long expected = 24L;
        Long result = airLineRepository.findAirLineByName("Ryanair").getIdAirLine();
        Assert.assertEquals(expected, result);
    }
}
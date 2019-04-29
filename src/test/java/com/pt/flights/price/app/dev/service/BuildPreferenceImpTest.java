package com.pt.flights.price.app.dev.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BuildPreferenceImpTest {

    @Autowired
    private BuildPreferenceImp buildPreferenceImp;

    @Autowired
    private CombinationFlightImp combinationFlightImp;

    @Autowired
    private EmailCombinationImp emailCombinationImp;


    @Before
    public void flightPreference() {
        buildPreferenceImp.flightPreference();
    }

    @Test
    @Ignore
    public void verifyIfNotEmpty() {
//        Assert.assertFalse(combinationFlightImp.findAll().isEmpty());
//        Assert.assertFalse(emailCombinationImp.findAll().isEmpty());
    }
}
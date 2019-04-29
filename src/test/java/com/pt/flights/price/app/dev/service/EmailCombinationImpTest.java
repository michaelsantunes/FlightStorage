package com.pt.flights.price.app.dev.service;

import com.pt.flights.price.app.dev.model.CombinationFlight;
import com.pt.flights.price.app.dev.model.EmailCombination;
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
public class EmailCombinationImpTest {

    @Autowired
    EmailCombinationImp emailCombinationImp;

    @Test
    @Ignore
    public void save() {
        CombinationFlight combinationFlight = new CombinationFlight();
        combinationFlight.setIdCombination((long) 115);
        EmailCombination emailCombination = new EmailCombination("teste@gmail.com");
        Assert.assertNotNull(emailCombinationImp.save(emailCombination));
    }
}
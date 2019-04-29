package com.pt.flights.price.app.dev.service;

import com.pt.flights.price.app.dev.model.CombinationFlight;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CombinationFlightImpTest {

    @Autowired
    CombinationFlightImp combinationFlightImp;

    @Test
    @Ignore
    public void findCombinationFlightByInitialAndFinalDate() throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = format.parse("2019-05-01");
        Date d2 = format.parse("2019-05-30");
        List<CombinationFlight> combinationFlightList = combinationFlightImp.findCombinationFlightByInitialAndFinalDate(d1, d2);
        Assert.assertFalse(combinationFlightList.isEmpty());
    }

    @Test
    @Ignore
    public void countByCriteriaQueryGreaterThanOrEqualToDate() throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = format.parse("2019-05-01");
        Assert.assertTrue(combinationFlightImp.countByCriteriaQueryGreaterThanOrEqualToDate(d1) > 0);
    }

    @Test
    @Ignore
    public void countByCriteriaQueryWithoutParameter() throws InterruptedException {
        Assert.assertTrue(combinationFlightImp.countByCriteriaQueryWithoutParameter() > 0);
    }
}
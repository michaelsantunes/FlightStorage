package com.pt.flights.price.app.dev.service;

import com.pt.flights.price.app.dev.controller.SkyScannerController;
import com.pt.flights.price.app.dev.model.SkyScannerParameter;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SkyScannerControllerTest {

    @Autowired
    SkyScannerController sky;

    @Test
    @Ignore
    public void getPriceFromSkyScanner() {
//        String country = "US";
//        String currency = "EUR";
//        String locale = "pt-PT";
//        String destinationPlace = "LIS";
//        String origenPlace = "OPO";
//        String outboundPartialDate = "2019-05-18";
//        String inboundPartialDate = "2019-05-19";
//        SkyScannerParameter skyScannerParameter = new SkyScannerParameter(country, currency, locale, destinationPlace, origenPlace, outboundPartialDate, inboundPartialDate);
//        sky.SkyScannerController(skyScannerParameter);
//        Assert.assertNotNull(sky.findFlightPrice());
    }
}
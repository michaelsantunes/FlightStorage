package com.pt.flights.price.app.util.others;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommonTest {

    @Autowired
    Common common;

    @Test
    @Ignore
    public void codeFlightFromTo() throws NoSuchAlgorithmException {
        String code1 = common.createCodeFlightFromTo(3000L);
        String code2 = common.createCodeFlightFromTo(3000L);
        System.out.println(code1 + " - " + code2);
        Assert.assertNotEquals(code1, code2);
    }
}
package com.pt.flights.price.app.dev.job;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JobStartTest {

    @Autowired
    JobStart jobStart;

    @Test
    public void startProcess() throws Exception{
        jobStart.startProcess();
    }
}
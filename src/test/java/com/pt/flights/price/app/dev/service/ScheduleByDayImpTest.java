package com.pt.flights.price.app.dev.service;

import com.pt.flights.price.app.dev.job.JobListDate;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ScheduleByDayImpTest {

    @Autowired
    JobListDate jobByDayImplements;

    @Test
    @Ignore
    public void buildScheduleInterval() {
        Assert.assertFalse(jobByDayImplements.createIntervalDate().isEmpty());
    }
}
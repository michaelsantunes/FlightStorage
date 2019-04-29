package com.pt.flights.price.app.dev.properties;

import com.pt.flights.price.app.util.others.EnumUtil;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EnumUtilTest  {

    @Autowired
    PropertiesConfiguration propertiesConfiguration;

    @Test
    @Ignore
    public void getKeyValue() {
        System.out.println(propertiesConfiguration.getGenericProperties(EnumUtil.PERCENTAGE_THREAD.getKeyValue()));
        System.out.println(EnumUtil.INTERVAL_BETWEEN_DATES_TO_SEARCH.getKeyValue());
    }


}
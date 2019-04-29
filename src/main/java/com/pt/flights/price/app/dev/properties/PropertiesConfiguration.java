package com.pt.flights.price.app.dev.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySources(
        { @PropertySource("classpath:application-rapidapi.properties"),
          @PropertySource("classpath:application-util.properties")
        }
)
public class PropertiesConfiguration {

    @Autowired
    private Environment environment;

    public Object getGenericProperties(String key) {
        return environment.getProperty(key);
    }
}

package com.pt.flights.price.app.util.others;

import com.pt.flights.price.app.dev.interfaces.EnumPropertiesInterface;

public enum EnumUtil implements EnumPropertiesInterface {
    INTERVAL_BETWEEN_DATES_TO_SEARCH("interval_between_dates_to_search"),
    PERCENTAGE_THREAD("percentage_thread"),
    START_IN_DAYS("start_in_days"),
    SKY_SCANNER_API("sky_scanner_api"),
    DOLLAR_OPTION("0"),
    REAL_OPTION("1"),
    FROM("0"),
    TO("1");

    private final String key;

    EnumUtil(String key) {
        this.key = key;
    }

    @Override
    public String getKeyValue() {
        return this.key;
    }
}

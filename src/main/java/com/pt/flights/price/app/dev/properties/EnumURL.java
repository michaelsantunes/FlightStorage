package com.pt.flights.price.app.dev.properties;

import com.pt.flights.price.app.dev.interfaces.EnumPropertiesInterface;

public enum EnumURL implements EnumPropertiesInterface {
    URL_SKYSCANNER("sky_scanner_url"),
    URL_CURRENCY_DOLAR("currency_dolar"),
    URL_CURRENCY_REAL("currency_real");

    private final String key;

    EnumURL(String key) {
        this.key = key;
    }

    @Override
    public String getKeyValue() {
        return this.key;
    }
}



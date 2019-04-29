package com.pt.flights.price.app.dev.properties;

import com.pt.flights.price.app.dev.interfaces.EnumPropertiesInterface;

public enum EnumKey implements EnumPropertiesInterface {
    RAPID_HEADER_NAME("rapid_header_name"),
    RAPID_HEADER_KEY("rapid_header_key");

    private String key;

    EnumKey(String key) {
        this.key = key;
    }

    @Override
    public String getKeyValue() {
        return this.key;
    }
}

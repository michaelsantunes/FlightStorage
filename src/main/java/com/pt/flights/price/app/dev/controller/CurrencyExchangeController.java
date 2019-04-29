package com.pt.flights.price.app.dev.controller;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.pt.flights.price.app.dev.properties.EnumKey;
import com.pt.flights.price.app.dev.properties.EnumURL;
import com.pt.flights.price.app.dev.properties.PropertiesConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CurrencyExchangeController {

    @Autowired
    PropertiesConfiguration propertiesConfiguration;

    /**
     * Get currency exchange
     * @return
     * @throws Exception
     */
    public List<Float> currencyExchange() throws Exception {
        List<Float> currencyList = new ArrayList<>();
        String header_name = (String) propertiesConfiguration.getGenericProperties(EnumKey.RAPID_HEADER_NAME.getKeyValue());
        String header_key = (String) propertiesConfiguration.getGenericProperties(EnumKey.RAPID_HEADER_KEY.getKeyValue());
        String dollar = (String) propertiesConfiguration.getGenericProperties(EnumURL.URL_CURRENCY_DOLAR.getKeyValue());
        String real = (String) propertiesConfiguration.getGenericProperties(EnumURL.URL_CURRENCY_REAL.getKeyValue());
        currencyList.add(getValueFromAPI(header_name, header_key, dollar));
        currencyList.add(getValueFromAPI(header_name, header_key, real));
        return currencyList;
    }

    /**
     * Return float list with currency exchange
     * @param header_name
     * @param header_key
     * @param rapidURL
     * @return
     * @throws Exception
     */
    public Float getValueFromAPI(String header_name, String header_key, String rapidURL) throws Exception {
        URL url = new URL(rapidURL);
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        http.setRequestProperty(header_name, header_key);
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(new InputStreamReader((InputStream) http.getContent()));
        return je.getAsFloat();
    }
}




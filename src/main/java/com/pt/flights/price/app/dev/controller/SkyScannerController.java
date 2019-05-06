package com.pt.flights.price.app.dev.controller;

import com.pt.flights.price.app.dev.interfaces.APICommonExternalInterface;
import com.pt.flights.price.app.dev.interfaces.SkyScannerInterface;
import com.pt.flights.price.app.dev.model.SkyScanner;
import com.pt.flights.price.app.dev.model.SkyScannerParameter;
import com.pt.flights.price.app.dev.properties.EnumKey;
import com.pt.flights.price.app.dev.properties.EnumURL;
import com.pt.flights.price.app.dev.properties.PropertiesConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SkyScannerController implements SkyScannerInterface, APICommonExternalInterface<SkyScannerParameter, SkyScanner, String> {

    //get prices from RAPIDAPI SKYSCANNER
    
    @Autowired
    private PropertiesConfiguration propertiesConfiguration;

    SkyScannerParameter parameter;

    private String url;
    private String headerName;
    private String headerkey;

    /**
     * Build skyscanner parameters
     * @param skyScannerParameter
     */
    @Override
    public void SkyScannerController(SkyScannerParameter skyScannerParameter) {
        this.parameter = skyScannerParameter;
        this.url = buildRequestURL(parameter, String.valueOf(propertiesConfiguration.getGenericProperties(EnumURL.URL_SKYSCANNER.getKeyValue())));
        this.headerName = (String) propertiesConfiguration.getGenericProperties(EnumKey.RAPID_HEADER_NAME.getKeyValue());
        this.headerkey = (String) propertiesConfiguration.getGenericProperties(EnumKey.RAPID_HEADER_KEY.getKeyValue());
    }

    /**
     * Search on SkyScanner API
     * @return Skyscanner Class
     */
    @Override
    public SkyScanner findFlightPrice() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.set(headerName, headerkey);
        HttpEntity<?> httpEntity = new HttpEntity<>(httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<SkyScanner> exchange = restTemplate.exchange(url, HttpMethod.GET, httpEntity, SkyScanner.class);
        return exchange.getBody();
    }

    /**
     * Build URL request
     * @param parameter
     * @param url
     * @return
     */
    @Override
    public String buildRequestURL(SkyScannerParameter parameter, String url) {
        StringBuilder urlRequest = new StringBuilder();
        urlRequest.append(url);
        urlRequest.append(parameter.getCountry()).append("/");
        urlRequest.append(parameter.getCurrency()).append("/");
        urlRequest.append(parameter.getLocale()).append("/");
        urlRequest.append(parameter.getOrigenPlace()).append("/");
        urlRequest.append(parameter.getDestinationPlace()).append("/");
        urlRequest.append(parameter.getOutboundPartialDate()).append("/");
        urlRequest.append(parameter.getInboundPartialDate());
        return urlRequest.toString();
    }
}

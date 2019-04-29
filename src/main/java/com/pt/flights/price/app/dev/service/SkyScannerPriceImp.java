package com.pt.flights.price.app.dev.service;

import com.pt.flights.price.app.dev.interfaces.CombinationFlightInterface;
import com.pt.flights.price.app.dev.controller.SkyScannerController;
import com.pt.flights.price.app.dev.model.*;
import com.pt.flights.price.app.util.others.EnumUtil;
import com.pt.flights.price.app.dev.properties.PropertiesConfiguration;
import com.pt.flights.price.app.util.others.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class SkyScannerPriceImp implements CombinationFlightInterface {


    @Autowired
    private PropertiesConfiguration propertiesConfiguration;
    @Autowired
    private SkyScannerController skyScannerController;
    @Autowired
    private AirLineImp airLineImp;
    @Autowired
    Common common;
    @Autowired
    CombinationPriceImp combinationPriceImp;

    private CombinationFlight mainParameter;
    private ThirdTaskParameter thirdTaskParameter;

    private final int FROM = Integer.parseInt(EnumUtil.FROM.getKeyValue());
    private final int TO = Integer.parseInt(EnumUtil.TO.getKeyValue());

    @Override
    public void getMainParameter(CombinationFlight mainParameter, ThirdTaskParameter thirdTaskParameter) throws Exception {
        this.mainParameter = mainParameter;
        this.thirdTaskParameter = thirdTaskParameter;
    }

    @Override
    public SearchModel getSearchModel() {
        SearchModel search = new SearchModel();
        search.setCountry("US");
        search.setCurrency("EUR");
        search.setLocale("pt-PT");
        search.setPatternDate("yyyy-MM-dd");
        search.setDestination(mainParameter.getAirPortTo().getIata());
        search.setOrigen(mainParameter.getAirPortFrom().getIata());
        search.setOutboundPartialDate(mainParameter.getInitialDate());
        search.setInboundPartialDate(mainParameter.getFinalDate());
        search.setApiUsed(String.valueOf(propertiesConfiguration.getGenericProperties(EnumUtil.SKY_SCANNER_API.getKeyValue())));
        return search;
    }

    @Override
    public void getPriceAndSave() throws Exception {
        SearchModel search = getSearchModel();
        SkyScannerParameter skyScannerParameter = new SkyScannerParameter(search);
        skyScannerController.SkyScannerController(skyScannerParameter);
        SkyScanner skyScanner = skyScannerController.findFlightPrice();
        if (skyScanner != null) {
            for (SkyScannerQuotes quotes : skyScanner.getQuotes()) {
                String code = common.createCodeFlightFromTo(mainParameter.getIdCombination());
                CombinationPrice cp = new CombinationPrice();
                cp.setCombinationFlight(this.mainParameter);
                cp.setDollarPrice(new BigDecimal(quotes.getMiniPrice() * thirdTaskParameter.getDollar()).setScale(0, RoundingMode.HALF_UP).floatValue());
                cp.setRealPrice(new BigDecimal(quotes.getMiniPrice() * thirdTaskParameter.getReal()).setScale(0, RoundingMode.HALF_UP).floatValue());
                cp.setExchangeEuroCurrency("USD=" + thirdTaskParameter.getDollar() + "#" + "BRL=" + thirdTaskParameter.getReal());
                cp.setEuroPrice(quotes.getMiniPrice());
                cp.setDirectFlight(quotes.getDirect());
                cp.setApi(String.valueOf(propertiesConfiguration.getGenericProperties(EnumUtil.SKY_SCANNER_API.getKeyValue())));
                saveFrom(cp, search, skyScanner, quotes, code);
                saveTo(cp, search, skyScanner, quotes, code);
            }
        }
    }

    @Override
    public void saveFrom(CombinationPrice combinationPrice, SearchModel searchModel, SkyScanner skyScanner, SkyScannerQuotes skyScannerQuotes,  String code) throws Exception {
        combinationPrice.setIdCombinationPrice(null);
        combinationPrice.setOriginDestination(FROM);
        combinationPrice.setIataCode(searchModel.getOrigen());
        ModelSave modelSave = new SkyScannerSave(combinationPrice, searchModel, code, skyScanner, skyScannerQuotes.getInboundLeg());
        savePrice(modelSave);
    }

    @Override
    public void saveTo(CombinationPrice combinationPrice, SearchModel searchModel, SkyScanner skyScanner, SkyScannerQuotes skyScannerQuotes,  String code) throws Exception {
        combinationPrice.setIdCombinationPrice(null);
        combinationPrice.setOriginDestination(TO);
        combinationPrice.setIataCode(searchModel.getDestination());
        ModelSave modelSave = new SkyScannerSave(combinationPrice, searchModel, code, skyScanner, skyScannerQuotes.getOutboundLeg());
        savePrice(modelSave);
    }

    @Override
    public void savePrice(ModelSave modelSavePrice) throws Exception {
        SkyScannerSave skyScannerSave = (SkyScannerSave) modelSavePrice;
        for (Integer idCarrier : skyScannerSave.getSkyScannerCarriersQuotes().getCarrierIds()) {
            for (SkyScannerCarriers carriers : skyScannerSave.getSkyScanner().getCarriers()) {
                if ((long) idCarrier == carriers.getCarrierId()) {
                    AirLine airLine = new AirLine(carriers.getName(), skyScannerSave.getSearchModel().getApiUsed());
                    skyScannerSave.getCombinationPrice().setOriginDestination(modelSavePrice.getCombinationPrice().getOriginDestination());
                    skyScannerSave.getCombinationPrice().setCodeCombination(skyScannerSave.getCode());
                    AirLine returnAirLine = airLineImp.saveIfNotExist(airLine);
                    skyScannerSave.getCombinationPrice().setAirLine(returnAirLine);
                    combinationPriceImp.save(skyScannerSave.getCombinationPrice());
                    System.out.println("SAVE - CODE " + skyScannerSave.getCode() );
                    return;
                }
            }
        }
    }
}

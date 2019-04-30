package com.pt.flights.price.app.dev.interfaces;

import com.pt.flights.price.app.dev.model.*;

public interface CombinationFlightInterface {
    void getMainParameter(CombinationFlight mainParameter, ThirdTaskParameter thirdTaskParameter) throws Exception;
    SearchModel getSearchModel();
    void getPriceAndSave() throws Exception;
    void saveFrom(CombinationPrice combinationPrice, SearchModel searchModel, SkyScanner skyScanner, SkyScannerQuotes skyScannerQuotes, String code) throws Exception;
    void saveTo(CombinationPrice combinationPrice, SearchModel searchModel, SkyScanner skyScanner, SkyScannerQuotes skyScannerQuotes,  String code) throws Exception;
    void savePrice(ModelSave modelSavePrice) throws Exception;
}

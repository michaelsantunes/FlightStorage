package com.pt.flights.price.app.dev.model;


public class SkyScannerSave extends ModelSave {

    private SkyScanner skyScanner;
    private SkyScannerCarriersQuotes skyScannerCarriersQuotes;

    public SkyScannerSave(CombinationPrice combinationPrice, SearchModel searchModel, String code, SkyScanner skyScanner, SkyScannerCarriersQuotes skyScannerCarriersQuotes) {
        super(combinationPrice, searchModel, code);
        this.skyScanner = skyScanner;
        this.skyScannerCarriersQuotes = skyScannerCarriersQuotes;
    }



    public SkyScanner getSkyScanner() {
        return skyScanner;
    }

    public SkyScannerCarriersQuotes getSkyScannerCarriersQuotes() {
        return skyScannerCarriersQuotes;
    }
}

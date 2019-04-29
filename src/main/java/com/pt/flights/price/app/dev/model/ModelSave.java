package com.pt.flights.price.app.dev.model;
public abstract class ModelSave {

    private CombinationPrice combinationPrice;
    private SearchModel searchModel;
    private String code;

    public ModelSave(CombinationPrice combinationPrice, SearchModel searchModel, String code) {
        this.combinationPrice = combinationPrice;
        this.searchModel = searchModel;
        this.code = code;
    }

    public CombinationPrice getCombinationPrice() {
        return combinationPrice;
    }

    public SearchModel getSearchModel() {
        return searchModel;
    }

    public String getCode() {
        return code;
    }
}

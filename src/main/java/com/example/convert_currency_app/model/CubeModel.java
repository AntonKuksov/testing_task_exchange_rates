package com.example.convert_currency_app.model;

import com.example.convert_currency_app.entities.Cube;
import com.example.convert_currency_app.entities.Currency;

import java.util.List;
import java.util.stream.Collectors;

public class CubeModel {
    private Integer id;
    private String time;
    private List<CurrModel> currencyList;
//    private List<DealModel> dealModelList;

    public static CubeModel toModel(Cube entity) {
        CubeModel model = new CubeModel();
        model.setId(entity.getId());
        model.setTime(entity.getTime());
        model.setCurrencyList(entity.getCurrencyList().stream().map(CurrModel::toModel).collect(Collectors.toList()));
//        model.setDealModelList(entity.getDealList().stream().map(DealModel::toModel).collect(Collectors.toList()));
        return model;
    }

    public CubeModel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<CurrModel> getCurrencyList() {
        return currencyList;
    }

    public void setCurrencyList(List<CurrModel> currencyList) {
        this.currencyList = currencyList;
    }

//    public List<DealModel> getDealModelList() {
//        return dealModelList;
//    }
//
//    public void setDealModelList(List<DealModel> dealModelList) {
//        this.dealModelList = dealModelList;
//    }
}

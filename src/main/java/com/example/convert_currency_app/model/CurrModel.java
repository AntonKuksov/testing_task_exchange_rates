package com.example.convert_currency_app.model;

import com.example.convert_currency_app.entities.Currency;

public class CurrModel {
    private Integer id;
    private String title;
    private double rate;


    public static CurrModel toModel(Currency entity) {
        CurrModel model = new CurrModel();
        model.setId(entity.getId());
        model.setTitle(entity.getTitle());
        model.setRate(entity.getRate());
        return model;
    }

    public CurrModel() {
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}

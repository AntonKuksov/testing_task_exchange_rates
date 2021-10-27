package com.example.convert_currency_app.model;

import com.example.convert_currency_app.entities.Deal;

public class DealModel {
    private Integer id;
    private String date;
    private String amount;
    private String incurr;
    private String outcurr;
    private String username;

    public static DealModel toModel(Deal entity) {
        DealModel model = new DealModel();
        model.setId(entity.getId());
        model.setDate(entity.getDate());
        model.setAmount(entity.getAmount());
        model.setIncurr(entity.getIncurr());
        model.setOutcurr(entity.getOutcurr());
        model.setUsername(entity.getUsername());
        return model;
    }
    public DealModel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getIncurr() {
        return incurr;
    }

    public void setIncurr(String incurr) {
        this.incurr = incurr;
    }

    public String getOutcurr() {
        return outcurr;
    }

    public void setOutcurr(String outcurr) {
        this.outcurr = outcurr;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

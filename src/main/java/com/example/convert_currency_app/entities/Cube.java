package com.example.convert_currency_app.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cube {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String time;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cube")
    private List<Currency> currencyList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cubed")
    private List<Deal> dealList;

    public List<Deal> getDealList() {
        return dealList;
    }

    public void setDealList(List<Deal> dealList) {
        this.dealList = dealList;
    }

    public Cube() {
    }

    public void Cube(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Currency> getCurrencyList() {
     return currencyList;
    }

    public void setCurrencyList(List<Currency> currencyList) {
        this.currencyList = currencyList;
    }

    @Override
    public String toString() {
        return "time=" + time + "\nid=" + id +"\n";
    }
}

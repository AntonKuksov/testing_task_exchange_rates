package com.example.convert_currency_app.entities;

import javax.persistence.*;

@Entity
public class Deal {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String date;
    private String amount;
    private String incurr;
    private String outcurr;
    private String username;
//    private String cube_id;

    @ManyToOne
    @JoinColumn(name = "cube_id")
    private Cube cubed;

    public Deal() {
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

    public Integer getCubed() {
        return cubed.getId();
    }

    public void setCubed(Cube cubed) {
        this.cubed = cubed;
    }


}

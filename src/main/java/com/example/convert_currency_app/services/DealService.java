package com.example.convert_currency_app.services;

import com.example.convert_currency_app.entities.Cube;
import com.example.convert_currency_app.entities.Deal;
import com.example.convert_currency_app.model.DealModel;
import com.example.convert_currency_app.repos.DealRepo;
import com.example.convert_currency_app.repos.NamesOnly;
import com.example.convert_currency_app.repos.RateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DealService {

    @Autowired
    private DealRepo dealRepo;
    @Autowired
    private RateRepo rateRepo;

    public List<NamesOnly> getAlldeals() {
        List<NamesOnly> deal = dealRepo.findAlld();
        return deal;
    }
    public DealModel createDeal (Deal deal) {
//        Cube cube = rateRepo.findById(cubeId).get();
//        deal.setCube(cube);
        return DealModel.toModel(dealRepo.save(deal));
    }
}

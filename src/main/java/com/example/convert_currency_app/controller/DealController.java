package com.example.convert_currency_app.controller;


import com.example.convert_currency_app.entities.Deal;
import com.example.convert_currency_app.repos.NamesOnly;
import com.example.convert_currency_app.services.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/deal")
public class DealController {

    @Autowired
    private DealService dealService;

    @GetMapping("/all")
    public ResponseEntity ShowAlldeal() {
        List<NamesOnly> deal = dealService.getAlldeals();
        return ResponseEntity.ok(deal);
    }

    @PostMapping
    public ResponseEntity registration(@RequestBody Deal deal) {
        dealService.createDeal(deal);
        return ResponseEntity.ok("Пользователь успешно сохранен");

    }
}

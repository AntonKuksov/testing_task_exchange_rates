package com.example.convert_currency_app.controller;

import com.example.convert_currency_app.entities.Cube;
import com.example.convert_currency_app.services.CubeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Calendar;


@Controller
@RequestMapping("/cubes")
public class RateController {

    @Autowired
    private CubeService cubeService;

    @GetMapping
    public ResponseEntity main() {
        Calendar cal = Calendar.getInstance();
        return ResponseEntity.ok(cubeService.getByDate(cal));
    }



    @GetMapping("/{id}")
    public ResponseEntity getOneCubeCurr(@RequestParam Integer id) {

        return ResponseEntity.ok(cubeService.getOne(id));
    }

}

package com.example.convert_currency_app.repos;

import com.example.convert_currency_app.entities.Cube;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RateRepo extends CrudRepository<Cube, Integer> {
   Cube findCubeByTime(String time);
   Cube findTopByOrderByIdDesc();
   Cube findCubeById(Integer id);
}

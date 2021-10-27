package com.example.convert_currency_app.repos;

import com.example.convert_currency_app.entities.Deal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface DealRepo extends CrudRepository<Deal, Integer> {
    @Query("select p from Deal p")
    List<NamesOnly> findAlld();

}

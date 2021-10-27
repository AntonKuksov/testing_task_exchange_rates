package com.example.convert_currency_app.repos;

import com.example.convert_currency_app.entities.Currency;
import org.springframework.data.repository.CrudRepository;

public interface CurrencyRepo extends CrudRepository<Currency, Integer> {
}

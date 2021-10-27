package com.example.convert_currency_app;

import com.example.convert_currency_app.entities.Cube;
import com.example.convert_currency_app.services.XMLService;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConvertCurrencyAppApplication implements CommandLineRunner {
	private XMLService xmlService;

	public ConvertCurrencyAppApplication(XMLService xmlService) {
		this.xmlService = xmlService;
	}

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ConvertCurrencyAppApplication.class);
		// disable spring banner
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		// load course from XMLService
//		Cube cube = xmlService.parseRates();

		// print course details
//		System.out.println(cube);
	}
}

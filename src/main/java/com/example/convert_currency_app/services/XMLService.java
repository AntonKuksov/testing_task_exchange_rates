package com.example.convert_currency_app.services;

import com.example.convert_currency_app.entities.Cube;
import com.example.convert_currency_app.entities.Currency;
import com.example.convert_currency_app.repos.RateRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

@Service
public class XMLService {

    private final Logger logger = LoggerFactory.getLogger(XMLService.class);
    @Autowired
    private RateRepo rateRepo;

    public Cube parseRates() {

        Cube cube = new Cube();

        try {
            String URL = "https://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml";

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(URL);
            // normalize XML response
            doc.getDocumentElement().normalize();
            //read time
            cube.setTime(doc.getElementsByTagName("Cube").item(1).getAttributes().item(0).getTextContent());
            rateRepo.save(cube);
            //read exchange rates
//            NodeList nodeList = doc.getElementsByTagName("Cube").item(1).getChildNodes();
//
//            //create an empty list for exchange rates
//            List<Currency> currencies = new ArrayList<>();
//
//            //loop all available exchange rates nodes
//            for (int i = 0; i < nodeList.getLength(); i++) {
//
//                Node node = nodeList.item(i);
//                if (node.getNodeName().equals("Cube")) {
//                    Currency curr = new Currency(node.getAttributes().item(0).getTextContent(),
//                            Double.parseDouble(node.getAttributes().item(1).getTextContent()));
//                    currencies.add(curr);
//                }
//            }
//
//            //set exchange rates in cube
//            cube.setCurrencyList(currencies);

        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }

        return cube;
    }
}

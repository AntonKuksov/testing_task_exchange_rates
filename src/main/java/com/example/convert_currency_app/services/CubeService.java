package com.example.convert_currency_app.services;

import com.example.convert_currency_app.entities.Cube;
import com.example.convert_currency_app.entities.Currency;
import com.example.convert_currency_app.model.CubeModel;
import com.example.convert_currency_app.repos.CurrencyRepo;
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
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class CubeService {
    private final Logger logger = LoggerFactory.getLogger(XMLService.class);

    @Autowired
    private RateRepo rateRepo;
    @Autowired
    private CurrencyRepo currencyRepo;


    public List<Currency> getOne(Integer id) {
        Cube cube = rateRepo.findCubeById(id);
        System.out.println(cube);
        List<Currency> curr = cube.getCurrencyList();
        return curr;
    }

    public void readXML()  {

            //read date from XML
            Cube cube3 = new Cube();
            Currency curr = new Currency();
            Calendar todaydate = Calendar.getInstance();
            try {
                String URL = "https://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml";
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document doc = builder.parse(URL);
                doc.getDocumentElement().normalize();
                String dateXML = doc.getElementsByTagName("Cube").item(1).getAttributes().item(0).getTextContent();

                SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
                String today = format1.format(todaydate.getTime());
                cube3.setTime(dateXML);
                //read exchange rates
                NodeList nodeList = doc.getElementsByTagName("Cube").item(1).getChildNodes();

                //create an empty list for exchange rates
                List<Currency> currencies = new ArrayList<>();

                //loop all available exchange rates nodes
                for (int i = 0; i < nodeList.getLength(); i++) {

                    Node node = nodeList.item(i);
                    if (node.getNodeName().equals("Cube")) {
                        Currency currtemp = new Currency();
                        currtemp.setCube(cube3);
                        currtemp.setTitle(node.getAttributes().item(0).getTextContent());
                        currtemp.setRate(Double.parseDouble(node.getAttributes().item(1).getTextContent()));
                        currencies.add(currtemp);

                    }
                    if (i+1 == nodeList.getLength()){ //Just add Euro rate in db
                        Currency currtempp = new Currency();
                        currtempp.setCube(cube3);
                        currtempp.setTitle("EUR");
                        currtempp.setRate(1);
                        currencies.add(currtempp);
                    }

                }
                //set exchange rates in cube
                cube3.setCurrencyList(currencies);
                rateRepo.save(cube3);
                currencyRepo.save(curr);
//                neednew = false;

            } catch (Exception ex) {
                logger.error(ex.getMessage());
            }
    }

    public CubeModel getByDate(Calendar c1) {

        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String time = format1.format(c1.getTime());
        System.out.println("Today is :" + time);
        Cube cube2 = rateRepo.findCubeByTime(time);
        if (cube2 == null) { //if didn't find TODAY
            c1.add(Calendar.DATE, -1);
            Date yesd  = c1.getTime();
            String уesterday = format1.format(yesd);
            Cube cube3 = rateRepo.findCubeByTime(уesterday);
            if (cube3 == null){  //if didn't find уesterday
                System.out.println("There is also no yesterday's exchange rate, now we will download rate from the bank");
                readXML();
                cube2 = rateRepo.findTopByOrderByIdDesc();
                return CubeModel.toModel(cube2);
            }
            else {return CubeModel.toModel(cube3);}
        }
        else {return CubeModel.toModel(cube2);
        }

    }


}

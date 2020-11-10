package com.example.demo.JavaFXModul.HttpMetod.PoliceMetodHttp;

import com.example.demo.SpringModul.Controler.ClientControler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

public class HttpDeletePolice {

    private static final String url ="http://localhost:8080/police/delet/?id=";
    static  private Logger logger = LoggerFactory.getLogger(HttpDeletePolice.class);

    public static void deletPoliceById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(url+id);
        logger.info("Delet police by ID -->" +id);
    }
}

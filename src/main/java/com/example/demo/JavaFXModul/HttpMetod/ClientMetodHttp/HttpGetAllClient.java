package com.example.demo.JavaFXModul.HttpMetod.ClientMetodHttp;

import com.example.demo.JavaFXModul.HttpMetod.PoliceMetodHttp.HttpGetAllPolice;
import com.example.demo.SpringModul.Models.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


import java.util.Arrays;
import java.util.List;

public class HttpGetAllClient {

    private final static String  url = "http://localhost:8080/get";
    private static Logger logger = LoggerFactory.getLogger(HttpGetAllPolice.class);

    public static List<Client> getAllClient() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Client[]> response =  restTemplate.getForEntity(url , Client[].class);
        List<Client> clients = Arrays.asList(response.getBody());
        logger.info("Respon URL: "+url+ " -->  " + response.getStatusCode());
        return clients;

    }
}

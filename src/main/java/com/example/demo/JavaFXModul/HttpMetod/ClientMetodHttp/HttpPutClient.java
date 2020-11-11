package com.example.demo.JavaFXModul.HttpMetod.ClientMetodHttp;

import com.example.demo.JavaFXModul.HttpMetod.PoliceMetodHttp.HttpPutPolicy;
import com.example.demo.SpringModul.Models.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

public class HttpPutClient {

    private static final String url ="http://localhost:8080/put";
    static  private Logger logger = LoggerFactory.getLogger(HttpPutPolicy.class);

    public static void putClient(Client client) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Client> request = new HttpEntity(client);
        restTemplate.put(url, request , Client.class);
        logger.info("Update Client --> " + client);
    }
}

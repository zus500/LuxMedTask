package com.example.demo.JavaFXModul.HttpMetod.PoliceMetodHttp;

import com.example.demo.SpringModul.Models.Client;
import com.example.demo.SpringModul.Models.Policy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class HttpGetAllPolice {

    private static Logger logger = LoggerFactory.getLogger(HttpGetAllPolice.class);
    private final static    String url = "http://localhost:8080/police/getall";

    public static  List<Policy> getAllClient(Client client) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Client> body =  new HttpEntity(client);
        ResponseEntity<List<Policy>> response = restTemplate.exchange(url, HttpMethod.POST, body, new ParameterizedTypeReference<List<Policy>>() {});
        logger.info("Respon URL: "+url+ " -->  " + response.getStatusCode());
        return response.getBody();
    }
}

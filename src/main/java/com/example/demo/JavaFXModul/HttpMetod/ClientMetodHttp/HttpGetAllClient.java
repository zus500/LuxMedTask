package com.example.demo.JavaFXModul.HttpMetod.ClientMetodHttp;

import com.example.demo.SpringModul.Models.Client;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class HttpGetAllClient {


    public static List<Client> getAllClient() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/get";
        ResponseEntity<List<Client>> response = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Client>>() {
        });
        return response.getBody();
    }
}

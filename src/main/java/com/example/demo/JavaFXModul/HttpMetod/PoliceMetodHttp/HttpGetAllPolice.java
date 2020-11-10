package com.example.demo.JavaFXModul.HttpMetod.PoliceMetodHttp;

import com.example.demo.SpringModul.Models.Client;
import com.example.demo.SpringModul.Models.Police;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class HttpGetAllPolice {


    public static  List<Police> getAllClient(Client client) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Client> body =  new HttpEntity(client);
        System.out.println(client);
        String url = "http://localhost:8080/police/getall";
        ResponseEntity<List<Police>> response = restTemplate.exchange(url, HttpMethod.POST, body, new ParameterizedTypeReference<List<Police>>() {});
        System.out.println(response.getBody());
        return response.getBody();
    }
}

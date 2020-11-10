package com.example.demo.JavaFXModul.HttpMetod.PoliceMetodHttp;

import org.springframework.web.client.RestTemplate;

public class HttpDeletePolice {


    public static void deletPoliceById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        final String url = "http://localhost:8080/police/delet/?id=";
        restTemplate.delete(url+id);
    }
}

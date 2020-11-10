package com.example.demo.JavaFXModul.HttpMetod.ClientMetodHttp;
import org.springframework.web.client.RestTemplate;



public class HttpDeletedClient {


    public static void deletClientById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        final String url = "http://localhost:8080/delet/?id=";

        restTemplate.delete(url+id);
    }
}

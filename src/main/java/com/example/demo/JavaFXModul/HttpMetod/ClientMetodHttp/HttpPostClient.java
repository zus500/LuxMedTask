package com.example.demo.JavaFXModul.HttpMetod.ClientMetodHttp;

import com.example.demo.SpringModul.Models.Client;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;


 public   class   HttpPostClient {

    public static void sendPOST(Client client) {


        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Client> request = new HttpEntity(client);
        restTemplate.postForObject("http://localhost:8080/post", request , Client.class);

    }
 }

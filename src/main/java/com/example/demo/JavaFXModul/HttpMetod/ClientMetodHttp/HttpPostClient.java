package com.example.demo.JavaFXModul.HttpMetod.ClientMetodHttp;

import com.example.demo.JavaFXModul.HttpMetod.PoliceMetodHttp.HttpDeletePolice;
import com.example.demo.SpringModul.Models.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;


 public class HttpPostClient {

     private static final String url ="http://localhost:8080/post";
     static  private Logger logger = LoggerFactory.getLogger(HttpPostClient.class);

    public static void postClient(Client client) {


        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Client> request = new HttpEntity(client);
        restTemplate.postForObject("http://localhost:8080/post", request , Client.class);
        logger.info("Update client --> "+client);
    }
 }

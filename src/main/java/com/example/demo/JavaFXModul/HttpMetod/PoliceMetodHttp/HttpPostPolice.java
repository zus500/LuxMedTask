package com.example.demo.JavaFXModul.HttpMetod.PoliceMetodHttp;

import com.example.demo.SpringModul.Models.Client;
import com.example.demo.SpringModul.Models.Police;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

public class HttpPostPolice {

    public static void sendPOST(Police police) {


        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Police> request = new HttpEntity(police);
        restTemplate.postForObject("http://localhost:8080/police/post", request , Police.class);

    }

}

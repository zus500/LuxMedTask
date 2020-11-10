package com.example.demo.JavaFXModul.HttpMetod.PoliceMetodHttp;

import com.example.demo.SpringModul.Models.Police;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

public class HttpPatchPolice {


    public static void sendPatch(Police police) {


        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Police> request = new HttpEntity(police);
        restTemplate.patchForObject("http://localhost:8080/police/patch", request , Police.class);

    }
}

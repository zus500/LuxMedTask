package com.example.demo.JavaFXModul.HttpMetod.PoliceMetodHttp;

import com.example.demo.SpringModul.Models.Policy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

public class HttpPutPolicy {


    private static final String url ="http://localhost:8080/police/put";
    static  private Logger logger = LoggerFactory.getLogger(HttpPutPolicy.class);

    public static void putPolice(Policy policy) {


        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Policy> request = new HttpEntity(policy);
        restTemplate.put(url, request , Policy.class);
        logger.info("Update police --> " + policy);
    }
}

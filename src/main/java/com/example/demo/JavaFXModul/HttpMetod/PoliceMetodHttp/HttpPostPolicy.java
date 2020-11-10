package com.example.demo.JavaFXModul.HttpMetod.PoliceMetodHttp;

import com.example.demo.SpringModul.Models.Policy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

public class HttpPostPolicy {

    static  private Logger logger = LoggerFactory.getLogger(HttpPostPolicy.class);
    private static final String url = "http://localhost:8080/police/post";

    public static void postPolicy(Policy policy) {


        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Policy> request = new HttpEntity(policy);
        restTemplate.postForObject(url, request , Policy.class);
        logger.info("Save new police -->" + policy);

    }

}

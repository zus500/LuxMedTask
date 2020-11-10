package com.example.demo.JavaFXModul.HttpMetod.ClientMetodHttp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;



public class HttpDeletedClient {

    private static final String url ="http://localhost:8080/delet/?id=";
    static  private Logger logger = LoggerFactory.getLogger(HttpPostClient.class);

    public static void deletClientById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(url+id);
        logger.info("Delet client by ID --> " + id);
    }
}

package com.example.demo.SpringModul.Controler;


import com.example.demo.SpringModul.Models.Client;
import com.example.demo.SpringModul.Service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientControler {

    private Logger logger = LoggerFactory.getLogger(ClientControler.class);

    @Autowired
    ClientService clientService;


    public ClientControler(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/get")
    public Iterable<Client> getAllClients(){
        logger.info("Return all client");
        return clientService.GetAllClient();
    }

    @PostMapping("/post")
    public Client creatClient(@RequestBody Client client){
        logger.info("Save new client --> "+client);
            return clientService.SaveClient(client);
    }

    @DeleteMapping("/delet/")
    public void deletUsers(@RequestParam int id){
        logger.info("Delet client by ID:-->"+ id);
            clientService.DeletClient(id);
    }
}

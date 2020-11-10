package com.example.demo.SpringModul.Controler;


import com.example.demo.SpringModul.Models.Client;
import com.example.demo.SpringModul.Models.Police;
import com.example.demo.SpringModul.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserControler {

    @Autowired
    ClientService clientService;


    @GetMapping("/get")
    public Iterable<Client> getAll(){

        return clientService.GetAllClient();
    }

    @PostMapping("/post")
    public void creatUsers(@RequestBody Client client){
        clientService.SaveClient(client);
    }

    @DeleteMapping("/delet/")
    public void deletUsers(@RequestParam Long id){
        clientService.DeletClient(id);
    }
}

package com.example.demo.SpringModul.Controler;

import com.example.demo.SpringModul.Models.Client;
import com.example.demo.SpringModul.Models.Policy;
import com.example.demo.SpringModul.Service.PoliceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/police")
public class PoliceControler {


    @Autowired
    PoliceService policeService;
    private Logger logger = LoggerFactory.getLogger(PoliceControler.class);


    @PostMapping("/post")
    public void SavePolice(@RequestBody Policy policy){
        logger.info("Save new policy --> " +policy);
        policeService.SavePolice(policy);
    }

    @PostMapping("/getall")
    public List<Policy> FindAllById(@RequestBody Client id){
        logger.info("Return all policy to client -->" + id);
        return policeService.FindAllById(id);
    }
    @DeleteMapping("/delet/")
    public void DeletPolice(@RequestParam Long id){
        logger.info("Delet policy by ID -->" + id);
        policeService.DeletPolicy(id);
    }

    @PutMapping("/patch")
    public void UpdatePolice(@RequestBody Policy policy){
        logger.info("Edit --> " + policy);
        policeService.UpdatePolice(policy);
    }
}

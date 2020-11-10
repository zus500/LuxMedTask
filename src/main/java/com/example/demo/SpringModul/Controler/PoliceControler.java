package com.example.demo.SpringModul.Controler;

import com.example.demo.SpringModul.Models.Client;
import com.example.demo.SpringModul.Models.Police;
import com.example.demo.SpringModul.Service.PoliceService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/police")
public class PoliceControler {

    @Autowired
    PoliceService policeService;


    @PostMapping("/post")
    public void SavePolice(@RequestBody Police police){
        policeService.SavePolice(police);
    }

    @PostMapping("/getall")
    public List<Police> FindAllById(@RequestBody Client id){

        return policeService.FindAllById(id);
    }
    @DeleteMapping("/delet/")
    public void DeletPolice(@RequestParam Long id){

        policeService.DeletPolicy(id);
    }

    @PatchMapping("/patch")
    public void UpdatePolice(@RequestBody Police police){
        System.out.println("asdie "+ police);
        policeService.UpdatePolice(police);
    }
}

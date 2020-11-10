package com.example.demo.SpringModul.Service;


import com.example.demo.SpringModul.Models.Client;
import com.example.demo.SpringModul.Models.Policy;
import com.example.demo.SpringModul.Repository.PoliceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoliceService {

    @Autowired
    PoliceRepository policeRepository;

    public void SavePolice(Policy policy){
        policeRepository.save(policy);

    }
    public List<Policy> FindAllById(Client id)
    {return  policeRepository.findAllByClient(id);}

    public void DeletPolicy(Long id){
        policeRepository.deleteById(id);
    }

    public void UpdatePolice(Policy policy) {
        policeRepository.save(policy);
    }
}

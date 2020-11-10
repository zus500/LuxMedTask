package com.example.demo.SpringModul.Service;

import com.example.demo.SpringModul.Models.Client;
import com.example.demo.SpringModul.Models.Police;
import com.example.demo.SpringModul.Repository.ClientRepository;
import com.example.demo.SpringModul.Repository.PoliceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    PoliceRepository policeService;

    public Iterable<Client> GetAllClient(){
        return clientRepository.findAll();
    }

    public  void  SaveClient(Client client){

        clientRepository.save(client);
    }

    public void  DeletClient(Long id){
        Optional<Client> client = clientRepository.findById(id);
        policeService.findAllByClient(client.get()).forEach(e ->{
            policeService.deleteById(e.getId());
        });
        clientRepository.deleteById(id);
    }
}

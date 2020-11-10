package com.example.demo.SpringModul.Repository;

import com.example.demo.SpringModul.Models.Client;
import com.example.demo.SpringModul.Models.Policy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PoliceRepository  extends CrudRepository<Policy, Long> {

    public List<Policy> findAllByClient(Client id);

}

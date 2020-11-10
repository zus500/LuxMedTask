package com.example.demo.SpringModul.Repository;

import com.example.demo.SpringModul.Models.Client;
import com.example.demo.SpringModul.Models.Police;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PoliceRepository  extends CrudRepository<Police, Long> {

    public List<Police> findAllByClient(Client id);

}

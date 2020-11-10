package com.example.demo.SpringModul.Repository;

import com.example.demo.SpringModul.Models.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ClientRepository extends CrudRepository <Client , Long> {

}

package com.example.lynxAPI.repository;

import com.example.lynxAPI.model.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepository extends MongoRepository<Client, Long> {
}

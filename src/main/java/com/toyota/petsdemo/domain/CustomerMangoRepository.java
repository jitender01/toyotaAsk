package com.toyota.petsdemo.domain;


import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerMangoRepository extends MongoRepository<Customer, Integer> {
        Optional<Customer> findById(Integer id);

        List<Customer> findAll();


}


package com.toyota.petsdemo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class PetsController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${pets.url}")
    private String petsServiceURL;


    @RequestMapping(value = "/pets", method = RequestMethod.GET)
    public List getAllPets() {
      return restTemplate.getForObject(petsServiceURL , ArrayList.class);
    }

    @RequestMapping(value = "/pets/{inputString}", method = RequestMethod.GET)
    public List getPets(@PathVariable String inputString) {
        return restTemplate.getForObject(petsServiceURL+inputString , ArrayList.class);
    }
}

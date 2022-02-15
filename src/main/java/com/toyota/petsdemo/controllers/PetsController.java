package com.toyota.petsdemo.controllers;


import com.toyota.petsdemo.domain.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Pet getPets(@PathVariable String inputString) {
        return restTemplate.getForObject(petsServiceURL+inputString , Pet.class);
    }

    @RequestMapping(value = "/pets/{id}", method = RequestMethod.PUT)
    public void removePets(@PathVariable String inputString) {

        Map< String, String > params = new HashMap< String, String >();
        params.put("id", inputString);
        restTemplate.delete(petsServiceURL , params);

    }

}

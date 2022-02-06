package com.toyota.petsdemo.controllers;
import com.toyota.petsdemo.domain.CustomerMangoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customerapi")
public class CustomerController {
    Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    CustomerMangoRepository customerMangoRepository;




    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public List<?> findCustomers() {

        logger.info("calling repo to get all the customers");

        return   customerMangoRepository.findAll();
    }





}

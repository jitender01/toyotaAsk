package com.toyota.petsdemo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/customerapi")
public class MessageController {
    Logger logger = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    List kafkaList;

    @RequestMapping(value = "/message",  method = RequestMethod.POST)
    String   publishMessage() {
        kafkaTemplate.send("toyota","Hello:team");

        return "{\"code\":0}";
    }


    @RequestMapping(value = "/message" ,  method = RequestMethod.GET)
    List<String>   getMessage() {
        kafkaTemplate.send("toyota","Hello:team");

        return kafkaList;
    }


    @KafkaListener(topics = "toyota")
    public void listen(String message) {

        logger.info("message -->",message);
        kafkaList.add(message);
    }



}

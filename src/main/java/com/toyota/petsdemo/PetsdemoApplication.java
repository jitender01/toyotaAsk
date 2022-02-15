package com.toyota.petsdemo;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Collections;
import java.util.Map;

@SpringBootApplication
public class PetsdemoApplication  {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(PetsdemoApplication.class);

    //    app.setDefaultProperties(Collections
       //         .singletonMap("server.port", "8083"));

        app.run(args);
    }


}

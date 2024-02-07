package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NumberingConfiguration {

    @Bean
    CommandLineRunner initDatabase(NumberingRepository repository) {

        
        return args -> {
            /** 
            repository.save();
            repository.save());
            **/
        };
    }
}
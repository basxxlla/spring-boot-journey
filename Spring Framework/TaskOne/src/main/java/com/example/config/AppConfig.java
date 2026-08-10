package com.example.config;

import com.example.service.PersonService;
import com.example.service.MangerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public PersonService personService() {
        return new PersonService();
    }

    @Bean
    public MangerService mangerService() {
        return new MangerService();
    }
}

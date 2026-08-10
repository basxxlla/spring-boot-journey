package com.example.config;

import com.example.service.AccountServiceImpl;
import com.example.service.PersonService;
import com.example.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public PersonService personService() {
        return new PersonService();
    }

    @Bean
    public AccountServiceImpl accountServiceImpl() {
        // Inject PersonService (as UserService) via constructor
        return new AccountServiceImpl(personService());
    }
}

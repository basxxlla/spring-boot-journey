package com.example;

import com.example.config.AppConfig;
import com.example.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainJavaConfig {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService personService = context.getBean("personService", UserService.class);
        UserService mangerService = context.getBean("mangerService", UserService.class);

        personService.save("Ahmed");
        personService.update("Ahmed");

        mangerService.save("Sara");
        mangerService.update("Sara");
    }
}

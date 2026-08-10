package com.example;

import com.example.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainXml {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        UserService personService = (UserService) context.getBean("personService");
        UserService mangerService = (UserService) context.getBean("mangerService");

        personService.save("Ahmed");
        personService.update("Ahmed");

        mangerService.save("Sara");
        mangerService.update("Sara");
    }
}

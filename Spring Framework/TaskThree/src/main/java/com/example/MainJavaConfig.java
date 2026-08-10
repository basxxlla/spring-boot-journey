package com.example;

import com.example.config.AppConfig;
import com.example.service.PersonService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainJavaConfig {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        // Because scope is "prototype", each getBean() call returns a NEW instance.
        // Notice "constructor called" + "init()" print twice below.
        PersonService person1 = context.getBean("personService", PersonService.class);
        person1.save("Ahmed");

        PersonService person2 = context.getBean("personService", PersonService.class);
        person2.save("Sara");

        System.out.println("Same instance? " + (person1 == person2)); // false

        // Spring will NOT call destroy() automatically for prototype beans,
        // even after context.close(). We call it manually if cleanup is needed.
        person1.destroy();
        person2.destroy();

        context.close();
    }
}

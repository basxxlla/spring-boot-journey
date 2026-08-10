package com.example;

import com.example.service.PersonService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainXml {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

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

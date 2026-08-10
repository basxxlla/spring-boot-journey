package com.example;

import com.example.service.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainXml {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        AccountServiceImpl accountServiceImpl =
                (AccountServiceImpl) context.getBean("accountServiceImpl");

        accountServiceImpl.save("Ahmed");
    }
}

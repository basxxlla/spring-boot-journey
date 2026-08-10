package com.example;

import com.example.config.AppConfig;
import com.example.service.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainJavaConfig {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        AccountServiceImpl accountServiceImpl =
                context.getBean("accountServiceImpl", AccountServiceImpl.class);

        accountServiceImpl.save("Ahmed");
    }
}

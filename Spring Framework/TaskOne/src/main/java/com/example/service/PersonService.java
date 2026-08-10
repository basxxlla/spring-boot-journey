package com.example.service;

public class PersonService implements UserService {
    @Override
    public void save(String name) {
        System.out.println("PersonService: saving person -> " + name);
    }

    @Override
    public void update(String name) {
        System.out.println("PersonService: updating person -> " + name);
    }
}

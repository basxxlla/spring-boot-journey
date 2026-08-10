package com.example.service;

public class MangerService implements UserService {
    @Override
    public void save(String name) {
        System.out.println("MangerService: saving manager -> " + name);
    }

    @Override
    public void update(String name) {
        System.out.println("MangerService: updating manager -> " + name);
    }
}

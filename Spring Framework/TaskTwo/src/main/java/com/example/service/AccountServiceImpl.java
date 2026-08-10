package com.example.service;

/**
 * Implements UserService (so callers can invoke save(name) directly)
 * and AccountService (getSavePerson). Internally it delegates the
 * actual saving work to a PersonService instance (injected via the container).
 */
public class AccountServiceImpl implements UserService, AccountService {

    private final UserService personService;

    // Constructor injection - the container will supply a PersonService bean here
    public AccountServiceImpl(UserService personService) {
        this.personService = personService;
    }

    @Override
    public void save(String name) {
        System.out.println("AccountServiceImpl: delegating save() to PersonService");
        personService.save(name);
    }

    @Override
    public void getSavePerson(String name) {
        System.out.println("AccountServiceImpl: getSavePerson() called");
        save(name);
    }
}

package com.example.service;

public class PersonService implements UserService {

    public PersonService() {
        System.out.println("PersonService: constructor called (bean instance created)");
    }

    @Override
    public void save(String name) {
        System.out.println("PersonService: saving person -> " + name);
    }

    /**
     * Called by the Spring container right after the bean is constructed
     * and its dependencies are set. Wired via init-method (XML)
     * or @Bean(initMethod = "init") (Java config).
     */
    public void init() {
        System.out.println("PersonService: init() -> bean initialized");
    }

    /**
     * Wired via destroy-method (XML) or @Bean(destroyMethod = "destroy") (Java config).
     *
     * IMPORTANT: because this bean is scope="prototype", Spring will NOT call
     * this method automatically. Spring hands the prototype instance to the
     * caller and stops managing its lifecycle from that point on - it does not
     * keep a reference, so it has no way of knowing when the bean is no longer
     * needed. destroy-method / destroyMethod is only invoked automatically for
     * singleton-scoped beans when the context is closed.
     *
     * To run cleanup for a prototype bean you must call it yourself
     * (see Main classes), or use something like Spring's
     * DestructionAwareBeanPostProcessor / a custom cleanup callback.
     */
    public void destroy() {
        System.out.println("PersonService: destroy() -> bean destroyed (called manually here)");
    }
}

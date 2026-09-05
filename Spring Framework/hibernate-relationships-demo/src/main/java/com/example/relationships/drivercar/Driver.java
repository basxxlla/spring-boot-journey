package com.example.relationships.drivercar;

import javax.persistence.*;

// Relationship: ONE-TO-ONE (a driver is currently assigned exactly one car).
// If a driver can use different cars over time / share a car, model this as
// ONE-TO-MANY (Car -> Driver) or MANY-TO-MANY instead.
@Entity
public class Driver {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id", unique = true)
    private Car car;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Car getCar() { return car; }
    public void setCar(Car car) { this.car = car; }
}

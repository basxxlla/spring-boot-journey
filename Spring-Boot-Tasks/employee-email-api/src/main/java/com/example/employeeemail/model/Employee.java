package com.example.employeeemail.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// NOTE: plain @Getter/@Setter (not Lombok's @Data) - @Data would generate
// equals/hashCode/toString that recurse through the bidirectional
// Employee <-> Email relationship and can blow the stack.
@Entity
@Table(name = "employee")
@Getter
@Setter
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int age;

    private double salary;

    // Employee has many Emails - One-to-Many, inverse side (Email owns the FK)
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Email> emails = new ArrayList<>();

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
}

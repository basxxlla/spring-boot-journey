package com.example.model;

import javax.persistence.*;
import org.hibernate.annotations.Check;

@Entity
@Table(name = "teacher")
// DB-level CHECK constraint: age must be between 15 and 20 (inclusive)
@Check(constraints = "age between 15 and 20")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // size 50
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    // enforced at DB level via @Check above (JPA doesn't have a range annotation itself)
    @Column(name = "age", nullable = false)
    private int age;

    // unique
    @Column(name = "address", nullable = false, unique = true)
    private String address;

    public Teacher() {
        // required no-arg constructor for Hibernate
    }

    public Teacher(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}

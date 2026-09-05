package com.example.relationships.studentpassport;

import javax.persistence.*;

// Relationship: ONE-TO-ONE (a student has exactly one passport)
@Entity
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passport_id", unique = true)
    private Passport passport;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Passport getPassport() { return passport; }
    public void setPassport(Passport passport) { this.passport = passport; }
}

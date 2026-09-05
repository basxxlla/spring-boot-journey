package com.example.inheritance.joined;

import javax.persistence.*;

// JOINED: base class fields live in "person"; each subclass gets its OWN
// table (employee / customer) holding only its extra fields, joined back to
// "person" by a shared primary key. Normalized, no wasted nullable columns,
// but reads need a JOIN.
@Entity
@Table(name = "person_joined")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}

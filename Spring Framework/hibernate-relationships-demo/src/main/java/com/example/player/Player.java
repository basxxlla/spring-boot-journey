package com.example.player;

import javax.persistence.*;

@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    // NOTE: "length" only affects VARCHAR/String columns in JPA/Hibernate.
    // For a numeric column most dialects ignore it (they'd use precision/scale
    // instead). Kept here to satisfy the literal request; if you actually meant
    // a text/code field capped at 10 chars, change the type to String.
    @Column(name = "age", length = 10)
    private int age;

    @Column(name = "status")
    private boolean status;

    public Player() {
    }

    public Player(String name, int age, boolean status) {
        this.name = name;
        this.age = age;
        this.status = status;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Player{id=" + id + ", name='" + name + "', age=" + age + ", status=" + status + "}";
    }
}

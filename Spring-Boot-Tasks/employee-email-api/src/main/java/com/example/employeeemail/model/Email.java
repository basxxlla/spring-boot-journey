package com.example.employeeemail.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "email")
@Getter
@Setter
@NoArgsConstructor
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // email "type", e.g. gmail, yahoo, outlook
    private String name;

    // the actual email address, e.g. eslam@gmail.com
    private String content;

    // Email belongs to one Employee - Many-to-One, owning side (FK lives here)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Email(String name, String content) {
        this.name = name;
        this.content = content;
    }
}

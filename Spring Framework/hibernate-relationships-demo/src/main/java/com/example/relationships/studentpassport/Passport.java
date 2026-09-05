package com.example.relationships.studentpassport;

import javax.persistence.*;

@Entity
public class Passport {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String passportNumber;

    @OneToOne(mappedBy = "passport")
    private Student student;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getPassportNumber() { return passportNumber; }
    public void setPassportNumber(String passportNumber) { this.passportNumber = passportNumber; }
    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }
}

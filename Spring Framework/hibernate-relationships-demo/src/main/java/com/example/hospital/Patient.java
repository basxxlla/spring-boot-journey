package com.example.hospital;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String typeOfDisease;

    // Patient -> Doctor : the "many" side of Doctor ONE-TO-MANY Patient
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    // Patient <-> Hospital : inverse side of the MANY-TO-MANY relationship
    @ManyToMany(mappedBy = "patients")
    private List<Hospital> hospitals = new ArrayList<>();

    public Patient() {
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getTypeOfDisease() { return typeOfDisease; }
    public void setTypeOfDisease(String typeOfDisease) { this.typeOfDisease = typeOfDisease; }
    public Doctor getDoctor() { return doctor; }
    public void setDoctor(Doctor doctor) { this.doctor = doctor; }
    public List<Hospital> getHospitals() { return hospitals; }
    public void setHospitals(List<Hospital> hospitals) { this.hospitals = hospitals; }
}

package com.example.hospital;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hospital")
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int numberOfDoctors;
    private int numberOfPatient;

    // Hospital -> Doctor : ONE-TO-MANY (one hospital employs many doctors)
    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL)
    private List<Doctor> doctors = new ArrayList<>();

    // Hospital <-> Patient : MANY-TO-MANY (a patient can be treated at several
    // hospitals, a hospital treats many patients) - owning side, backed by
    // the hospital_patient join table.
    @ManyToMany
    @JoinTable(
            name = "hospital_patient",
            joinColumns = @JoinColumn(name = "hospital_id"),
            inverseJoinColumns = @JoinColumn(name = "patient_id")
    )
    private List<Patient> patients = new ArrayList<>();

    public Hospital() {
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getNumberOfDoctors() { return numberOfDoctors; }
    public void setNumberOfDoctors(int numberOfDoctors) { this.numberOfDoctors = numberOfDoctors; }
    public int getNumberOfPatient() { return numberOfPatient; }
    public void setNumberOfPatient(int numberOfPatient) { this.numberOfPatient = numberOfPatient; }
    public List<Doctor> getDoctors() { return doctors; }
    public void setDoctors(List<Doctor> doctors) { this.doctors = doctors; }
    public List<Patient> getPatients() { return patients; }
    public void setPatients(List<Patient> patients) { this.patients = patients; }
}

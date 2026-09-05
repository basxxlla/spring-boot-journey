package com.example.relationships.doctorpatient;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// Relationship: MANY-TO-MANY
// Note: in the Hospital schema (Part 2) Doctor->Patient was modeled as ONE-TO-MANY
// (each patient has a single assigned doctor). Here, as a standalone general
// example, MANY-TO-MANY is used instead (a patient may see several doctors,
// e.g. specialists, and a doctor has many patients). Pick whichever matches
// your actual business rule.
@Entity
public class Doctor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(
            name = "doctor_patient",
            joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "patient_id")
    )
    private List<Patient> patients = new ArrayList<>();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<Patient> getPatients() { return patients; }
    public void setPatients(List<Patient> patients) { this.patients = patients; }
}

package com.example.hospital;

import javax.persistence.*;

@Entity
@Table(name = "doctor_details")
public class DoctorDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // "fukkAddress" in the spec is treated as a typo for "fullAddress"
    @Column(name = "full_address")
    private String fullAddress;

    private String firstName;
    private String lastName;
    private int age;

    // Inverse side of the Doctor <-> DoctorDetails ONE-TO-ONE relationship
    @OneToOne(mappedBy = "doctorDetails")
    private Doctor doctor;

    public DoctorDetails() {
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFullAddress() { return fullAddress; }
    public void setFullAddress(String fullAddress) { this.fullAddress = fullAddress; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public Doctor getDoctor() { return doctor; }
    public void setDoctor(Doctor doctor) { this.doctor = doctor; }
}

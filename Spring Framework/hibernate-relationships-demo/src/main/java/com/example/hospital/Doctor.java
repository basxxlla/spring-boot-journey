package com.example.hospital;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private double salary;

    // Doctor -> Hospital : the "many" side of Hospital ONE-TO-MANY Doctor
    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    // Doctor <-> DoctorDetails : ONE-TO-ONE, owning side (holds the FK)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor_details_id", unique = true)
    private DoctorDetails doctorDetails;

    // Doctor -> Patient : ONE-TO-MANY (one doctor treats many patients)
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<Patient> patients = new ArrayList<>();

    public Doctor() {
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
    public Hospital getHospital() { return hospital; }
    public void setHospital(Hospital hospital) { this.hospital = hospital; }
    public DoctorDetails getDoctorDetails() { return doctorDetails; }
    public void setDoctorDetails(DoctorDetails doctorDetails) { this.doctorDetails = doctorDetails; }
    public List<Patient> getPatients() { return patients; }
    public void setPatients(List<Patient> patients) { this.patients = patients; }
}

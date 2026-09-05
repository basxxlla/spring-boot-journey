package com.example.inheritance.joined;

import javax.persistence.*;

@Entity
@Table(name = "employee_joined")
@PrimaryKeyJoinColumn(name = "person_id")
public class Employee extends Person {
    private double salary;

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
}

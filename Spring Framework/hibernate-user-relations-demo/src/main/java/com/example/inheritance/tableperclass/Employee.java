package com.example.inheritance.tableperclass;

import javax.persistence.*;

@Entity
@Table(name = "employee_tpc")
public class Employee extends Person {
    private double salary;

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
}

package com.example.employeeemail.repository;

import com.example.employeeemail.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByNameIn(List<String> names);
}

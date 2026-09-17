package com.example.employee.service;

import com.example.employee.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    // 1
    List<Employee> getAll();
    // 2
    List<Employee> getByIds(List<Long> ids);
    // 3
    Employee save(Employee employee);
    // 4
    List<Employee> saveAll(List<Employee> employees);
    // 5
    Employee update(Long id, Employee employee);
    // 6
    List<Employee> updateAll(List<Employee> employees);
    // 7
    void deleteAll();
    // 8
    void deleteById(Long id);
    // 9
    void deleteByIds(List<Long> ids);
    // 10 (3 variants)
    List<Employee> searchByNameDerived(String name);
    List<Employee> searchByNameNative(String name);
    List<Employee> searchByNameJPQL(String name);

    Optional<Employee> getById(Long id);
}

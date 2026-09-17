package com.example.employee.service;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // 1. Get All Employees
    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getById(Long id) {
        return employeeRepository.findById(id);
    }

    // 2. Get Employees By List of IDs
    @Override
    public List<Employee> getByIds(List<Long> ids) {
        return employeeRepository.findAllById(ids);
    }

    // 3. Save Employee
    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    // 4. Save List of Employees
    @Override
    public List<Employee> saveAll(List<Employee> employees) {
        return employeeRepository.saveAll(employees);
    }

    // 5. Update Employee
    @Override
    public Employee update(Long id, Employee employee) {
        Employee existing = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with id: " + id));
        existing.setName(employee.getName());
        existing.setAge(employee.getAge());
        existing.setPhoneNumber(employee.getPhoneNumber());
        return employeeRepository.save(existing);
    }

    // 6. Update List of Employees
    // Each Employee in the list MUST carry its own id so we know which row to update.
    @Override
    public List<Employee> updateAll(List<Employee> employees) {
        for (Employee e : employees) {
            if (e.getId() == null || !employeeRepository.existsById(e.getId())) {
                throw new EntityNotFoundException("Employee not found with id: " + e.getId());
            }
        }
        return employeeRepository.saveAll(employees);
    }

    // 7. Delete All Employees
    @Override
    public void deleteAll() {
        employeeRepository.deleteAll();
    }

    // 8. Delete Employee By ID
    @Override
    public void deleteById(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new EntityNotFoundException("Employee not found with id: " + id);
        }
        employeeRepository.deleteById(id);
    }

    // 9. Delete Employees By List of IDs
    @Override
    public void deleteByIds(List<Long> ids) {
        employeeRepository.deleteAllById(ids);
    }

    // 10. Search Employee By Name - three implementations
    @Override
    public List<Employee> searchByNameDerived(String name) {
        return employeeRepository.findByNameStartingWith(name);
    }

    @Override
    public List<Employee> searchByNameNative(String name) {
        return employeeRepository.searchByNameNative(name);
    }

    @Override
    public List<Employee> searchByNameJPQL(String name) {
        return employeeRepository.searchByNameJPQL(name);
    }
}

package com.example.employee.controller;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // 1. Get All Employees
    @GetMapping
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(employeeService.getAll());
    }

    // (bonus) Get Employee By ID - not in your numbered list but handy alongside the others
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable Long id) {
        return employeeService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 2. Get Employees By List of IDs
    // GET /api/employees/by-ids?ids=1,2,3
    @GetMapping("/by-ids")
    public ResponseEntity<List<Employee>> getByIds(@RequestParam List<Long> ids) {
        return ResponseEntity.ok(employeeService.getByIds(ids));
    }

    // 3. Save Employee
    @PostMapping
    public ResponseEntity<Employee> save(@Valid @RequestBody Employee employee) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.save(employee));
    }

    // 4. Save List of Employees
    @PostMapping("/batch")
    public ResponseEntity<List<Employee>> saveAll(@Valid @RequestBody List<Employee> employees) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.saveAll(employees));
    }

    // 5. Update Employee
    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable Long id, @Valid @RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.update(id, employee));
    }

    // 6. Update List of Employees
    // Each Employee object in the request body must include its own "id".
    @PutMapping("/batch")
    public ResponseEntity<List<Employee>> updateAll(@RequestBody List<Employee> employees) {
        return ResponseEntity.ok(employeeService.updateAll(employees));
    }

    // 7. Delete All Employees
    @DeleteMapping
    public ResponseEntity<Void> deleteAll() {
        employeeService.deleteAll();
        return ResponseEntity.noContent().build();
    }

    // 8. Delete Employee By ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        employeeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // 9. Delete Employees By List of IDs
    // DELETE /api/employees/by-ids?ids=1,2,3
    @DeleteMapping("/by-ids")
    public ResponseEntity<Void> deleteByIds(@RequestParam List<Long> ids) {
        employeeService.deleteByIds(ids);
        return ResponseEntity.noContent().build();
    }

    // 10. Search Employee By Name - 3 variants, e.g. name=ahmed -> matches "ahmed%"
    @GetMapping("/search/derived")
    public ResponseEntity<List<Employee>> searchDerived(@RequestParam String name) {
        return ResponseEntity.ok(employeeService.searchByNameDerived(name));
    }

    @GetMapping("/search/native")
    public ResponseEntity<List<Employee>> searchNative(@RequestParam String name) {
        return ResponseEntity.ok(employeeService.searchByNameNative(name));
    }

    @GetMapping("/search/jpql")
    public ResponseEntity<List<Employee>> searchJPQL(@RequestParam String name) {
        return ResponseEntity.ok(employeeService.searchByNameJPQL(name));
    }
}

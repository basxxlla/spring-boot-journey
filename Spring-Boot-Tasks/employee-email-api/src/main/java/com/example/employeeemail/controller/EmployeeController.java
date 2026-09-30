package com.example.employeeemail.controller;

import com.example.employeeemail.dto.EmployeeRequestDto;
import com.example.employeeemail.dto.EmployeeResponseDto;
import com.example.employeeemail.dto.EmployeeWithEmailsRequestDto;
import com.example.employeeemail.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    // create API to create Employee
    @PostMapping
    public ResponseEntity<EmployeeResponseDto> create(@Valid @RequestBody EmployeeRequestDto dto) {
        return new ResponseEntity<>(employeeService.create(dto), HttpStatus.CREATED);
    }

    // create API to update Employee
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponseDto> update(
            @PathVariable Long id, @Valid @RequestBody EmployeeRequestDto dto) {
        return new ResponseEntity<>(employeeService.update(id, dto), HttpStatus.OK);
    }

    // create API to remove Employee
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        employeeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // create API to get all Employee
    @GetMapping
    public ResponseEntity<List<EmployeeResponseDto>> getAll() {
        return new ResponseEntity<>(employeeService.getAll(), HttpStatus.OK);
    }

    // create API to get Employee by Id
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDto> getById(@PathVariable Long id) {
        return new ResponseEntity<>(employeeService.getById(id), HttpStatus.OK);
    }

    // create API to get Employee by List of ID
    @GetMapping("/by-ids")
    public ResponseEntity<List<EmployeeResponseDto>> getByIds(@RequestParam List<Long> ids) {
        return new ResponseEntity<>(employeeService.getByIds(ids), HttpStatus.OK);
    }

    // create API to get Employee by List of name
    @GetMapping("/by-names")
    public ResponseEntity<List<EmployeeResponseDto>> getByNames(@RequestParam List<String> names) {
        return new ResponseEntity<>(employeeService.getByNames(names), HttpStatus.OK);
    }

    // create api to take Employee with List of address(=emails) and save all
    @PostMapping("/with-emails")
    public ResponseEntity<EmployeeResponseDto> createWithEmails(
            @Valid @RequestBody EmployeeWithEmailsRequestDto dto) {
        return new ResponseEntity<>(employeeService.createWithEmails(dto), HttpStatus.CREATED);
    }
}

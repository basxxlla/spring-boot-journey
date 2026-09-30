package com.example.employeeemail.service;

import com.example.employeeemail.dto.*;
import com.example.employeeemail.exception.ResourceNotFoundException;
import com.example.employeeemail.mapper.EmailMapper;
import com.example.employeeemail.mapper.EmployeeMapper;
import com.example.employeeemail.model.Email;
import com.example.employeeemail.model.Employee;
import com.example.employeeemail.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final EmailMapper emailMapper;

    // create Employee
    public EmployeeResponseDto create(EmployeeRequestDto dto) {
        Employee employee = employeeMapper.toEntity(dto);
        return employeeMapper.toDto(employeeRepository.save(employee));
    }

    // update Employee
    public EmployeeResponseDto update(Long id, EmployeeRequestDto dto) {
        Employee employee = getEntityOrThrow(id);
        employeeMapper.updateEntityFromDto(dto, employee);
        return employeeMapper.toDto(employeeRepository.save(employee));
    }

    // remove Employee
    public void delete(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Employee not found with id: " + id);
        }
        employeeRepository.deleteById(id);
    }

    // get all Employee
    @Transactional(readOnly = true)
    public List<EmployeeResponseDto> getAll() {
        return employeeMapper.toDtoList(employeeRepository.findAll());
    }

    // get Employee by Id
    @Transactional(readOnly = true)
    public EmployeeResponseDto getById(Long id) {
        return employeeMapper.toDto(getEntityOrThrow(id));
    }

    // get Employee by List of ID
    @Transactional(readOnly = true)
    public List<EmployeeResponseDto> getByIds(List<Long> ids) {
        return employeeMapper.toDtoList(employeeRepository.findAllById(ids));
    }

    // get Employee by List of name
    @Transactional(readOnly = true)
    public List<EmployeeResponseDto> getByNames(List<String> names) {
        return employeeMapper.toDtoList(employeeRepository.findByNameIn(names));
    }

    // create Employee together with a list of Emails, save all in one go
    public EmployeeResponseDto createWithEmails(EmployeeWithEmailsRequestDto dto) {
        Employee employee = employeeMapper.toEntity(dto);

        List<Email> emails = dto.getEmails().stream()
                .map(emailMapper::toEntity)
                .collect(Collectors.toList());

        // set the owning side (Email.employee) so the FK is correct when
        // cascade persists these through Employee.emails
        emails.forEach(email -> email.setEmployee(employee));
        employee.setEmails(emails);

        return employeeMapper.toDto(employeeRepository.save(employee));
    }

    private Employee getEntityOrThrow(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
    }
}

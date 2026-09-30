package com.example.employeeemail.service;

import com.example.employeeemail.dto.EmailRequestDto;
import com.example.employeeemail.dto.EmailResponseDto;
import com.example.employeeemail.exception.ResourceNotFoundException;
import com.example.employeeemail.mapper.EmailMapper;
import com.example.employeeemail.model.Email;
import com.example.employeeemail.model.Employee;
import com.example.employeeemail.repository.EmailRepository;
import com.example.employeeemail.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailRepository emailRepository;
    private final EmployeeRepository employeeRepository;
    private final EmailMapper emailMapper;

    // create Email
    public EmailResponseDto create(EmailRequestDto dto) {
        Email email = emailMapper.toEntity(dto);
        attachEmployeeIfProvided(email, dto.getEmployeeId());
        return emailMapper.toDto(emailRepository.save(email));
    }

    // update Email
    public EmailResponseDto update(Long id, EmailRequestDto dto) {
        Email email = getEntityOrThrow(id);
        emailMapper.updateEntityFromDto(dto, email);
        attachEmployeeIfProvided(email, dto.getEmployeeId());
        return emailMapper.toDto(emailRepository.save(email));
    }

    // remove Email
    public void delete(Long id) {
        if (!emailRepository.existsById(id)) {
            throw new ResourceNotFoundException("Email not found with id: " + id);
        }
        emailRepository.deleteById(id);
    }

    // get all Email
    @Transactional(readOnly = true)
    public List<EmailResponseDto> getAll() {
        return emailMapper.toDtoList(emailRepository.findAll());
    }

    // get Email by name (email type, e.g. "gmail") - can match several rows
    @Transactional(readOnly = true)
    public List<EmailResponseDto> getByName(String name) {
        return emailMapper.toDtoList(emailRepository.findByName(name));
    }

    // get Email by List of name
    @Transactional(readOnly = true)
    public List<EmailResponseDto> getByNames(List<String> names) {
        return emailMapper.toDtoList(emailRepository.findByNameIn(names));
    }

    // get Email by content (the actual address) - expected to be unique
    @Transactional(readOnly = true)
    public EmailResponseDto getByContent(String content) {
        Email email = emailRepository.findByContent(content)
                .orElseThrow(() -> new ResourceNotFoundException("Email not found with content: " + content));
        return emailMapper.toDto(email);
    }

    private void attachEmployeeIfProvided(Email email, Long employeeId) {
        if (employeeId != null) {
            Employee employee = employeeRepository.findById(employeeId)
                    .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + employeeId));
            email.setEmployee(employee);
        }
    }

    private Email getEntityOrThrow(Long id) {
        return emailRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Email not found with id: " + id));
    }
}

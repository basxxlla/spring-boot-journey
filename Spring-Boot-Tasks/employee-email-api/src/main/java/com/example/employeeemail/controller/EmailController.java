package com.example.employeeemail.controller;

import com.example.employeeemail.dto.EmailRequestDto;
import com.example.employeeemail.dto.EmailResponseDto;
import com.example.employeeemail.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/emails")
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;

    // create API to create Email
    @PostMapping
    public ResponseEntity<EmailResponseDto> create(@Valid @RequestBody EmailRequestDto dto) {
        return new ResponseEntity<>(emailService.create(dto), HttpStatus.CREATED);
    }

    // create API to update Email
    @PutMapping("/{id}")
    public ResponseEntity<EmailResponseDto> update(
            @PathVariable Long id, @Valid @RequestBody EmailRequestDto dto) {
        return new ResponseEntity<>(emailService.update(id, dto), HttpStatus.OK);
    }

    // create API to remove Email
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        emailService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // create API to get all Email
    @GetMapping
    public ResponseEntity<List<EmailResponseDto>> getAll() {
        return new ResponseEntity<>(emailService.getAll(), HttpStatus.OK);
    }

    // create API to get Email by name
    @GetMapping("/by-name")
    public ResponseEntity<List<EmailResponseDto>> getByName(@RequestParam String name) {
        return new ResponseEntity<>(emailService.getByName(name), HttpStatus.OK);
    }

    // create API to get Email by List of name
    @GetMapping("/by-names")
    public ResponseEntity<List<EmailResponseDto>> getByNames(@RequestParam List<String> names) {
        return new ResponseEntity<>(emailService.getByNames(names), HttpStatus.OK);
    }

    // create API to get Email by content
    @GetMapping("/by-content")
    public ResponseEntity<EmailResponseDto> getByContent(@RequestParam String content) {
        return new ResponseEntity<>(emailService.getByContent(content), HttpStatus.OK);
    }
}

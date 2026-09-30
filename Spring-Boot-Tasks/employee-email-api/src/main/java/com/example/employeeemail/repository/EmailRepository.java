package com.example.employeeemail.repository;

import com.example.employeeemail.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmailRepository extends JpaRepository<Email, Long> {
    List<Email> findByName(String name);
    List<Email> findByNameIn(List<String> names);
    Optional<Email> findByContent(String content);
}

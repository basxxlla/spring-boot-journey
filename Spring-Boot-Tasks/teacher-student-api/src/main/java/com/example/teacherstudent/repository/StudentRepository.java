package com.example.teacherstudent.repository;

import com.example.teacherstudent.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT DISTINCT s FROM Student s LEFT JOIN FETCH s.teachers")
    List<Student> findAllWithTeachers();

    @Query("SELECT s FROM Student s LEFT JOIN FETCH s.teachers WHERE s.id = :id")
    Optional<Student> findByIdWithTeachers(Long id);
}

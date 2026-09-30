package com.example.teacherstudent.repository;

import com.example.teacherstudent.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Query("SELECT DISTINCT t FROM Teacher t LEFT JOIN FETCH t.students")
    List<Teacher> findAllWithStudents();

    @Query("SELECT t FROM Teacher t LEFT JOIN FETCH t.students WHERE t.id = :id")
    Optional<Teacher> findByIdWithStudents(Long id);
}

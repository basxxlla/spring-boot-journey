package com.example.teacherstudent.controller;

import com.example.teacherstudent.dto.StudentDTO;
import com.example.teacherstudent.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * GET /api/students
     * Get ALL students with their related teachers
     */
    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllStudentsWithTeachers() {
        List<StudentDTO> students = studentService.getAllStudentsWithTeachers();
        return ResponseEntity.ok(students);
    }

    /**
     * GET /api/students/{id}
     * Get ONE student by ID with related teachers
     */
    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentByIdWithTeachers(@PathVariable Long id) {
        StudentDTO student = studentService.getStudentByIdWithTeachers(id);
        return ResponseEntity.ok(student);
    }
}

package com.example.university.controller;

import com.example.university.dto.StudentDetailDto;
import com.example.university.model.Student;
import com.example.university.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Create a student
    @PostMapping
    public ResponseEntity<Student> create(@RequestBody Student student) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createStudent(student));
    }

    // Get all students
    @GetMapping
    public ResponseEntity<List<Student>> getAll() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    // GET /api/students/{id}
    // Also satisfies "Get student by ID" - returns basic info + enrolled
    // courses (each with course info and instructor info), per the API spec.
    @GetMapping("/{id}")
    public ResponseEntity<StudentDetailDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudentDetail(id));
    }

    // Register a student to a course
    @PostMapping("/{studentId}/register/{courseId}")
    public ResponseEntity<StudentDetailDto> registerToCourse(
            @PathVariable Long studentId, @PathVariable Long courseId) {
        return ResponseEntity.ok(studentService.registerToCourse(studentId, courseId));
    }
}

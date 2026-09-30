package com.example.teacherstudent.controller;

import com.example.teacherstudent.dto.TeacherDTO;
import com.example.teacherstudent.service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    /**
     * GET /api/teachers
     * Get ALL teachers with their related students
     */
    @GetMapping
    public ResponseEntity<List<TeacherDTO>> getAllTeachersWithStudents() {
        List<TeacherDTO> teachers = teacherService.getAllTeachersWithStudents();
        return ResponseEntity.ok(teachers);
    }

    /**
     * GET /api/teachers/{id}
     * Get ONE teacher by ID with related students
     */
    @GetMapping("/{id}")
    public ResponseEntity<TeacherDTO> getTeacherByIdWithStudents(@PathVariable Long id) {
        TeacherDTO teacher = teacherService.getTeacherByIdWithStudents(id);
        return ResponseEntity.ok(teacher);
    }
}

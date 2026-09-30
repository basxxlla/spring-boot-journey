package com.example.university.controller;

import com.example.university.dto.CourseBasicDto;
import com.example.university.dto.InstructorDetailDto;
import com.example.university.model.Instructor;
import com.example.university.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructors")
public class InstructorController {

    private final InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    // Create an instructor
    @PostMapping
    public ResponseEntity<Instructor> create(@RequestBody Instructor instructor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(instructorService.createInstructor(instructor));
    }

    // Get all instructors
    @GetMapping
    public ResponseEntity<List<Instructor>> getAll() {
        return ResponseEntity.ok(instructorService.getAllInstructors());
    }

    // Get courses taught by an instructor (simple list)
    @GetMapping("/{id}/courses")
    public ResponseEntity<List<CourseBasicDto>> getCoursesTaught(@PathVariable Long id) {
        return ResponseEntity.ok(instructorService.getCoursesTaughtBy(id));
    }

    // GET /api/instructors/{id} - instructor info + each course they teach +
    // enrolled students in each course
    @GetMapping("/{id}")
    public ResponseEntity<InstructorDetailDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(instructorService.getInstructorDetail(id));
    }
}

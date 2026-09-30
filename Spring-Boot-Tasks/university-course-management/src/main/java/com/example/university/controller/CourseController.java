package com.example.university.controller;

import com.example.university.dto.CourseDetailDto;
import com.example.university.model.Course;
import com.example.university.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    // Create a course
    @PostMapping
    public ResponseEntity<Course> create(@RequestBody Course course) {
        return ResponseEntity.status(HttpStatus.CREATED).body(courseService.createCourse(course));
    }

    // Get all courses
    @GetMapping
    public ResponseEntity<List<Course>> getAll() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    // Assign an instructor to a course
    @PutMapping("/{courseId}/instructor/{instructorId}")
    public ResponseEntity<Course> assignInstructor(
            @PathVariable Long courseId, @PathVariable Long instructorId) {
        return ResponseEntity.ok(courseService.assignInstructor(courseId, instructorId));
    }

    // GET /api/courses/{id} - course info + instructor info + all enrolled students
    @GetMapping("/{id}")
    public ResponseEntity<CourseDetailDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(courseService.getCourseDetail(id));
    }
}

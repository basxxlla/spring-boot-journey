package com.example.university.repository;

import com.example.university.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    // Derived query - used by the "courses taught by an instructor" endpoint
    List<Course> findByInstructorId(Long instructorId);
}

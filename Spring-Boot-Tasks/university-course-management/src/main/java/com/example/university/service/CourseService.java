package com.example.university.service;

import com.example.university.dto.CourseDetailDto;
import com.example.university.exception.ResourceNotFoundException;
import com.example.university.model.Course;
import com.example.university.model.Instructor;
import com.example.university.repository.CourseRepository;
import com.example.university.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final InstructorRepository instructorRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository, InstructorRepository instructorRepository) {
        this.courseRepository = courseRepository;
        this.instructorRepository = instructorRepository;
    }

    // Create a course
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    // Get all courses
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseEntity(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + id));
    }

    // Assign an instructor to a course (Many-to-One; Course owns the FK)
    @Transactional
    public Course assignInstructor(Long courseId, Long instructorId) {
        Course course = getCourseEntity(courseId);
        Instructor instructor = instructorRepository.findById(instructorId)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor not found with id: " + instructorId));

        course.setInstructor(instructor);
        return courseRepository.save(course);
    }

    // GET /api/courses/{id} - course info + instructor info + all enrolled students
    @Transactional(readOnly = true)
    public CourseDetailDto getCourseDetail(Long id) {
        Course course = getCourseEntity(id);
        return CourseDetailDto.from(course);
    }
}

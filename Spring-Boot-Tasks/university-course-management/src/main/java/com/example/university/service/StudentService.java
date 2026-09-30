package com.example.university.service;

import com.example.university.dto.StudentDetailDto;
import com.example.university.exception.ResourceNotFoundException;
import com.example.university.model.Course;
import com.example.university.model.Student;
import com.example.university.repository.CourseRepository;
import com.example.university.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    // Create a student
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    // Get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Get student by ID (basic entity lookup, used internally / by other services)
    public Student getStudentEntity(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
    }

    // GET /api/students/{id} - student info + enrolled courses (each with instructor info)
    @Transactional(readOnly = true)
    public StudentDetailDto getStudentDetail(Long id) {
        Student student = getStudentEntity(id);
        return StudentDetailDto.from(student);
    }

    // Register a student to a course (Many-to-Many; Student owns the join table)
    @Transactional
    public StudentDetailDto registerToCourse(Long studentId, Long courseId) {
        Student student = getStudentEntity(studentId);
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + courseId));

        student.getCourses().add(course);
        studentRepository.save(student);

        return StudentDetailDto.from(student);
    }
}

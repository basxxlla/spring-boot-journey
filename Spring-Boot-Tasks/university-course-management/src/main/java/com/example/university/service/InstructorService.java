package com.example.university.service;

import com.example.university.dto.CourseBasicDto;
import com.example.university.dto.InstructorDetailDto;
import com.example.university.exception.ResourceNotFoundException;
import com.example.university.model.Instructor;
import com.example.university.repository.CourseRepository;
import com.example.university.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InstructorService {

    private final InstructorRepository instructorRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public InstructorService(InstructorRepository instructorRepository, CourseRepository courseRepository) {
        this.instructorRepository = instructorRepository;
        this.courseRepository = courseRepository;
    }

    // Create an instructor
    public Instructor createInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    // Get all instructors
    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

    public Instructor getInstructorEntity(Long id) {
        return instructorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor not found with id: " + id));
    }

    // Get courses taught by an instructor (simple list, no student details)
    public List<CourseBasicDto> getCoursesTaughtBy(Long instructorId) {
        // ensures 404 if the instructor itself doesn't exist
        getInstructorEntity(instructorId);
        return courseRepository.findByInstructorId(instructorId).stream()
                .map(CourseBasicDto::from)
                .collect(Collectors.toList());
    }

    // GET /api/instructors/{id} - instructor info + each course they teach +
    // enrolled students in each course
    @Transactional(readOnly = true)
    public InstructorDetailDto getInstructorDetail(Long id) {
        Instructor instructor = getInstructorEntity(id);
        return InstructorDetailDto.from(instructor);
    }
}

package com.example.teacherstudent.service;

import com.example.teacherstudent.dto.StudentSummaryDTO;
import com.example.teacherstudent.dto.TeacherDTO;
import com.example.teacherstudent.exception.ResourceNotFoundException;
import com.example.teacherstudent.model.Student;
import com.example.teacherstudent.model.Teacher;
import com.example.teacherstudent.repository.TeacherRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    /**
     * Get ALL teachers with their related students
     */
    @Transactional(readOnly = true)
    public List<TeacherDTO> getAllTeachersWithStudents() {
        List<Teacher> teachers = teacherRepository.findAllWithStudents();
        return teachers.stream()
                .map(this::toTeacherDTO)
                .collect(Collectors.toList());
    }

    /**
     * Get ONE teacher by ID with related students
     */
    @Transactional(readOnly = true)
    public TeacherDTO getTeacherByIdWithStudents(Long id) {
        Teacher teacher = teacherRepository.findByIdWithStudents(id)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher not found with id: " + id));
        return toTeacherDTO(teacher);
    }

    private TeacherDTO toTeacherDTO(Teacher teacher) {
        Set<StudentSummaryDTO> studentSummaries = teacher.getStudents().stream()
                .map(this::toStudentSummary)
                .collect(Collectors.toSet());

        return new TeacherDTO(
                teacher.getId(),
                teacher.getFirstName(),
                teacher.getLastName(),
                teacher.getEmail(),
                teacher.getSubject(),
                studentSummaries
        );
    }

    private StudentSummaryDTO toStudentSummary(Student student) {
        return new StudentSummaryDTO(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getGrade()
        );
    }
}

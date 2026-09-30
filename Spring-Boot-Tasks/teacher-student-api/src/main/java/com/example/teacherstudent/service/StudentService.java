package com.example.teacherstudent.service;

import com.example.teacherstudent.dto.StudentDTO;
import com.example.teacherstudent.dto.TeacherSummaryDTO;
import com.example.teacherstudent.exception.ResourceNotFoundException;
import com.example.teacherstudent.model.Student;
import com.example.teacherstudent.model.Teacher;
import com.example.teacherstudent.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    /**
     * Get ALL students with their related teachers
     */
    @Transactional(readOnly = true)
    public List<StudentDTO> getAllStudentsWithTeachers() {
        List<Student> students = studentRepository.findAllWithTeachers();
        return students.stream()
                .map(this::toStudentDTO)
                .collect(Collectors.toList());
    }

    /**
     * Get ONE student by ID with related teachers
     */
    @Transactional(readOnly = true)
    public StudentDTO getStudentByIdWithTeachers(Long id) {
        Student student = studentRepository.findByIdWithTeachers(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
        return toStudentDTO(student);
    }

    private StudentDTO toStudentDTO(Student student) {
        Set<TeacherSummaryDTO> teacherSummaries = student.getTeachers().stream()
                .map(this::toTeacherSummary)
                .collect(Collectors.toSet());

        return new StudentDTO(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getGrade(),
                teacherSummaries
        );
    }

    private TeacherSummaryDTO toTeacherSummary(Teacher teacher) {
        return new TeacherSummaryDTO(
                teacher.getId(),
                teacher.getFirstName(),
                teacher.getLastName(),
                teacher.getEmail(),
                teacher.getSubject()
        );
    }
}

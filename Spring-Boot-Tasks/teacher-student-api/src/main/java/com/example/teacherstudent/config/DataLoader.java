package com.example.teacherstudent.config;

import com.example.teacherstudent.model.Student;
import com.example.teacherstudent.model.Teacher;
import com.example.teacherstudent.repository.StudentRepository;
import com.example.teacherstudent.repository.TeacherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DataLoader implements CommandLineRunner {

    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;

    public DataLoader(TeacherRepository teacherRepository, StudentRepository studentRepository) {
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    @Transactional
    public void run(String... args) {
        // Create Teachers
        Teacher t1 = new Teacher("Ahmed", "Hassan", "ahmed.hassan@school.com", "Mathematics");
        Teacher t2 = new Teacher("Sara", "Ali", "sara.ali@school.com", "Physics");
        Teacher t3 = new Teacher("Omar", "Khaled", "omar.khaled@school.com", "Chemistry");

        // Create Students
        Student s1 = new Student("Youssef", "Mahmoud", "youssef.m@student.com", "Grade 10");
        Student s2 = new Student("Nour", "Ibrahim", "nour.i@student.com", "Grade 11");
        Student s3 = new Student("Layla", "Said", "layla.s@student.com", "Grade 10");
        Student s4 = new Student("Karim", "Fathy", "karim.f@student.com", "Grade 12");
        Student s5 = new Student("Mona", "Adel", "mona.a@student.com", "Grade 11");

        // Save students first
        studentRepository.save(s1);
        studentRepository.save(s2);
        studentRepository.save(s3);
        studentRepository.save(s4);
        studentRepository.save(s5);

        // Assign relationships (Teacher is the owning side)
        t1.addStudent(s1);
        t1.addStudent(s2);
        t1.addStudent(s3);

        t2.addStudent(s2);
        t2.addStudent(s4);
        t2.addStudent(s5);

        t3.addStudent(s1);
        t3.addStudent(s4);
        t3.addStudent(s5);

        teacherRepository.save(t1);
        teacherRepository.save(t2);
        teacherRepository.save(t3);

        System.out.println("========================================");
        System.out.println("Sample data loaded successfully!");
        System.out.println("Teachers: 3 | Students: 5");
        System.out.println("========================================");
    }
}

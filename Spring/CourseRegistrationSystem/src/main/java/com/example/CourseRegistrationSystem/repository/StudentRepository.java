package com.example.CourseRegistrationSystem.repository;

import com.example.CourseRegistrationSystem.data.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {
    private final List<Student> students;

    public StudentRepository(List<Student> students) {
        this.students = students;
    }

    public Student add(Student student) {
        students.add(student);
        return student;
    }

    public List<Student> getStudents() {
        return students;
    }
}

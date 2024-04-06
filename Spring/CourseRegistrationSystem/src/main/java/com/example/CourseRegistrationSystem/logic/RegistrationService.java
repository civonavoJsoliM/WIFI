package com.example.CourseRegistrationSystem.logic;

import com.example.CourseRegistrationSystem.data.Course;
import com.example.CourseRegistrationSystem.data.Registration;
import com.example.CourseRegistrationSystem.data.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RegistrationService {

    public List<Course> getCoursesFromCertainDepartment(List<Course> courses, String department) {
        return courses.stream()
                .filter(course -> course.department().equals(department))
                .toList();
    }

    public Optional<Map.Entry<Student, Integer>> getStudentWithMostCreditsForAGivenSemester(List<Registration> registrations, String semester) {
        return registrations.stream()
                .filter(registration -> registration.semester().equals(semester))
                .collect(Collectors.groupingBy(Registration::student, Collectors.summingInt(registration -> registration.course().creditValue())))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue());
    }

    public List<Student> getStudentsRegisteredForCertainCourse(List<Registration> registrations, String course) {
        return registrations.stream()
                .filter(registration -> registration.course().name().equals(course))
                .map(Registration::student)
                .toList();
    }
}

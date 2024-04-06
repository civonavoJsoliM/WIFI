package com.example.CourseRegistrationSystem.repository;

import com.example.CourseRegistrationSystem.data.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseRepository {

    private final List<Course> courses;

    public CourseRepository(List<Course> courses) {
        this.courses = courses;
    }

    public Course add(Course course) {
        courses.add(course);
        return course;
    }

    public List<Course> getCourses() {
        return courses;
    }
}

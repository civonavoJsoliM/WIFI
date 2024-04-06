package com.example.CourseRegistrationSystem.configuration;

import com.example.CourseRegistrationSystem.data.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class StudentConfiguration {

    @Bean
    List<Student> students() {
        return new ArrayList<>();
    }
}

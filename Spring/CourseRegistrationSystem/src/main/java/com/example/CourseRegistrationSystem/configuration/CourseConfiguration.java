package com.example.CourseRegistrationSystem.configuration;

import com.example.CourseRegistrationSystem.data.Course;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class CourseConfiguration {

    @Bean
    List<Course> courses() {
        return new ArrayList<>();
    }
}

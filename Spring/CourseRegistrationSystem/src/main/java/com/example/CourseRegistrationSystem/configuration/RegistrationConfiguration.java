package com.example.CourseRegistrationSystem.configuration;

import com.example.CourseRegistrationSystem.data.Registration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class RegistrationConfiguration {

    @Bean
    List<Registration> registrations() {
        return new ArrayList<>();
    }
}

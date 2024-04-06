package com.example.ProjectManagementSystem.configuration;

import com.example.ProjectManagementSystem.data.Project;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ProjectConfiguration {

    @Bean
    List<Project> projects() {
        return new ArrayList<>();
    }
}

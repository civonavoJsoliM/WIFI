package com.example.ProjectManagementSystem.configuration;

import com.example.ProjectManagementSystem.data.Task;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class TaskConfiguration {

    @Bean
    List<Task> tasks() {
        return new ArrayList<>();
    }
}

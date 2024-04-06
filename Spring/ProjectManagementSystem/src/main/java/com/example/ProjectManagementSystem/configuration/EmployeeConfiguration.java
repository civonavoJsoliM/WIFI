package com.example.ProjectManagementSystem.configuration;

import com.example.ProjectManagementSystem.data.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class EmployeeConfiguration {

    @Bean
    List<Employee> employees() {
        return new ArrayList<>();
    }
}

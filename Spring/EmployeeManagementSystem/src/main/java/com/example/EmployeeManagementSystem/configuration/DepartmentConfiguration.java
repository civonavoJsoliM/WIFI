package com.example.EmployeeManagementSystem.configuration;

import com.example.EmployeeManagementSystem.data.Department;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DepartmentConfiguration {

    @Bean
    List<Department> departments() {
        return new ArrayList<>();
    }
}

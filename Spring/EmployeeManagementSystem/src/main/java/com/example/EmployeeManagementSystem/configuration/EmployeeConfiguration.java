package com.example.EmployeeManagementSystem.configuration;

import com.example.EmployeeManagementSystem.data.Employee;
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

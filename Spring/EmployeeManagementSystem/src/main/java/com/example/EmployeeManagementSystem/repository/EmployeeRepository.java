package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.data.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {

    private final List<Employee> employees;

    public EmployeeRepository(List<Employee> employees) {
        this.employees = employees;
    }

    public Employee add(Employee employee) {
        employees.add(employee);
        return employee;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}

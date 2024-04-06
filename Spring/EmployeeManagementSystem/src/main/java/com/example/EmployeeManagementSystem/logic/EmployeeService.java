package com.example.EmployeeManagementSystem.logic;

import com.example.EmployeeManagementSystem.data.Department;
import com.example.EmployeeManagementSystem.data.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.OptionalDouble;

@Service
public class EmployeeService {

    public List<Employee> getEmployeesFromCertainDepartment(List<Employee> employees, String department) {
        return employees.stream()
                .filter(employee -> employee.department().name().equals(department))
                .toList();
    }

    public OptionalDouble getAverageSalaryFromCertainDepartment(List<Employee> employees, String department) {
        return employees.stream()
                .filter(employee -> employee.department().name().equals(department))
                .mapToDouble(Employee::salary)
                .average();
    }

    public List<Department> getDepartmentsExceedingCertainBudget(List<Department> departments, double budget) {
        return departments.stream()
                .filter(department -> department.budget() > budget)
                .toList();
    }
}

package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.data.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentRepository {

    private final List<Department> departments;

    public DepartmentRepository(List<Department> departments) {
        this.departments = departments;
    }

    public Department add(Department department) {
        departments.add(department);
        return department;
    }

    public List<Department> getDepartments() {
        return departments;
    }
}

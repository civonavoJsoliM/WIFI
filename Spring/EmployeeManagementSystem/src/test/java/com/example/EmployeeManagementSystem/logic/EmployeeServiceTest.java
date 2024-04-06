package com.example.EmployeeManagementSystem.logic;


import com.example.EmployeeManagementSystem.data.Department;
import com.example.EmployeeManagementSystem.data.Employee;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {

    @ParameterizedTest
    @MethodSource
    void getEmployeesFromCertainDepartment(List<Employee> employees, String department, List<Employee> expected) {
        EmployeeService employeeService = new EmployeeService();
        List<Employee> employeesFromCertainDepartment = employeeService.getEmployeesFromCertainDepartment(employees, department);
        assertEquals(expected, employeesFromCertainDepartment);
    }

    static Stream<Arguments> getEmployeesFromCertainDepartment() {
        return Stream.of(
                Arguments.of(getEmployees(), getDepartments().get(0).name(), List.of(getEmployees().get(0), getEmployees().get(1), getEmployees().get(2))),
                Arguments.of(getEmployees(), "", List.of()),
                Arguments.of(List.of(), "", List.of()),
                Arguments.of(List.of(), getDepartments().get(2).name(), List.of())
        );
    }

    @ParameterizedTest
    @MethodSource
    void getAverageSalaryFromCertainDepartment(List<Employee> employees, String department, OptionalDouble expected) {
        EmployeeService employeeService = new EmployeeService();
        OptionalDouble averageSalary = employeeService.getAverageSalaryFromCertainDepartment(employees, department);
        assertEquals(expected, averageSalary);
    }

    static Stream<Arguments> getAverageSalaryFromCertainDepartment() {
        return Stream.of(
                Arguments.of(getEmployees(), getDepartments().get(0).name(),  OptionalDouble.of(43_333.333333333333333)),
                Arguments.of(getEmployees(), getDepartments().get(1).name(), OptionalDouble.of(21_000)),
                Arguments.of(getEmployees(), "", OptionalDouble.empty()),
                Arguments.of(List.of(), "", OptionalDouble.empty()),
                Arguments.of(List.of(), getDepartments().get(3).name(), OptionalDouble.empty())
        );
    }

    @ParameterizedTest
    @MethodSource
    void getDepartmentsExceedingCertainBudget(List<Department> departments, double budget, List<Department> expected) {
        EmployeeService employeeService = new EmployeeService();
        List<Department> departmentsExceedingCertainBudget = employeeService.getDepartmentsExceedingCertainBudget(departments, budget);
        assertEquals(expected, departmentsExceedingCertainBudget);
    }

    static Stream<Arguments> getDepartmentsExceedingCertainBudget() {
        return Stream.of(
                Arguments.of(getDepartments(), 50_000, List.of(getDepartments().get(0), getDepartments().get(2), getDepartments().get(5))),
                Arguments.of(getDepartments(), 81_000, List.of(getDepartments().get(0), getDepartments().get(2))),
                Arguments.of(getDepartments(), 0.0, getDepartments()),
                Arguments.of(getDepartments(), 200_000, List.of()),
                Arguments.of(List.of(), 50_000, List.of())
        );
    }

    static List<Employee> getEmployees() {
        return List.of(
                new Employee("1", "Max", getDepartments().get(0), 50_000),
                new Employee("2", "Phillip", getDepartments().get(0), 45_000),
                new Employee("3", "Karl", getDepartments().get(0), 35_000),
                new Employee("4", "Peter", getDepartments().get(1), 20_000),
                new Employee("5", "Hans", getDepartments().get(1), 22_000),
                new Employee("6", "Moritz", getDepartments().get(2), 60_000),
                new Employee("7", "Joseph", getDepartments().get(2), 65_000),
                new Employee("8", "Christoph", getDepartments().get(3), 35_000),
                new Employee("11", "Christian", getDepartments().get(3), 40_000),
                new Employee("9", "Michael", getDepartments().get(4), 20_000),
                new Employee("10", "Sebastian", getDepartments().get(5), 45_000)
        );
    }

    static List<Department> getDepartments() {
        return List.of(
                new Department("1", "Engineering", 100_000),
                new Department("2", "HR", 30_000),
                new Department("3", "Sales", 130_000),
                new Department("4", "Bookkeeping", 40_000),
                new Department("5", "Logistics", 30_000),
                new Department("6", "Trading", 80_000));
    }
}
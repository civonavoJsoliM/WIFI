package com.example.ProjectManagementSystem.logic;

import com.example.ProjectManagementSystem.data.Employee;
import com.example.ProjectManagementSystem.data.Project;
import com.example.ProjectManagementSystem.data.Task;
import com.example.ProjectManagementSystem.data.TaskStatus;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ProjectServiceTest {

    @ParameterizedTest
    @MethodSource
    void getUnfinishedTasksFromCertainProject(List<Task> tasks, String project, List<Task> expected) {
        ProjectService projectService = new ProjectService();
        List<Task> unfinishedTasks = projectService.getUnfinishedTasksFromCertainProject(tasks, project);
        assertEquals(expected, unfinishedTasks);
    }

    static Stream<Arguments> getUnfinishedTasksFromCertainProject() {
        return Stream.of(
                Arguments.of(getTasks(), getProjects().get(2).name(), List.of(getTasks().get(5), getTasks().get(7), getTasks().get(15))),
                Arguments.of(getTasks(), getProjects().get(1).name(), List.of(getTasks().get(3))),
                Arguments.of(getTasks(), "", List.of()),
                Arguments.of(getTasks(), "Windows", List.of()),
                Arguments.of(List.of(), getProjects().get(3).name(), List.of()),
                Arguments.of(List.of(), "", List.of())
        );
    }

    @ParameterizedTest
    @MethodSource
    void getTotalUtilizedBudgetFromCertainProject(List<Task> tasks, String project, double expected) {
        ProjectService projectService = new ProjectService();
        double totalBudget = projectService.getTotalUtilizedBudgetFromCertainProject(tasks, project);
        assertEquals(expected, totalBudget);
    }

    static Stream<Arguments> getTotalUtilizedBudgetFromCertainProject() {
        return Stream.of(
                Arguments.of(getTasks(), getProjects().get(0).name(), 200_000),
                Arguments.of(getTasks(), getProjects().get(1).name(), 0),
                Arguments.of(getTasks(), getProjects().get(2).name(), 9_000_000),
                Arguments.of(getTasks(), "", 0),
                Arguments.of(getTasks(), "Meta", 0),
                Arguments.of(List.of(), getProjects().get(3).name(), 0),
                Arguments.of(List.of(), "", 0),
                Arguments.of(List.of(), "Window", 0)
        );
    }

    @ParameterizedTest
    @MethodSource
    void getEmployeeWithMostCompletedTasks(List<Task> tasks, Optional<Map.Entry<Employee, Long>> expected) {
        ProjectService projectService = new ProjectService();
        Optional<Map.Entry<Employee, Long>> employee = projectService.getEmployeeWithMostCompletedTasks(tasks);
        assertEquals(expected, employee);
    }

    static Stream<Arguments> getEmployeeWithMostCompletedTasks() {
        return Stream.of(
                Arguments.of(getTasks(), Optional.of(new AbstractMap.SimpleEntry<>(getEmployees().get(1), 5L))),
                Arguments.of(List.of(), Optional.empty())
        );
    }

    static List<Task> getTasks() {
        return List.of(
                new Task("1", getProjects().get(0), "", TaskStatus.COMPLETED, getEmployees().get(0)),
                new Task("2", getProjects().get(0), "", TaskStatus.COMPLETED, getEmployees().get(1)),
                new Task("3", getProjects().get(0), "", TaskStatus.PENDING, getEmployees().get(2)),
                new Task("4", getProjects().get(1), "", TaskStatus.PENDING, getEmployees().get(3)),
                new Task("5", getProjects().get(2), "", TaskStatus.COMPLETED, getEmployees().get(1)),
                new Task("6", getProjects().get(2), "", TaskStatus.PENDING, getEmployees().get(5)),
                new Task("7", getProjects().get(2), "", TaskStatus.COMPLETED, getEmployees().get(1)),
                new Task("8", getProjects().get(2), "", TaskStatus.PENDING, getEmployees().get(7)),
                new Task("9", getProjects().get(3), "", TaskStatus.COMPLETED, getEmployees().get(8)),
                new Task("10", getProjects().get(4), "", TaskStatus.COMPLETED, getEmployees().get(9)),
                new Task("11", getProjects().get(4), "", TaskStatus.COMPLETED, getEmployees().get(0)),
                new Task("12", getProjects().get(4), "", TaskStatus.COMPLETED, getEmployees().get(0)),
                new Task("13", getProjects().get(4), "", TaskStatus.COMPLETED, getEmployees().get(1)),
                new Task("14", getProjects().get(3), "", TaskStatus.COMPLETED, getEmployees().get(0)),
                new Task("15", getProjects().get(3), "", TaskStatus.COMPLETED, getEmployees().get(1)),
                new Task("16", getProjects().get(2), "", TaskStatus.PENDING, getEmployees().get(0)),
                //new Task("17", getProjects().get(1), "", TaskStatus.COMPLETED, getEmployees().get(2)),
                new Task("18", getProjects().get(2), "", TaskStatus.COMPLETED, getEmployees().get(2))
        );
    }
    static List<Employee> getEmployees() {
        return List.of(
                new Employee("1", "Max"),
                new Employee("2", "Phillip"),
                new Employee("3", "Moritz"),
                new Employee("4", "Christopher"),
                new Employee("5", "Franz"),
                new Employee("6", "Herbert"),
                new Employee("7", "Sebastian"),
                new Employee("8", "Helmut"),
                new Employee("9", "Christian"),
                new Employee("10", "Patrick")
        );
    }
    static List<Project> getProjects() {
        return List.of(
                new Project("1", "Siemens", LocalDate.now(), 100_000),
                new Project("2", "Spotify", LocalDate.now(), 1_000_000),
                new Project("3", "Netflix", LocalDate.now(), 3_000_000),
                new Project("4", "OBB", LocalDate.now(), 500_000),
                new Project("5", "Amazon", LocalDate.now(), 1_500_000)
        );
    }
}
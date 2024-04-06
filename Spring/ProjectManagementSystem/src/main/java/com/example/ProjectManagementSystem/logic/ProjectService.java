package com.example.ProjectManagementSystem.logic;

import com.example.ProjectManagementSystem.data.Employee;
import com.example.ProjectManagementSystem.data.Project;
import com.example.ProjectManagementSystem.data.Task;
import com.example.ProjectManagementSystem.data.TaskStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    public List<Task> getUnfinishedTasksFromCertainProject(List<Task> tasks, String project) {
        return tasks.stream()
                .filter(task -> task.project().name().equals(project))
                .filter(task -> task.status().equals(TaskStatus.PENDING))
                .toList();
    }

    public double getTotalUtilizedBudgetFromCertainProject(List<Task> tasks, String project) {
        return tasks.stream()
                .filter(task -> task.project().name().equals(project))
                .filter(task -> task.status().equals(TaskStatus.COMPLETED))
                .mapToDouble(task -> task.project().budget())
                .sum();
    }

    public Optional<Map.Entry<Employee, Long>> getEmployeeWithMostCompletedTasks(List<Task> tasks) {
        return tasks.stream()
                .filter(task -> task.status().equals(TaskStatus.COMPLETED))
                .collect(Collectors.groupingBy(Task::employee, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue());
    }
}

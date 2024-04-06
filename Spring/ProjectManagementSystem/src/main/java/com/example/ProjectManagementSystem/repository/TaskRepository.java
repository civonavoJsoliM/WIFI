package com.example.ProjectManagementSystem.repository;

import com.example.ProjectManagementSystem.data.Task;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskRepository {

    private final List<Task> tasks;

    public TaskRepository(List<Task> tasks) {
        this.tasks = tasks;
    }

    public Task add(Task task) {
        tasks.add(task);
        return task;
    }

    public List<Task> getTasks() {
        return tasks;
    }
}

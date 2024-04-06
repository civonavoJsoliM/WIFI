package com.example.ProjectManagementSystem.data;

public record Task(String id, Project project, String description, TaskStatus status, Employee employee) {
}

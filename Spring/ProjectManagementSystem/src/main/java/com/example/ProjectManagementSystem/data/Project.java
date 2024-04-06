package com.example.ProjectManagementSystem.data;

import java.time.LocalDate;

public record Project(String id, String name, LocalDate deadline, double budget) {
}

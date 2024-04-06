package com.example.ProjectManagementSystem.repository;

import com.example.ProjectManagementSystem.data.Project;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectRepository {

    private final List<Project> projects;

    public ProjectRepository(List<Project> projects) {
        this.projects = projects;
    }

    public Project add(Project project) {
        projects.add(project);
        return project;

    }

    public List<Project> getProjects() {
        return projects;
    }
}


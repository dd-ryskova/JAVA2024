package com.example.lab1.services;

import com.example.lab1.repositories.ProjectRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import com.example.lab1.models.ProjectEntity;
import com.example.lab1.models.dto.ProjectRequest;

import java.util.List;
import java.util.UUID;

import static java.util.UUID.randomUUID;

@Stateless
public class ProjectService {
    @Inject
    private ProjectRepository projectRepository;

    public List<ProjectEntity> getAll() {
        return projectRepository.findAll();
    }

    public UUID create(ProjectRequest projectRequest) {
        ProjectEntity project = new ProjectEntity();
        project.setId(UUID.randomUUID());
        project.setName(projectRequest.getName());
        project.setDescription(projectRequest.getDescription());
        project.setStartDate(projectRequest.getStartDate());
        project.setEndDate(projectRequest.getEndDate());

        projectRepository.persist(project);
        return project.getId();
    }

    public void delete(UUID projectId) {
        projectRepository.delete(projectId);
    }
}

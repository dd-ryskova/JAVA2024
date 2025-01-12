package com.example.lab1.services;

import com.example.lab1.repositories.TaskRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import com.example.lab1.models.TaskEntity;
import com.example.lab1.models.dto.TaskRequest;

import java.util.List;
import java.util.UUID;

import static java.util.UUID.randomUUID;

@Stateless
public class TaskService {
    @Inject
    private TaskRepository taskRepository;

    public List<TaskEntity> getAll() {
        return taskRepository.findAll();
    }

    public UUID create(TaskRequest taskRequest) {
        TaskEntity task = new TaskEntity();
        task.setId(UUID.randomUUID());
        task.setTitle(taskRequest.getTitle());
        task.setDescription(taskRequest.getDescription());
        task.setStatus(taskRequest.getStatus());
        task.setProjectID(taskRequest.getProjectId());
        taskRepository.persist(task);
        return task.getId();
    }

    public void delete(UUID taskId) {
        taskRepository.delete(taskId);
    }
}

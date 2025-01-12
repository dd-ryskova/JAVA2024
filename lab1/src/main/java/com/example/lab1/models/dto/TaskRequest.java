package com.example.lab1.models.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class TaskRequest {
    private String title;          // Название задачи
    private UUID projectId;        // ID проекта, к которому относится задача
    private String description;    // Описание задачи
    private String status;         // Статус задачи ("New", "In Progress", "Completed")
}
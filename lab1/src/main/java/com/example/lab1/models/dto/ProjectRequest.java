package com.example.lab1.models.dto;

import lombok.Data;

@Data
public class ProjectRequest {
    private String name;  // Название проекта
    private String description;  // Описание проекта
    private String startDate;  // Дата начала проекта
    private String endDate;  // Дата завершения проекта
}

package com.example.lab4.models.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class ProjectRequest {
    private UUID id;
    private String name;
    private String description;
    private String startDate;
    private String endDate;
}

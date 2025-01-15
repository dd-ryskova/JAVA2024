package com.example.lab4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.lab4.models.TaskEntity;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<TaskEntity, UUID> {
}

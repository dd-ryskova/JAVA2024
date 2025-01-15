package com.example.lab4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.lab4.models.ProjectEntity;

import java.util.UUID;

public interface ProjectRepository extends JpaRepository<ProjectEntity, UUID> {
}

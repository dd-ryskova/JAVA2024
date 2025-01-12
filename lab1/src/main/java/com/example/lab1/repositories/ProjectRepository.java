package com.example.lab1.repositories;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ejb.Stateless;
import com.example.lab1.models.ProjectEntity;

import java.util.List;
import java.util.UUID;

@Stateless
public class ProjectRepository {
    @PersistenceContext
    private EntityManager em;

    public List<ProjectEntity> findAll() {
        return em.createQuery("SELECT p FROM ProjectEntity p", ProjectEntity.class).getResultList();
    }

    public void persist(ProjectEntity entity) {
        em.persist(entity);
    }

    public void delete(UUID departmentId) {
        ProjectEntity entity = em.find(ProjectEntity.class, departmentId);
        if (entity != null) {
            em.remove(entity);
        }
    }
}

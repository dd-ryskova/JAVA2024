package com.example.lab1.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ejb.Stateless;
import com.example.lab1.models.TaskEntity;

import java.util.List;
import java.util.UUID;

@Stateless
public class TaskRepository {
    @PersistenceContext
    private EntityManager em;

    public List<TaskEntity> findAll() {
        return em.createQuery("select t from TaskEntity t", TaskEntity.class).getResultList();
    }

    public void persist(TaskEntity entity) {
        em.persist(entity);
    }

    public void delete(UUID departmentId) {
        TaskEntity entity = em.find(TaskEntity.class, departmentId);
        if (entity != null) {
            em.remove(entity);
        }
    }
}

package com.example.restapi.repositories;

import com.example.restapi.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
    // O JpaRepository já fornece todos os métodos básicos de CRUD (save, findById, findAll, deleteById, etc.)
}

package com.example.restapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restapi.models.Task;
import com.example.restapi.repositories.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    // Criar uma task
    public Task saveTask(Task task) {
        try {
            return taskRepository.save(task);
        } catch (Exception e) {
            System.err.println("Erro ao salvar a task: " + e.getMessage());
            throw new RuntimeException("Erro ao salvar a tarefa", e);
        }
    }

    // Atualizar task
    public Task updateTask(Long id, Task task) {
        try {
            return taskRepository.findById(id)
                .map(existingTask -> {
                    existingTask.setTitle(task.getTitle());
                    existingTask.setDescription(task.getDescription());
                    existingTask.setStatus(task.getStatus());
                    return taskRepository.save(existingTask);
                })
                .orElseThrow(() -> new RuntimeException("Task não encontrada com ID: " + id));
        } catch (Exception e) {
            System.err.println("Erro ao atualizar tarefa: " + e.getMessage());
            throw new RuntimeException("Erro ao atualizar a tarefa", e);
        }
    }

    // Obter todas as tasks
    public List<Task> getAllTasks() {
        try {
            return taskRepository.findAll();
        }catch (Exception e) {
            System.err.println("Erro ao buscas informações no banco: " + e.getMessage());
            throw new RuntimeException("Erro ao buscar tarefas", e);
        }
    }

    // Obter uma task por id
    public Optional<Task> getTaskById(Long id) {
        try {
            return taskRepository.findById(id);
        } catch (Exception e) {
            System.err.println("Erro ao buscar a task com ID " + id + ": " + e.getMessage());
            return Optional.empty(); 
        }
    }

    // Deletar uma task por id
    public void deleteTask(Long id) {
        try {
            taskRepository.deleteById(id);
        }
        catch(Exception e) {
            System.err.println("Erro ao deletar a tarefa (" + id + "): " + e.getMessage());
            throw new RuntimeException("Erro ao salvar a task", e);
        }
    }
}
package com.example.restapi.services;

import com.example.restapi.models.Task;
import com.example.restapi.models.Status;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
	private List<Task> tasks = new ArrayList<>();
	private Long nextId = 1L;

	public Task createTask(Task task) {
		task.setId(nextId++);
        if (task.getStatus() == null) {
			task.setStatus(Status.PENDING);
		}
		tasks.add(task);
		return task;
	}

	public List<Task> getAllTasks() {
		return tasks;
	}

	public Optional<Task> getTaskById(Long id) {
		return tasks.stream().filter(task -> task.getId().equals(id)).findFirst();
	}

	public Optional<Task> updateTask(Long id, Task updatedTask) {
		Optional<Task> existingTask = getTaskById(id);
		if (existingTask.isPresent()) {
			Task task = existingTask.get();
			task.setTitle(updatedTask.getTitle());
			task.setDescription(updatedTask.getDescription());
			task.setStatus(updatedTask.getStatus());
			return Optional.of(task);
		}
		return Optional.empty();
	}

	public boolean deleteTask(Long id) {
		return getTaskById(id).map(tasks::remove).orElse(false);
	}
}
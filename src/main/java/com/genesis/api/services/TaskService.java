package com.genesis.api.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genesis.api.models.Task;
import com.genesis.api.repository.mongo.TaskRepository;

@Service
public class TaskService {
	@Autowired
	private TaskRepository taskRepository;
	
	
	public Task createTask(Task task) {
		
		task = task.toBuilder()
				.createdAt(LocalDateTime.now())
				.updatedAt(LocalDateTime.now())
				.build();
		return taskRepository.save(task);
	}
	
	public List<Task> getAllTasks(){
		return taskRepository.findAll();
	}
	
	public void deleteTask(String id) {
		taskRepository.deleteById(id);
	}
	
	public List<Task> getAllTasksByUsername(String username){
		return taskRepository.findByUsername(username);
	}
	
	public Task updateTask(String id, Task updatedTask) {
		Optional<Task> taskOptional = taskRepository.findById(id);
		
		if(taskOptional.isPresent()) {
			Task task = taskOptional.get();
			
			task = task.builder()
					.title(updatedTask.getTitle())
					.description(updatedTask.getDescription())
					.completed(updatedTask.isCompleted())
					.updatedAt(LocalDateTime.now())
					.build();
			
			return taskRepository.save(task);
		}
		return null;
	}
	
	

}

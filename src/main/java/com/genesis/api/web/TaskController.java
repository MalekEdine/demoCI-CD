package com.genesis.api.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.genesis.api.models.Task;
import com.genesis.api.services.TaskService;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {
	@Autowired
	private TaskService taskService;
	
	@GetMapping("/test")
	public String testApi() {
		return "TEST USER OK";
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity <List<Task>> getAllTask(){
		return ResponseEntity.ok(taskService.getAllTasks());
	}
	
	
	@GetMapping("/username/{username}")
	public ResponseEntity <List<Task>> getAllTaskByUsername(@PathVariable String username){
		return ResponseEntity.ok(taskService.getAllTasksByUsername(username));
	}
	
	
	@PostMapping
	public ResponseEntity<Task> createTask(@RequestBody Task task){
		return ResponseEntity.ok(taskService.createTask(task));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTask(@PathVariable String id){
		taskService.deleteTask(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Task> updateTask(@PathVariable String id, @RequestBody Task task){
		Task updatedTask = taskService.updateTask(id, task);
		
		return updatedTask!= null ? ResponseEntity.ok(updatedTask) : ResponseEntity.notFound().build();
	}
}

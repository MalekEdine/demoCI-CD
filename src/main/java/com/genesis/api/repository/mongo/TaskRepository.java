package com.genesis.api.repository.mongo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.genesis.api.models.Task;

public interface TaskRepository extends MongoRepository<Task, String>{
	List<Task> findByCompleted(boolean completed);
	List<Task> findByUsername(String username);

}

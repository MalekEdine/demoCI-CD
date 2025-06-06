package com.genesis.api.services;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


import com.genesis.api.models.User;
import com.genesis.api.repository.sql.UserRepository;

class UserServiceTest {
	private UserRepository userRepository;
	private UserService userService;
	
	@BeforeEach
	void setup() {
		userRepository = mock(UserRepository.class);
		userService = new UserService(userRepository);
	}
	
	
	@Test
	void testGetAllUSers() {
		List<User> users = new ArrayList<>();
		users.add(new User());
		users.add(new User());
		users.add(new User());
		
		when(userRepository.findAll()).thenReturn(users);
		
		List<User> result = userService.getAllUsers();
		assertEquals(3, result.size());
	}

}

package com.genesis.api.repository.sql;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.genesis.api.models.User;

public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByUsername(String username);
	Optional<User> findByEmail(String email);
}

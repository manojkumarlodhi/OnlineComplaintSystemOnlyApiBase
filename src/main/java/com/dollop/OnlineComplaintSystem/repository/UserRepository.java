package com.dollop.OnlineComplaintSystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dollop.OnlineComplaintSystem.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
	
	public Optional<User> findByEmail(String email);
	public  Boolean existsByEmail(String email);

}

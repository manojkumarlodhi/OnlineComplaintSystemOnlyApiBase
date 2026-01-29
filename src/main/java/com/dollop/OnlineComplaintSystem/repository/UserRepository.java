package com.dollop.OnlineComplaintSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dollop.OnlineComplaintSystem.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}

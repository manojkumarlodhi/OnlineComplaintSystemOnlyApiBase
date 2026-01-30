package com.dollop.OnlineComplaintSystem.service.impl;

import java.net.Authenticator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.dollop.OnlineComplaintSystem.enums.Role;
import com.dollop.OnlineComplaintSystem.exception.AccessDenied;
import com.dollop.OnlineComplaintSystem.exception.ResourceNotFoundException;
import com.dollop.OnlineComplaintSystem.model.User;
import com.dollop.OnlineComplaintSystem.repository.UserRepository;
@Component
public class UserHelper {
	@Autowired
	private UserRepository repo;
	
	public User getLoggedInUser() {
		Authentication auth =SecurityContextHolder.getContext().getAuthentication();
		String email=auth.getName();
		return repo.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("user not found"));
	}
	
	public void checkAdmin() {
		User user=getLoggedInUser();
		if(user.getRole()!=Role.ADMIN) {
			throw new AccessDenied("Access Denied: Only admin can perform this action");
		}
	}
	
	public void checkUser() {
		User user=getLoggedInUser();
		if(user.getRole()!=Role.USER) {
			throw new AccessDenied("Access Denied: Only normal user can perform this action");
		}
	}
}

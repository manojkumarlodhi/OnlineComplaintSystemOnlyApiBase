package com.dollop.OnlineComplaintSystem.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dollop.OnlineComplaintSystem.exception.ResourceNotFoundException;
import com.dollop.OnlineComplaintSystem.model.User;
import com.dollop.OnlineComplaintSystem.repository.UserRepository;
@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<User> optionalUser=repo.findByEmail(email);
		if(!optionalUser.isPresent()) {
			throw new ResourceNotFoundException("user not foound " + email);
		}
		User user=optionalUser.get();
		
		return org.springframework.security.core.userdetails.User.withUsername(user.getEmail())
				.password(user.getPassword()).roles(user.getRole().name()).build();
	}

}

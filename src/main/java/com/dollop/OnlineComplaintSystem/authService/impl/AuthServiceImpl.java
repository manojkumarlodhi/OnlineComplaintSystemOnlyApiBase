package com.dollop.OnlineComplaintSystem.authService.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.dollop.OnlineComplaintSystem.authService.AuthService;
import com.dollop.OnlineComplaintSystem.exception.InvalidEmailOrPassword;
import com.dollop.OnlineComplaintSystem.security.JwtTokenProvider;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
	
	private final AuthenticationManager authenticationManager;
	  private final JwtTokenProvider jwtTokenProvider;
	

	@Override
	public String login(String email, String password) {
		// TODO Auto-generated method stub
		try {
		Authentication authentication =authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
		
		
		  return jwtTokenProvider.generatedToken(authentication.getName());
		}catch(BadCredentialsException e) {
			throw new InvalidEmailOrPassword("invalid Email or password");
		}
	}

}

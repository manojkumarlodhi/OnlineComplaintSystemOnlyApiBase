package com.dollop.OnlineComplaintSystem.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.dollop.OnlineComplaintSystem.enums.Role;
import com.dollop.OnlineComplaintSystem.model.User;
import com.dollop.OnlineComplaintSystem.requestDto.UserRequestDto;
import com.dollop.OnlineComplaintSystem.responseDto.UserResponseDto;

@Component
public class UserMapper {
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public User toEntity(UserRequestDto dto) {
		User user=new User();
		user.setName(dto.getName());
		user.setEmail(dto.getEmail());
		user.setMobile(dto.getMobile());
		user.setPassword(passwordEncoder.encode(dto.getPassword()));
		user.setRole(Role.USER);
		return user;
	}
	
	public UserResponseDto toResponse(User user) {
		
		UserResponseDto dto = new UserResponseDto();
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setMobile(user.getMobile());
        dto.setRegistrationDate(user.getRegistrationDate());
        dto.setRole(user.getRole());
        return dto;
	}
	
	

}

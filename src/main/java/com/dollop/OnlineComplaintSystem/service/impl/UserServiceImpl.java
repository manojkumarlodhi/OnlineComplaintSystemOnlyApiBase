package com.dollop.OnlineComplaintSystem.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dollop.OnlineComplaintSystem.exception.EmailAlreadyExistsException;
import com.dollop.OnlineComplaintSystem.exception.ResourceNotFoundException;
import com.dollop.OnlineComplaintSystem.mapper.UserMapper;
import com.dollop.OnlineComplaintSystem.model.User;
import com.dollop.OnlineComplaintSystem.repository.UserRepository;
import com.dollop.OnlineComplaintSystem.requestDto.UserRequestDto;
import com.dollop.OnlineComplaintSystem.responseDto.UserResponseDto;
import com.dollop.OnlineComplaintSystem.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository repo;
	@Autowired
	private UserMapper map;
	@Autowired
	private UserHelper userhelper;

	@Override
	public UserResponseDto registerUser(UserRequestDto dto) {
		// TODO Auto-generated method stub
		if(repo.existsByEmail(dto.getEmail())) {
			throw new EmailAlreadyExistsException("Email Already Exists " + dto.getEmail());
		}
		return map.toResponse(repo.save(map.toEntity(dto))) ;
	}

	@Override
	public List<UserResponseDto> getAllUsers() {
		 userhelper.checkAdmin();
		 List<User> users=repo.findAll();
		 if(users.isEmpty()) {
			 throw new ResourceNotFoundException("user not found ");
		 }
		 List<UserResponseDto> result=new ArrayList<>();
		 for(User user: users) {
			 result.add(map.toResponse(user));
		 }
		return result;
	}

	@Override
	public UserResponseDto getUserById(Long id) {
		// TODO Auto-generated method stub
		 userhelper.checkAdmin();
		 User user=repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("user not found  with id"));
		return map.toResponse(user);
	}

}

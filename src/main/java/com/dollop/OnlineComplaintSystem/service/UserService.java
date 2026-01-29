package com.dollop.OnlineComplaintSystem.service;

import java.util.List;

import com.dollop.OnlineComplaintSystem.requestDto.UserRequestDto;
import com.dollop.OnlineComplaintSystem.responseDto.UserResponseDto;

public interface UserService {
	UserResponseDto registerUser(UserRequestDto dto);
	List<UserResponseDto> getAllUsers();
	UserResponseDto getUserById(Long id);

}

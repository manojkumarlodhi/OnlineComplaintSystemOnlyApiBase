package com.dollop.OnlineComplaintSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dollop.OnlineComplaintSystem.authService.AuthService;
import com.dollop.OnlineComplaintSystem.requestDto.LoginRequestDto;
import com.dollop.OnlineComplaintSystem.requestDto.UserRequestDto;
import com.dollop.OnlineComplaintSystem.responseDto.LoginResponseDto;
import com.dollop.OnlineComplaintSystem.responseDto.UserResponseDto;
import com.dollop.OnlineComplaintSystem.responseUtil.ResponseUtil;
import com.dollop.OnlineComplaintSystem.service.UserService;
import com.dollop.OnlineComplaintSystem.successResponse.SuccessResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class AuthController {
	@Autowired
	private UserService service;
	@Autowired
	private AuthService authservice;
	
	@PostMapping("/register")
	public ResponseEntity<SuccessResponse> register(@RequestBody @Valid UserRequestDto userRequestDto, HttpServletRequest request){
		UserResponseDto registerUser=service.registerUser(userRequestDto);
		return ResponseUtil.success(
				"User registered successfully!", 
				registerUser,
				HttpStatus.CREATED,
	            request.getRequestURI());
	}
	
	@PostMapping("/login")
	public ResponseEntity<SuccessResponse> login( @RequestBody @Valid LoginRequestDto dto , HttpServletRequest request){
		String responseDto =authservice.login(dto.getEmail(),dto.getPassword());
		LoginResponseDto response = new LoginResponseDto();
	        response.setToken(responseDto);
	        response.setTokenType("Bearer");

		return ResponseUtil.success(
				"login succesfully",
				responseDto,
				HttpStatus.OK,
				 request.getRequestURI()
			);

    }
	
	
	
	
	

}

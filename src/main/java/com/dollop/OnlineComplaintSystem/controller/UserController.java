package com.dollop.OnlineComplaintSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dollop.OnlineComplaintSystem.responseDto.UserResponseDto;
import com.dollop.OnlineComplaintSystem.service.UserService;
import com.dollop.expensetracker.responseUtil.ResponseUtil;
import com.dollop.expensetracker.successResponse.SuccessResponse;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<SuccessResponse> listAllUser( HttpServletRequest request){
		List<UserResponseDto> response=service.getAllUsers();
		return ResponseUtil.success(
                "All users fetched successfully",
                response,
                HttpStatus.OK,
                request.getRequestURI()
        );
	}
	@GetMapping("/{id}")
	public ResponseEntity<SuccessResponse> getUserById(@PathVariable Long id,HttpServletRequest request){
		 UserResponseDto response = service.getUserById(id);

	        return ResponseUtil.success(
	                "User fetched successfully",
	                response,
	                HttpStatus.OK,
	                request.getRequestURI()
	        );
		
	}

}

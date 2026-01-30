package com.dollop.OnlineComplaintSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dollop.OnlineComplaintSystem.requestDto.ComplaintRequestSDto;
import com.dollop.OnlineComplaintSystem.requestDto.UpdateStatusRequestDto;
import com.dollop.OnlineComplaintSystem.responseDto.ComplaintResponseDto;
import com.dollop.OnlineComplaintSystem.responseUtil.ResponseUtil;
import com.dollop.OnlineComplaintSystem.service.ComplaintService;
import com.dollop.expensetracker.successResponse.SuccessResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/complaints")
public class ComplaintController {
	@Autowired
	private ComplaintService service;
	
	
	@PostMapping
	public ResponseEntity<SuccessResponse>submitComplaint(@RequestBody @Valid ComplaintRequestSDto requestSDto , HttpServletRequest request){
		ComplaintResponseDto response=service.submitComplaint(requestSDto);
		
		return ResponseUtil.success(
				"complaint submit succesfully !",
				response,
				 HttpStatus.OK,
	             request.getRequestURI()
				);
	}
	@GetMapping
	public ResponseEntity<SuccessResponse> listAllComplaint( HttpServletRequest request){
		List<ComplaintResponseDto> response=service.getAllComplaints();
		
		return ResponseUtil.success(
				"all complant list fetch succesfully",
				response,
				HttpStatus.OK,
				 request.getRequestURI()
				
				);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<SuccessResponse> getComplaintById(@PathVariable Long id ,HttpServletRequest request){
		ComplaintResponseDto response =service.getComplaintById(id);
		
		return ResponseUtil.success(
				" fetch complaint succesfully",
				response,
				HttpStatus.OK,
				 request.getRequestURI()
				
				);
	}
	
	
	@PutMapping("/{id}/status")
	public ResponseEntity<SuccessResponse> updateComplaintStatus(@PathVariable Long id,
	                                                            @RequestBody @Valid UpdateStatusRequestDto dto,
	                                                            HttpServletRequest request) {

	    ComplaintResponseDto response = service.updateComplaintStatus(id, dto);

	    return ResponseUtil.success(
	            "Complaint status updated successfully",
	            response,
	            HttpStatus.OK,
	            request.getRequestURI()
	    );
	}

	
	@GetMapping("/users/{id}/complaints")
	public ResponseEntity<SuccessResponse> getComplaintsByUserId(@PathVariable Long id,
	                                                            HttpServletRequest request) {

	    List<ComplaintResponseDto> response = service.getComplaintsByUserId(id);

	    return ResponseUtil.success(
	            "User complaints fetched successfully",
	            response,
	            HttpStatus.OK,
	            request.getRequestURI()
	    );
	}

	
	
	
	
	
	
	
	
	
	
	

}

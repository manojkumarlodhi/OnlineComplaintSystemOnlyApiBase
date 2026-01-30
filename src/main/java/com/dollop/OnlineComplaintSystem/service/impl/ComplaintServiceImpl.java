package com.dollop.OnlineComplaintSystem.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dollop.OnlineComplaintSystem.enums.Role;
import com.dollop.OnlineComplaintSystem.exception.AccessDenied;
import com.dollop.OnlineComplaintSystem.exception.InvalidEmailOrPassword;
import com.dollop.OnlineComplaintSystem.exception.ResourceNotFoundException;
import com.dollop.OnlineComplaintSystem.mapper.ComplaintMapper;
import com.dollop.OnlineComplaintSystem.model.Complaint;
import com.dollop.OnlineComplaintSystem.model.User;
import com.dollop.OnlineComplaintSystem.repository.ComplaintRepository;
import com.dollop.OnlineComplaintSystem.repository.UserRepository;
import com.dollop.OnlineComplaintSystem.requestDto.ComplaintRequestSDto;
import com.dollop.OnlineComplaintSystem.requestDto.UpdateStatusRequestDto;
import com.dollop.OnlineComplaintSystem.responseDto.ComplaintResponseDto;
import com.dollop.OnlineComplaintSystem.service.ComplaintService;
@Service
public class ComplaintServiceImpl implements ComplaintService {
	@Autowired
	private UserHelper help;
	@Autowired
	private ComplaintMapper map;
	@Autowired
	private ComplaintRepository repo;
	@Autowired
	private UserRepository userRepo;

	@Override
	public ComplaintResponseDto submitComplaint(ComplaintRequestSDto dton) {
		// TODO Auto-generated method stub
		User loggedInUser=help.getLoggedInUser();
		help.checkUser();
		return map.toResponse(repo.save(map.toEntity(dton, loggedInUser)));
	}

	@Override
	public List<ComplaintResponseDto> getAllComplaints() {
	
		// TODO Auto-generated method stub
		help.checkAdmin();
		List<Complaint> complaints=repo.findAll();
		if(complaints.isEmpty()) {
			throw new ResourceNotFoundException("complaint not found");
		}
		List<ComplaintResponseDto> result =new ArrayList<>();
		for(Complaint complaint: complaints) {
			result.add(map.toResponse(complaint));
		}
		return result;
	}

	@Override
	public ComplaintResponseDto getComplaintById(Long id) {
		// TODO Auto-generated method stub
		
		Complaint complaint=repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("complaint not found  with id "));
		User loggedInUser=help.getLoggedInUser();
		if(loggedInUser.getRole() == Role.USER && !complaint.getUser().getId().equals(loggedInUser.getId())) {
			 throw new AccessDenied("Access Denied: You can only view your own complaints");
	    }
		return map.toResponse(complaint);
	}

	@Override
	public ComplaintResponseDto updateComplaintStatus(Long id, UpdateStatusRequestDto dto) {
		// TODO Auto-generated method stub
		help.checkAdmin();
		Complaint complaint=repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("complaints not found with id"));
		 List<String> allowedStatuses = List.of("PENDING", "IN_PROGRESS", "RESOLVED", "REJECTED");
	        if (!allowedStatuses.contains(dto.getStatus())) {
	            throw new InvalidEmailOrPassword("Invalid status value: " + dto.getStatus());
	        }
		complaint.setStatus(dto.getStatus());
		repo.save(complaint);
		return map.toResponse(complaint);
	}

	@Override
	public List<ComplaintResponseDto> getComplaintsByUserId(Long userId) {
		// TODO Auto-generated method stub
		User loggedInUser=help.getLoggedInUser();
		if (loggedInUser.getRole() == Role.USER && !loggedInUser.getId().equals(userId)) {
            throw new AccessDenied("Access Denied: You can only view your own complaints");
        }
		User user=userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user not found with id"));
		List<Complaint> complaints = repo.findByUser(user);
		List<ComplaintResponseDto> result = new ArrayList<>();
        for (Complaint c : complaints) {
            result.add(map.toResponse(c));
        }
		return result;
	}

}

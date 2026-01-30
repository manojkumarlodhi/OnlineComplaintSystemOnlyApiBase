package com.dollop.OnlineComplaintSystem.mapper;

import org.springframework.stereotype.Component;

import com.dollop.OnlineComplaintSystem.enums.ComplaintStatus;
import com.dollop.OnlineComplaintSystem.model.Complaint;
import com.dollop.OnlineComplaintSystem.model.User;
import com.dollop.OnlineComplaintSystem.requestDto.ComplaintRequestSDto;
import com.dollop.OnlineComplaintSystem.responseDto.ComplaintResponseDto;

@Component
public class ComplaintMapper {
	
	public Complaint toEntity(ComplaintRequestSDto dto,User loggedInUser) {
		 Complaint c =new  Complaint();
		 c.setUser(loggedInUser);
		 c.setCategory(dto.getCategory());
		 c.setDescription(dto.getDescription());
		 c.setStatus(ComplaintStatus.OPEN);
		return c;
	}
	
	
	public ComplaintResponseDto toResponse(Complaint complaint) {
		ComplaintResponseDto dto = new ComplaintResponseDto();
        dto.setId(complaint.getId());
        dto.setUserId(complaint.getUser().getId());
        dto.setUserName(complaint.getUser().getName());
        dto.setUserEmail(complaint.getUser().getEmail());
        dto.setUserMobile(complaint.getUser().getMobile());
        dto.setCategory(complaint.getCategory());
        dto.setDescription(complaint.getDescription());
        dto.setStatus(complaint.getStatus());
        dto.setCreatedAt(complaint.getCreatedAt());
        dto.setUpdatedAt(complaint.getUpdatedAt());

        return dto;
	}
	
	
}

package com.dollop.OnlineComplaintSystem.service;

import java.util.List;

import com.dollop.OnlineComplaintSystem.requestDto.ComplaintRequestSDto;
import com.dollop.OnlineComplaintSystem.requestDto.UpdateStatusRequestDto;
import com.dollop.OnlineComplaintSystem.responseDto.ComplaintResponseDto;

public interface ComplaintService {
	ComplaintResponseDto submitComplaint(ComplaintRequestSDto dton);
	List<ComplaintResponseDto> getAllComplaints();
	ComplaintResponseDto getComplaintById(Long id);
	ComplaintResponseDto updateComplaintStatus(Long id ,UpdateStatusRequestDto dto);
	List<ComplaintResponseDto> getComplaintsByUserId(Long userId);

}

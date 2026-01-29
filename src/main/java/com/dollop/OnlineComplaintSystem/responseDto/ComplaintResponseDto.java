package com.dollop.OnlineComplaintSystem.responseDto;

import java.time.LocalDateTime;

import com.dollop.OnlineComplaintSystem.enums.ComplaintStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComplaintResponseDto {
	private Long id;
	private Long userId;
	private String userName;
	private String userEmail;
	private String userMobile;
	private String category;
	private String description;
	private ComplaintStatus status;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

}

package com.dollop.OnlineComplaintSystem.requestDto;

import com.dollop.OnlineComplaintSystem.enums.ComplaintStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateStatusRequestDto {
	private ComplaintStatus status;

}

package com.dollop.OnlineComplaintSystem.requestDto;

import com.dollop.OnlineComplaintSystem.enums.ComplaintStatus;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateStatusRequestDto {
	@NotNull(message = "Status is required")
	private ComplaintStatus status;

}

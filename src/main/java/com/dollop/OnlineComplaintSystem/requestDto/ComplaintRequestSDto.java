package com.dollop.OnlineComplaintSystem.requestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComplaintRequestSDto {
	private String category;
	private String description;

}

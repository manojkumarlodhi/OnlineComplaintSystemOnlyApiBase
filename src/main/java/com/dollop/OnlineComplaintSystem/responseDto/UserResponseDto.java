package com.dollop.OnlineComplaintSystem.responseDto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
	
    private Long id;
    private String name;
    private String email;
    private String mobile;
    private LocalDateTime registrationDate;

}

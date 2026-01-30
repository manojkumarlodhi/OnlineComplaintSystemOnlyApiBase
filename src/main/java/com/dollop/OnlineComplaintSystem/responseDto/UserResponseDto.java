package com.dollop.OnlineComplaintSystem.responseDto;

import java.time.LocalDateTime;

import com.dollop.OnlineComplaintSystem.enums.Role;
import com.dollop.OnlineComplaintSystem.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
    private String name;
    private String email;
    private String mobile;
    private LocalDateTime registrationDate;
    private Role role;

}

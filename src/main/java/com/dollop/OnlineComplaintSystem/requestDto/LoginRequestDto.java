package com.dollop.OnlineComplaintSystem.requestDto;

import com.dollop.OnlineComplaintSystem.util.RegexConstant;
import com.dollop.OnlineComplaintSystem.util.Validation;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDto {
	 @NotBlank(message = Validation.EMAIL_REQUIRED)
     @Email(message = Validation.EMAIL_INVALID)
	 private String email;
	 
	 @NotBlank(message = Validation.PASSWORD_REQUIRED)
	 @Pattern(regexp = RegexConstant.PASSWORD_REGEX, message = Validation.PASSWORD_INVALID)
	 private String password;
	 
}

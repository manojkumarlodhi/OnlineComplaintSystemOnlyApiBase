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
public class UserRequestDto {
	
	@NotBlank(message = Validation.USERNAME_REQUIRED)
	@Pattern(regexp = RegexConstant.NAME_REGEX, message = Validation.USERNAME_INVALID)
	private String name;
	@NotBlank(message = Validation.EMAIL_REQUIRED)
	@Email(message = Validation.EMAIL_INVALID)
	private String email;
	@NotBlank(message = Validation.MOBILE_REQUIRED)
	@Pattern(regexp = RegexConstant.MOBILE_REGEX, message = Validation.MOBILE_INVALID)
	private String mobile;
	@NotBlank(message = Validation.PASSWORD_REQUIRED)
    @Pattern(regexp = RegexConstant.PASSWORD_REGEX, message = Validation.PASSWORD_INVALID)
	private String password;
	

}

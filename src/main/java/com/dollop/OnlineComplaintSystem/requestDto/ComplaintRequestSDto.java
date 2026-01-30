package com.dollop.OnlineComplaintSystem.requestDto;

import com.dollop.OnlineComplaintSystem.util.RegexConstant;
import com.dollop.OnlineComplaintSystem.util.Validation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComplaintRequestSDto {
	@NotBlank(message = Validation.CATEGORY_REQUIRED)
	@Pattern(regexp = RegexConstant.CATEGORY_REGEX, message = Validation.CATEGORY_INVALID)
	private String category;
	@NotBlank(message = Validation.DESCRIPTION_REQUIRED)
	@Size(min = 10, max = 500, message = Validation.DESCRIPTION_INVALID)
	private String description;

}

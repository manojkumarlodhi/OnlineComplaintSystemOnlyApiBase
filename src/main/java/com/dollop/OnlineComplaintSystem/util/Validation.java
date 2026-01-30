package com.dollop.OnlineComplaintSystem.util;

public class Validation {
	
	 public static final String USERNAME_REQUIRED = "Username is required";
	    public static final String USERNAME_INVALID = "Username must contain only alphabets and spaces (3-50 characters)";

	    public static final String EMAIL_REQUIRED = "Email is required";
	    public static final String EMAIL_INVALID = "Email must be a valid email address";

	    public static final String MOBILE_REQUIRED = "Mobile is required";
	    public static final String MOBILE_INVALID = "Mobile number must be a valid 10-digit Indian number";

	    public static final String PASSWORD_REQUIRED = "Password is required";
	    public static final String PASSWORD_INVALID =
	            "Password must be 8-20 chars, include uppercase, lowercase, digit and special character";
	    
	    public static final String CATEGORY_REQUIRED = "Category is required";
	    public static final String CATEGORY_INVALID = "Category must be 3-50 characters and contain only alphabets/spaces";

	    public static final String DESCRIPTION_REQUIRED = "Description is required";
	    public static final String DESCRIPTION_INVALID = "Description must be 10-500 characters";

}

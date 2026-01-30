package com.dollop.OnlineComplaintSystem.util;

public class RegexConstant {
	
	 
    public static final String NAME_REGEX = "^[A-Za-z ]{3,50}$";

   
    public static final String MOBILE_REGEX = "^[6-9][0-9]{9}$";

    
    public static final String PASSWORD_REGEX =
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$";
    
    public static final String CATEGORY_REGEX = "^[A-Za-z ]{3,50}$";

}

package com.dollop.OnlineComplaintSystem.authService;

import com.dollop.OnlineComplaintSystem.requestDto.LoginRequestDto;

public interface AuthService {
	  String login(String email, String password);

}

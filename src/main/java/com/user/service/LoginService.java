package com.user.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	public boolean validate(String emailId, String pwd) {
		if(emailId.equals("littlecakes@cakelycakes.com") || emailId.equals("bigcakes@cakelycakes.com") ) {
			if(pwd.equals("ju"))
				return true;
			return false;
		}
		return false;
	}
	
}

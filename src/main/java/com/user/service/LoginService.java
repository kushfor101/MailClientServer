package com.user.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	public boolean validate(String emailId, String pwd) {
		if(emailId.equals("kaushal@samplemail.com") || emailId.equals("jadavpur@samplemail.com") || emailId.equals("littlecakes@samplemail.com") || emailId.equals("bigcakes@samplemail.com") ) {
			if(pwd.equals("ju"))
				return true;
			return false;
		}
		return false;
	}
	
}

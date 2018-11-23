package com.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.user.service.LoginService;

@Controller
public class LogoutController {
	
	@RequestMapping("logout")
	public ModelAndView logout(HttpServletRequest req, HttpServletResponse res) {
		req.getSession().removeAttribute("user");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index.jsp");
		return mav;
	}
}

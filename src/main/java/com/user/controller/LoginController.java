package com.user.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.user.model.MessageQueue;
import com.user.model.User;
import com.user.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping("login")
	public ModelAndView login(@RequestParam("text") String emailId, @RequestParam("pwd") String password, 
			HttpServletRequest req, HttpServletResponse res ) {
		ModelAndView mv = new ModelAndView();
		
		boolean isValid = loginService.validate(emailId, password);
		if(!isValid)
			mv.setViewName("loginerror.jsp");
		else {
			mv.setViewName("homepage.jsp");
			User user = new User(emailId, password);
			ArrayList<User> users = null;
			if(req.getSession().getAttribute("users")!=null)
				users = (ArrayList<User>)req.getSession().getAttribute("users");
			else
				users = new ArrayList<User>();
			users = User.addUser(users, user);
			req.getSession().setAttribute("users", users);
			req.getSession().setAttribute("currentuser", emailId);
			if(req.getSession().getAttribute("messagequeue")!=null) {
				System.out.println("got message queue");
				ArrayList<String> received = new ArrayList<String>();
				ArrayList<MessageQueue> mqs = (ArrayList<MessageQueue>)req.getSession().getAttribute("messagequeue");
				ArrayList<MessageQueue> newmqs = new ArrayList<MessageQueue>();
				for(MessageQueue mq : mqs) {
					if(mq.getFromId().equals(emailId) && mq.isReceived()) {
						received.add(mq.getToId());
					}
					else
						newmqs.add(mq);
				}
				req.getSession().setAttribute("messagequeue", newmqs);
				if(!received.isEmpty()) {
					System.out.println("sending notification");
					mv.addObject("notification", received);
				}
			}
			return mv;
		}
		return mv;
		
	}

}

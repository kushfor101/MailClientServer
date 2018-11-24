package com.user.controller;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sun.mail.pop3.POP3Store;

@Controller
public class ViewMailController {

	@RequestMapping("viewmails")
	public ModelAndView viewMails(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("viewpage.jsp");
		mav.addObject("currentuser", (String)req.getParameter("currentuser"));
		String user = (String)req.getParameter("currentuser");
		int in = user.indexOf('@');
		user = user.substring(0, in);
		System.out.println("hellooooo"+user);
		try {
			Properties properties = new Properties();
			properties.put("mail.pop3.host", "samplemail.com");
			Session emailSession = Session.getInstance(properties);
			
			System.out.println(user + " pwd ");
			POP3Store emailStore = (POP3Store) emailSession.getStore("pop3");
			emailStore.connect(user,"ju");

			Folder emailFolder = emailStore.getFolder("INBOX");
			emailFolder.open(Folder.READ_ONLY);

			Message[] messages = emailFolder.getMessages();
			mav.addObject("size", messages.length);
			mav.addObject("messages", messages);
			req.getSession().setAttribute("messages", messages);			
			for (int i = 0; i < messages.length; i++) {
				Message message = messages[i];
				System.out.println("==============================");
				System.out.println("Email #" + (i + 1));
				System.out.println("Subject: " + message.getSubject());
				System.out.println("From: " + message.getFrom()[0]);
				System.out.println("Text: " + message.getContent().toString());
			}

		//	emailFolder.close(false);
		//	emailStore.close(); 
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return mav;
		
	}
	
}

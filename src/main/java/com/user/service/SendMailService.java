package com.user.service;

import java.util.HashMap;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class SendMailService {
	
	public void sendMail(String fromId, String toId, String subject, String body) {
		
		try {
			Properties properties = new Properties();
			properties.put("mail.smtp.host", "cakelycakes.com");
			Session emailSession = Session.getInstance(properties);
			System.out.println("MY ID" + fromId);
			Message emailMessage = new MimeMessage(emailSession);
			emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toId));
	//		emailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(cc));
			emailMessage.setFrom(new InternetAddress(fromId));
			emailMessage.setSubject(subject);
			emailMessage.setText(body);

			emailSession.setDebug(true);

			Transport.send(emailMessage);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
	
}

package com.esi.uclm.procesos.gestion;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSender {

	final String username = "pis.uclm.2016@gmail.com";
	final String password = "pisuclm2016";   
	String content = "Existen tareas que requieren su atención, ";
	String to_email;

	public EmailSender (String to_email) {    
		this.to_email= to_email;
	}

	public void send() {

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to_email));
			message.setSubject("TODO App - Información");
			message.setText(content + to_email.split("@")[0]);

			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
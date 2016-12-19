package com.esi.uclm.procesos.gestion;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSender {

	private static EmailSender _instance;

	private final String username = "pis.uclm.2016@gmail.com";
	private final String password = "pisuclm2016";

	private Properties _props;

	private EmailSender () {
		_props = new Properties();
		_props.put("mail.smtp.auth", "true");
		_props.put("mail.smtp.starttls.enable", "true");
		_props.put("mail.smtp.host", "smtp.gmail.com");
		_props.put("mail.smtp.port", "587");
	}

	public static EmailSender getInstance() {
		if (_instance == null) _instance = new EmailSender();
		return _instance;
	}

	public void send(String to_email) {

		Session session = Session.getInstance(_props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			Message message = new MimeMessage(session);

			message.setFrom(new InternetAddress(username));

			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to_email));

			message.setSubject("TODO App - Informaci�n");

			String msg = "Buenas " + to_email.split("@")[0] + ",\n\n";
			msg += "existen tareas que requieren su atenci�n. Acceda al sitio web para verlas.";		
			message.setText(msg);

			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
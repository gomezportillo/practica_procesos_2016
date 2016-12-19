package com.esi.uclm.procesos.gestion;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

//https://www.tutorialspoint.com/java/java_sending_email.htm
public class EmailSender {

    String from = "PIS_TO_DO_APP@gmail.com";
    String host = "localhost";    
	String content = "Este email le informa de que se le ha asignado una nueva tarea, ";
	String to;
	
	public EmailSender (String to) {    
		this.to= to;
	}
	
	public boolean send() {
      Properties properties = System.getProperties();
      properties.setProperty("mail.smtp.host", host);
      Session session = Session.getDefaultInstance(properties);

      try {
         MimeMessage message = new MimeMessage(session);

         message.setFrom(new InternetAddress(from));

         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

         message.setSubject("Se le ha asignado una tarea.");
         
         message.setText(content + to.split("@")[0] + ". Acceda al sitio web para verla.");
         
         Transport.send(message);
         
         System.out.println("Mensaje enviado");
         return true;
         
      }catch (MessagingException mex) {
         mex.printStackTrace();
         return false;
      }
   }
}
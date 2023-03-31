package TP2_Modelo;

import java.util.Properties;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class MandarMail {
	public MandarMail(String destinatario, String asunto, String mensaje) {
		String para = destinatario;

		String de = "jakartafrom@example.com";

		final String username = "a094ccae2cfdb3";
		final String password = "82a851fcf4aa33";

		String host = "smtp.mailtrap.io";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new jakarta.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(de));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(para));
			message.setSubject(asunto);
			message.setText(mensaje);
			Transport.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

//	public void mandar(String destinatario, String asunto, String mensaje) {
//		String para = destinatario;
//
//		String de = "jakartafrom@example.com";
//
//		final String username = "a094ccae2cfdb3";
//		final String password = "82a851fcf4aa33";
//
//		String host = "smtp.mailtrap.io";
//
//		Properties props = new Properties();
//		props.put("mail.smtp.auth", "true");
//		props.put("mail.smtp.starttls.enable", "true");
//		props.put("mail.smtp.host", host);
//		props.put("mail.smtp.port", "587");
//
//		Session session = Session.getInstance(props, new jakarta.mail.Authenticator() {
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication(username, password);
//			}
//		});
//		try {
//			Message message = new MimeMessage(session);
//			message.setFrom(new InternetAddress(de));
//			message.setRecipient(Message.RecipientType.TO, new InternetAddress(para));
//			message.setSubject(asunto);
//			message.setText(mensaje);
//			Transport.send(message);
//		} catch (MessagingException e) {
//			throw new RuntimeException(e);
//		}
//	}
}

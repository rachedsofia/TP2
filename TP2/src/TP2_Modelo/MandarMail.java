package TP2_Modelo;

import java.util.Objects;
import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class MandarMail implements Mandar {
	private String emisor;
	private String receptor;
	private String user;
	private String password;
	private String host;

	public MandarMail(String emisor, String receptor, String usuario, String contra, String host) {

		this.emisor = Objects.requireNonNull(emisor);
		this.receptor = Objects.requireNonNull(receptor);
		this.user = Objects.requireNonNull(usuario);
		this.password = Objects.requireNonNull(contra);
		this.host = Objects.requireNonNull(host);
	}

	public void mandar(String titulo, String mensaje) {

		String de = "jakartafrom@example.com";

		final String username = "a094ccae2cfdb3";
		final String password = "82a851fcf4aa33";

		String host = "smtp.mailtrap.io";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");

		// create the Session object
		Authenticator authenticator = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		};
		Session session = Session.getInstance(props, authenticator);

		try {
			// create a MimeMessage object
			Message message = new MimeMessage(session);
			// set From email field
			message.setFrom(new InternetAddress(emisor));
			// set To email field
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receptor));
			// set email subject field
			message.setSubject(titulo);
			// set the content of the email message
			message.setText(mensaje);
			// send the email message
			Transport.send(message);
			System.out.println("Mensaje Enviado!");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void notificacionConcurso(String titulo, String msj) {

	}

	@Override
	public Boolean estaEnviado() {
		return null;
	}

}

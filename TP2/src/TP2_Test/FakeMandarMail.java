package TP2_Test;

import java.util.Objects;

import TP2_Modelo.Mandar;

public class FakeMandarMail implements Mandar {
	private String emisor;
	private String receptor;
	private String user;
	private String password;
	private String host;
	boolean enviado;

	public FakeMandarMail(String emisor, String receptor, String usuario, String contra, String host) {

		this.emisor = Objects.requireNonNull(emisor);
		this.receptor = Objects.requireNonNull(receptor);
		this.user = Objects.requireNonNull(usuario);
		this.password = Objects.requireNonNull(contra);
		this.host = Objects.requireNonNull(host);
	}

	public void notificarMail(String titulo, String msj) {
		enviado = true;

	}

	public Boolean estaEnviado() {
		return enviado;
	}

	@Override
	public void notificacionConcurso(String titulo, String msj) {
		this.enviado = true;
	}

}

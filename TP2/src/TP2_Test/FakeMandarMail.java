package TP2_Test;

import java.util.Objects;

public class FakeMandarMail {
	private String destinatario;
	private String asunto;
	private String mensaje;
	public boolean enviado;

	public FakeMandarMail(String destinatario, String asunto, String mensaje) {
		this.destinatario = Objects.requireNonNull(destinatario);
		this.asunto = Objects.requireNonNull(asunto);
		this.mensaje = Objects.requireNonNull(mensaje);

	}

	public void notificarMail(String titulo, String msj) {
		enviado = true;

	}

	public Boolean isEnviado() {
		return enviado;
	}

}

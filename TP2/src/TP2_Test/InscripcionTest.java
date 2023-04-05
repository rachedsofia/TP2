package TP2_Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import TP2_Modelo.Concurso;
import TP2_Modelo.Participante;
import TP2_Modelo.RegistroInscripcion;
import TP2_Persistencia.BDRegistroInscripcion;

public class InscripcionTest {
	@Test
	public void ConcursoPoderJudicial() {
		LocalDate fechaC = LocalDate.now();
		LocalDate fechaD = LocalDate.of(2023, 4, 25);

		// RegistroInscripcion registar = new
		// DiscoRegistroInscripcion("C:\\Users\\msofi\\OneDrive\\EscritorioTP2-Reg.txt");

		// Punto 3
		RegistroInscripcion registar = new BDRegistroInscripcion("jdbc:mysql://127.0.0.1/poo_tp2-3", "root", "");
		// Punto 4
		// Mandar notificar = new EnEmail("from@example.com", "tom@example.com",
		// "b78c9f4878db7f", "b4f74a52b601e4",
		// "sandbox.smtp.mailtrap.io");

		// Punto 5
		// Mandar notificar = new Mandar("from@example.com", "tom@example.com",
		// "b78c9f4878db7f", "b4f74a52b601e4",
//				"sandbox.smtp.mailtrap.io");
		FakeMandarMail notificar = new FakeMandarMail("from@example.com", "tom@example.com", "b78c9f4878db7f",
				"b4f74a52b601e4", "sandbox.smtp.mailtrap.io");

		Participante participanteC = new Participante("Sofia", "Rached", 44122180);
		Concurso concursoPoderJudicialA = new Concurso("Poder Judicial", fechaC, fechaD, 1, registar, notificar);

		concursoPoderJudicialA.inscribirParticipante(participanteC);

		assertEquals(true, notificar.estaEnviado());

	}
}

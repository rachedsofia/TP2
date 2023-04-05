package tp2_modelo;

import java.time.LocalDate;

import TP2_Persistencia.BDRegistroInscripcion;
import tp2_test.FakeMandarMail;

public class Main {
	public static void main(String[] args) {
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
		Concurso concursoPoderJudicialA = new Concurso("Poder Judicial", fechaC, fechaD, 1, registar, notificar);

		Participante participanteC = new Participante("Sofia", "Rached", 44122980);
		concursoPoderJudicialA.inscribirParticipante(participanteC);

	}
}

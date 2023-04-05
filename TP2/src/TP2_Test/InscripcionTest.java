package TP2_Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import TP2_Modelo.Concurso;
import TP2_Modelo.Mandar;
import TP2_Modelo.MandarMail;
import TP2_Modelo.Participante;
import TP2_Modelo.RegistroInscripcion;

public class InscripcionTest {
	@Test
	public void ConcursoPoderJudicial() {
		// inicialización
		Participante participante1 = new Participante("Sofia", "Rached", 44122180);
		Participante participante2 = new Participante("luciana", "Rached", 44122140);

		LocalDate fecha3 = LocalDate.of(2023, 03, 07);
		LocalDate fecha4 = LocalDate.of(2023, 05, 30);
//		RegistroInscripcion registrar = new DiscoRegistroInscripcion(
//				"C:\\Users\\msofi\\OneDrive\\EscritorioTP2-Reg.txt");
		RegistroInscripcion registrar = new FakeRegistroInscripcion();
//		ObjetoDeMentira registrar = new ObjetoDeMentira(); ANDA CON EL ASSERT COMENTADO
		Concurso concursoPoderJudicial = new Concurso("Poder Judicial", fecha3, fecha4, 1, registrar);
		Concurso concursoPoderJudicial1 = new Concurso("Poder Judicial", fecha3, fecha4, 2, registrar);

		boolean valorEsperadoParticipante2Inscripto = false;

		// ejercitacion
		concursoPoderJudicial.inscribirParticipante(participante1);
		concursoPoderJudicial1.inscribirParticipante(participante2);
		boolean resultado1 = participante2.inscripto;

		assertEquals(valorEsperadoParticipante2Inscripto, resultado1);
	}

	@Test
	public void ConcursoPoderJudicialBD() {
		// inicialización
		Participante participanteA = new Participante("Sofia", "Rached", 44122180);
		Participante participanteB = new Participante("luciana", "Rached", 44122140);

		LocalDate fechaA = LocalDate.of(2023, 03, 07);
		LocalDate fechaB = LocalDate.of(2023, 03, 10);
//		RegistroInscripcion registrarA = new BDRegistroInscripcion("jdbc:mysql://127.0.0.1/poo_tp2-3", "root", "");
		RegistroInscripcion registrarA = new FakeRegistroInscripcion();
		Concurso concursoPoderJudicialA = new Concurso("Poder Judicial", fechaA, fechaB, 1, registrarA);
		Concurso concursoPoderJudicial1B = new Concurso("Poder Judicial", fechaA, fechaB, 2, registrarA);

		boolean valorEsperadoParticipanteBInscripto = false;

		// ejercitacion
		concursoPoderJudicialA.inscribirParticipante(participanteA);
		concursoPoderJudicial1B.inscribirParticipante(participanteB);
		boolean resultadoB = participanteB.inscripto;

		assertEquals(valorEsperadoParticipanteBInscripto, resultadoB);

	}

	@Test
	public void ConcursoPoderJudicialMAIL() {
		// inicialización
		Participante participanteC = new Participante("Sofia", "Rached", 44122180);
		Participante participanteD = new Participante("luciana", "Rached", 44122140);

		LocalDate fechaC = LocalDate.of(2023, 03, 07);
		LocalDate fechaD = LocalDate.of(2023, 05, 30);
//		RegistroInscripcion registrarA = new BaseRegistrarInscripcion("jdbc:mysql://127.0.0.1/poo_tp2-3", "root", "");
//		RegistroInscripcion registrarA = new ObjetoDeMentira();
		Mandar registrarA = new MandarMail("from@example.com", "tom@example.com", "b78c9f4878db7f", "b4f74a52b601e4",
				"sandbox.smtp.mailtrap.io");
		Concurso concursoPoderJudicialA = new Concurso("Poder Judicial", fechaC, fechaD, 1, registrarA);
		Concurso concursoPoderJudicial1B = new Concurso("Poder Judicial", fechaC, fechaD, 2, registrarA);

		boolean valorEsperadoParticipanteBInscripto = false;

		// ejercitacion
		concursoPoderJudicialA.inscribirParticipante(participanteC);
		concursoPoderJudicial1B.inscribirParticipante(participanteD);
		boolean resultadoB = participanteD.inscripto;
		boolean resultadoA = participanteC.inscripto;
//		
		// validacion
		assertEquals(valorEsperadoParticipanteBInscripto, resultadoA);
		assertEquals(valorEsperadoParticipanteBInscripto, resultadoB);
	}

	@Test
	public void ConcursoPoderJudicialMAILFAKE() {
		// inicialización
		Participante participanteC = new Participante("Sofia", "Rached", 44122180);
		Participante participanteD = new Participante("luciana", "Rached", 44122140);

		LocalDate fechaC = LocalDate.now();
		LocalDate fechaD = LocalDate.of(2023, 05, 30);
//		RegistroInscripcion registrarA = new BaseRegistrarInscripcion("jdbc:mysql://127.0.0.1/poo_tp2-3", "root", "");
//		RegistroInscripcion registrarA = new ObjetoDeMentira();
		Mandar registrarC = new FakeMandarMail("from@example.com", "tom@example.com", "b78c9f4878db7f",
				"b4f74a52b601e4", "sandbox.smtp.mailtrap.io");
		Concurso concursoPoderJudicialA = new Concurso("Poder Judicial", fechaC, fechaD, 1, registrarC);
		Concurso concursoPoderJudicial1B = new Concurso("Poder Judicial", fechaC, fechaD, 2, registrarC);

		boolean valorEsperadoParticipanteBInscripto = false;

		// ejercitacion
		concursoPoderJudicialA.inscribirParticipante(participanteC);
		concursoPoderJudicial1B.inscribirParticipante(participanteD);
		boolean resultadoB = participanteD.inscripto;
		boolean resultadoA = participanteC.inscripto;
//		
		// validacion
		assertEquals(valorEsperadoParticipanteBInscripto, resultadoA);
		assertEquals(valorEsperadoParticipanteBInscripto, resultadoB);
	}

}

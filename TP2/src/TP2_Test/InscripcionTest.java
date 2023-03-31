package TP2_Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import TP2_Modelo.Concurso;
import TP2_Modelo.Participante;
import TP2_Modelo.RegistroInscripcion;
import TP2_Persistencia.BaseRegistrarInscripcion;
import TP2_Persistencia.DiscoRegistroInscripcion;

public class InscripcionTest {
	@Test
	public void ConcursoPoderJudicial() {
		// inicialización
		Participante participante1 = new Participante("Sofia", "Rached", 44122180);
		Participante participante2 = new Participante("luciana", "Rached", 44122140);

		LocalDate fecha3 = LocalDate.of(2023, 03, 07);
		LocalDate fecha4 = LocalDate.of(2023, 03, 10);
		RegistroInscripcion registrar = new DiscoRegistroInscripcion("C:\\Users\\msofi\\OneDrive\\EscritorioTP2-Reg.txt");
		
		Concurso concursoPoderJudicial = new Concurso("Poder Judicial", fecha3, fecha4,1,registrar);
		Concurso concursoPoderJudicial1 = new Concurso("Poder Judicial", fecha3, fecha4,2,registrar);
		
		boolean valorEsperadoParticipante2Inscripto = false;

		// ejercitacion
		concursoPoderJudicial.inscribirParticipante(participante1);
		concursoPoderJudicial1.inscribirParticipante(participante2);
		boolean resultado1 = participante2.inscripto;
		boolean resultado2 = participante1.inscripto;
//		
		// validacion
		assertEquals(valorEsperadoParticipante2Inscripto, resultado2);
		assertEquals(valorEsperadoParticipante2Inscripto, resultado1);
	}
	@Test
	public void ConcursoPoderJudicialBD() {
		// inicialización
		Participante participanteA = new Participante("Sofia", "Rached", 44122180);
		Participante participanteB = new Participante("luciana", "Rached", 44122140);

		LocalDate fechaA = LocalDate.of(2023, 03, 07);
		LocalDate fechaB = LocalDate.of(2023, 03, 10);
		RegistroInscripcion registrarA = new BaseRegistrarInscripcion("jdbc:mysql://127.0.0.1/poo_tp2-3","root", "");
		
		Concurso concursoPoderJudicialA = new Concurso("Poder Judicial", fechaA, fechaB,1,registrarA);
		Concurso concursoPoderJudicial1B = new Concurso("Poder Judicial", fechaA, fechaB,2,registrarA);
		
		boolean valorEsperadoParticipanteBInscripto = false;

		// ejercitacion
		concursoPoderJudicialA.inscribirParticipante(participanteA);
		concursoPoderJudicial1B.inscribirParticipante(participanteB);
		boolean resultadoB = participanteB.inscripto;
		boolean resultadoA = participanteA.inscripto;
//		
		// validacion
		assertEquals(valorEsperadoParticipanteBInscripto, resultadoA);
		assertEquals(valorEsperadoParticipanteBInscripto, resultadoB);
	
	}
}

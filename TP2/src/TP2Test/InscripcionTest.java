package TP2Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import EnDiscoRegistroInscripcion.DiscoRegistroInscripcion;
import TP2Modelo.Concurso;
import TP2Modelo.Participante;
import TP2Modelo.RegistroInscripcion;

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
}

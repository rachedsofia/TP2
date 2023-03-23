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
		LocalDate fecha3 = LocalDate.of(2023, 03, 07);
		LocalDate fecha4 = LocalDate.of(2023, 03, 10);
		RegistroInscripcion registrar = new DiscoRegistroInscripcion("C:\\Users\\msofi\\OneDrive\\EscritorioTP2-Reg.txt");
		
		Concurso concursoPoderJudicial = new Concurso("Poder Judicial", fecha3, fecha4,1,registrar);
		boolean valorEsperadoParticipante2Inscripto = false;

		// ejercitacion
		concursoPoderJudicial.inscribirParticipante(participante1);
		boolean resultado2 = participante1.inscripto;
//		
		// validacion
		assertEquals(valorEsperadoParticipante2Inscripto, resultado2);

	}
}

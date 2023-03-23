package TP2Modelo;
import java.time.LocalDate;

import EnDiscoRegistroInscripcion.DiscoRegistroInscripcion;

public class Main {
	public static void main(String[] args) {
		String fechaF2 = "2023-03-30";
	
		LocalDate fecha1 = LocalDate.now();
		LocalDate fecha2 = LocalDate.parse(fechaF2);
		
		Participante participante1 = new Participante("Sofia", "Rached", 44122180);
		
		RegistroInscripcion registrar = new DiscoRegistroInscripcion("C:\\Users\\msofi\\OneDrive\\Escritorio\\Prueba.txt");
		
		Concurso concursoTecno = new Concurso("Tecnología", fecha1, fecha2,1,registrar);

		concursoTecno.inscribirParticipante(participante1);
		

	}

	

}

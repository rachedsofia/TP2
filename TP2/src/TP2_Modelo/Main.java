package TP2_Modelo;
import java.time.LocalDate;

import TP2_Persistencia.DiscoRegistroInscripcion;

public class Main {
	public static void main(String[] args) {
System.out.println("EN DISCO");
		String fechaF2 = "2023-03-30";
	
		LocalDate fecha1 = LocalDate.now();
		LocalDate fecha2 = LocalDate.parse(fechaF2);
		
		Participante participante1 = new Participante("Sofia", "Rached", 44122180);
		
		RegistroInscripcion registrar = new DiscoRegistroInscripcion("C:\\Users\\msofi\\OneDrive\\Escritorio\\Prueba.txt");
		
		Concurso concursoTecno = new Concurso("Tecnología", fecha1, fecha2,1,registrar);

		concursoTecno.inscribirParticipante(participante1);

//		System.out.println("EN BASE DE DATOS");
//
//		String fechaF21 = "2023-03-30";
//		
//		LocalDate fecha11 = LocalDate.now();
//		LocalDate fecha21 = LocalDate.parse(fechaF21);
//		
//		Participante participante11 = new Participante("Sofia", "Rached", 44122180);
//		
//		RegistroInscripcion registrar1 = new BaseRegistrarPago("http://localhost/phpmyadmin/index.php?route=/sql&pos=0&db=poo_tp2-3&table=registro");
//		
//		Concurso concursoTecno1 = new Concurso("Tecnología", fecha11, fecha21,1,registrar1);
//
//		concursoTecno1.inscribirParticipante(participante11);

	}

	

}

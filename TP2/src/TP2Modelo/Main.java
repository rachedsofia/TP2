package TP2Modelo;
import java.time.LocalDate;

public class Main {
	public static void main(String[] args) {
		String fechaI1 = "2023-03-15";
		String fechaF2 = "2023-03-27";
		String fechaF3 = "2023-03-07";
		String fechaF4 = "2023-03-10";

		LocalDate fecha1 = LocalDate.parse(fechaI1);
		LocalDate fecha2 = LocalDate.parse(fechaF2);
		LocalDate fecha3 = LocalDate.parse(fechaF3);
		LocalDate fecha4 = LocalDate.parse(fechaF4);

		Participante participante1 = new Participante("Sofia", "Rached", 44122180);
		Participante participante2 = new Participante("Luciana", "Rached", 465432225);

		Concurso concursoTecno = new Concurso("Tecnología", fecha1, fecha2);
		Concurso concursoPoderJudicial = new Concurso("Poder Judicial", fecha3, fecha4);
		Concurso concursoPoderJudicial2 = new Concurso("Poder Judicial", fecha1, fecha2);

		concursoTecno.inscribirParticipante(participante1);
		concursoPoderJudicial2.inscribirParticipante(participante1);
		concursoPoderJudicial.inscribirParticipante(participante2);

		System.out.println("Cantidad de puntos participante 1: " + participante1.getCantPuntos());
		System.out.println("Cantidad de puntos participante 1: " + participante2.getCantPuntos());

	}

}

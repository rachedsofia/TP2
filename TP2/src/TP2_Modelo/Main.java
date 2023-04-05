package TP2_Modelo;

import java.time.LocalDate;

import TP2_Test.FakeRegistroInscripcion;

public class Main {
	public static void main(String[] args) {
		System.out.println("EN DISCO");
		String fechaF2 = "2023-03-30";

		LocalDate fecha1 = LocalDate.now();
		LocalDate fecha2 = LocalDate.parse(fechaF2);

		Participante participante1 = new Participante("Sofia", "Rached", 44122180);

//		RegistroInscripcion registrar = new DiscoRegistroInscripcion("C:\\Users\\msofi\\OneDrive\\Escritorio\\Prueba.txt");
		RegistroInscripcion registrar = new FakeRegistroInscripcion();
		Concurso concursoTecno = new Concurso("Tecnología", fecha1, fecha2, 1, registrar);

		concursoTecno.inscribirParticipante(participante1);

		System.out.println("EN BASE DE DATOS");

		String fechaF21 = "2023-03-30";

		LocalDate fecha11 = LocalDate.now();
		LocalDate fecha21 = LocalDate.parse(fechaF21);

		Participante participante11 = new Participante("Sofia", "Rached", 44122180);
//		RegistroInscripcion registrar1 = new BaseRegistrarInscripcion("jdbc:mysql://127.0.0.1/poo_tp2-3","root", "");
		RegistroInscripcion registrar1 = new FakeRegistroInscripcion();
		Concurso concursoTecno1 = new Concurso("Tecnología", fecha11, fecha21, 1, registrar1);
		concursoTecno1.inscribirParticipante(participante11);

		System.out.println("EN MAILTRAP");

		String fechaF4 = "2023-03-30";

		LocalDate fecha0 = LocalDate.now();
		LocalDate fecha5 = LocalDate.parse(fechaF4);
		Participante participante4 = new Participante("Sofia", "Rached", 44122180);
		Mandar notificar = new MandarMail("from@example.com", "tom@example.com", "b78c9f4878db7f", "b4f74a52b601e4",
				"sandbox.smtp.mailtrap.io");

//		Mandar notificar = new FakeMandarMail(("from@example.com", "tom@example.com", "b78c9f4878db7f", "b4f74a52b601e4",
//		"sandbox.smtp.mailtrap.io");
		Concurso concursoTecno10 = new Concurso("Tecnología", fecha0, fecha5, 1, notificar);

		concursoTecno10.inscribirParticipante(participante4);
	}
}

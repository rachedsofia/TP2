package TP2_Persistencia;

import java.time.LocalDate;

import TP2_Modelo.RegistroInscripcion;

public class BaseRegistrarInscripcion implements RegistroInscripcion {
	private ParticipanteJDBC participanteJDBC = new ParticipanteJDBC();    

	@Override
	public void registrar(LocalDate fecha, int id_Participante, int id_Concurso) {
		// TODO Auto-generated method stub

		try {
			participanteJDBC.create(fecha, id_Participante, id_Concurso);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	}
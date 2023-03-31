package TP2_Persistencia;

import java.time.LocalDate;

import TP2_Modelo.RegistroInscripcion;

public class ObjetoDeMentira implements RegistroInscripcion {
	// variables para comparar los valores
	int idParti;
	int idConcu;

	@Override
	public void registrar(LocalDate f, int id_Participante, int id_Concurso) {
		// TODO Auto-generated method stub

	}

	public boolean comparar(int id_participante, int id_concurso) {
		if (idParti == id_participante && idConcu == id_concurso) {
			return true;
		} else {
			return false;
		}
	}

}

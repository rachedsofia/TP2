package tp2_test;

import java.time.LocalDate;

import tp2_modelo.RegistroInscripcion;

public class FakeRegistroInscripcion implements RegistroInscripcion {
	// variables para comparar los valores
	int idParti;
	int idConcu;

	@Override
	public void registrar(LocalDate f, int id_Participante, int id_Concurso) {
		// TODO Auto-generated method stub

	}

	boolean comparar(int id_participante, int id_concurso) {
		if (idParti == id_participante && idConcu == id_concurso) {
			return true;
		}
		return false;
	}

}

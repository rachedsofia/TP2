package TP2_Persistencia;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

import tp2_modelo.RegistroInscripcion;

public class DiscoRegistroInscripcion implements RegistroInscripcion {

	private String ruta;

	public DiscoRegistroInscripcion(String direccion) {
		this.ruta = direccion;

	}

	@Override
	public void registrar(LocalDate f, int id_Participante, int id_Concurso) {
		// TODO Auto-generated method stub
		FileWriter escritura;
		try {
			escritura = new FileWriter(ruta);
			escritura.write(f + "||" + id_Participante + "||" + id_Concurso);
			escritura.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

}

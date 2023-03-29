package TP2_Modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Participante {
	public String nombre; 
	private String apellido;
	public int id;
	private int cantPuntos = 0;
	LocalDate fechaIns;
	private ArrayList<Concurso> listConcurso = new ArrayList<Concurso>();

	public boolean inscripto = false;

	public Participante(String nombre, String apellido, int id) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.id = id;
		this.fechaIns = LocalDate.now();
	}

	public void sumarPuntos() {
		this.cantPuntos = +10;
	}
	
	public int obtenerId() {
		return id;
	}
}

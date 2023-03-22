package TP2Modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Participante {
	private String nombre; // private todo
	// sumar puntos
	private String apellido;
	private int id;
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

	public int getCantPuntos() {
		return cantPuntos;
	}

	public void sumarPuntos() {
		this.cantPuntos = +10;
	}
}

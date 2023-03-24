package TP2Modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Concurso {

	private String nombreConcurso;
	private LocalDate fechaDesde;
	private LocalDate fechaHasta;
	private ArrayList<Participante> listParticipante = new ArrayList<Participante>();
	RegistroInscripcion registroInscipcion;
	public int id; 
	

	public Concurso(String nombre, LocalDate fechaDesde, LocalDate fechaHasta,int id, RegistroInscripcion registro) {
		this.nombreConcurso = nombre;
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
		this.id = id; 
		this.registroInscipcion = registro;
	}
	
	public int obtenerId() {
		return id;
	}
	public boolean yaInscripto(Participante participante) {
		return listParticipante.contains(participante);
	}

	public boolean inscribePrimerDia() {
		LocalDate fechaInscripcion = LocalDate.now();
		return fechaDesde.equals(fechaInscripcion);
	}

	public boolean sePuedeInscribir(Participante participante) {
		return (participante.fechaIns.isAfter(this.fechaDesde)) && (participante.fechaIns.isBefore(this.fechaHasta));
	}

	public void inscribirParticipante(Participante participante) {
		if ((!yaInscripto(participante)) && ((inscribePrimerDia()))) {
			participante.sumarPuntos();
		}
		if (sePuedeInscribir(participante) == true) {
			participante.inscripto = true;
			this.agregarParticipante(participante);
		}
		
		this.registroInscipcion.registrar(LocalDate.now(),participante.obtenerId(),this.obtenerId()); 
	}

	public void agregarParticipante(Participante unParticipante) {
		this.listParticipante.add(unParticipante);
	}
}

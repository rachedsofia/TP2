package TP2_Modelo;

import java.time.LocalDate;
import java.util.List;

public class Concurso {

	private String nombreConcurso;
	private LocalDate fechaDesde;
	private LocalDate fechaHasta;
	private List<Participante> participantes;
	RegistroInscripcion registroInscipcion;
	Mandar mandarMail;
	public int id;

	public Concurso(String nombre, LocalDate fechaDesde, LocalDate fechaHasta, int id, RegistroInscripcion registro,
			Mandar mail) {
		this.nombreConcurso = nombre;
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
		this.id = id;
		this.registroInscipcion = registro;
		this.mandarMail = mail;
	}

	public int obtenerId() {
		return id;
	}

	public boolean yaInscripto(Participante participante) {
		return this.participantes.stream().anyMatch(p -> participante.equals(p));
	}

	private boolean inscribePrimerDia() {
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
		if (sePuedeInscribir(participante)) {
			this.participantes.add(participante);
		}
		this.registroInscipcion.registrar(LocalDate.now(), participante.obtenerId(), this.obtenerId());
		this.mandarMail.notificacionConcurso("Concurso:" + this.obtenerId(),
				"Se cargo el participante " + participante.obtenerId() + " en la fecha " + LocalDate.now());

	}

	String obtenerNombre() {
		return this.nombreConcurso;
	}
}

package TP2_Modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Concurso {

	private String nombreConcurso;
	private LocalDate fechaDesde;
	private LocalDate fechaHasta;
	private ArrayList<Participante> listParticipante = new ArrayList<Participante>();
	RegistroInscripcion registroInscipcion;
	Mandar mandarMail;
	private String correo = "msofiarached@gmail.com";
	public int id;
	private boolean inscripto;

	public Concurso(String nombre, LocalDate fechaDesde, LocalDate fechaHasta, int id, RegistroInscripcion registro) {
		this.nombreConcurso = nombre;
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
		this.id = id;
		this.registroInscipcion = registro;
	}

	public Concurso(String nombre, LocalDate fechaDesde, LocalDate fechaHasta, int id, Mandar mail) {
		this.nombreConcurso = nombre;
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
		this.id = id;
		this.mandarMail = mail;
	}

	public int obtenerId() {
		return id;
	}

	public boolean yaInscripto(Participante participante) {
		return listParticipante.contains(participante);
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
			this.inscripto = true;
			this.agregarParticipante(participante);
		}

		this.registroInscipcion.registrar(LocalDate.now(), participante.obtenerId(), this.obtenerId());
		this.mandarMail.notificacionConcurso("Concurso:" + this.obtenerId(),
				"Se cargo el participante " + participante.obtenerId() + " en la fecha " + LocalDate.now());

	}

	public void agregarParticipante(Participante unParticipante) {
		this.listParticipante.add(unParticipante);
	}

	String obtenerNombre() {
		return this.nombreConcurso;
	}
}

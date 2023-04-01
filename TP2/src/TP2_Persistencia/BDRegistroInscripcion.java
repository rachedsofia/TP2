package TP2_Persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.time.LocalDate;

import TP2_Modelo.RegistroInscripcion;

public class BDRegistroInscripcion implements RegistroInscripcion {
	String url; 
	String user;
	String password; 
	 
	public BDRegistroInscripcion(String url,	String user, String password) {
		if(url == null || user == null || password == null) {
			throw new RuntimeException("Faltan datos");
		}
		this.url = url;
		this.user = user;
		this.password = password;
	}

	@Override
	public void registrar(LocalDate fecha, int id_Participante, int id_Concurso) {
		try (Connection conn = DriverManager.getConnection(this.url,this.user, this.password);
				java.sql.PreparedStatement statement = conn.prepareStatement("INSERT INTO participante_concurso(fecha,id_participante, id_concurso) " + " VALUES (?,?,?)")){
					Date date = Date.valueOf(fecha);
				
				statement.setDate(1, date);
				statement.setInt(2, id_Participante);
				statement.setInt(3, id_Concurso);
				statement.executeUpdate();
	} catch (Exception e) {
		throw new RuntimeException(e);
		}
	}
}

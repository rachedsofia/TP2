package EnDiscoRegistroInscripcion;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.swing.JOptionPane;
import TP2Modelo.RegistroInscripcion;

public class BaseRegistrarPago implements RegistroInscripcion {
	public static final String URL = "http://localhost/phpmyadmin/index.php?route=/sql&pos=0&db=poo_tp2-3&table=registro";
    public static final String USER = "root";
    public static final String CLAVE = "";
      
	private String direccion; 
	public BaseRegistrarPago(String direccion) {
		this.direccion = direccion; 
	}
	
    public BaseRegistrarPago registrar(){
    	BaseRegistrarPago con = null;
        try{
            Class.forName("com.mysq l.cj.jdbc.Driver");
            con = (BaseRegistrarPago) DriverManager.getConnection(URL, USER, CLAVE);
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return con;
    }

    private Connection con;

	@Override
	public void registrar(LocalDate fecha, int id_Participante, int id_Concurso) {
		// TODO Auto-generated method stub
		  PreparedStatement ps;
	        String sql;
	        ZoneId defaultZoneId = ZoneId.systemDefault();
	        Date fecha1 = Date.from(fecha.atStartOfDay(defaultZoneId).toInstant());
	        try{
	            sql = "insert into datos(fecha,id_participante,id_concurso) values(?,?,?)";
	            ps = con.prepareStatement(sql);
	            ps.setDate(1, (java.sql.Date) fecha1);
	            ps.setInt(2, id_Participante);
	            ps.setInt(3, id_Concurso);
	            ps.executeUpdate();
	            JOptionPane.showMessageDialog(null, "Se han insertado los datos");
	        }catch(SQLException e){
	            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
	        }
	}
	}
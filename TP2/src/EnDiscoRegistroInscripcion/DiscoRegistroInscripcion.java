package EnDiscoRegistroInscripcion;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.time.LocalDate;

import TP2Modelo.RegistroInscripcion;

public class DiscoRegistroInscripcion implements RegistroInscripcion {

	private String direccion; 
	public DiscoRegistroInscripcion(String direccion) {
		this.direccion = direccion; 
		
	}
	@Override
	public void registrar(LocalDate fecha, int id_Participante, int id_Concurso) {
		FileOutputStream salida;
		try {
			FileOutputStream is = new FileOutputStream("C:\\\\Users\\\\msofi\\\\OneDrive\\\\Escritorio\\\\Prueba.txt\\\\TP2-Reg.txt");
			OutputStreamWriter osw = new OutputStreamWriter(is);
			Writer escritura = new BufferedWriter(osw);
			escritura.write(fecha + "||" + id_Participante +"||" + id_Concurso);
			escritura.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
//		System.out.println(id_Concurso);
//		System.out.println(id_Participante);
	
	}
	

}

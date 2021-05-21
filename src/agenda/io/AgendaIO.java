package agenda.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.PatternSyntaxException;

import agenda.modelo.AgendaContactos;
import agenda.modelo.Contacto;
import agenda.modelo.Personal;
import agenda.modelo.Profesional;
import agenda.modelo.Relacion;

/**
 * Utilidades para cargar la agenda
 * 
 * @author - Elorri Oloritz, Ibai Andreu, Julen Baztarrika
 */
public class AgendaIO {

	public static void importar(AgendaContactos agenda, String nombre) {
		int contador = 1; 
		InputStream input = AgendaIO.class.getClassLoader()
				 .getResourceAsStream(nombre);
		BufferedReader entrada = null;
		String sb = "";
		try {
			entrada = new BufferedReader(new InputStreamReader(input));
			String linea = entrada.readLine();
			while (linea != null) {
				try {
					sb += linea +"\n";
					Contacto contacto = parsearLinea(linea);
					AgendaContactos.añadirContacto(contacto);
					contador++;
				}
				catch (NumberFormatException e) {
					System.out.println(e.getMessage());
				}
				linea = entrada.readLine();

			}
		}
		catch (FileNotFoundException e) {
			System.out.println("Error al abrir fichero " + e.getMessage());
		}
		catch (IOException e) {
			System.out.println("Error al leer");
		}
		finally {
			try {
				entrada.close();
			}
			catch (IOException e) {
				System.out.println("Error al cerrar");
			}
			catch (NullPointerException e) {
				System.out.println("Error al cerrar " + e.toString());
			}
		}

	}
	
		/**
		 * @throws PatternSyntaxException
		 * @throws NumberFormatException
		 * @throws NullPointerException
		 */
	private static Contacto parsearLinea(String linea) 
	throws PatternSyntaxException, NumberFormatException, NullPointerException {
		
		String[] cont = linea.split(",");
		int tipo = Integer.parseInt(cont[0].trim());
		String nombre = cont[1].trim();
		String apellidos = cont[2].trim();
		String telefono = cont[3].trim();
		String email = cont[4].trim();
		
		if (tipo == 1) {
			String empresa = cont[5].trim();
			Profesional pro = new Profesional(nombre,apellidos,telefono,email,empresa);
			return pro;
		}
		else {
			String fecha = cont[5].trim();
			Relacion rel = Relacion.AMIGOS;
			for (Relacion r : Relacion.values()) {
				if (r.toString().equals(cont[6].trim().toUpperCase())) {
					rel = r;
				}
			}
			Personal per = new Personal(nombre,apellidos,telefono,email,rel,fecha);
			return per;
			}
		}
	
	public static void exportarPersonales(AgendaContactos agenda, String nombre)
			throws IOException, NullPointerException {
		File f = new File(nombre + ".txt");
		PrintWriter salida = new PrintWriter(
		new BufferedWriter(new FileWriter(f)));
		
		Map<Relacion, List<String>> ag = agenda.personalesPorRelacion();
	    
		for (Map.Entry<Relacion, List<String>> entry : ag.entrySet()) {
			salida.println(entry.getKey() + "\n     " + entry.getValue());
		}
		salida.close();
	}
}

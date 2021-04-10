package ut7.agenda.modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @authors - Elorri Oloritz, Ibai Andreu, Julen Baztarrika
 */

public class Personal extends Contacto extends Contacto{
	
	private Relacion rel;
	private LocalDate fecha;

	public Personal(String nombre, String apellidos, String telefono,
			String email, Relacion rel, String fecha) {
		super(nombre,apellidos,telefono,email);
		this.rel = rel;
		this.fecha = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	
	public String firma() {
		return "Un abrazo!!";
	}
	
	public boolean esCumpleanos() {
		return fecha.getMonth() == LocalDate.now().getMonth() &&
				fecha.getDayOfMonth() == LocalDate.now().getDayOfMonth();
	}

	@Override
	public String toString() {
		String str = super.toString();
		String mes;
		
		switch(fecha.getMonthValue()){
		case 1:
			mes = " ene. ";
		case 2:
			mes = " feb. ";
		case 3:
			mes = " mar. ";
		case 4:
			mes = " abr. ";
		case 5:
			mes = " may. ";
		case 6:
			mes = " jun. ";
		case 7:
			mes = " jul. ";
		case 8:
			mes = " ago. ";
		case 9:
			mes = " sep. ";
		case 10:
			mes = " oct. ";
		case 11:
			mes = " nov. ";
		default:
			mes = " dic. ";
		}
		str += "\nFecha nacimiento: " + fecha.getDayOfMonth() + mes + fecha.getYear() + 
				"\nRelacion: " + rel.toString();
				
		return str;
	}

}

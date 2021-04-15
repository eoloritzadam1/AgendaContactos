package ut7.agenda.modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @authors - Elorri Oloritz, Ibai Andreu, Julen Baztarrika
 */

public class Personal extends Contacto{
	
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
	
	public Relacion getRel() {
		return rel;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	@Override
	public String toString() {
		String str = super.toString();
		String mes;
		
		switch(fecha.getMonthValue()){
		case 1:
			mes = " ene. ";
			break;
		case 2:
			mes = " feb. ";
			break;
		case 3:
			mes = " mar. ";
			break;
		case 4:
			mes = " abr. ";
			break;
		case 5:
			mes = " may. ";
			break;
		case 6:
			mes = " jun. ";
			break;
		case 7:
			mes = " jul. ";
			break;
		case 8:
			mes = " ago. ";
			break;
		case 9:
			mes = " sep. ";
			break;
		case 10:
			mes = " oct. ";
			break;
		case 11:
			mes = " nov. ";
			break;
		default:
			mes = " dic. ";
		}
		str += "\nFecha nacimiento: " + fecha.getDayOfMonth() + mes + fecha.getYear() + 
				"\nRelacion: " + rel.toString();
				
		return str;
	}


}

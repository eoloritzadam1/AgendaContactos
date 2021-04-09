import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 
 * @author Elorri Oloritz
 *
 */

public class Personal extends Contacto {
	
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
		return this.fecha.equals(LocalDate.now());
	}

}

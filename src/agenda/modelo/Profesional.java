package agenda.modelo;

/**
 * @author - Elorri Oloritz, Ibai Andreu, Julen Baztarrika
 */

public class Profesional extends Contacto {

	private String nombreEmpresa;
	
	/**
	 * 
	 * @param nombre
	 * @param apellidos
	 * @param telefono
	 * @param email
	 * @param nombreEmpresa
	 * Constructor para la clase profesional heredado de la clase Contacto.
	 */
	public Profesional(String nombre, String apellidos, String telefono,
			String email, String nombreEmpresa) {
		super(nombre,apellidos,telefono,email);
		this.nombreEmpresa = Character.toUpperCase(nombreEmpresa.charAt(0)) + nombreEmpresa.substring(1, nombreEmpresa.length()).toLowerCase();
	}
	
	/**
	 * Accesor para el nombre de empresa
	 * @return
	 */
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	
	/**
	 * Mutador para el nombre de empresa con la seguridad de que
	 * todos los caracteres sean en minuscula excepto el primero
	 * que siempre será mayuscula.
	 * @param nombreEmpresa
	 */
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = Character.toUpperCase(nombreEmpresa.charAt(0)) + nombreEmpresa.substring(1, nombreEmpresa.length()).toLowerCase();
	}
	
	/**
	 * 
	 * @return un mensaje aleatorio de firma
	 */
	public String firma() {
		String firma = "";
		
		switch((int)Math.random()*4) {
		case 0:
			firma = "Atentamente";
		break;
		case 1:
			firma = "Saludos";
		break;
		case 2:
			firma = "Saludos Cordiales";
		break;
		case 3:
			firma = "Mis mejores deseos";
		break;
		}
		
		return firma;
	}

	/**
	 * toString() para la clase Profesional.
	 */
	public String toString() {
		String str = super.toString();
		return str + "\nEmpresa: " + nombreEmpresa;
	}

	
	
}

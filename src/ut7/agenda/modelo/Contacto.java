package ut7.agenda.modelo;

import java.util.Collections;

/**
 * @authors - Elorri Oloritz, Ibai Andreu, Julen Baztarrika
 */

public abstract class Contacto implements Comparable<Contacto>{
	private String nombre;
	private String apellidos;
	private String telefono;
	private String email;

	public Contacto(String nombre, String apellidos, String telefono,
			String email) {
		this.nombre = nombre.toUpperCase();
		this.apellidos = apellidos.toUpperCase();
		this.telefono = telefono;
		this.email = email.toLowerCase();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return email.hashCode();
	}
	
	/**
	 * Devuelve la primera letra del contacto
	 */
	public char getPrimeraLetra() {
		return apellidos.charAt(0);
		
	}
	
	public abstract String firma();

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contacto other = (Contacto) obj;
		if (apellidos == null) {
			if (other.apellidos != null)
				return false;
		} else if (!apellidos.equals(other.apellidos))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		return true;
	}
	
	/**
	 * Compara un contacto primero los apellidos después el nombre 
	 * si coincide devuelve 0
	 */
	public int compareTo(Contacto c) {
		if(apellidos.equalsIgnoreCase(c.apellidos)) {
			if(nombre.equalsIgnoreCase(c.nombre)) {
				return 0;
			}
		}
		return -1;
		/*int comp = this.nombre.compareToIgnoreCase(c.getNombre());
		if (comp == 0) {
			comp = this.apellidos.compareToIgnoreCase(c.getApellidos());
		}
		if (comp == 0) {
			comp = this.telefono.compareToIgnoreCase(c.getTelefono());
		}
		if (comp == 0) {
			comp = this.email.compareToIgnoreCase(c.getEmail());
		}
		return comp;*/
	}

	/**
	 * toString de la clase Contacto
	 */
	public String toString() {
		return apellidos.toUpperCase() + ", " + nombre.toUpperCase() +
		" (" + getClass() + ") /n" + "Tfno: " + telefono + " | email: " + 
				email + "/nEmpresa: ";
	}
	
	
}

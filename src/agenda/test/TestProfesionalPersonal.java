package agenda.test;

import java.util.ArrayList;
import java.util.List;

import agenda.modelo.Contacto;
import agenda.modelo.Personal;
import agenda.modelo.Profesional;
import agenda.modelo.Relacion;

/**
 * @author - Elorri Oloritz, Ibai Andreu, Julen Baztarrika
 */

public class TestProfesionalPersonal {

	public static void main(String[] args) {
		List<Contacto> profesionales = new ArrayList<>();
		addContacto(profesionales, new Profesional("Isabel", "Acosta Mendioroz",
				"678895433", "iacostamen@gmail.com", "walden estrella"));
		addContacto(profesionales, new Profesional("Angel", "Esteban Grande",
				"674544123", "aestebang@gmail.com", "magma publicidad"));
		addContacto(profesionales, new Profesional("Isabel", "Acosta Marin",
				"678895433", "iacostamar@gmail.com", "publicidad holdings"));
		addContacto(profesionales, new Profesional("Isabel", "Acosta Mendioroz",
				"678895433", "iacostamen@gmail.com", "walden estrella"));
		System.out.println("Contactos profesionales");
		mostrarContactos(profesionales);

		separador();
		Profesional profesional = new Profesional("Isabel", "Acosta Marin",
				"678895433", "iacostamar@gmail.com", "publicidad holdings");
		buscarContacto(profesionales, profesional);
		profesional = new Profesional("Isabel", "Acosta Marin", "678895433",
				"isaacostamarin@gmail.com", "electronica lado");
		buscarContacto(profesionales, profesional);
		separador();

		mostrarFirmaEmail(profesionales.get(1));
		separador();

		// -------------------------------------

		List<Contacto> personales = new ArrayList<>();
		addContacto(personales,
				new Personal("Elena", "Bueno Ganuza", "6786547699",
						"ebuenogan@gmail.com", Relacion.AMIGOS, "17/03/2000"));
		addContacto(personales,
				new Personal("Amaia", "Romero Sein", "642222343",
						"aromerosein@gmail.com", Relacion.PAREJA,
						"08/03/2012"));
		addContacto(personales,
				new Personal("Ignacio", "Anto roth", "688912799",
						"iantoroth@gmail.com", Relacion.PADRE, "11/11/1969"));
		addContacto(personales,
				new Personal("Berta", "andia solano", "621123345",
						"bandiasol@gmail.com", Relacion.HIJA, "12/12/1999"));
		addContacto(personales,
				new Personal("Ignacio", "Anto roth", "688912799",
						"iantoroth@gmail.com", Relacion.PADRE, "11/11/1969"));
		System.out.println("Contactos personales");
		mostrarContactos(personales);

		separador();
		Personal personal = new Personal("Elena", "Bueno Ganuza", "6786547699",
				"ebuenogan@gmail.com", Relacion.AMIGOS, "17/03/2000");
		buscarContacto(personales, personal);
		separador();

		mostrarFirmaEmail(personales.get(1));
		separador();
	}

	private static void addContacto(List<Contacto> contactos,
			Contacto contacto) {
		if (!contactos.contains(contacto)) {
			contactos.add(contacto);
		}

	}

	private static void mostrarContactos(List<Contacto> contactos) {
		for (Contacto contacto : contactos) {
			System.out.println(contacto);
		}

	}

	private static void buscarContacto(List<Contacto> contactos,
			Contacto contacto) {

		int pos = contactos.indexOf(contacto);
		System.out.println("El contacto\n" + contacto);
		if (pos == -1) {
			System.out.println("no existe\n");
		} else {
			System.out.println("est?? en posici??n " + pos + "\n");
		}
	}

	private static void mostrarFirmaEmail(Contacto contacto) {
		System.out.println("Mostrando la firma del email del contacto ...");
		System.out.println(contacto);
		System.out.println(contacto.getEmail());

	}

	private static void separador() {
		System.out.println(
				"------------------------------------------------------------");

	}

}

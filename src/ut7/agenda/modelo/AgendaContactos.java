package ut7.agenda.modelo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @authors - Elorri Oloritz, Ibai Andreu, Julen Baztarrika
 */

public class AgendaContactos {
	private Map<Character, Set<Contacto>> agenda;
	private int total = 0;

	public AgendaContactos() {
		agenda = new HashMap<>();
	}

	public void añadirContacto(Contacto cont) {
		agenda.put(cont.getPrimeraLetra(), cont);
		total++;
	}

	public void contactosEnLetra(String letra) {
		
	}

	public void totalContactos() {
		System.out.println(total); 
	}

	@Override
	public String toString() {

		return null;
	}

	public List<Contacto> buscarContactos(String texto) {
		ArrayList<Contacto> resul = new ArrayList<>();
		for (Contacto contacto:agenda) {
			if (contacto.getNombre().contains(texto)) {
				resul.add(contacto);
			}
			else if(contacto.getApellidos().contains(texto)) {
				resul.add(contacto);
			}
		}
		
		return resul;

	}

	public List<Personal> personalesEnLetra(char letra) {

	}

	public List<Personal> felicitar() {
		ArrayList<Contacto> resul = new ArrayList<>();
		Iterator<Contacto> it = agenda.iterator();
		while (it.hasNext()) {
			Contacto c = it.next();
			if (c instanceof Personal) {
				if (((Personal) c).esCumpleanos() == true) {
					resul.add(c);
				}
			}
		}
		return resul;
	}

	public void personalesPorRelacion() {

	}

	public List<Personal> personalesOrdenadosPorFechaNacimiento(char letra) {

		return null;

	}

}

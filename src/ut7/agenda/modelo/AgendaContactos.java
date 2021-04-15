package ut7.agenda.modelo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @authors - Elorri Oloritz, Ibai Andreu, Julen Baztarrika
 */

public class AgendaContactos {
	private Map<Character, Set<Contacto>> agenda;
	private int total = 0;

	public AgendaContactos() {
		agenda = new TreeMap<>(); //Corregido, tiene que ir en orden alfabético
	}

	public void añadirContacto(Contacto cont) {
		if (agenda.containsKey(cont.getPrimeraLetra())) {
			agenda.get(cont.getPrimeraLetra()).add(cont);
		} // primero debe comprobar si existe la letra
		else {
			HashSet<Contacto> contactos = new HashSet<>();
			contactos.add(cont);
			agenda.put(cont.getPrimeraLetra(), contactos);
		}
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
		Iterator<Map.Entry<Character, Set<Contacto>>> it = agenda.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Character, Set<Contacto>> e = it.next();
			for (Contacto c : e.getValue()) {
				if (c.getNombre().contains(texto) || c.getApellidos().contains(texto)) {
					resul.add(c);
				}
			}
		}
		
		return resul;
	}

	public List<Personal> personalesEnLetra(char letra) {
		ArrayList<Personal> resul = new ArrayList<>();
		if (!agenda.containsKey(letra)) {
			resul = null;
		}
		else {
			for (Contacto c : agenda.get(letra)) {
					if (c instanceof Personal) {
						resul.add((Personal) c);
					}
			}
		}
		return resul;
	}

	public List<Personal> felicitar() {
		ArrayList<Personal> resul = new ArrayList<>();
		Iterator<Map.Entry<Character, Set<Contacto>>> it = agenda.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Character, Set<Contacto>> e = it.next();
			for (Contacto c : e.getValue()) {
				if (c instanceof Personal) {
					if (((Personal) c).esCumpleanos() == true) {
						resul.add((Personal) c);
					}
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

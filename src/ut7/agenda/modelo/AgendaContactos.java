package ut7.agenda.modelo;
import java.util.ArrayList;
import java.util.Collections;
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

	public Set<Contacto> contactosEnLetra(char letra) {
		Set<Contacto> resul = agenda.get(letra);
		return resul;
	}

	public int totalContactos() {
		return total;
	}

	@Override
	public String toString() {
		String str = "AGENDA DE CONTACTOS\n";
		Iterator<Map.Entry<Character, Set<Contacto>>> it1 = agenda.entrySet().iterator();
		while (it1.hasNext()) {
			Map.Entry<Character, Set<Contacto>> e = it1.next();
			str += "\n" + e.getKey() + " (" + contactosEnLetra(e.getKey()).size() + 
					" contacto/s)";
			Iterator<Contacto> it2 = e.getValue().iterator();
			while (it2.hasNext()) {
				Contacto c = it2.next();
				str += "\n" + c.toString() + "\n";
			}
		}
		return str;
	}

	public List<Contacto> buscarContactos(String texto) {
		ArrayList<Contacto> resul = new ArrayList<>();
		Iterator<Map.Entry<Character, Set<Contacto>>> it = agenda.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Character, Set<Contacto>> e = it.next();
			for (Contacto c : e.getValue()) {
				if (c.getNombre().contains(texto.toUpperCase()) ||
						c.getApellidos().contains(texto.toUpperCase())) {
					resul.add(c);
				}
			}
		}
		
		return resul;
	}

	public List<Personal> personalesEnLetra(char letra) {
		/*ArrayList<Personal> resul = new ArrayList<>();
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
		*/
		ArrayList<Personal> resul = new ArrayList<>();
		if (agenda.containsKey(letra)) {
			for (Contacto c : contactosEnLetra(letra)){
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

	public Map<Relacion, List<String>> personalesPorRelacion() {
		Map<Relacion, List<String>> resul = new TreeMap<>();
		Iterator<Map.Entry<Character, Set<Contacto>>> it = agenda.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Character, Set<Contacto>> e = it.next();
			for (Contacto c : e.getValue()) {
				if (c instanceof Personal) {
					String cadena = c.getNombre() + ' ' + c.getApellidos();
					Relacion rel = ((Personal) c).getRel();
					if (resul.containsKey(rel)) {
						resul.get(rel).add(cadena);
					} 
					else {
						List<String> contactos = new ArrayList<>();
						contactos.add(cadena);
						resul.put(rel,contactos);
					}
				}
			}
		}
		return resul;
	}

	public List<Personal> personalesOrdenadosPorFechaNacimiento(char letra) {
		List<Personal> resul = personalesEnLetra(letra);
		Collections.sort(resul, new ComparadorFechaNacimiento());
		return resul;
	}

}

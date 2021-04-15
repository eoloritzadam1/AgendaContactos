package ut7.agenda.modelo;
import java.util.Comparator;

public class ComparadorFechaNacimiento implements Comparator<Personal> {
	
	@Override
	public int compare(Personal p1, Personal p2) {
		return p1.getFecha().compareTo(p2.getFecha());
	}
}

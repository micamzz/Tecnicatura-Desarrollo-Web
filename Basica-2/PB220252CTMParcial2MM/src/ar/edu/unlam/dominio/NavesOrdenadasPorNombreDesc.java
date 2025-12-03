package ar.edu.unlam.dominio;

import java.util.Comparator;

public class NavesOrdenadasPorNombreDesc implements Comparator <Nave>{

	@Override
	public int compare(Nave o1, Nave o2) {
		return o1.getNombre().compareToIgnoreCase(o2.getNombre()) * (-1);
	}

}

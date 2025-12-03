package ar.edu.unlam.dominio;

import java.util.Comparator;

public class NavesOrdenadasPorId implements Comparator <Nave> {

	@Override
	public int compare(Nave o1, Nave o2) {
		return o1.getIdUnico().compareToIgnoreCase(o2.getIdUnico());
	}

}

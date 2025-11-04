package ar.edu.unlam.dominio;

import java.util.Comparator;

public class MotosOrdenadasPorPatente implements Comparator <Moto>{

	@Override
	public int compare(Moto o1, Moto o2) {
		return o1.getPatente().compareToIgnoreCase(o2.getPatente());
	}

}



package ar.edu.unlam.dominio;

import java.util.Comparator;

public class OrdenCanchasPorPrecio implements Comparator <Cancha>{

	@Override
	public int compare(Cancha o1, Cancha o2) {
		
		return o1.getPrecioBasePorHora().compareTo(o2.getPrecioBasePorHora());
	}

}

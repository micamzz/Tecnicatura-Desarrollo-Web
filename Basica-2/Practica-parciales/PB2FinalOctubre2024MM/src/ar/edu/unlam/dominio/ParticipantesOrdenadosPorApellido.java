package ar.edu.unlam.dominio;

import java.util.Comparator;

public class ParticipantesOrdenadosPorApellido implements Comparator <Cliente>{

	@Override
	public int compare(Cliente o1, Cliente o2) {
		
		return o1.getApellido().compareToIgnoreCase(o2.getApellido()) ;
	}

}

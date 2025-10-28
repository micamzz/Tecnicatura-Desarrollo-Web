package ar.edu.unlam.dominio;

import java.util.Comparator;

public class MedicosOrdenadosPorapellido implements Comparator <Medico> {

	@Override
	public int compare(Medico o1, Medico o2) {
		
		Integer resultado =  o1.getApellido().compareTo(o2.getApellido());
		
		if (resultado ==0) {
			return o1.getDni().compareTo(o2.getDni());
		}
			
		return resultado;
		
	}


}

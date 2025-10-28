package ar.edu.unlam.dominio;

import java.util.Comparator;

public class PacientesOrdenadosPorApellido implements Comparator <Paciente>{

	@Override
	public int compare(Paciente o1, Paciente o2) {
		
		Integer resultado = o1.getApellido().compareTo(o2.getApellido());
		if (resultado == 0) {
			return o1.getDni().compareTo(o2.getDni());
		}
		
		return resultado;
		}

}

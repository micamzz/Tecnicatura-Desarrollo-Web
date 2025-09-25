package ar.edu.unlam.dominio;

import java.util.HashSet;
import java.util.Objects;

public class Conductor {

	private String nombre;
	private String licencia;
	
	public Conductor(String nombre, String licencia) {
		super();
		this.nombre = nombre;
		this.licencia = licencia;
	}
	
	

	
	@Override
	public int hashCode() {
		return Objects.hash(licencia);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conductor other = (Conductor) obj;
		return Objects.equals(licencia, other.licencia);
	}

	
	
	
	
	
	
	
	
	
}

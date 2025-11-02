package ar.edu.unlam.dominio;

import java.util.Objects;

public class Cliente implements Comparable <Cliente>{

	private String nombre;
	private String apellido;
	private Integer dni;
	
	public Cliente(String nombre, String apellido, Integer dni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}

	
	public Integer getDni() {
		return dni;
	}


	@Override
	public int compareTo(Cliente o) {
		return this.dni.compareTo(o.getDni());
	}


	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(dni, other.dni);
	}
	
	
	
	
	
	
	
}

package ar.edu.unlam.dominio;

import java.util.Objects;

public class Cliente {

	private Integer dni;
	 private String nombre;
	 private String apellido;
	 
	 
	public Cliente(Integer dni, String nombre, String apellido) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	
	

	public String getApellido() {
		return apellido;
	}




	public Integer getDni() {
		return dni;
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

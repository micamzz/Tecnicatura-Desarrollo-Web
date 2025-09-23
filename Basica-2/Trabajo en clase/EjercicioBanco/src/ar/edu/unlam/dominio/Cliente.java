package ar.edu.unlam.dominio;

import java.util.Objects;

public class Cliente {

	private Integer dni;
	private String apellido;

	
	public Cliente(Integer dni, String apellido) {
		this.dni=dni;
		this.apellido = apellido;
	}


	public Integer getDni() {
		return dni;
	}


	public void setDni(Integer dni) {
		this.dni = dni;
	}


	public String getApellido() {
		return apellido;
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
		Cliente other = (Cliente) obj;
		return Objects.equals(dni, other.dni);
	}
	
	
}

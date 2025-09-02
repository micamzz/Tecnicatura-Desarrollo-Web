package ar.edu.unlam.dominio;

import java.util.Objects;

public class Cliente {
	private Integer dni;
	private String nombre;
	private String apellido;

	public Cliente(String nombre, String apellido, Integer dni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}
	
	public Integer obtenerDni() {
		return this.dni;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	// 2 objetos son iguales si tienen el mismo DNI.
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

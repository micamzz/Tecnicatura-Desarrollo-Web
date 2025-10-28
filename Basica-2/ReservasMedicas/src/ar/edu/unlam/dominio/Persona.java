package ar.edu.unlam.dominio;

import java.util.Objects;

public abstract class Persona {

	private String nombre;
	private String apellido;
	private Integer dni;
	private Integer edad;
	
	
	public Persona(String nombre, String apellido, Integer dni, Integer edad) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.dni = dni;
		
	}


	public String getNombre() {
		return nombre;
	}


	public String getApellido() {
		return apellido;
	}
	
	public String getNombreCompleto() {
		
		return this.nombre + " " + this.apellido;
	}


	public Integer getDni() {
		return dni;
	}


	public Integer getEdad() {
		return edad;
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
//		if (getClass() != obj.getClass())
//			return false;
		Persona other = (Persona) obj;
		return Objects.equals(dni, other.dni);
	}
	
	
	
}

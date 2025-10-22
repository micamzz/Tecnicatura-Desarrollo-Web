package ar.edu.unlam.dominio;

public class Paciente {

	private Integer dni;
	private String nombre;
	private String apellido;
	
	
	public Paciente(Integer dni, String nombre, String apellido) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
}


	public Integer getDni() {
		return this.dni;
	}

	
	
	
}

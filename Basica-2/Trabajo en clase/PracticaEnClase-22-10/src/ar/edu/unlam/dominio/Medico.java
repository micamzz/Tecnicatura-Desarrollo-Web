package ar.edu.unlam.dominio;



public class Medico implements Comparable<Medico>{

	private Integer dni;
	private String nombre;
	private String apellido;
	
	
	
	public Medico(Integer dni, String nombre, String apellido) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
	}



	public Integer getDni() {
		return dni;
	}


	public String getApellido() {
		return apellido;
	}



	@Override
	public int compareTo(Medico o) {
		return this.getDni().compareTo(o.getDni());
	}













	
	
	
	
	
	
}

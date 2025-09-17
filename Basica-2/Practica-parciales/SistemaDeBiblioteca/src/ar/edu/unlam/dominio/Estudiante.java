package ar.edu.unlam.dominio;

public class Estudiante {
 
	private Integer dni;
	private String nombre;
	private String apellido;
	private Integer librosPrestados;
	
	
	public Estudiante(Integer dni, String nombre, String apellido) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.librosPrestados = 0;
	}
	
	public void prestarLibro() {
		this.librosPrestados++;
	}
	
	public void devuelveLibro() {
		this.librosPrestados--;
	}
	
	public Boolean puedePrestarLibro() {
	return this.librosPrestados < 2;
	}

	public Integer getLibrosPrestados() {
		return librosPrestados;
	}
	
	
	
	
}

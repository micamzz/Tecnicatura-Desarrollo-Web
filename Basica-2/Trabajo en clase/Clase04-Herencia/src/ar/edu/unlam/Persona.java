package ar.edu.unlam;

public class Persona implements Operaciones {
	
	private Integer dni;
	private String nombre;
	private Integer edad;
	
	public Persona(Integer dni, String nombre, Integer edad ) {
		this.dni = dni;
		this.nombre = nombre;
		this.edad = edad;

	}
	public Integer getDni() {
		return this.dni;
	}

	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = "Nombre: " + nombre;
		
	}

	public Integer getEdad() {
		return this.edad;
	}

	public String toString() {
		return "Soy una Persona";
	}
	
	protected void emitirMensaje() {
		
	}

	@Override
	public void resolverTarea(int cantidadDeTareas) {
		System.out.println("Ayudar de persona");
	}

	@Override
	public void ayudar() {
		// TODO Auto-generated method stub
	}
}

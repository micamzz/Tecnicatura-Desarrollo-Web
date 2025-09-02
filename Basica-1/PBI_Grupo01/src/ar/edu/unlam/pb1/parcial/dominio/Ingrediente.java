package ar.edu.unlam.pb1.parcial.dominio;

public class Ingrediente {

	private String nombre;
	private double precio;
	private Origen origen;
	boolean ingredienteEstaDisponible;

	public Ingrediente(String nombre, Origen origen) {
		this.nombre = nombre;
		this.precio = 0.0;
		this.origen = origen;
		this.ingredienteEstaDisponible = false;
	}

	public boolean isIngredienteEstaDisponible() {
		return ingredienteEstaDisponible;
	}

	public void setIngredienteEstaDisponible(boolean ingredienteEstaDisponible) {
		this.ingredienteEstaDisponible = ingredienteEstaDisponible;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Origen getOrigen() {
		return origen;
	}

	public void setOrigen(Origen origen) {
		this.origen = origen;
	}

	@Override

	public String toString() {
		return "Ingrediente [nombre=" + nombre + ", origen=" + origen + "]\n ";
	}

}

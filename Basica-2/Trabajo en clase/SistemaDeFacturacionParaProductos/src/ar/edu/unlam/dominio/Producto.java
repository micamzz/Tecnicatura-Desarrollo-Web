package ar.edu.unlam.dominio;

public class Producto {

	private String nombre;
	private Double precio;
	private String descripcion;
	
	public Producto(String nombre, Double precio, String descripcion) {
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
	}

	public Double getPrecio() {
		return this.precio;
	}
	// Metodos
	
	public Double calcularPrecioFinal() {

		return this.precio;
	}
	
	
	
	
	
	
}

package ar.edu.unlam.dominio;

public abstract class Producto {

	
	private String nombre;
	private Integer stock;
	protected Double precioBase;

	public Producto (String nombre,Double precioBase,Integer stock) {
		this.nombre = nombre;
		this.stock = stock;
		this.precioBase = precioBase;
		
	}
	
	
	public abstract Double calcularPrecioFinal();


	public String getNombre() {
		return nombre;
	}


	public Integer getStock() {
		return stock;
	}


	public  Double getPrecioBase() {
		return this.precioBase;
	}
	
	
	
}

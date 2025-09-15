package ar.edu.unlam.dominio;

public class Producto {

	private String nombre;
	private Integer cantidad;
	private Double precioUnitario;
	
	public Producto(String nombre, Integer cantidad, Double precioUnitario) {
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public Double getPrecioUnitario() {
		return precioUnitario;
	}
	
	public Double obtenerPrecio() {
		Double precio = 0D;
		
		precio += this.precioUnitario * this.cantidad;
		
		return precio;
	}
	
	
	
	
	
	
}

package ar.edu.unlam.dominio;

public class ProductoNoPerecedero extends Producto {

	private static final Double RECARGO=0.07D;
	
	
	public ProductoNoPerecedero(String nombre, Integer cantidad, Double precioUnitario) {
		super(nombre, cantidad, precioUnitario);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public Double obtenerPrecio() {
		
		Double precioFinal =  super.obtenerPrecio() + (super.obtenerPrecio() * RECARGO);
		
		
		return precioFinal;
	}

}

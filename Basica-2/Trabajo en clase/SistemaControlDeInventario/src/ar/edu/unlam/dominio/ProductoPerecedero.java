package ar.edu.unlam.dominio;

public class ProductoPerecedero  extends Producto{

	private static final Double RECARGO=0.05D;
	
	
	public ProductoPerecedero(String nombre, Integer cantidad, Double precioUnitario) {
		super(nombre, cantidad, precioUnitario);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Double obtenerPrecio() {
		Double precioSinDescuento = super.obtenerPrecio();
		Double precioFinal =   precioSinDescuento + (precioSinDescuento * RECARGO);
		
		return precioFinal;
	}


	
}

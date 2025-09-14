package ar.edu.unlam.dominio;

public class ProductoAlimenticio extends Producto {

	private  Integer valorFijo;
	
	public ProductoAlimenticio(String nombre, Double precio, String descripcion) {
		super(nombre, precio, descripcion);
		this.valorFijo = 1000;
	}
	
	@Override
	public Double calcularPrecioFinal() {
      Double porcentajeAgregado = 0.075;
      Double montoFinal=0.0;
      
      montoFinal = getPrecio() + valorFijo+ (getPrecio() * porcentajeAgregado);
	
      return montoFinal;
		
	}
}

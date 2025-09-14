package ar.edu.unlam.dominio;

public class ProductoRopa extends Producto  {
	
	private Double comisionDelVendedor;
	
	public ProductoRopa(String nombre, Double precio, String descripcion) {
		super(nombre, precio, descripcion);
		this.comisionDelVendedor = 0.05D;
	}

	
	@Override
	public Double calcularPrecioFinal() {

		Double montoFinal=0.0;
      montoFinal = getPrecio() + (getPrecio() * this.comisionDelVendedor);
	
      return montoFinal;
		
	}
}

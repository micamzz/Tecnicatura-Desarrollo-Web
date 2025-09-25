package ar.edu.unlam.dominio;

public class Snack extends Producto {

	private Tamano tamano;
	
	public Snack(String nombre, Double precioBase,Tamano tamano,Integer stock ) {
		super(nombre, precioBase,stock);
	this.tamano = tamano;
	}

	@Override
	public Double calcularPrecioFinal() {
	
		Double  montoFinal = super.getPrecioBase() * (1 + tamano.getDescuento());

return montoFinal;

}
}
package ar.edu.unlam.dominio;

public class Bebida extends Producto {

	private Contenedor contenido;
	
	public Bebida(String nombre, Double precioBase, Contenedor contenido ,Integer stock) {
		super(nombre, precioBase, stock);
		this.contenido = contenido;
	}

	@Override
	public Double calcularPrecioFinal() {
		Double montoFinal = super.getPrecioBase() * (1 + this.contenido.getDescuento());
		return montoFinal;
	}

}

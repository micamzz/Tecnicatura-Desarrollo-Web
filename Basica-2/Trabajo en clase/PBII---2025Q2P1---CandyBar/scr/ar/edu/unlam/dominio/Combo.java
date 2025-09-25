package ar.edu.unlam.dominio;

public class Combo extends Producto {

	private Snack snack;
	private Bebida bebida;
	private Double descuento;
	
	
	public Combo(String nombre,Snack snack, Bebida bebida,Double descuento, Integer stock) {
		super(nombre,  0.0, stock);
		this.snack = snack;
		this.bebida = bebida;
		this.descuento = descuento;
	}


	@Override
	public Double calcularPrecioFinal() {
		
		Double precioSnack = snack.calcularPrecioFinal();
		Double precioBebida = bebida.calcularPrecioFinal();
	
		
		Double montoTotal = super.getPrecioBase()  + precioSnack + precioBebida;
		
		return montoTotal * (1-descuento);
	}

}

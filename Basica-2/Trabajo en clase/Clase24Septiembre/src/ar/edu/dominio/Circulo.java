package ar.edu.dominio;

public class Circulo extends Figura {

	

	private Double radio;

	public Circulo(String color, Double radio){
		super(color);
		this.radio = radio;
	}


	
	public Double calcularPerimetro() {
		return 2*Math.PI * this.radio;
	}



	@Override
	public Double calcularSuperficie() {
		// TODO Auto-generated method stub
		return Math.PI*this.radio*this.radio;
	}



	@Override
	public String obtenerDescripcionFigura() {
		// TODO Auto-generated method stub
		return "Soy un circulo de color " + getColor() + " y radio : " + this.radio;
	}
	
	public String metodoY() {
		return "este es el metodo Y del ciruclo  =) ";
	}
	
	
}

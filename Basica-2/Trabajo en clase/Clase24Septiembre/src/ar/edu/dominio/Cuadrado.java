package ar.edu.dominio;

public class Cuadrado extends Figura {

	

	private Double lado;

	public Cuadrado(String color, Double lado) {
		super(color);
		this.lado = lado;
	}


	public Double getLado() {
		return lado;
	}

	public void setLado(Double lado) {
		this.lado = lado;
	}
	
	
	public Double calcularPerimetro() {
		return this.lado * 4 ;
		
	}


	@Override
	public Double calcularSuperficie() {
		return this.lado *this.lado;
	}


	@Override
	public String obtenerDescripcionFigura() {
		return "Soy un cuadrado de color : " + getColor() + " y lado " + this.lado;
	}
	
	
	public String metodoX() {
		return "este es el metodo propio del cuadrado :) ";
	}
	
	
	
	
}

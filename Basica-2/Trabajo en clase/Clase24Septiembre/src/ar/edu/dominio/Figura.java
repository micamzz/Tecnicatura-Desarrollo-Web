package ar.edu.dominio;

public abstract class Figura {

	private String color; // Atributo en comun
	
	public Figura(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
	public abstract Double calcularPerimetro();
	
	public abstract Double calcularSuperficie();
	
	public abstract String obtenerDescripcionFigura();
}

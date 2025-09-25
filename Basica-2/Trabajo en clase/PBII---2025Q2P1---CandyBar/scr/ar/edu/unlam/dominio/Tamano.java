package ar.edu.unlam.dominio;

public enum Tamano {
PEQUENO(-0.15),
MEDIANO(0.0),
GRANDE(0.20);
	
	private Double descuento;
	
	Tamano (Double descuento) {
		this.descuento = descuento;
	}

	public Double getDescuento() {
		return descuento;
	}
	
	
	
}

package ar.edu.unlam.dominio;

public enum Contenedor {
VASO (0.0), BOTELLA(0.10);
	
	private Double descuento;
	
	Contenedor (Double descuento) {
		this.descuento = descuento;
	}

	public Double getDescuento() {
		return descuento;
	}
	
}

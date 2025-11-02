package ar.edu.unlam.dominio;

public enum tipoAtril {

	CAOBA(0.05), 
	CEDRO(0.10),
	ROBLE_OSCURO(0.15);
	
	
	private Double descuento;
	
	tipoAtril(Double d){
		this.descuento = d;
	}

	public Double getDescuento() {
		return descuento;
	}

}

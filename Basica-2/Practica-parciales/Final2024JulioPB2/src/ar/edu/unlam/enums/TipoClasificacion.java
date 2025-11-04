package ar.edu.unlam.enums;

public enum TipoClasificacion {
BASICO("Basico"),
PREMIUM("Premium");
	
	String mensaje;

	private TipoClasificacion(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getClasificacion() {
		return mensaje;
	}


	
	
	
	
	
}

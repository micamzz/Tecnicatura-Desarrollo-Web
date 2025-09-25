package ar.edu.unlam.dominio;

public enum CoheficienteHabitacion {
   HABITACION_ESTANDAR (1D),
   HABITACION_DELUXE(2D);
	
	private Double precio;

	private CoheficienteHabitacion(Double precio) {
		this.precio = precio;
	}

	public Double getPrecio() {
		return precio;
	}

	
	
}

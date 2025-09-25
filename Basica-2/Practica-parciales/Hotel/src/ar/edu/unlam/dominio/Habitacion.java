package ar.edu.unlam.dominio;

public abstract class Habitacion {
 
    private CoheficienteHabitacion tipoHab;	
     private Integer cantidadMaximaDePersonas;
     private Double precio;
     
	
	public Habitacion(Integer cantidadMaxima,CoheficienteHabitacion tipoHab ) {
		this.cantidadMaximaDePersonas = cantidadMaxima;
		this.precio = 60D; // 60 la noche
		this.tipoHab = tipoHab;
		
	}
	
	
	public CoheficienteHabitacion getTipoHab() {
		return tipoHab;
	}

	
	public Double getPrecio() {
		return  this.precio * cantidadMaximaDePersonas;
	}


	public Integer getCantidadMaximaDePersonas() {
		return cantidadMaximaDePersonas;
	}

	public abstract Double calcularPrecioHabitacion();
		
}



package ar.edu.unlam.dominio;

public class HabitacionEstandar extends Habitacion {


	public HabitacionEstandar(Integer cantidadMaxima) {
		super(cantidadMaxima, CoheficienteHabitacion.HABITACION_ESTANDAR);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Double calcularPrecioHabitacion() {
		Double precio =  getTipoHab().getPrecio() * super.getPrecio();
		return precio;
	}

	

	
	
	
	
	
	
//	 Ejemplo : cantidad Precio * cantidadDePersonasMaximas * coheficiente del tipo Habitacion (
//			  1 para las standar y 2 para las de lujo).
	
	
	
	
}

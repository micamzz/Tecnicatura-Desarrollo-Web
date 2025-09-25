package ar.edu.unlam.dominio;

public class HabitacionDeluxe extends Habitacion {

	public HabitacionDeluxe(Integer cantidadMaxima) {
		super(cantidadMaxima,CoheficienteHabitacion.HABITACION_DELUXE);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Double calcularPrecioHabitacion() {
		Double precio =  getTipoHab().getPrecio() * super.getPrecio();
		return precio;
	}

}

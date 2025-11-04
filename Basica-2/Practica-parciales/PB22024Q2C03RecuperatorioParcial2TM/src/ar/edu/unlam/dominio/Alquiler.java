package ar.edu.unlam.dominio;

public class Alquiler {

	private Cliente cliente;
	private Vehiculo vehiculo;
	private Integer horasAlquiler;
	
	
	public Alquiler(Cliente cliente, Vehiculo vehiculo, Integer horasAlquiler) {
		this.cliente = cliente;
		this.vehiculo = vehiculo;
		this.horasAlquiler = horasAlquiler;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	

	
	
	
	
	
}

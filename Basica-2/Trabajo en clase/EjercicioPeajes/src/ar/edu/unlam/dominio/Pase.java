package ar.edu.unlam.dominio;

import java.time.LocalDateTime;
import java.util.Objects;

public class Pase {

	
	private Vehiculo vehiculo;
	private LocalDateTime fechaHora;
	
	public Pase(Vehiculo vehiculoNuevo, LocalDateTime fechaYHora) {
		this.vehiculo = vehiculoNuevo;
		this.fechaHora= fechaYHora;
	
	}


	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}


	@Override
	public int hashCode() {
		return Objects.hash(fechaHora, vehiculo);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pase other = (Pase) obj;
		return Objects.equals(fechaHora, other.fechaHora) && Objects.equals(vehiculo, other.vehiculo);
	}


	


	
}

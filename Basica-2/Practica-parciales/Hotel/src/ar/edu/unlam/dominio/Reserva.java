package ar.edu.unlam.dominio;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Reserva {
	
	private static Integer incremento=0;
    private Integer id=0;
	private Cliente cliente1;
	private LocalDate fechaIngreso;
	private LocalDate fechaEgreso;
	private Integer nroHabitacion;
	private Set<Habitacion> habitacion;

	public Reserva(Cliente cliente1, LocalDate fechaIngreso, Integer nroHabitacion) {
		this.cliente1 = cliente1;
		this.fechaIngreso = fechaIngreso;
		this.nroHabitacion = nroHabitacion;
		this.fechaEgreso = null;
		this.id = ++incremento;
		habitacion = new HashSet <> ();
	}


	public LocalDate getFechaEgreso() {
		return fechaEgreso;
	}


	public void setFechaEgreso(LocalDate fechaEgreso) {
		this.fechaEgreso = fechaEgreso;
	}


	public Integer getId() {
		return id;
	}


	public Cliente getCliente1() {
		return cliente1;
	}


	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}


	public Integer getNroHabitacion() {
		return nroHabitacion;
	}
	

	public Set<Habitacion> getHabitacion() {
		return habitacion;
	}


	public void setHabitacion(Set<Habitacion> habitacion) {
		this.habitacion = habitacion;
	}

	public void agregarHabitacion(Habitacion habitacion) {
	    this.habitacion.add(habitacion);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		return Objects.equals(id, other.id);
	}


	
	
	
	
}

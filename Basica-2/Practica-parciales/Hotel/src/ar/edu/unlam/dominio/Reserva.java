package ar.edu.unlam.dominio;

import java.time.LocalDate;
import java.util.Objects;

public class Reserva {
	
	private static Integer incremento=0;
    private Integer id=0;
	private Cliente cliente1;
	private LocalDate fechaIngreso;
	private LocalDate fechaEgreso;
	private Integer nroHabitacion;


	public Reserva(Cliente cliente1, LocalDate fechaIngreso, Integer nroHabitacion) {
		this.cliente1 = cliente1;
		this.fechaIngreso = fechaIngreso;
		this.nroHabitacion = nroHabitacion;
		this.fechaEgreso = null;
		this.id = ++incremento;
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

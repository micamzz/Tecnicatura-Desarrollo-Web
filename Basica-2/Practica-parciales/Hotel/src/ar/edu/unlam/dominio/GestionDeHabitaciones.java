package ar.edu.unlam.dominio;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GestionDeHabitaciones {

	private Set<Reserva> listadoDeReservas;
	private Set<Habitacion> listadoDeHabitaciones;

	public GestionDeHabitaciones() {
		this.listadoDeReservas = new HashSet<>();
		this.listadoDeHabitaciones = new HashSet<>();

	}

	public Boolean realizarReserva(Reserva reservaNueva) {

		for (Reserva reserva : listadoDeReservas) {
			if (reserva.getCliente1().equals(reservaNueva.getCliente1()) && reserva.getFechaEgreso() == null) {
				return false;
			}
		}

		return this.listadoDeReservas.add(reservaNueva);
	}

	public Integer cantidadDeReservasRealizadas() {
		return this.listadoDeReservas.size();
	}

	public Boolean AgregarHabitaciones(Habitacion habitacion) {
		return this.listadoDeHabitaciones.add(habitacion);
	}

	public HashSet<Reserva> buscarReservasActivas() {

		HashSet<Reserva> reservasActivas = new HashSet<>();

		for (Reserva reserva : listadoDeReservas) {
			if (reserva.getFechaEgreso() == null) {
				reservasActivas.add(reserva);
			}
		}

		return reservasActivas;
	}

	public Integer cantidadDeReservasActivas() {

		HashSet<Reserva> reservasActivas = buscarReservasActivas();
return reservasActivas.size();

		
	}

	
	
	
	public HashSet<Cliente> buscarClientesQueHicieronReserva() {

		HashSet<Cliente> clienteHistorial = new HashSet<>();

		for (Reserva reserva : listadoDeReservas) {
			clienteHistorial.add(reserva.getCliente1());

		}

		return clienteHistorial;
	}

	public Reserva obtenerReservaPorId(Integer idBuscado) {
		for (Reserva reserva : listadoDeReservas) {
			if (reserva.getId().equals(idBuscado)) {
				return reserva;
			}
		}
		return null;
	}

	public Boolean cerrarReserva(Integer idBuscado, LocalDate fechaEgreso) {
// No se puede cerrar cerrar una reserva si la fecha de salida es anterior a la
		// de entrada.

		Reserva reservaACerrar = obtenerReservaPorId(idBuscado);

		if (reservaACerrar.getFechaEgreso() == null && !fechaEgreso.isBefore(reservaACerrar.getFechaIngreso())) {
			reservaACerrar.setFechaEgreso(fechaEgreso);
			return true;
		}

		return false;
	}

	public Integer obtenerDiasDeEstadia(Integer idReserva) {
		Reserva reserva = obtenerReservaPorId(idReserva);

		if (reserva == null || reserva.getFechaEgreso() == null) {
			return 0;
		}
		LocalDate fechaIngreso = reserva.getFechaIngreso();
		LocalDate fechaEgreso = reserva.getFechaEgreso();

		Integer dias = (int) ChronoUnit.DAYS.between(fechaIngreso, fechaEgreso);
		return dias;

	}

	public Double obtenerPrecioReserva(Integer idReserva) {
		Integer dias = obtenerDiasDeEstadia(idReserva);
		Double montoFinal = 0D;

		for (Habitacion habitacion : listadoDeHabitaciones) {
			montoFinal = habitacion.getPrecio() * dias;
			return montoFinal;
		}

		return montoFinal;
	}

}
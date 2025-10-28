package ar.edu.unlam.dominio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import ar.edu.unlam.menum.Especialidad;

public class GestorDeTurnos {

	private HashSet<Paciente> listadoDePacientes;
	private HashSet<Medico> listadoDeMedicos;
	private HashSet<Reserva> listadoDeReservas;

	public GestorDeTurnos() {
		this.listadoDePacientes = new HashSet<>();
		this.listadoDeMedicos = new HashSet<>();
		this.listadoDeReservas = new HashSet<>();
	}

	public Boolean agregarPaciente(Paciente pacienteNuevo) {
		return this.listadoDePacientes.add(pacienteNuevo);

	}

	public Boolean agregarMedico(Medico medicoNuevo) {
		return this.listadoDeMedicos.add(medicoNuevo);

	}

	public Integer obtenerCantidadDeReservas() {
		return this.listadoDeReservas.size();
	}

	public Integer obtenerCantidadDeReservasPorPacientes(Paciente paciente) {
		return this.buscarReservasPorPaciente(paciente).size();
	}

	public Boolean reservarUnTurno(Reserva reservaNueva) throws TurnoFueraDeHorarioException,
			ReservaRegistradaEnMismoHorarioException, PacienteNoEncontradoEnElSistemaException {

		if (!buscarPacienteEnElSistema(reservaNueva.getPaciente())) {
			throw new PacienteNoEncontradoEnElSistemaException("El paciente no está registrado en el sistema.");
		}

		validarHoraDeLasReservas(reservaNueva);
		validarQueElPacienteNoTengaOtraReservaEnElMismoHorarioYFecha(reservaNueva);
		validarQueElMedicoNoTengaOtraReservaEnElMismoHorarioYFecha(reservaNueva);
		validarHorarioDelturno(reservaNueva.getFechaYHoraInicio());

		// paso todas las validaciones, agregamos la nueva reserva.
		return this.listadoDeReservas.add(reservaNueva);
	}

	public Boolean buscarPacienteEnElSistema(Paciente paciente) {

		return this.listadoDePacientes.contains(paciente);
	}

	// Para que los turnos no puedan ser antes de las 8 ni después de las 17 hs
	public Boolean validarHoraDeLasReservas(Reserva reservaNueva) throws TurnoFueraDeHorarioException {
		LocalDateTime fechaYHora = reservaNueva.getFechaYHoraInicio();
		Integer hora = fechaYHora.getHour();

		if (hora < 8 || hora > 17) {
			throw new TurnoFueraDeHorarioException("Turno Fuera del horario establecido.");
		}
		return true;

	}

//	 Para que el turno dure 15 minutos
	public Boolean validarHorarioDelturno(LocalDateTime fechaYHora) {

		for (Reserva reserva : listadoDeReservas) {
			if (reserva.getFechaYHoraInicio().toLocalDate().equals(fechaYHora.toLocalDate())) {
				if (fechaYHora.isBefore(reserva.getFechaYHoraFinal())) {
					return false;
				}
			}
			// SI LA HORA NUEVA ES ANTERIOR A LA HORA DE FINALIZACION DEL TURNO DEVUELVE
			// FALSE..
			// TOLOCALDATE SIRVE PARA QUE TOME SOLO EL LOCALDATE (LA FECHA)
			// ENTONCES COMPARA PARA Q VALIDE SI ES EL MISMO DIA
		}
		return true;
	}

	public Boolean validarQueElPacienteNoTengaOtraReservaEnElMismoHorarioYFecha(Reserva reservaNueva)
			throws ReservaRegistradaEnMismoHorarioException {

		for (Reserva reserva : listadoDeReservas) {
			boolean mismoPaciente = reserva.getPaciente().equals(reservaNueva.getPaciente());
			boolean mismaFechaYHora = reserva.getFechaYHoraInicio().equals(reservaNueva.getFechaYHoraInicio());

			if (mismoPaciente && mismaFechaYHora) {
				throw new ReservaRegistradaEnMismoHorarioException(
						"El paciente ya tiene una reserva en esa fecha y horario");
			}
		}
		return true;
	}

	public Boolean validarQueElMedicoNoTengaOtraReservaEnElMismoHorarioYFecha(Reserva reservaNueva)
			throws ReservaRegistradaEnMismoHorarioException {

		for (Reserva reserva : listadoDeReservas) {
			if (reserva.getMedico().equals(reservaNueva.getMedico())
					&& reserva.getFechaYHoraInicio().equals(reservaNueva.getFechaYHoraInicio())
					&& !reserva.getPaciente().equals(reservaNueva.getPaciente())) {
				throw new ReservaRegistradaEnMismoHorarioException(
						"El medico ya tiene una reserva en esa fecha y horario");
			}
		}

		return true;
	}

	// Para cancelar el turno por reserva
	public Boolean cancelarReserva(Reserva reserva) throws ReservaNoEncontradaException {
		Reserva reservaACancelar = buscarReservaPorId(reserva.getId());

		if (reservaACancelar == null)
			throw new ReservaNoEncontradaException("Reserva no encontrada");

		return this.listadoDeReservas.remove(reservaACancelar);

	}

	// Cancelar turno por paciente, fecha y hora.
	public Boolean cancelarReserva(Paciente paciente, LocalDateTime fechaYHora) {
		Boolean seCancelo = false;
		Reserva reservaACancelar = buscarReservaPorPaciente(paciente, fechaYHora);

		if (reservaACancelar != null) {
			this.listadoDeReservas.remove(reservaACancelar);
			seCancelo = true;
		}
		return seCancelo;
	}

	// Buscar reserva por paciente
	public Reserva buscarReservaPorPaciente(Paciente paciente, LocalDateTime fechaYHora) {
		for (Reserva reservas : listadoDeReservas) {
			if (reservas.getPaciente().equals(paciente) && reservas.getFechaYHoraInicio().equals(fechaYHora)) {
				return reservas;
			}
		}
		return null;
	}

	// Buscar reserva por ID.
	public Reserva buscarReservaPorId(Integer id) {
		for (Reserva reservas : listadoDeReservas) {
			if (reservas.getId().equals(id))
				return reservas;
		}
		return null;
	}

	// buscar Paciente pot Dni
	public Paciente buscarPacientePorDni(Integer dni) {
		for (Paciente paciente : listadoDePacientes) {
			if (paciente.getDni().equals(dni)) {
				return paciente;
			}
		}
		return null;
	}

	// Buscar listado de reservas por paciente
	public HashSet<Reserva> buscarReservasPorPaciente(Paciente paciente) {

		HashSet<Reserva> reservasEncontradas = new HashSet<>();

		for (Reserva reservas : listadoDeReservas) {
			if (reservas.getPaciente().equals(paciente)) {
				reservasEncontradas.add(reservas);
			}
		}

		return reservasEncontradas;

	}

	// Encontrar las reservas de un cliente del mes ingresado

	public HashSet<Reserva> reservasDeUnClientePorMes(Paciente paciente, LocalDateTime fecha) {
		HashSet<Reserva> listaReservasMes = new HashSet();

		for (Reserva reservas : listadoDeReservas) {
			if (reservas.getPaciente().equals(paciente) && reservas.getFechaYHoraInicio().getYear() == fecha.getYear()
					&& reservas.getFechaYHoraInicio().getMonth() == fecha.getMonth()) {
				listaReservasMes.add(reservas);
			}
		}
		return listaReservasMes;
	}

	public HashSet<Medico> buscarMedicosPorEspecialidad(Especialidad tipoEspecialidad) {
		HashSet<Medico> medicosEncontrados = new HashSet<>();

		for (Medico medico : listadoDeMedicos) {
			if (medico.getTipoEspecialidad().equals(tipoEspecialidad)) {
				medicosEncontrados.add(medico);
			}

		}
		return medicosEncontrados;
	}

	public TreeSet<Paciente> ordenarPacientesPorApellidos() {

		TreeSet<Paciente> pacientesOrdenados = new TreeSet<>(new PacientesOrdenadosPorApellido());

		pacientesOrdenados.addAll(listadoDePacientes);
		return pacientesOrdenados;
	}

	public TreeSet<Medico> ordernarMedicosPorApellido() {

		TreeSet<Medico> medicosOrdenados = new TreeSet<>(new MedicosOrdenadosPorapellido());

		medicosOrdenados.addAll(listadoDeMedicos);
		return medicosOrdenados;
	}

	public Map<Paciente, List<Reserva>> obtenerReporteDeReservasPorPaciente() {

		Map<Paciente, List<Reserva>> reporte = new HashMap<>();

		for (Reserva reserva : listadoDeReservas) {

			Paciente paciente1 = reserva.getPaciente();

			if (reporte.containsKey(paciente1)) {
				List<Reserva> reservasDelPaciente = reporte.get(paciente1);
				reservasDelPaciente.add(reserva);

			} else {

				List<Reserva> nuevaLista = new ArrayList<>();
				nuevaLista.add(reserva);
				reporte.put(paciente1, nuevaLista);
			}
		}

		return reporte;

	}

	public Map<Medico, List<Reserva>> obteneReporteDeReservasPorMedico() {

		Map<Medico, List<Reserva>> reporte = new HashMap<>();

		for (Reserva reserva : listadoDeReservas) {
			Medico medico1 = reserva.getMedico();

			if (!reporte.containsKey(medico1)) {
				List<Reserva> nuevaLista = new ArrayList<>();
				nuevaLista.add(reserva);
				reporte.put(medico1, nuevaLista);
			} else {
				List<Reserva> reservasDelMedico = reporte.get(medico1);
				reservasDelMedico.add(reserva);
			}
		}

		return reporte;
	}
}

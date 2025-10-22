package ar.edu.unlam.dominio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class GestionDeClinica {

	private TreeSet<Medico> listadoMedico;
	private Set<Paciente> listadoPaciente;
	private Set<Turno> listadoDeTurno;

	public GestionDeClinica() {

		listadoMedico = new TreeSet<>();
		listadoPaciente = new HashSet<>();
		listadoDeTurno = new HashSet<>();
	}

	public Boolean agregarMedicosAlListado(Medico medico1) {

		return this.listadoMedico.add(medico1);
	}

	
	public TreeSet<Medico> getListadoMedico() {
		return this.listadoMedico;
	}

	
	public Boolean agregarPaciente(Paciente paciente) {
		return this.listadoPaciente.add(paciente);
	}

	
	public Integer obtenerTurno(Integer dniPaciente1, Integer dnimedico, LocalDateTime fechaYhora)
			throws MedicoNoEncontradoExcepcion {

		Paciente nuevoPaciente = buscarPacientePorDni(dniPaciente1);
		Medico nuevoMedico = buscarMedicoPorDni(dnimedico);

		Turno nuevoTurno = new Turno(nuevoPaciente, nuevoMedico, fechaYhora);
		this.listadoDeTurno.add(nuevoTurno);

		return nuevoTurno.getId();

	}

	public Paciente buscarPacientePorDni(Integer dni) {

		for (Paciente paciente : listadoPaciente) {
			if (paciente.getDni().equals(dni)) {
				return paciente;
			}
		}
		return null;
	}

	public Medico buscarMedicoPorDni(Integer dni) throws MedicoNoEncontradoExcepcion {

		for (Medico medico1 : listadoMedico) {
			if (medico1.getDni().equals(dni)) {
				return medico1;
			}
		}

		throw new MedicoNoEncontradoExcepcion("El medico no se encuentra en el sistema");
	}

	
	public Integer getCantidadDeTurnos() {
		return this.listadoDeTurno.size();
	}

	
	public HashMap<Paciente, List<Turno>> obtenerReporteDeTurnoDeLosPacientes() {

		HashMap<Paciente, List<Turno>> reporte = new HashMap<>();

		for (Turno turno : listadoDeTurno) {
			Paciente paciente = turno.getPaciente();

			/*
			 * Recorre la lista de turnos Crea un nuevo paciente obtenido de la lista de
			 * turnos . PREGUNTA SI EL SI EL REPORTE NO CONTIENE AL PACIENTE (KEY) CREA UNA
			 * NUEVA LIST PARA AGREGARLO - A LA LISTA Y AGREGARLO TAMBIEN AL REPORTE CON UN
			 * PUT. PARA LA PROXIMA VEZ SI ESE PACIENTE(KEY) YA ESTA PREGUNTO UN ELSE EL
			 * REPORTE. OBTENERN VALOR( LISTA ) Y AGREGARLO A ESA LISTA.
			 */
			if (!reporte.containsKey(paciente)) {
				List<Turno> listado = new ArrayList<>();
				listado.add(turno);
				reporte.put(paciente, listado); // PARA AGREGAR AL MAPA.
			} else {

				reporte.get(paciente).add(turno);

			}

		}

		return reporte;
	}

}

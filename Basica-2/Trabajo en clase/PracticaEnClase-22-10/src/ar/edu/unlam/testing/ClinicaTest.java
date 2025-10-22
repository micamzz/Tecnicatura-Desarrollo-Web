package ar.edu.unlam.testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;
import java.util.Map;
import ar.edu.unlam.dominio.*;


public class ClinicaTest {

	private GestionDeClinica hospital1;

	@Before

	public void inicializacion() {

		hospital1 = new GestionDeClinica();
	}

	@Test
	public void dadoQueExisteUnaClinicaAlInsertarTresMedicosVerificarQueEstenOrdenadosPorDni() {

		Medico medico1 = new Medico(38662441, "Micaela", "Mazza");
		Medico medico2 = new Medico(36225889, "Lara", "Daniela");
		Medico medico3 = new Medico(16542819, "Maria", "Lopez");

		hospital1.agregarMedicosAlListado(medico1);
		hospital1.agregarMedicosAlListado(medico2);
		hospital1.agregarMedicosAlListado(medico3);

		TreeSet<Medico> medicosOrdenados = hospital1.getListadoMedico();

		assertEquals(16542819, medicosOrdenados.first().getDni(), 0.01);
		assertEquals(38662441, medicosOrdenados.last().getDni(), 0.01);

	}

	@Test
	public void dadoQueExisteUnSistemaDeTurnosSeQuiereReservarUnTurnoYSeObtieneUnResultadoExitoso()
			throws MedicoNoEncontradoExcepcion {
		
		Medico medico1 = new Medico(38662441, "Micaela", "Mazza");

		Paciente paciente1 = new Paciente(111111, "carlos", "saul");

		hospital1.agregarMedicosAlListado(medico1);
		hospital1.agregarPaciente(paciente1);

		LocalDateTime fechaHoraTurno = LocalDateTime.of(2025, 10, 22, 10, 30);

//		hospital1.obtenerTurno(paciente1.getDni(), medico1.getDni(), fechaHoraTurno);

		Integer resultadoEsperado = 0;
        Integer resultadoObtenido = hospital1.obtenerTurno(paciente1.getDni(), medico1.getDni(), fechaHoraTurno);

		assertEquals(resultadoEsperado, resultadoObtenido);
		assertEquals(resultadoEsperado, resultadoObtenido);
		assertEquals(resultadoEsperado, resultadoObtenido);

	}

	@Test(expected = MedicoNoEncontradoExcepcion.class)
	public void dadoQueSeQuiereRegistrarUnTurnoConUnMedicoQueNoEstaRegistradoSeObtieneUnaExcepcion()
			throws MedicoNoEncontradoExcepcion {

		Medico medico1 = new Medico(38662441, "Micaela", "Mazza");

		Paciente paciente1 = new Paciente(111111, "carlos", "saul");
		hospital1.agregarPaciente(paciente1);

//		hospital1.agregarMedicosAlListado(medico1);

		Integer DniMedicoNoExistente = 3333;

		LocalDateTime fechaHoraTurno = LocalDateTime.of(2025, 10, 22, 10, 30);
		hospital1.obtenerTurno(paciente1.getDni(), DniMedicoNoExistente, fechaHoraTurno);

	}

	@Test
	public void dadoQueExisteUnaClinicaAlInsertarTresMedicas() throws MedicoNoEncontradoExcepcion {

		Medico medico1 = new Medico(38662441, "Micaela", "Mazza");
		Medico medico2 = new Medico(36225889, "Lara", "Daniela");
		Medico medico3 = new Medico(16542819, "Maria", "Lopez");

		Paciente paciente1 = new Paciente(111111, "pedro", "martinez");
		Paciente paciente2 = new Paciente(222222, "carlos", "bianchi");
		Paciente paciente3 = new Paciente(333333, "juan", "roman");

		hospital1.agregarMedicosAlListado(medico1);
		hospital1.agregarMedicosAlListado(medico2);
		hospital1.agregarMedicosAlListado(medico3);
		hospital1.agregarPaciente(paciente1);
		hospital1.agregarPaciente(paciente2);
		hospital1.agregarPaciente(paciente3); // SIN TURNO.

//      TURNOS DEL PRIMER PACIENTE  - TOTAL 3 
		LocalDateTime fechaHoraTurno1 = LocalDateTime.of(2025, 10, 22, 10, 30);
		LocalDateTime fechaHoraTurno2 = LocalDateTime.of(2025, 10, 23, 11, 30);
		LocalDateTime fechaHoraTurno3 = LocalDateTime.of(2025, 10, 24, 10, 30);
		hospital1.obtenerTurno(paciente1.getDni(), medico2.getDni(), fechaHoraTurno1);
		hospital1.obtenerTurno(paciente1.getDni(), medico3.getDni(), fechaHoraTurno2);
		hospital1.obtenerTurno(paciente1.getDni(), medico2.getDni(), fechaHoraTurno3);

		// TURNOS DEL SEGUNDO PACIENTE - TOTAL 2
		LocalDateTime fechaHoraTurno4 = LocalDateTime.of(2025, 10, 25, 17, 30);
		LocalDateTime fechaHoraTurno5 = LocalDateTime.of(2025, 10, 25, 12, 30);
		hospital1.obtenerTurno(paciente2.getDni(), medico2.getDni(), fechaHoraTurno4);
		hospital1.obtenerTurno(paciente2.getDni(), medico3.getDni(), fechaHoraTurno5);

		HashMap<Paciente, List<Turno>> reporte = hospital1.obtenerReporteDeTurnoDeLosPacientes();

		// assertTrue() para que reporte contenga la KEY PACIENTE 1

		// CONTAINSKEY --> VERIFICA SI ESE MAP (REPORTE) TIENE UNA KEY QUE SEA IGUAL
		// AL OBJETO QUE SE PASA COMO PARAMETRO.
		assertTrue(reporte.containsKey(paciente1));
		assertTrue(reporte.containsKey(paciente2));

		assertEquals(3, reporte.get(paciente1).size());
		assertEquals(2, reporte.get(paciente2).size());

		// COMO EL PACIENTE 3 NO TIENEN NINGUN TURNO SE USA assertFalse();
		assertFalse(reporte.containsKey(paciente3));

		// RECORRER UN MAPA EJEMPLO
		// el Entry representa una pareja (clave-valor) CONJUNTO CLAVE-VALOR.
		// Dentro de este Entry podes acceder a la clave y al valor.

		// Cambiar lo que esta en violeta
		// key por paciente , val por turno

//		for (Map.Entry<keyType, valType> entry : map.entrySet()) {
//			keyType key = entry.getKey();
//			valType val = entry.getValue();
//			
//		}

		// TIPO DE DATO NOMBRE QUE LE DOY : COLECCION QUE ESTOY LEYENDO
		for (Map.Entry<Paciente, List<Turno>> registroDeTurnos : reporte.entrySet()) {
			Paciente paciente = registroDeTurnos.getKey(); // obtengo la clave del mapa
			List<Turno> turnos = registroDeTurnos.getValue(); // obtengo el valor del mapa (lista de turnos)
			}
		}
	}




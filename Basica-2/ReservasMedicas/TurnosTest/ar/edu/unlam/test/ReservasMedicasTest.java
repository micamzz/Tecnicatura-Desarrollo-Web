package ar.edu.unlam.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.dominio.GestorDeTurnos;
import ar.edu.unlam.dominio.Medico;
import ar.edu.unlam.dominio.Paciente;
import ar.edu.unlam.dominio.PacienteNoEncontradoEnElSistemaException;
import ar.edu.unlam.dominio.Reserva;
import ar.edu.unlam.dominio.ReservaNoEncontradaException;
import ar.edu.unlam.dominio.ReservaRegistradaEnMismoHorarioException;
import ar.edu.unlam.dominio.TipoDePlanMedico;
import ar.edu.unlam.dominio.TurnoFueraDeHorarioException;
import ar.edu.unlam.menum.Especialidad;

public class ReservasMedicasTest {

	private GestorDeTurnos gestor;
	
	Paciente paciente1;
	Paciente paciente2;
	Medico medico1;
	Medico medico2;
	
	@Before
	public void inicializacion() {
		gestor  =new GestorDeTurnos();
		
	 paciente1 = new Paciente("Maria", "Lopez", 11111111,30, TipoDePlanMedico.BASICO);
	 paciente2  = new Paciente("Carlos", "Beder", 22222222,60, TipoDePlanMedico.PREMIUN);
	 
	  medico1 = new Medico("Carla", "Gonzales", 333333333,60,Especialidad.DERMATOLOGIA);
	 medico2 = new Medico("Agustin", "Martino", 444444444, 63, Especialidad.TRAUMATOLOGIA);
		
	}
	
	
	@Test
	public void dadoQueExisteUnGestorDeReservasSeDeseaAgregarDosPacientesYSeObtieneUnResultadoExitoso() {
		Boolean seAgrego1 = gestor.agregarPaciente(paciente1);
		Boolean seAgrego2 = gestor.agregarPaciente(paciente2);
		
		assertTrue(seAgrego1);
		assertTrue(seAgrego2);
		
	}
	
	@Test
	public void dadoQueExisteUnGestorDeReservasSeDeseaAgregarDosPacientesConElMismoApellidoYSeObtieneUnResultadoFalso() {
		
		Paciente pacienteDniRepetido = new Paciente("Carlos", "Beder", 11111111,60, TipoDePlanMedico.PREMIUN);
		
		Boolean seAgrego1 = gestor.agregarPaciente(paciente1);
		Boolean seAgrego2 = gestor.agregarPaciente(pacienteDniRepetido);
		
		assertTrue(seAgrego1);
		assertFalse(seAgrego2);
		
	}
	@Test
	public void dadoQueExisteUnGestorDeReservasSeDeseaAgregarDosMedicosYSeObtieneUnResultadoExitoso() {
			
	Boolean seAgrego1 = gestor.agregarMedico(medico1);
	Boolean seAgrego2 = gestor.agregarMedico(medico2);
		
		assertTrue(seAgrego1);
		assertTrue(seAgrego2);
		
	}
	
	@Test
	public void dadoQueExisteUnGestorDeReservasSeDeseaAgregarDosMedicosConElMismoDniYSeObtieneUnResultadoFalso() {
		
    Medico medico3 = new Medico("Lucas", "Martino", 333333333, 48, Especialidad.CARDIOLOGIA);
		
	Boolean seAgrego1 = gestor.agregarMedico(medico1);
	Boolean seAgrego2 = gestor.agregarMedico(medico3);
		
		assertTrue(seAgrego1);
		assertFalse(seAgrego2);	
	}
	
	
	@Test
	public void dadoQueExisteUnMedicoYSeQuiereRegistrarComoPacienteSeObtieneUnResultadoExitoso() {
		
		// "Agustin", "Martino", 444444444, 63, Especialidad.TRAUMATOLOGIA  MEDICO 2
		Paciente pacienteMedico = new Paciente("Agustin", "Martino", 444444444, 63, TipoDePlanMedico.PREMIUN);
		
		Boolean seAgrego1 = gestor.agregarMedico(medico2);
		Boolean seAgrego2 = gestor.agregarPaciente(pacienteMedico);
		
		assertTrue(seAgrego1);
		assertTrue(seAgrego2);
			
	}
	
	@Test
	public void dadoQueExisteUnPacienteYQuiereReservarUnTurnoMedicoSeObtieneUnResultadoExitoso() throws TurnoFueraDeHorarioException, ReservaRegistradaEnMismoHorarioException, PacienteNoEncontradoEnElSistemaException {

		gestor.agregarMedico(medico1);
		gestor.agregarPaciente(paciente1);
	
		LocalDateTime fecha = LocalDateTime.of(2028, 01, 03, 10, 30);
		Reserva reservaNueva = new Reserva(paciente1, medico1,fecha,paciente1.getTipoDePlan().getPrecioCopago());
		Boolean reservaDeTurno = gestor.reservarUnTurno(reservaNueva);
		
		assertTrue(reservaDeTurno);
	}
	
	
	@Test (expected = PacienteNoEncontradoEnElSistemaException.class)
	public void dadoQueNoExisteUnClienteRegistradoEnElSistemaYQuiereReservarUnTurnoYObtieneResultadoFalso() throws TurnoFueraDeHorarioException, ReservaRegistradaEnMismoHorarioException, PacienteNoEncontradoEnElSistemaException {

		
		gestor.agregarMedico(medico1);
	
		// NO SE REGISTRA A EL PACIENTE EN EL SISTEMA
		LocalDateTime fecha = LocalDateTime.of(2028, 01, 05, 10, 30);
		
		Reserva reservaNueva = new Reserva(paciente1, medico1,fecha,paciente1.getTipoDePlan().getPrecioCopago());
		Boolean seReservo = gestor.reservarUnTurno(reservaNueva);
		
	}
	
	@Test (expected = TurnoFueraDeHorarioException.class)
	public void dadoQueExisteUnPacienteQuiereReservarUnTurnoFueraDelHorarioEstablecidoSeObtieneUnResultadoFalso() throws TurnoFueraDeHorarioException, ReservaRegistradaEnMismoHorarioException, PacienteNoEncontradoEnElSistemaException {
	
		gestor.agregarPaciente(paciente1);
		gestor.agregarMedico(medico1);
	
		LocalDateTime fecha = LocalDateTime.of(2028, 01, 03, 07, 00); // 07 DE LA MAÑANA.
		Reserva reservaNueva = new Reserva(paciente1, medico1,fecha,paciente1.getTipoDePlan().getPrecioCopago());
		Boolean reservaDeTurno = gestor.reservarUnTurno(reservaNueva);
		
	
	}
	
	@Test(expected = ReservaRegistradaEnMismoHorarioException.class)
	public void dadoQueUnPacienteYaTieneUnaReservaEnElMismoHorario_NoPuedeReservarOtra()
	        throws TurnoFueraDeHorarioException, ReservaRegistradaEnMismoHorarioException, PacienteNoEncontradoEnElSistemaException {


	    gestor.agregarPaciente(paciente1);
	    gestor.agregarMedico(medico2);

	    LocalDateTime fecha = LocalDateTime.of(2025, 10, 15, 10, 0);
	    Reserva reserva1 = new Reserva(paciente1, medico2, fecha, paciente1.getTipoDePlan().getPrecioCopago());
	    Reserva reserva2 = new Reserva(paciente1, medico2, fecha, paciente1.getTipoDePlan().getPrecioCopago());

	    gestor.reservarUnTurno(reserva1);
	    gestor.reservarUnTurno(reserva2); 
	}
	
	@Test(expected = ReservaRegistradaEnMismoHorarioException.class)
	public void dadoQueUnMedicoYaTieneUnaReservaEnElMismoHorario_NoPuedeAtenderOtroPaciente()
	        throws TurnoFueraDeHorarioException, ReservaRegistradaEnMismoHorarioException, PacienteNoEncontradoEnElSistemaException {

	    Medico medico3 = new Medico("Laura", "Diaz", 44332211, 50, Especialidad.CARDIOLOGIA);


	    gestor.agregarMedico(medico3);
	    gestor.agregarPaciente(paciente1);
	    gestor.agregarPaciente(paciente2);

	    LocalDateTime fecha = LocalDateTime.of(2025, 10, 20, 9, 0);
	    Reserva reserva1 = new Reserva(paciente1, medico3, fecha, paciente1.getTipoDePlan().getPrecioCopago());
	    Reserva reserva2 = new Reserva(paciente2, medico3, fecha, paciente2.getTipoDePlan().getPrecioCopago());
	    
	    gestor.reservarUnTurno(reserva1);
	    gestor.reservarUnTurno(reserva2); 
	}
	
	@Test(expected = ReservaNoEncontradaException.class)
	public void dadoQueSeIntentaCancelarUnaReservaQueNoExiste_LanzaExcepcion() throws ReservaNoEncontradaException {
   LocalDateTime fecha = LocalDateTime.of(2025, 10, 20, 9, 0);
		    
		    Reserva reservaInexistente = new Reserva(paciente1, medico2, fecha, paciente1.getTipoDePlan().getPrecioCopago());
	    gestor.cancelarReserva(reservaInexistente);
	}
	@Test
	public void ObtenerUnaListaDePacientesOrdenadosAlfabeticamentePorApellido() {

		Paciente paciente1 = new Paciente("Maria", "Lopez", 12345689, 30, TipoDePlanMedico.BASICO);
		Paciente paciente2 = new Paciente("Carlos", "Beder", 77777, 60, TipoDePlanMedico.PREMIUN); // Primer Paciente
		Paciente paciente3 = new Paciente("Mica", "Sarmiento", 85, 00001, TipoDePlanMedico.NO_POSEE); // Ultimo Paciente
		Paciente paciente4 = new Paciente("Mati", "Federal", 12, 024347, TipoDePlanMedico.PLUS);
		Paciente paciente5 = new Paciente("Tomas", "Mazza", 67, 6546546, TipoDePlanMedico.BASICO);
		Paciente paciente6 = new Paciente("Ivan", "PalestinaFree", 120, 23523623, TipoDePlanMedico.NO_POSEE);
		Paciente paciente7 = new Paciente("Marcos", "Castellano", 12330, 235, TipoDePlanMedico.PREMIUN);

		gestor.agregarPaciente(paciente1);
		gestor.agregarPaciente(paciente2);
		gestor.agregarPaciente(paciente3);
		gestor.agregarPaciente(paciente4);
		gestor.agregarPaciente(paciente5);
		gestor.agregarPaciente(paciente6);
		gestor.agregarPaciente(paciente7);

		TreeSet<Paciente> pacientesOrdenados = gestor.ordenarPacientesPorApellidos();

		assertEquals(7, pacientesOrdenados.size());
		assertEquals(paciente2.getApellido(), pacientesOrdenados.first().getApellido());
		assertEquals(paciente3.getApellido(), pacientesOrdenados.last().getApellido());
		
	}
	
	@Test
	public void ObtenerUnaListaDeMedicosOrdenadosAlfabeticamentePorApellido() {
		
	        Medico medico3 = new Medico("Carla", "Gonzales", 7485384, 60, Especialidad.DERMATOLOGIA);
		    Medico medico4 = new Medico("Joaquin", "Arce", 9348721, 45, Especialidad.CARDIOLOGIA);
		    Medico medico5 = new Medico("Lucia", "Benitez", 12837465, 38, Especialidad.CLINICA);
		    Medico medico6 = new Medico("Martin", "Dominguez", 4523189, 50, Especialidad.PEDIATRIA);
		    Medico medico7 = new Medico("Sofia", "Zamora", 10123578, 41, Especialidad.TRAUMATOLOGIA);
		    Medico medico8 = new Medico("Ezequiel", "Campos", 5647382, 55, Especialidad.CARDIOLOGIA);
		    Medico medico9 = new Medico("Natalia", "Farias", 8765432, 47, Especialidad.CLINICA);

		    gestor.agregarMedico(medico3);
		    gestor.agregarMedico(medico4);
		    gestor.agregarMedico(medico5);
		    gestor.agregarMedico(medico6);
		    gestor.agregarMedico(medico7);
		    gestor.agregarMedico(medico8);
		    gestor.agregarMedico(medico9);
		    
		    TreeSet <Medico> medicosOrdenados = gestor.ordernarMedicosPorApellido();
		    
		    assertEquals(7, medicosOrdenados.size());
		    assertEquals("Arce", medicosOrdenados.first().getApellido());
		    assertEquals("Zamora", medicosOrdenados.last().getApellido());
		    
	}
	
	@Test
	public void dadoQueExistenReservasDeVariosPacientesSeGeneraUnReporteAgrupadoPorPaciente() throws TurnoFueraDeHorarioException, ReservaRegistradaEnMismoHorarioException, PacienteNoEncontradoEnElSistemaException {
	    
	    Paciente paciente1 = new Paciente("Maria", "Lopez", 12345689, 30, TipoDePlanMedico.BASICO);
	    Paciente paciente2 = new Paciente("Carlos", "Beder", 9876543, 60, TipoDePlanMedico.PREMIUN);

	    Medico medico = new Medico("Carla", "Gonzales", 7485384, 45, Especialidad.CLINICA);

	    LocalDateTime fecha1 = LocalDateTime.of(2025, 10, 10, 9, 0);
	    LocalDateTime fecha2 = LocalDateTime.of(2025, 10, 11, 10, 0);
	    LocalDateTime fecha3 = LocalDateTime.of(2025, 10, 12, 11, 0);


	    Reserva reserva1 = new Reserva(paciente1, medico, fecha1, paciente1.getTipoDePlan().getPrecioCopago());
	    Reserva reserva2 = new Reserva(paciente2, medico, fecha3, paciente2.getTipoDePlan().getPrecioCopago());
	    Reserva reserva3 = new Reserva(paciente1, medico, fecha2, paciente1.getTipoDePlan().getPrecioCopago());
	  
	    
	    gestor.agregarPaciente(paciente1);
	    gestor.agregarPaciente(paciente2);
	    gestor.agregarMedico(medico);
	    gestor.reservarUnTurno(reserva1);
	    gestor.reservarUnTurno(reserva2);
	    gestor.reservarUnTurno(reserva3);

	 
	    Map<Paciente, List<Reserva>> reporte = gestor.obtenerReporteDeReservasPorPaciente();

	    assertEquals(2, reporte.get(paciente1).size());
	    assertEquals(1, reporte.get(paciente2).size());
	    assertTrue(reporte.get(paciente1).contains(reserva1));
	    assertTrue(reporte.get(paciente1).contains(reserva3));
	    assertTrue(reporte.get(paciente2).contains(reserva2));
	}
	
}






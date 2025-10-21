package ar.edu.unlam.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.dominio.*;

public class SistemaReservaTest {

	private Cliente cliente1;
	private Cliente cliente2;
	private GestionDeHabitaciones hilton;
	private Reserva reserva1;
	private LocalDate fechaIngreso;
	private Integer nroHabitacion;
	private CoheficienteHabitacion tipo;
	private Habitacion habitacion1;

	@Before
	public void inicializacion() {
		cliente1 = new Cliente("PEDRO");
		cliente2 = new Cliente ("Mario");
		
		hilton = new GestionDeHabitaciones();
		fechaIngreso = LocalDate.of(2025, 04, 23); // 23 de Abril del 2025
		nroHabitacion = 001;
		
		reserva1 = new Reserva(cliente1, fechaIngreso, nroHabitacion);
	
		
	    habitacion1 = new HabitacionEstandar(4);
	}


	
	
	@Test
	public void dadoQueExisteUnClienteRealizaUnaReservaYseObtieneResultadoExitoso() {
		Boolean seAgrego = hilton.realizarReserva(reserva1);
		assertTrue(seAgrego);
	}
	
	
	@Test
	public void dadoQueUnCLienteYaTieneUnaReservaVigenteQuiereRealizarYNoPuedeRealizarOtra() {
		hilton.realizarReserva(reserva1);
		
		LocalDate fechaIngreso2 = LocalDate.of(2025, 4, 29);
		
		hilton.AgregarHabitaciones(habitacion1);
		
		Reserva reserva2 = new Reserva(cliente1,fechaIngreso2,111);
		
		Boolean seAgrego2 = hilton.realizarReserva(reserva2);
		assertFalse(seAgrego2);
		
	}


	@Test
	public void dadoQueExisteUnaReservaSeBuscaPorIdYseActualizaFechaDeEgreso() {
		hilton.realizarReserva(reserva1);
		Integer idReserva =  reserva1.getId();
		LocalDate fechaEgreso = LocalDate.of(2025, 04, 26); // 3 dias después 

		Boolean seAgrego = hilton.cerrarReserva(idReserva, fechaEgreso);

		assertTrue(seAgrego);

	}

	
	@Test
	
	public void dadoQueExisteUnaReservaCerradaSeQuiereActualizarLaFechaDeCheckOutYNoSePuede() {
		hilton.realizarReserva(reserva1);
		Integer idReserva =  reserva1.getId();
		LocalDate fechaEgreso = LocalDate.of(2025, 04, 26); // 3 dias después 

		Boolean seAgrego = hilton.cerrarReserva(idReserva, fechaEgreso); //Primer cierre

		assertTrue(seAgrego);

		LocalDate fechaEgreso2 = LocalDate.of(2025, 04, 30); // 3 dias	
		
		Boolean seAgrego2 = hilton.cerrarReserva(idReserva, fechaEgreso2);
		assertFalse(seAgrego2);
	}
		
		

	@Test
	public void dadoQueExisteUnaReservaSeBuscaPorIdYSeQuiereCerrarConFechaAnteriorAlIngresoYNoSePuede() {
		hilton.realizarReserva(reserva1); // fecha INGRESO 23/04/2025
		Integer idReserva = reserva1.getId();
		LocalDate fechaEgreso = LocalDate.of(2025, 04, 10); // FECHA EGRESO ANTERIOR. 

		Boolean seAgrego = hilton.cerrarReserva(idReserva, fechaEgreso);
		assertFalse(seAgrego);
	}

	

	@Test
	public void dadoQueSeReservaUnaHabitacionEstandarpara1PersonaYSeObtieneDeResultadoElValorDeLaHabitacion() {
		hilton.realizarReserva(reserva1);
	
		// La habitaciones de 4 personas y es ESTANDAR
		Habitacion habitacion1 = new HabitacionEstandar(4);

		Double valorEsperado = 240D;
		Double valorObtenido = habitacion1.calcularPrecioHabitacion();

		assertEquals(valorEsperado, valorObtenido);

	}

	@Test
	public void dadoQueSeRealizaUnaReservaHabitacionDexulePorTresDiasElMontoTotalAPagarEs720() {
		hilton.realizarReserva(reserva1);
		Integer idReserva = reserva1.getId();
		LocalDate fechaEgreso = LocalDate.of(2025, 04, 26); // 3 dias
        
		Habitacion habitacion2 = new HabitacionDeluxe(4);
		reserva1.agregarHabitacion(habitacion2); // 
		hilton.AgregarHabitaciones(habitacion2); //
		
		
       hilton.cerrarReserva(idReserva, fechaEgreso); // Se cierra la reserva 1
       


		Double valorEsperado = 720D;
		Double valorObtenido = hilton.obtenerPrecioReserva(idReserva);

		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void dadoQueSeRealizaUnaReservaHabitacionEstandarPor6DiasElMontoTotalAPagarEs1440() {
		hilton.realizarReserva(reserva1);
		Integer idReserva = reserva1.getId();
		LocalDate fechaEgreso = LocalDate.of(2025, 04, 29); // 3 dias
	
		reserva1.agregarHabitacion(habitacion1);
		hilton.AgregarHabitaciones(habitacion1);
		;
       hilton.cerrarReserva(idReserva, fechaEgreso); // Se cierra la reserva
    
		
		Double valorEsperado = 1440D;
		Double valorObtenido = hilton.obtenerPrecioReserva(idReserva);

		assertEquals(valorEsperado, valorObtenido);
	}
	
   

	@Test
	public void dadoQueSeHacen6ReservasPeroSolo5activasSeVerificaQueElResultadoSea5() {
		LocalDate fecha1 = LocalDate.of(2025, 4, 23);  // 23 Abril 2025
		LocalDate fecha2 = LocalDate.of(2025, 5, 10);  // 10 Mayo 2025
		LocalDate fecha3 = LocalDate.of(2025, 6, 1);   // 1 Junio 2025
		LocalDate fecha4 = LocalDate.of(2025, 6, 15);  // 15 Junio 2025
		LocalDate fecha5 = LocalDate.of(2025, 7, 5);   // 5 Julio 2025
		LocalDate fecha6 = LocalDate.of(2025, 8, 20);  // 20 Agosto 2025
		
		Cliente cliente3 = new Cliente("Carlos");
		Cliente cliente4 = new Cliente("Ana");
		Cliente cliente5 = new Cliente("Luis");
		Cliente cliente6 = new Cliente("Sofía");

		Reserva reserva1 = new Reserva(cliente1, fecha1, 101);
		Reserva reserva2 = new Reserva(cliente2, fecha2, 102);
		Reserva reserva3 = new Reserva(cliente3, fecha3, 103);
		Reserva reserva4 = new Reserva(cliente4, fecha4, 104);
		Reserva reserva5 = new Reserva(cliente5, fecha5, 105);
		Reserva reserva6 = new Reserva(cliente6, fecha6, 106);
		
		hilton.realizarReserva(reserva1);
		hilton.realizarReserva(reserva2);
		hilton.realizarReserva(reserva3);
		hilton.realizarReserva(reserva4);
		hilton.realizarReserva(reserva5);
		hilton.realizarReserva(reserva6);
		
		
		// SE CIERRA LA RESERVA 4
		Integer idReserva =  reserva4.getId();
		LocalDate fechaEgreso = LocalDate.of(2025, 06, 21);
		hilton.cerrarReserva(idReserva, fechaEgreso);
		
		
		
		Integer valorEsperado = 5;
		Integer valorObtenido = hilton.cantidadDeReservasActivas();

		assertEquals(valorEsperado, valorObtenido);
		
	}
	
	
	@Test
	
	public void dadoQueExisten3ReservasObtenerLasReservasActivas() {
		
		LocalDate fecha1 = LocalDate.of(2025, 4, 23);  // 23 Abril 2025
		LocalDate fecha2 = LocalDate.of(2025, 5, 10);  // 10 Mayo 2025
		LocalDate fecha3 = LocalDate.of(2025, 6, 1);   // 1 Junio 2025
		
		Cliente cliente3 = new Cliente("Carlos");
	

		Reserva reserva1 = new Reserva(cliente1, fecha1, 101);
		Reserva reserva2 = new Reserva(cliente2, fecha2, 102);
		Reserva reserva3 = new Reserva(cliente3, fecha3, 103);
		

		hilton.realizarReserva(reserva1);
		hilton.realizarReserva(reserva2);
		hilton.realizarReserva(reserva3);
		
		
		HashSet <Reserva> listadoReserva = new HashSet <> ();
		
		listadoReserva.add(reserva1);
		listadoReserva.add(reserva2);
		listadoReserva.add(reserva3);
		
		assertEquals(listadoReserva, hilton.buscarTodasLasReservas());
		
		
		
		
		
		
	}
	
	
	/*
	
	 * Construir un Sistema para administrar las reservas de habitaciones. Tenemos
	 * las Habitaciones estandars y las de lujos - cada habitacion debe calcular
	 * suPrecio en funcion la cantidad de Hspedes Por el tipo habitacion. las
	 * habitaciones de lujos cuestan e doble que las estandars
	 * 
	 * Ejemplo : cantidad Precio * cantidadDePersonasMaximas * coheficiente del tipo
	 * Habitacion ( 1 para las standar y 2 para las de lujo).
	 * 
	 * - para cada reserva se debe registrar id(aoutoincremental) TitularDeLaReserva
	 * , fechaIngreso, fechaEgreso,Habitacion -para realizar la Reserva se debe
	 * pasar el cliente fecha ingreso, numeroHabitacion)
	 *  - para cerrar la reserva
	 * debe pasar idReserva y la fecha de Checkuot
	 * 

	 * obtener precio de la reserva y esteva a calcular el precio de la habitacion
	 * por la cantidad de dias que duro la reserva si la fecha de checkout es nuloo
	 * devuele null
	 * 
	 * No se puede cerrar cerrar una reserva si la fecha de salida es anterior a la
	 * de entrada. no se puede realizar una reserva para un cliente si ya tiene un
	 * reserva activa.
	 * 
	 * obtener un listado de las reservas vigentes.
	 * 
	 * obtener un listado de clientes que hicieron reservas.
	 * 
	 * vigente las q no tiene fecha de salida .
	 * 
	 */

}

package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import org.junit.Test;

public class SistemaDeReservasDeCanchasDeportivasTest {

	@Test
	public void dadoQueExisteUnGestorDeReservasDeCanchasSePuedeCrearUnaCanchaExitosamenteElMetodoDevuelveTrue() {

		GestorDeReserva gestor = new GestorDeReserva();

		Double precioBasePorHora = 20000.00;

		Cancha canchaDeFutbol = new CanchaDeFutbol5(precioBasePorHora);

		Boolean seAgrego = gestor.agregarCancha(canchaDeFutbol);

		assertTrue(seAgrego);
	}

	@Test
	public void dadoQueExistenMuchasCanchasPuedoObtenerLaQueQuieroSabiendoSoloSuId() {
		GestorDeReserva gestor = new GestorDeReserva();

		Double precioBasePorHora = 20000.00;

		Cancha canchaDeFutbol = new CanchaDeFutbol5(precioBasePorHora);
		Cancha canchaDeFutbol2 = new CanchaDeFutbol5(precioBasePorHora);
		Cancha canchaDeFutbol3 = new CanchaDeFutbol5(precioBasePorHora);

		gestor.agregarCancha(canchaDeFutbol);
		gestor.agregarCancha(canchaDeFutbol2);
		gestor.agregarCancha(canchaDeFutbol3);

		// Quiero obtener la cancha 2

		Integer idDeCanchaABuscar = canchaDeFutbol2.getIdCancha();
		Cancha canchaEncontrada = gestor.obtenerCanchaPorId(idDeCanchaABuscar);
		assertEquals(canchaDeFutbol2, canchaEncontrada);
	}

	@Test
	public void dadoQueExistenMuchasCanchasPuedoObtenerUnListadoDeLasCanchasDeFutbol5OrdenadasPorSuID() {
		GestorDeReserva gestor = new GestorDeReserva();

		Double precioBasePorHora = 20000.00;

		Cancha canchaDeFutbol1 = new CanchaDeFutbol11(precioBasePorHora);
		Cancha canchaDeFutbol2 = new CanchaDeFutbol5(100D); // 3
		Cancha canchaDeFutbol3 = new CanchaDeFutbol7(precioBasePorHora);
		Cancha canchaDeFutbol4 = new CanchaDeFutbol5(200D); // 2
		Cancha canchaDeFutbol5 = new CanchaDeFutbol5(300D); // 1

		gestor.agregarCancha(canchaDeFutbol1);
		gestor.agregarCancha(canchaDeFutbol2);
		gestor.agregarCancha(canchaDeFutbol3);
		gestor.agregarCancha(canchaDeFutbol4);
		gestor.agregarCancha(canchaDeFutbol5);

		// Tiene que devolver 3 canchas de futbol 5 ordenados en forma descendiente

		TreeSet<Cancha> canchas5Ordenadas = gestor.obtenerListadoDeCanchasDeFutbol5OrdenadasPorId();

		assertEquals(3, canchas5Ordenadas.size()); // Devuelve el tamaño del TreeSet
		assertEquals(canchaDeFutbol5.getIdCancha(), canchas5Ordenadas.first().getIdCancha()); // Compara con el primero del TreeSet
		assertEquals(canchaDeFutbol2.getIdCancha(), canchas5Ordenadas.last().getIdCancha()); // Compara con el ultimo del TreeSet

	}
	
	@Test
	public void dadoQueExistenMuchasCanchasPuedoObtenerUnListadoDeLasCanchasDeFutbol5OrdenadasPorSuPrecioHora() {
		GestorDeReserva gestor = new GestorDeReserva();

		Double precioBasePorHora = 20000.00;

		Cancha canchaDeFutbol1 = new CanchaDeFutbol11(700D); // 5
		Cancha canchaDeFutbol2 = new CanchaDeFutbol5(100D); // 2
		Cancha canchaDeFutbol3 = new CanchaDeFutbol7(50D); // 1
		Cancha canchaDeFutbol4 = new CanchaDeFutbol5(200D); // 3
		Cancha canchaDeFutbol5 = new CanchaDeFutbol5(300D); // 4

		gestor.agregarCancha(canchaDeFutbol1);
		gestor.agregarCancha(canchaDeFutbol2);
		gestor.agregarCancha(canchaDeFutbol3);
		gestor.agregarCancha(canchaDeFutbol4);
		gestor.agregarCancha(canchaDeFutbol5);

		// Tiene que devolver 5 canchas. Precio ASCENDENTE 
		TreeSet<Cancha> canchasOrdenadasPorPrecio = gestor.obtenerListadoDeCanchasPorPrecio();

		assertEquals(5, canchasOrdenadasPorPrecio.size()); // Devuelve el tamaño del TreeSet
		assertEquals(50D, canchasOrdenadasPorPrecio.first().getPrecioBasePorHora(),0.01); // Compara con el primero																						// del TreeSet
		assertEquals(700D, canchasOrdenadasPorPrecio.last().getPrecioBasePorHora(),0.01); // Compara con el ultimo del TreeSet
  
		// AL ser DOUBLE AGREGARLE EL 0.01.
	}

	@Test
	public void dadoQueExisteUnGestorDeReservasDeCanchasYUnaCanchaElClientePuedeReservarlaElMetodoDevuelveTrue() {
		GestorDeReserva gestor = new GestorDeReserva();

		Double precioBasePorHora = 20000.00;

		Cancha cancha = new CanchaDeFutbol5(precioBasePorHora);
		gestor.agregarCancha(cancha);

		LocalDateTime horaInicio = LocalDateTime.of(2025, 10, 01, 20, 00);

		String nombre = "Juan";
		Integer dni = 123;
		Cliente clienteTitular = new Cliente(nombre, dni);
		ReservaBase reserva = new ReservaBase(clienteTitular, cancha, horaInicio);

		Boolean seAgregoReserva = gestor.agregarReserva(reserva);

		assertTrue(seAgregoReserva);
	}

	@Test
	public void dadoQueExisteUnaCanchaReservadaNoSePuedeReservarLaMismaEnElMismoHorarioElMetodoDevuelveFalse() {

		GestorDeReserva gestor = new GestorDeReserva();

		Double precioBasePorHora = 20000.00;

		Cancha cancha = new CanchaDeFutbol5(precioBasePorHora);
		gestor.agregarCancha(cancha);

		LocalDateTime horaInicio = LocalDateTime.of(2025, 10, 01, 20, 00);

		String nombre = "Juan";
		Integer dni = 123;
		Cliente clienteTitular = new Cliente(nombre, dni);
		ReservaBase reserva = new ReservaBase(clienteTitular, cancha, horaInicio);
		gestor.agregarReserva(reserva);

		Cliente clienteTitular2 = new Cliente("Pedro", 235);
		LocalDateTime horaInicio2 = LocalDateTime.of(2025, 10, 01, 20, 00);
		ReservaBase reserva2 = new ReservaBase(clienteTitular2, cancha, horaInicio2);

		Boolean seAgregoReserva2 = gestor.agregarReserva(reserva2);
		assertFalse(seAgregoReserva2);

	}

	@Test
	public void dadoQueExisteUnaCanchaReservadaElClientePuedeCancelarSuReserva() {

		GestorDeReserva gestor = new GestorDeReserva();

		Double precioBasePorHora = 20000.00;

		Cancha cancha = new CanchaDeFutbol5(precioBasePorHora);
		gestor.agregarCancha(cancha);

		LocalDateTime horaInicio = LocalDateTime.of(2025, 10, 01, 20, 00);

		String nombre = "Juan";
		Integer dni = 123;
		Cliente clienteTitular = new Cliente(nombre, dni);
		ReservaBase reserva = new ReservaBase(clienteTitular, cancha, horaInicio);
		gestor.agregarReserva(reserva);

		Boolean seCanceloLaReserva = gestor.cancelarReserva(reserva);
		assertTrue(seCanceloLaReserva);

	}

	@Test
	public void dadoQueExisteUnaCanchaDeFutbol5YUnaReservaSePuedeAgregarUnaPelotaDeFutbolSiLaCanchaAReservarEsDeFutbol() {

		GestorDeReserva gestor = new GestorDeReserva();

		Double precioBasePorHora = 20000.00;

		Cancha cancha = new CanchaDeFutbol5(precioBasePorHora);
		gestor.agregarCancha(cancha);

		LocalDateTime horaInicio = LocalDateTime.of(2025, 10, 01, 20, 00);

		String nombre = "Juan";
		Integer dni = 123;
		Cliente clienteTitular = new Cliente(nombre, dni);
		ReservaBase reserva = new ReservaBase(clienteTitular, cancha, horaInicio);
		gestor.agregarReserva(reserva);

		ItemAdicional pelotaDeFutbol = new PelotaDeFutbol();

		Boolean seAgregoElItem = reserva.agregarItemAdicional(pelotaDeFutbol);
		Integer cantidadEsperada = 1;
		Integer cantidadObtenida = reserva.getCantidadItems();
		assertTrue(seAgregoElItem);
		assertEquals(cantidadEsperada, cantidadObtenida);

	}

	@Test
	public void dadoQueExisteUnaCanchaDeTenisYUnaReservaNOSePuedeAgregarUnaPelotaDeFutbolSiLaCanchaAReservarNoEsDeFutbol() {

		GestorDeReserva gestor = new GestorDeReserva();

		Double precioBasePorHora = 20000.00;

		Cancha cancha = new CanchaDeTenis(precioBasePorHora);
		gestor.agregarCancha(cancha);

		LocalDateTime horaInicio = LocalDateTime.of(2025, 10, 01, 20, 00);

		String nombre = "Juan";
		Integer dni = 123;
		Cliente clienteTitular = new Cliente(nombre, dni);
		ReservaBase reserva = new ReservaBase(clienteTitular, cancha, horaInicio);
		gestor.agregarReserva(reserva);

		ItemAdicional pelotaDeFutbol = new PelotaDeFutbol();

		Boolean seAgregoElItem = reserva.agregarItemAdicional(pelotaDeFutbol);
		Integer cantidadEsperada = 0;
		Integer cantidadObtenida = reserva.getCantidadItems();

		assertFalse(seAgregoElItem);
		assertEquals(cantidadEsperada, cantidadObtenida);

	}

	@Test
	public void dadoQueExisteUnaCanchaDeTenisYUnaReservaElClientePuedeAgregarRaquetasDeTenis() {

		GestorDeReserva gestor = new GestorDeReserva();

		Double precioBasePorHora = 20000.00;

		Cancha cancha = new CanchaDeTenis(precioBasePorHora);
		gestor.agregarCancha(cancha);

		LocalDateTime horaInicio = LocalDateTime.of(2025, 10, 01, 20, 00);

		String nombre = "Juan";
		Integer dni = 123;
		Cliente clienteTitular = new Cliente(nombre, dni);
		ReservaBase reserva = new ReservaBase(clienteTitular, cancha, horaInicio);
		gestor.agregarReserva(reserva);

		ItemAdicional raquetaDeTenis = new RaquetaDeTenis();

		Boolean seAgregoElItem = reserva.agregarItemAdicional(raquetaDeTenis);

		assertTrue(seAgregoElItem);
	}

	@Test
	public void dadoQueExisteUnaCanchaDeTenisYUnaReservaElClientePuedeAgregarRaquetasDeTenisQueSeSumaEnElPrecioFinal() {

		GestorDeReserva gestor = new GestorDeReserva();

		Double precioBasePorHora = 20000.00;

		Cancha cancha = new CanchaDeTenis(precioBasePorHora);
		gestor.agregarCancha(cancha);

		LocalDateTime horaInicio = LocalDateTime.of(2025, 10, 01, 20, 00);

		String nombre = "Juan";
		Integer dni = 123;
		Cliente clienteTitular = new Cliente(nombre, dni);
		ReservaBase reserva = new ReservaBase(clienteTitular, cancha, horaInicio);
		gestor.agregarReserva(reserva);

		ItemAdicional raquetaDeTenis = new RaquetaDeTenis();

		reserva.agregarItemAdicional(raquetaDeTenis);

		Double precioFinalEsperado = 48000.00;
		Double precioFinalObtenido = reserva.calcularPrecioFinal();

		assertEquals(precioFinalEsperado, precioFinalObtenido);
	}

	@Test
	public void dadoQueExisteUnaCanchaYMuchasReservasPuedoIdentificarUnaReservaSoloConSuiID() {

		GestorDeReserva gestor = new GestorDeReserva();

		Double precioBasePorHora = 20000.00;

		Cancha cancha = new CanchaDeFutbol5(precioBasePorHora);
		gestor.agregarCancha(cancha);

		LocalDateTime horaInicio = LocalDateTime.of(2025, 10, 01, 20, 00);

		Cliente clienteTitular = new Cliente("Juan", 123);
		ReservaBase reservaDeJuan = new ReservaBase(clienteTitular, cancha, horaInicio);
		gestor.agregarReserva(reservaDeJuan);

		Cliente clienteTitular2 = new Cliente("Pedro", 235);
		LocalDateTime horaInicio2 = LocalDateTime.of(2025, 10, 01, 23, 00);
		ReservaBase reservaDePedro = new ReservaBase(clienteTitular2, cancha, horaInicio2);

		gestor.agregarReserva(reservaDePedro);

		// Quiero obtener la reserva de Pedro
		Integer IdDeReserva = reservaDePedro.getIdReserva();

		ReservaBase reservaEsperada = reservaDePedro;
		ReservaBase reservaEncontrada = gestor.obtenerReservaPorId(IdDeReserva);

		assertEquals(reservaEsperada, reservaEncontrada);

	}

	@Test
	public void dadoQueExisteUnaReservaDeCanchasElClientePuedeCancelarlaSabiendoSuIdDeReserva() {
		GestorDeReserva gestor = new GestorDeReserva();

		Double precioBasePorHora = 20000.00;

		Cancha cancha = new CanchaDeFutbol5(precioBasePorHora);
		gestor.agregarCancha(cancha);

		LocalDateTime horaInicio = LocalDateTime.of(2025, 10, 01, 20, 00);

		Cliente clienteTitular = new Cliente("Juan", 123);
		ReservaBase reservaDeJuan = new ReservaBase(clienteTitular, cancha, horaInicio);
		gestor.agregarReserva(reservaDeJuan);

		gestor.agregarReserva(reservaDeJuan);

		Cliente clienteTitular2 = new Cliente("Pedro", 235);
		LocalDateTime horaInicio2 = LocalDateTime.of(2025, 10, 01, 23, 00);
		ReservaBase reservaDePedro = new ReservaBase(clienteTitular2, cancha, horaInicio2);

		gestor.agregarReserva(reservaDePedro);

		// Juan desea cancelar su reserva
		Integer idReserva = reservaDeJuan.getIdReserva();

		Boolean seCanceloReserva = gestor.cancelarReservaPorId(idReserva);

		assertTrue(seCanceloReserva);

	}

	@Test
	public void dadoQuePuedoIdentificarUnaReservaConItemsSoloConSuiIdPuedoFinalizarlaYObtenerElImporteTotalAPagar() {

		GestorDeReserva gestor = new GestorDeReserva();

		Double precioBasePorHora = 20000.00;

		Cancha cancha = new CanchaDeFutbol5(precioBasePorHora);
		gestor.agregarCancha(cancha);

		Cliente clienteTitular = new Cliente("Pedro", 235);
		LocalDateTime horaInicio = LocalDateTime.of(2025, 10, 01, 20, 00);
		ReservaBase reserva = new ReservaBase(clienteTitular, cancha, horaInicio);

		gestor.agregarReserva(reserva);

		ItemAdicional pelota = new PelotaDeFutbol();
		reserva.agregarItemAdicional(pelota);

		Integer IdDeReserva = reserva.getIdReserva();

		Double valorObtenido = gestor.finalizarReserva(IdDeReserva);
		Double valorEsperado = 25000D;

		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void dadoQueExisteUnGestorDeReservaDeCanchasSePuedeCrearUnaCanchaExitosamenteElMetodoDevuelveTrue() {
		GestorDeReserva gestor = new GestorDeReserva();

		Double precioBasePorHora = 2800.00;

		Cancha canchaDeFutbol = new CanchaDeFutbol7(precioBasePorHora);

		Boolean seAgrego = gestor.agregarCancha(canchaDeFutbol);

		assertTrue(seAgrego);
	}

	@Test
	public void dadoQueExisteUnaReservaDeUnClienteJubiladoSeAplicaUnDescuentoDel15PorCientoEnElPrecioFinal() {

		GestorDeReserva gestor = new GestorDeReserva();

		Double precioBasePorHora = 20000.00;

		Cancha cancha = new CanchaDeFutbol5(precioBasePorHora);
		gestor.agregarCancha(cancha);

		LocalDateTime horaInicio = LocalDateTime.of(2025, 10, 01, 20, 00);

		Cliente clienteJubilado = new Cliente("Carlos", 789);
		ReservaBase reserva = new ReservaBase(clienteJubilado, cancha, horaInicio);
		gestor.agregarReserva(reserva);

		DescuentoJubilados reservaConDescuento = new DescuentoJubilados(reserva);

		Double precioEsperado = 17000.00;
		Double precioObtenido = reservaConDescuento.calcularPrecioFinal();

		assertEquals(precioEsperado, precioObtenido);
	}

	@Test
	public void dadoQueExisteUnGestirDeReservasYMuchasReservasPuedoVerCuantasCanchasEstanDisponiblesEnUnMomentoPuntual() {
		GestorDeReserva gestor = new GestorDeReserva();

		Double precioBasePorHora = 20000.00;
		Cancha cancha = new CanchaDeFutbol5(precioBasePorHora);
		gestor.agregarCancha(cancha);
		Cliente clienteTitular = new Cliente("Pedro", 235);
		LocalDateTime horaInicio = LocalDateTime.of(2025, 10, 8, 20, 00);
		ReservaBase reserva = new ReservaBase(clienteTitular, cancha, horaInicio);
		gestor.agregarReserva(reserva);

		Cancha cancha2 = new CanchaDeFutbol5(precioBasePorHora);
		gestor.agregarCancha(cancha);
		Cliente clienteTitular2 = new Cliente("Pedro", 235);
		LocalDateTime horaInicio2 = LocalDateTime.of(2025, 10, 8, 12, 00);
		ReservaBase reserva2 = new ReservaBase(clienteTitular2, cancha2, horaInicio2);
		gestor.agregarReserva(reserva2);

		Cancha cancha3 = new CanchaDeFutbol5(precioBasePorHora);
		gestor.agregarCancha(cancha3);
		Cliente clienteTitular3 = new Cliente("Pedro", 235);
		LocalDateTime horaInicio3 = LocalDateTime.of(2025, 10, 8, 16, 00);
		ReservaBase reserva3 = new ReservaBase(clienteTitular3, cancha3, horaInicio3);
		gestor.agregarReserva(reserva3);

		// Ahora tengo 3 canchas que fueron reservadas en horarios distintos

		LocalDateTime momento = LocalDateTime.of(2025, 10, 8, 12, 00);

		// Si quiero ver cuantas canchas estan disponibles en ese momento el metodo
		// deberia devolver 2 ya que la cancha 2 no esta disponible a esa hora

		HashSet<Cancha> canchasDisponibles = new HashSet<>();

		canchasDisponibles = gestor.obtenerCanchasDisponibles(momento);

		Integer resultadoObtenido = canchasDisponibles.size();
		Integer resultadoEsperado = 2;

		assertEquals(resultadoEsperado, resultadoObtenido);

	}
	
	
	@Test
	public void dadoQueExisteUnGestirDeReservasYMuchasReservasPuedoVerCuantasCanchasEstanDisponiblesEnUnMomentoPuntal() {
	
		GestorDeReserva gestor = new GestorDeReserva();

		Double precioBasePorHora = 20000.00;
		Cancha cancha = new CanchaDeFutbol5(precioBasePorHora);
		gestor.agregarCancha(cancha);
		Cliente clienteTitular = new Cliente("Pedro", 23);
		LocalDateTime horaInicio = LocalDateTime.of(2025, 10, 8, 20, 00);
		ReservaBase reserva = new ReservaBase(clienteTitular, cancha, horaInicio);
		gestor.agregarReserva(reserva);

		Cancha cancha2 = new CanchaDeFutbol5(precioBasePorHora);
		gestor.agregarCancha(cancha);
		Cliente clienteTitular2 = new Cliente("Pedro", 25);
		LocalDateTime horaInicio2 = LocalDateTime.of(2025, 10, 8, 12, 00);
		ReservaBase reserva2 = new ReservaBase(clienteTitular2, cancha2, horaInicio2);
		gestor.agregarReserva(reserva2);

		Cancha cancha3 = new CanchaDeFutbol5(precioBasePorHora);
		gestor.agregarCancha(cancha3);
		Cliente clienteTitular3 = new Cliente("Pedro", 275);
		LocalDateTime horaInicio3 = LocalDateTime.of(2025, 10, 8, 16, 00);
		ReservaBase reserva3 = new ReservaBase(clienteTitular3, cancha3, horaInicio3);
		gestor.agregarReserva(reserva3);
		
		// MANERA DE DECLARAR UN MAP 
		// PRIMER VALOR UNA CLAVE , SEGUNDO EL VALOR
		Map<Cliente, List<Cancha>> reporteClienteCancha = new HashMap<>();
		
		List <Cancha> listadoCliente1 = new ArrayList <>();
		listadoCliente1.add(cancha2);
		listadoCliente1.add(cancha);
		
		reporteClienteCancha.put(clienteTitular, listadoCliente1);
		
		List <Cancha> listadoCliente2 = new ArrayList <>();
		listadoCliente2.add(cancha3);
		listadoCliente2.add(cancha);
		
		//Agrego clave valor
	//	reporteClienteCancha.put(clienteTitular2, listadoCliente2);
		
		// Le paso la KEY y me devuelve un listado de los valores.
	 // List <Cancha> nuevaListaCliente1 =  reporteClienteCancha.get(clienteTitular);
	 
	 
//RECORRER UN MAPA EJEMPLO
//     TIPO DE DATO       NOMBRE QUE LE DOY : COLECCION QUE ESTOY LEYENDO
// ENTRY CONJUNTO DE CLAVE VALOR 
	 
//	 for (Map.Entry<Cliente, List <Cancha>> entry : reporteClienteCancha.entrySet()) {
//		Cliente key = entry.getKey();
//		List <Cancha> val = entry.getValue(); 
//	}
		
	 // Obtengo el valor de esa KEY
//	 reporteClienteCancha.get(listadoCliente1);
	 
	 
	 Map<Cliente, List<Cancha>> reporteClienteCancha2 = gestor.obtenerReporteClientesCanchas();

	}
	
	

}

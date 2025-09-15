package ar.edu.unlam.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.dominio.GestorDePeaje;
import ar.edu.unlam.dominio.Pase;
import ar.edu.unlam.dominio.Tarifa;
import ar.edu.unlam.dominio.Vehiculo;

public class TestPeaje {
	private GestorDePeaje ausa;

	@Before
	public void gestorAgregado() {
		ausa = new GestorDePeaje();
	}

	@Test
	public void dadoQueExisteUnGestorDePeajesAlRegistrarUnPaseObtengoUnResultadoExistoso() {

		Vehiculo vehiculoNuevo = new Vehiculo("LOE321", "CHEVROLET", "CELTA");
		Vehiculo vehiculoNuevo2 = new Vehiculo("PGT165", "SUZUKI", "FUN");

		LocalDateTime fechaHora = LocalDateTime.of(2025, 9, 3, 9, 14, 0);

		Pase pase = new Pase(vehiculoNuevo, fechaHora);
		Pase pase2 = new Pase(vehiculoNuevo2, fechaHora);

		Boolean seAgrego = ausa.agregarPase(pase);
		Boolean seAgrego2 = ausa.agregarPase(pase2);

		assertTrue(seAgrego);
		assertTrue(seAgrego2);

	}

	@Test
	public void dadoQueExisteUnaEmpresaDePeajeVerificarQueUnVehiculoNoPuedaPasarDosVecesALaMismaFechaYHora() {
		LocalDateTime fechaHora = LocalDateTime.of(2025, 9, 3, 9, 14, 0);

		Vehiculo vehiculoNuevo = new Vehiculo("LOE321", "CHEVROLET", "CELTA");
		Vehiculo vehiculoNuevo2 = new Vehiculo("LOE321", "CHEVROLET", "CELTA");

		Vehiculo vehiculoNuevo3 = new Vehiculo("PGT165", "SUZUKI", "FUN");

		Pase pase = new Pase(vehiculoNuevo, fechaHora);
		Pase pase2 = new Pase(vehiculoNuevo2, fechaHora);
		Pase pase3 = new Pase(vehiculoNuevo3, fechaHora);

		Boolean seAgrego = ausa.agregarPase(pase);
		Boolean seAgrego2 = ausa.agregarPase(pase2);
		Boolean seAgrego3 = ausa.agregarPase(pase3);

		assertTrue(seAgrego);
		assertFalse(seAgrego2);
		assertTrue(seAgrego3);

	}

	@Test
	public void dadoQueExisteUnGestorDePeajeAlRegistrar2PasesDeunVehiculoYotroPaseDeotroVheculoObtengoUnListadoConLos2Vehiculos() {

		LocalDateTime fechaHora = LocalDateTime.of(2025, 9, 3, 9, 14, 0);
		LocalDateTime fechaHora2 = LocalDateTime.now();
		LocalDateTime fechaHora3 = LocalDateTime.of(2025, 9, 3, 9, 30, 0);

		Vehiculo vehiculoNuevo = new Vehiculo("LOE321", "CHEVROLET", "CELTA");
		Vehiculo vehiculoNuevo2 = new Vehiculo("LOE421", "CHEVROLET", "CELTA");

		Pase pase = new Pase(vehiculoNuevo, fechaHora);
		Pase pase2 = new Pase(vehiculoNuevo2, fechaHora2);
		Pase pase3 = new Pase(vehiculoNuevo, fechaHora3);

		ausa.agregarPase(pase);
		ausa.agregarPase(pase2);
		ausa.agregarPase(pase3);

		HashSet<Vehiculo> vehiculos = ausa.obtenerTodosLosVehiculos();

		Integer valorEsperado = 2;
		Integer valorObtenido = vehiculos.size();

		assertEquals(valorEsperado, valorObtenido);

	}

	@Test
	public void dadoQueExisteUnGestorDePeajeAlAgregarUnaNuevaTarifaObtengoUnResultadoExitoso() {

		Double valorJulio = 1000.0;
		LocalDate desdeJulio = LocalDate.of(2025, 7, 1);

		Tarifa tarifaJulio = new Tarifa(desdeJulio, valorJulio);

		Boolean seAgrego = ausa.agregarTarifa(tarifaJulio);

		assertTrue(seAgrego);

		Integer valorEsperado = 1; //
		Integer valorObtenido = ausa.obtenerCantidadDeTarifas();
		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void cuandoAgregoUnaTarifaModificoElHastaEnUnDiaAnterior() {
		// JULIO
		Double valorJulio = 1000.0;
		LocalDate desdeJulio = LocalDate.of(2025, 7, 1);

		Tarifa tarifaJulio = new Tarifa(desdeJulio, valorJulio);
		Boolean seAgrego = ausa.agregarTarifa(tarifaJulio);
		assertTrue(seAgrego);

		// AGOSTO
		Double valorAgosto = 1000.0;
		LocalDate desdeAgosto = LocalDate.of(2025, 8, 1);
		Tarifa tarifaAgosto = new Tarifa(desdeAgosto, valorAgosto);
		Boolean seAgrego2 = ausa.agregarTarifa(tarifaAgosto);
		assertTrue(seAgrego2);

		// OCTUBRE
		Double valorOctubre = 1500.0;
		LocalDate desdeOctubre = LocalDate.of(2025, 9, 1);
		Tarifa tarifaOctubre = new Tarifa(desdeOctubre, valorOctubre);

		Boolean seAgrego3 = ausa.agregarTarifa(tarifaOctubre);
		assertTrue(seAgrego3);

		// PARA VERIFIFCAR EL HASTA
		LocalDate esperadoHastaJulio = desdeAgosto.minusDays(1);
		assertEquals(esperadoHastaJulio, tarifaJulio.getHasta());

		LocalDate esperadoHastaSeptiembre = desdeOctubre.minusDays(1);
		assertEquals(esperadoHastaSeptiembre, tarifaAgosto.getHasta());

		// VERIFICAR QUE LA TARIFA VIGENTE EL HASTA SEA NULL
		assertNull(tarifaOctubre.getHasta());

	}

	@Test
	public void dadoQueExisteUnaTarifaConUnaFechaDesde01SeptiembreNoPermitaAgregarUnaNuevaTarifaConFechaDesde01Agosto() {

		LocalDate fechaDesde = LocalDate.of(2025, 9, 1);

		Tarifa tarifaSeptiembre = new Tarifa(fechaDesde, 2000D);

		assertTrue(ausa.agregarTarifa(tarifaSeptiembre));

		LocalDate fechaDesdeAgosto = LocalDate.of(2025, 8, 1);

		Tarifa tarifaAgosto = new Tarifa(fechaDesde, 2500D);

		assertFalse(ausa.agregarTarifa(tarifaAgosto));

	}

	@Test
	public void cuandoUnVehiculoPasaPorElPeajeSeAgregaLaTarifaYSeObtieneTarifaPorMes() {

		// Fecha y hora del primer pase
		LocalDateTime fechaHora = LocalDateTime.of(2025, 9, 3, 15, 30, 15);
		// Fecha y hora del segundo pase . Mismo dia, media hora despues.
		LocalDateTime fechaHora2 = LocalDateTime.of(2025, 9, 3, 16, 01, 05);

		String patente = "LOE31";
		String marca = "CHEVROLET";
		String modelo = "Celta";

		Vehiculo vehiculoNuevo = new Vehiculo(patente, marca, modelo);

		LocalDate fechaDesdeJulio = LocalDate.of(2025, 07, 1);
		Double valorTarifaJulio = 1000D;

		Tarifa nuevaTarifa = new Tarifa(fechaDesdeJulio, valorTarifaJulio);
		ausa.agregarTarifa(nuevaTarifa);

		Pase pase = new Pase(vehiculoNuevo, fechaHora);
		Pase pase2 = new Pase(vehiculoNuevo, fechaHora2); // Se crea el segundo pase
		ausa.agregarPase(pase);
		ausa.agregarPase(pase2);

		Double valorEsperado = 2000.0; // Paso 2 veces en septiembre
		// patente,anio,mes
		Double valorObtenido = ausa.obtenerMontoAAbonarDeUnVehiculoParaUnMesDado(patente, 2025, 9);

		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void obtenerElValorDeUnMesDeUnVehiculoRegistrado() {
		// TARIFA

		LocalDate fechaDesde = LocalDate.of(2025, 9, 1);
		LocalDate fechaHasta = null;
		Double valorTarifa = 1000.0;

		Tarifa nuevaTarifa = new Tarifa(fechaDesde, valorTarifa);

		assertTrue(ausa.agregarTarifa(nuevaTarifa));

		// VEHICULO Y PASE
		LocalDateTime fechaHora = LocalDateTime.of(2025, 9, 03, 12, 0);
		LocalDateTime fechaHora2 = LocalDateTime.of(2025, 9, 7, 12, 0);

		Vehiculo vehiculoNuevo = new Vehiculo("LOE321", "CHEVROLET", "CELTA");

		Pase pase = new Pase(vehiculoNuevo, fechaHora);

		Pase pase2 = new Pase(vehiculoNuevo, fechaHora2);
		ausa.agregarPase(pase);
		ausa.agregarPase(pase2);

		Double valorEsperado = 2000.0;
		Double valorObtenido = ausa.obtenerMontoAAbonarDeUnVehiculoParaUnMesDado("LOE321", 2025, 9);

		assertEquals(valorEsperado, valorObtenido);

	}

	@Test

	public void dadoVariasTarifasYPasesEnDistintosMesesSoloObtengoLosPasesDeSeptiembre() {
		String patente = "LOE31";
		String marca = "CHEVROLET";
		String modelo = "Celta";

		Vehiculo vehiculoNuevo = new Vehiculo(patente, marca, modelo);

		// TARIFA JULIO
		LocalDate fechaDesdeJulio = LocalDate.of(2025, 07, 1);
		Double valorTarifaJulio = 1000D;
		Tarifa nuevaTarifa = new Tarifa(fechaDesdeJulio, valorTarifaJulio);
		ausa.agregarTarifa(nuevaTarifa);

		// TARIFA SEPTIEMBRE
		LocalDate fechaDesdeSeptiembre = LocalDate.of(2025, 9, 1);
		Double valorTarifaSeptiembre = 2000D;
		Tarifa nuevaTarifaSeptiembre = new Tarifa(fechaDesdeSeptiembre, valorTarifaSeptiembre);
		ausa.agregarTarifa(nuevaTarifaSeptiembre);

		// PASES
		LocalDateTime fechaHora = LocalDateTime.of(2025, 7, 10, 8, 15, 10); // Pase julio
		LocalDateTime fechaHora2 = LocalDateTime.of(2025, 7, 25, 18, 45, 30);// Pase Julio
		// PASES SEPTIEMBRE
		LocalDateTime fechaHora3 = LocalDateTime.of(2025, 9, 3, 15, 30, 15);
		LocalDateTime fechaHora4 = LocalDateTime.of(2025, 9, 3, 16, 01, 05);
		LocalDateTime fechaHora5 = LocalDateTime.of(2025, 9, 10, 10, 00, 15);
		LocalDateTime fechaHora6 = LocalDateTime.of(2025, 9, 30, 9, 21, 05);

		// AGREGAR PASES
		Pase pase1 = new Pase(vehiculoNuevo, fechaHora);
		Pase pase2 = new Pase(vehiculoNuevo, fechaHora2);
		Pase pase3 = new Pase(vehiculoNuevo, fechaHora3);
		Pase pase4 = new Pase(vehiculoNuevo, fechaHora4);
		Pase pase5 = new Pase(vehiculoNuevo, fechaHora5);
		Pase pase6 = new Pase(vehiculoNuevo, fechaHora6);

		ausa.agregarPase(pase1);
		ausa.agregarPase(pase2);
		// Pases septiembre
		ausa.agregarPase(pase3);
		ausa.agregarPase(pase4);
		ausa.agregarPase(pase5);
		ausa.agregarPase(pase6);

		Double valorEsperado = 8000D; // 4 veces en septiembre
		Double valorObtenido = ausa.obtenerMontoAAbonarDeUnVehiculoParaUnMesDado(patente, 2025, 9);

		assertEquals(valorEsperado, valorObtenido);
	}

	/*
	 * Test agregarTarifa() Desde 01/07/2025 hasta Null
	 * 
	 * Test cuandoAgregoUnaTarifaModificoElHAstaEnUndiaAnterior() Nueva desde =
	 * Fecha nueva vigente Se setea el Hasta de la tarifa anterior hasta un dia
	 * antes Nueva tarifa --> hasta = Null
	 * 
	 * Test obtengoelprecioDeTarifasParaunmes() Test
	 * dadoQueExisteUnaTarifaConUnaFechaDesde01SeptiembreNoPermitaAgregarUnaNuevaTarifaConFechaDesde01Agosto
	 * ()
	 * 
	 */

}

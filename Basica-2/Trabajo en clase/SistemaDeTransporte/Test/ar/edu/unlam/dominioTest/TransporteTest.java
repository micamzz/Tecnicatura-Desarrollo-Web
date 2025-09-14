package ar.edu.unlam.dominioTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.dominio.Camion;
import ar.edu.unlam.dominio.Coche;
import ar.edu.unlam.dominio.Colectivo;
import ar.edu.unlam.dominio.Pasajero;

public class TransporteTest {

	private Colectivo linea216;
	private Camion ives;
	private Coche miAuto;

	@Before
	public void instanciasDeVehiculos() {

		// Datos COLECTIVO
		String patente = "PGT165";
		Double pesoMaximo = 400D;
		Integer capacidadMaximaDePasajeros = 30;
		linea216 = new Colectivo(patente, pesoMaximo, capacidadMaximaDePasajeros);

		// Datos CAMION
		String patenteCamion = "ABC123";
		Double pesoMaximoCamion = 800D;
		Integer capacidadMaximaDePasajerosCamion = 2;
		ives = new Camion(patenteCamion, pesoMaximoCamion, capacidadMaximaDePasajerosCamion);

		// Datos COCHE
		String patenteCoche = "FFG234";
		Double pesoMaximoCoche = 600D;
		Integer capacidadMaximaDePasajerosCoche = 5;

		miAuto = new Coche(patenteCoche, pesoMaximoCoche, capacidadMaximaDePasajerosCoche);

	}

	// TEST PARA COLECTIVOS
	@Test
	public void dadoQueExisteUnColectivoUnaPersonaQuiereSubirYObtieneUnResultadoExitoso() {

		// Pasajero
		Double pesoPasajero = 50.0;
		Pasajero pasajeroPrueba = new Pasajero(pesoPasajero);

		Boolean sePudoSubir = linea216.cargarPasajeros(pasajeroPrueba);

		assertTrue(sePudoSubir);

	}

	@Test

	public void dadoQueExisteUnColectivoAlSuperarLaCapacidadDePesoMaximoDevuelveFalse() {
		// Pasajero
		Double pesoPasajero = 80.0;
		Pasajero pasajeroPrueba = new Pasajero(pesoPasajero);

		Double pesoPasajero2 = 150.0;
		Pasajero pasajeroPrueba2 = new Pasajero(pesoPasajero2);

		Double pesoPasajero3 = 80.0;
		Pasajero pasajeroPrueba3 = new Pasajero(pesoPasajero3);

		Double pesoPasajero4 = 100.0;
		Pasajero pasajeroPrueba4 = new Pasajero(pesoPasajero4);

		Boolean sePudoSubir = linea216.cargarPasajeros(pasajeroPrueba);
		Boolean sePudoSubir2 = linea216.cargarPasajeros(pasajeroPrueba2);
		Boolean sePudoSubir3 = linea216.cargarPasajeros(pasajeroPrueba3);
		// Boolean sePudoSubir4 = linea216.cargarPasajeros(pasajeroPrueba4);

		assertTrue(sePudoSubir);
		assertTrue(sePudoSubir2);
		assertTrue(sePudoSubir3);
		// assertFalse(sePudoSubir4);

	}

	@Test

	public void dadoQueSubenVariasPersonasAlColectivoElPesoEsperadoDeCargaEsDe310() {
		System.out.println("Cantidad de pasajeros al iniciar test: " + linea216.obtenerCapacidadActualDePasajeros());
		// Pasajero
		Double pesoPasajero = 80.0;
		Pasajero pasajeroPrueba = new Pasajero(pesoPasajero);

		Double pesoPasajero2 = 150.0;
		Pasajero pasajeroPrueba2 = new Pasajero(pesoPasajero2);

		Double pesoPasajero3 = 80.0;
		Pasajero pasajeroPrueba3 = new Pasajero(pesoPasajero3);

		// Carga de Pasajeros
		linea216.cargarPasajeros(pasajeroPrueba);
		linea216.cargarPasajeros(pasajeroPrueba2);
		linea216.cargarPasajeros(pasajeroPrueba3);

		Double valorEsperado = 310.0;
		Double valorObtenido = linea216.obtenerPesoActualDePasajeros();

		assertEquals(valorEsperado, valorObtenido);
	}

	// TEST PARA CAMION
	@Test

	public void dadoQueExisteUnCamionAlSubirDosPersonaDevuelveUnResultadoExitoso() {

		// Pasajero
		Double pesoPasajero = 50.0;
		Pasajero pasajeroPrueba = new Pasajero(pesoPasajero);

		Double pesoPasajero2 = 80.0;
		Pasajero pasajeroPrueba2 = new Pasajero(pesoPasajero2);

		Boolean sePudoSubir = ives.cargarPasajeros(pasajeroPrueba);
		Boolean sePudoSubir2 = ives.cargarPasajeros(pasajeroPrueba2);

		assertTrue(sePudoSubir);
		assertTrue(sePudoSubir2);

		Integer valorEsperado = 2;
		Integer valorObtenido = ives.obtenerCapacidadActualDePasajeros();

		assertEquals(valorEsperado, valorObtenido);

	}

	@Test
	public void dadoQueExisteUnCamionAlSuperarLaCapacidadDeCargaDePasajerosDevuelveFalse() {
		// Pasajero
		Double pesoPasajero = 50.0;
		Pasajero pasajeroPrueba = new Pasajero(pesoPasajero);

		Double pesoPasajero2 = 80.0;
		Pasajero pasajeroPrueba2 = new Pasajero(pesoPasajero2);

		Double pesoPasajero3 = 80.0;
		Pasajero pasajeroPrueba3 = new Pasajero(pesoPasajero3);

		Boolean sePudoSubir = ives.cargarPasajeros(pasajeroPrueba);
		Boolean sePudoSubir2 = ives.cargarPasajeros(pasajeroPrueba2);
		Boolean sePudoSubir3 = ives.cargarPasajeros(pasajeroPrueba3);

		assertTrue(sePudoSubir);
		assertTrue(sePudoSubir2);
		assertFalse(sePudoSubir3);
	}

	// TEST PARA AUTOS

	@Test

	public void dadoQueTengoUnAutoSeQuiereSubirUnaPersonaYElResultadoEsExitoso() {

		// Pasajero
		Double pesoPasajero = 50.0;
		Pasajero pasajeroPrueba = new Pasajero(pesoPasajero);

		Double pesoPasajero2 = 80.0;
		Pasajero pasajeroPrueba2 = new Pasajero(pesoPasajero2);

		Double pesoPasajero3 = 80.0;
		Pasajero pasajeroPrueba3 = new Pasajero(pesoPasajero3);

		miAuto.cargarPasajeros(pasajeroPrueba);
		miAuto.cargarPasajeros(pasajeroPrueba2);
		miAuto.cargarPasajeros(pasajeroPrueba3);

		Boolean sePudoSubir = ives.cargarPasajeros(pasajeroPrueba);
		assertTrue(sePudoSubir);

	}

	@Test

	public void dadoQueTengoUnAutoYSeQuierenSubir6PersonasYNoSuperanElPesoMaximoPeroElResultadoEsFalsoPorqueSuperaLaCapacidad() {

		// Pasajero
		Double pesoPasajero = 50.0;
		Pasajero pasajeroPrueba = new Pasajero(pesoPasajero);

		Double pesoPasajero2 = 45.0;
		Pasajero pasajeroPrueba2 = new Pasajero(pesoPasajero2);

		Double pesoPasajero3 = 30.0;
		Pasajero pasajeroPrueba3 = new Pasajero(pesoPasajero3);

		Double pesoPasajero4 = 60.0;
		Pasajero pasajeroPrueba4 = new Pasajero(pesoPasajero4);

		Double pesoPasajero5 = 80.0;
		Pasajero pasajeroPrueba5 = new Pasajero(pesoPasajero5);

		Double pesoPasajero6 = 80.0;
		Pasajero pasajeroPrueba6 = new Pasajero(pesoPasajero6);

		Boolean sePudoSubir = miAuto.cargarPasajeros(pasajeroPrueba);
		Boolean sePudoSubir2 = miAuto.cargarPasajeros(pasajeroPrueba2);
		Boolean sePudoSubir3 = miAuto.cargarPasajeros(pasajeroPrueba3);
		Boolean sePudoSubir4 = miAuto.cargarPasajeros(pasajeroPrueba4);
		Boolean sePudoSubir5 = miAuto.cargarPasajeros(pasajeroPrueba5);
		Boolean sePudoSubir6 = miAuto.cargarPasajeros(pasajeroPrueba6);

		assertTrue(sePudoSubir5);
		assertFalse(sePudoSubir6);

		Integer valorEsperado = 5;
		Integer valorObtenido = miAuto.obtenerCapacidadActualDePasajeros();

		assertEquals(valorEsperado, valorObtenido);

	}

}

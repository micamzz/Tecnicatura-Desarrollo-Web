package ar.edu.unlam.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.dominio.*;
import ar.edu.unlam.enums.*;
import ar.edu.unlam.excepciones.*;

public class PlanesTest {

	GestorDePlanes compania;

	@Before
	public void inicializacion() {
		compania = new GestorDePlanes();

	}

	@Test
	public void dadoQueExisteUnaCompaniaSePuedeAgregarUnCliente() throws ClienteExistenteException {

		Integer dni = 1234;
		String nombre = "Mariana";
		String apellido = "Vetrano";
		Integer edad = 33;

		Cliente cliente1 = new Cliente(dni, nombre, apellido, edad);

		Boolean seAgrego = compania.agregarCliente(cliente1);

		assertTrue(seAgrego);
	}

	@Test(expected = ClienteExistenteException.class)
	public void dadoQueExisteUnaCompaniaAlAgregarUnClienteExistenteSeLanzaUnaClienteExistenteException()
			throws ClienteExistenteException {
		Integer dni = 1234;
		String nombre = "Mariana";
		String apellido = "Vetrano";
		Integer edad = 33;

		Cliente cliente1 = new Cliente(dni, nombre, apellido, edad);
		compania.agregarCliente(cliente1);

		// CLIENTE 2

		Integer dni2 = 1234;
		String nombre2 = "Agustin";
		String apellido2 = "Castellano";
		Integer edad2 = 48;

		Cliente cliente2 = new Cliente(dni2, nombre2, apellido2, edad2);

		compania.agregarCliente(cliente2);
	}

	@Test
	public void dadoQueExisteUnaCompaniaConUnPlanBasicoYUnPlanPremiumCuandoSeObtieneElPrecioDeUnPlanPremiumDevuelve6000() {

		Integer IdPlan = 10;
		String nombrePlan = "HD";

		Plan planPremiun = new PlanPremium(IdPlan, nombrePlan);

		compania.agregarPlan(planPremiun);

		Double resultadoEsperado = 6000D;
		Double resultadoObtenido = planPremiun.obtenerPrecio();

		assertEquals(resultadoEsperado, resultadoObtenido);

	}

	@Test
	public void dadoQueExisteUnaCompaniaConClientesSePuedenListarLosClientesOrdenadosDeManeraAscendentePorSuDni()
			throws ClienteExistenteException {

		Integer dni = 1234;
		String nombre = "Mariana";
		String apellido = "Vetrano";
		Integer edad = 33;

		Cliente cliente1 = new Cliente(dni, nombre, apellido, edad);
		compania.agregarCliente(cliente1);

		// CLIENTE 2

		Integer dni2 = 8989;
		String nombre2 = "Agustin";
		String apellido2 = "Castellano";
		Integer edad2 = 48;

		Cliente cliente2 = new Cliente(dni2, nombre2, apellido2, edad2);

		compania.agregarCliente(cliente2);

		// CLIENTE 3

		Integer dni3 = 1233;
		String nombre3 = "Lara";
		String apellido3 = "Daniela";
		Integer edad3 = 32;

		Cliente cliente3 = new Cliente(dni3, nombre3, apellido3, edad3);

		compania.agregarCliente(cliente3);

		TreeSet<Cliente> listaOrdenadaPorDni = compania.obtenerListadoDeClientesOrdenadosPorDni();

		assertEquals(cliente3, listaOrdenadaPorDni.first());
		assertEquals(cliente2, listaOrdenadaPorDni.last());
		assertEquals(3, listaOrdenadaPorDni.size());
	}

	@Test
	public void dadoQueExisteUnaCompaniaConSuscripcionesAPlanesBasicosYPremiumSePuedenListarLasSuscripcionesAPlanesPremium()
			throws ClienteExistenteException, ClienteYaSuscriptoException {
		// CLIENTES
		Integer dni = 1234;
		String nombre = "Mariana";
		String apellido = "Vetrano";
		Integer edad = 33;

		Cliente cliente1 = new Cliente(dni, nombre, apellido, edad);
		// CLIENTE 2
		Integer dni2 = 8989;
		String nombre2 = "Agustin";
		String apellido2 = "Castellano";
		Integer edad2 = 48;
		Cliente cliente2 = new Cliente(dni2, nombre2, apellido2, edad2);

		// CLIENTE 3
		Integer dni3 = 1233;
		String nombre3 = "Lara";
		String apellido3 = "Daniela";
		Integer edad3 = 32;

		Cliente cliente3 = new Cliente(dni3, nombre3, apellido3, edad3);

		compania.agregarCliente(cliente1);
		compania.agregarCliente(cliente2);
		compania.agregarCliente(cliente3);

		// PLANES PREMIUN - 4 ;
		Integer IdPlan = 15;
		String nombrePlan = "HD-BASIC";
		Plan planPremiun = new PlanPremium(IdPlan, nombrePlan);

		Integer IdPlan2 = 16;
		String nombrePlan2 = "HD";
		Plan planPremiun2 = new PlanPremium(IdPlan2, nombrePlan2);

		Integer IdPlan3 = 17;
		String nombrePlan3 = "HD-PLUS";
		Plan planPremiun3 = new PlanPremium(IdPlan3, nombrePlan3);

		Integer IdPlan4 = 18;
		String nombrePlan4 = "FULL-MAX";
		Plan planPremiun4 = new PlanPremium(IdPlan4, nombrePlan4);

		// PLANES BASICOS (3)

		Integer IdPlan5 = 1;
		String nombrePlan5 = "FULL-MAX";
		Plan planBasico1 = new PlanBasico(IdPlan5, nombrePlan5);

		Integer IdPlan6 = 1;
		String nombrePlan6 = "FULL-MAX";
		Plan planBasico2 = new PlanBasico(IdPlan6, nombrePlan5);

		Integer IdPlan7 = 1;
		String nombrePlan7 = "FULL-MAX";
		Plan planBasico3 = new PlanBasico(IdPlan7, nombrePlan7);

		// AGREGAR PLANES A LA COMPANIA

		compania.agregarPlan(planPremiun);
		compania.agregarPlan(planPremiun2);
		compania.agregarPlan(planPremiun3);
		compania.agregarPlan(planPremiun4);
		compania.agregarPlan(planBasico1);
		compania.agregarPlan(planBasico2);
		compania.agregarPlan(planBasico3);

		// CANALES BASICOS
		Integer numeroCanal1 = 10;
		String nombreCanal1 = "Telefe";
		Canal canal10 = new Canal(numeroCanal1, nombreCanal1, TipoDeCanal.VARIOS, TipoClasificacion.BASICO);

		Integer numeroCanal13 = 13;
		String nombreCanal13 = "Trece";
		Canal canal13 = new Canal(numeroCanal13, nombreCanal13, TipoDeCanal.VARIOS, TipoClasificacion.BASICO);

		Integer numeroCanal9 = 9;
		String nombreCanal9 = "Nueve";
		Canal canal9 = new Canal(numeroCanal9, nombreCanal9, TipoDeCanal.VARIOS, TipoClasificacion.BASICO);

		// CANALES PREMIUN
		Integer numeroCanal40 = 40;
		String nombreCanal40 = "FOX";
		Canal canal40 = new Canal(numeroCanal40, nombreCanal40, TipoDeCanal.VARIOS, TipoClasificacion.PREMIUM);

		Integer numeroCanal41 = 41;
		String nombreCanal41 = "FOX-PREMIUM";
		Canal canal41 = new Canal(numeroCanal41, nombreCanal41, TipoDeCanal.DEPORTE, TipoClasificacion.PREMIUM);

		Integer numeroCanal42 = 42;
		String nombreCanal42 = "FOX-SPORTS";
		Canal canal42 = new Canal(numeroCanal42, nombreCanal42, TipoDeCanal.DEPORTE, TipoClasificacion.PREMIUM);

		Integer numeroCanal50 = 50;
		String nombreCanal50 = "DISNEY-PLUS";
		Canal canal50 = new Canal(numeroCanal50, nombreCanal50, TipoDeCanal.INFANTIL, TipoClasificacion.PREMIUM);

		compania.agregarCanal(canal10);
		compania.agregarCanal(canal13);
		compania.agregarCanal(canal9);
		compania.agregarCanal(canal40);
		compania.agregarCanal(canal41);
		compania.agregarCanal(canal42);
		compania.agregarCanal(canal50);

		HashSet<Canal> listadoPlanes = compania.obtenerListadoDeCanales();

		Suscripcion suscripcion1 = new Suscripcion(cliente1, planPremiun, listadoPlanes);
		Suscripcion suscripcion2 = new Suscripcion(cliente2, planPremiun, listadoPlanes);
		Suscripcion suscripcion3 = new Suscripcion(cliente3, planPremiun2, listadoPlanes);

		compania.agregarSuscripcion(suscripcion1);
		compania.agregarSuscripcion(suscripcion2);
		compania.agregarSuscripcion(suscripcion3);

		ArrayList<Suscripcion> listadoSuscripcionPremium = compania.obtenerListadoDeSuscripcionesPremium();

		assertEquals(3, listadoSuscripcionPremium.size());
		assertTrue(listadoSuscripcionPremium.contains(suscripcion2));

	}

	@Test

	public void dadoQueExisteUnaCompaniaConSuscripcionesAPlanesBasicosYPremiumSePuedenListarLosClientesSuscritosAPlanesBasicos()
			throws ClienteExistenteException, ClienteYaSuscriptoException {
		// CLIENTES
		Integer dni = 1234;
		String nombre = "Mariana";
		String apellido = "Vetrano";
		Integer edad = 33;

		Cliente cliente1 = new Cliente(dni, nombre, apellido, edad);
		// CLIENTE 2
		Integer dni2 = 8989;
		String nombre2 = "Agustin";
		String apellido2 = "Castellano";
		Integer edad2 = 48;
		Cliente cliente2 = new Cliente(dni2, nombre2, apellido2, edad2);

		// CLIENTE 3
		Integer dni3 = 1233;
		String nombre3 = "Lara";
		String apellido3 = "Daniela";
		Integer edad3 = 32;

		Cliente cliente3 = new Cliente(dni3, nombre3, apellido3, edad3);

		compania.agregarCliente(cliente1);
		compania.agregarCliente(cliente2);
		compania.agregarCliente(cliente3);

		// PLANES PREMIUN ;

		Integer IdPlan3 = 17;
		String nombrePlan3 = "HD-PLUS";
		Plan planPremiun3 = new PlanPremium(IdPlan3, nombrePlan3);

		Integer IdPlan4 = 18;
		String nombrePlan4 = "FULL-MAX";
		Plan planPremiun4 = new PlanPremium(IdPlan4, nombrePlan4);

		// PLANES BASICOS (3)

		Integer IdPlan5 = 1;
		String nombrePlan5 = "FULL-MAX";
		Plan planBasico1 = new PlanBasico(IdPlan5, nombrePlan5);

		// AGREGAR PLANES A LA COMPANIA

		compania.agregarPlan(planPremiun3);
		compania.agregarPlan(planPremiun4);
		compania.agregarPlan(planBasico1);

		// CANALES BASICOS
		Integer numeroCanal1 = 10;
		String nombreCanal1 = "Telefe";
		Canal canal10 = new Canal(numeroCanal1, nombreCanal1, TipoDeCanal.VARIOS, TipoClasificacion.BASICO);

		Integer numeroCanal13 = 13;
		String nombreCanal13 = "Trece";
		Canal canal13 = new Canal(numeroCanal13, nombreCanal13, TipoDeCanal.VARIOS, TipoClasificacion.BASICO);

		Integer numeroCanal9 = 9;
		String nombreCanal9 = "Nueve";
		Canal canal9 = new Canal(numeroCanal9, nombreCanal9, TipoDeCanal.VARIOS, TipoClasificacion.BASICO);

		// CANALES PREMIUN
		Integer numeroCanal40 = 40;
		String nombreCanal40 = "FOX";
		Canal canal40 = new Canal(numeroCanal40, nombreCanal40, TipoDeCanal.VARIOS, TipoClasificacion.PREMIUM);

		Integer numeroCanal41 = 41;
		String nombreCanal41 = "FOX-PREMIUM";
		Canal canal41 = new Canal(numeroCanal41, nombreCanal41, TipoDeCanal.DEPORTE, TipoClasificacion.PREMIUM);

		Integer numeroCanal42 = 42;
		String nombreCanal42 = "FOX-SPORTS";
		Canal canal42 = new Canal(numeroCanal42, nombreCanal42, TipoDeCanal.DEPORTE, TipoClasificacion.PREMIUM);

		Integer numeroCanal50 = 50;
		String nombreCanal50 = "DISNEY-PLUS";
		Canal canal50 = new Canal(numeroCanal50, nombreCanal50, TipoDeCanal.INFANTIL, TipoClasificacion.PREMIUM);

		compania.agregarCanal(canal10);
		compania.agregarCanal(canal13);
		compania.agregarCanal(canal9);
		compania.agregarCanal(canal40);
		compania.agregarCanal(canal41);
		compania.agregarCanal(canal42);
		compania.agregarCanal(canal50);

		HashSet<Canal> listadoPlanes = compania.obtenerListadoDeCanales();

		Suscripcion suscripcion1 = new Suscripcion(cliente1, planBasico1, listadoPlanes);
		Suscripcion suscripcion2 = new Suscripcion(cliente2, planPremiun4, listadoPlanes);
		Suscripcion suscripcion3 = new Suscripcion(cliente3, planBasico1, listadoPlanes);

		compania.agregarSuscripcion(suscripcion1);
		compania.agregarSuscripcion(suscripcion2);
		compania.agregarSuscripcion(suscripcion3);

		ArrayList<Suscripcion> listadoSuscripcionBasicas = compania.obtenerListadoDeSuscripcionesBasicas();

		assertEquals(2, listadoSuscripcionBasicas.size());
		assertTrue(listadoSuscripcionBasicas.contains(suscripcion3));
		assertFalse(listadoSuscripcionBasicas.contains(suscripcion2));

	}

	@Test

	public void dadoQueExisteUnaCompaniaConSuscripcionesAPlanesBasicosYPremiumSePuedeMostrarElTotalDePrecioParaUnPlanBasicoOPremium()
			throws ClienteYaSuscriptoException, ClienteExistenteException {
		// CLIENTES
		Integer dni = 1234;
		String nombre = "Mariana";
		String apellido = "Vetrano";
		Integer edad = 33;

		Cliente cliente1 = new Cliente(dni, nombre, apellido, edad);
		// CLIENTE 2
		Integer dni2 = 8989;
		String nombre2 = "Agustin";
		String apellido2 = "Castellano";
		Integer edad2 = 48;
		Cliente cliente2 = new Cliente(dni2, nombre2, apellido2, edad2);

		// CLIENTE 3
		Integer dni3 = 1233;
		String nombre3 = "Lara";
		String apellido3 = "Daniela";
		Integer edad3 = 32;

		Cliente cliente3 = new Cliente(dni3, nombre3, apellido3, edad3);

		compania.agregarCliente(cliente1);
		compania.agregarCliente(cliente2);
		compania.agregarCliente(cliente3);

		// PLANES PREMIUN ;

		Integer IdPlan3 = 17;
		String nombrePlan3 = "HD-PLUS";
		Plan planPremiun3 = new PlanPremium(IdPlan3, nombrePlan3);

		Integer IdPlan4 = 18;
		String nombrePlan4 = "FULL-MAX";
		Plan planPremiun4 = new PlanPremium(IdPlan4, nombrePlan4);

		// PLANES BASICOS (3)

		Integer IdPlan5 = 1;
		String nombrePlan5 = "FULL-MAX";
		Plan planBasico1 = new PlanBasico(IdPlan5, nombrePlan5);

		// AGREGAR PLANES A LA COMPANIA

		compania.agregarPlan(planPremiun3);
		compania.agregarPlan(planPremiun4);
		compania.agregarPlan(planBasico1);

		// CANALES BASICOS
		Integer numeroCanal1 = 10;
		String nombreCanal1 = "Telefe";
		Canal canal10 = new Canal(numeroCanal1, nombreCanal1, TipoDeCanal.VARIOS, TipoClasificacion.BASICO);

		Integer numeroCanal13 = 13;
		String nombreCanal13 = "Trece";
		Canal canal13 = new Canal(numeroCanal13, nombreCanal13, TipoDeCanal.VARIOS, TipoClasificacion.BASICO);

		Integer numeroCanal9 = 9;
		String nombreCanal9 = "Nueve";
		Canal canal9 = new Canal(numeroCanal9, nombreCanal9, TipoDeCanal.VARIOS, TipoClasificacion.BASICO);

		// CANALES PREMIUN
		Integer numeroCanal40 = 40;
		String nombreCanal40 = "FOX";
		Canal canal40 = new Canal(numeroCanal40, nombreCanal40, TipoDeCanal.VARIOS, TipoClasificacion.PREMIUM);

		Integer numeroCanal41 = 41;
		String nombreCanal41 = "FOX-PREMIUM";
		Canal canal41 = new Canal(numeroCanal41, nombreCanal41, TipoDeCanal.DEPORTE, TipoClasificacion.PREMIUM);

		Integer numeroCanal42 = 42;
		String nombreCanal42 = "FOX-SPORTS";
		Canal canal42 = new Canal(numeroCanal42, nombreCanal42, TipoDeCanal.DEPORTE, TipoClasificacion.PREMIUM);

		Integer numeroCanal50 = 50;
		String nombreCanal50 = "DISNEY-PLUS";
		Canal canal50 = new Canal(numeroCanal50, nombreCanal50, TipoDeCanal.INFANTIL, TipoClasificacion.PREMIUM);

		compania.agregarCanal(canal10);
		compania.agregarCanal(canal13);
		compania.agregarCanal(canal9);
		compania.agregarCanal(canal40);
		compania.agregarCanal(canal41);
		compania.agregarCanal(canal42);
		compania.agregarCanal(canal50);

		HashSet<Canal> listadoPlanes = compania.obtenerListadoDeCanales();

		Suscripcion suscripcion1 = new Suscripcion(cliente1, planBasico1, listadoPlanes);
		Suscripcion suscripcion2 = new Suscripcion(cliente2, planPremiun4, listadoPlanes);
		Suscripcion suscripcion3 = new Suscripcion(cliente3, planBasico1, listadoPlanes);

		compania.agregarSuscripcion(suscripcion1); // 5000
		compania.agregarSuscripcion(suscripcion2); // 6000
		compania.agregarSuscripcion(suscripcion3); // 5000

		Double resultadoEsperado = 16000D;
		Double resultadObtenido = compania.obtenerPrecioDeLasSuscripciones();

		assertEquals(resultadoEsperado, resultadObtenido);

		Double resultadoEsperado2 = 10000D;
		Double resultadObtenido2 = compania.obtenerTotalDeLasSuscripcionesBasicas();

		assertEquals(resultadoEsperado2, resultadObtenido2);

		Double resultadoEsperado3 = 6000D;
		Double resultadObtenido3 = compania.obtenerTotalDeLasSuscripcionesPremium();

		assertEquals(resultadoEsperado3, resultadObtenido3);

	}

	@Test
	public void dadoQueExisteUnCompaniaConClientesSuscritosAPlanesBasicosOPremiumSePuedeObtnerUnMapaConElPlanComoClaveYUnaListaDeClientesOrdenadosDeManeraDescendentePorDniDelClienteComoValores()
			throws ClienteYaSuscriptoException, ClienteExistenteException {
		// CLIENTES
		Integer dni = 1234;
		String nombre = "Mariana";
		String apellido = "Vetrano";
		Integer edad = 33;

		Cliente cliente1 = new Cliente(dni, nombre, apellido, edad);
		// CLIENTE 2
		Integer dni2 = 8989;
		String nombre2 = "Agustin";
		String apellido2 = "Castellano";
		Integer edad2 = 48;
		Cliente cliente2 = new Cliente(dni2, nombre2, apellido2, edad2);

		// CLIENTE 3
		Integer dni3 = 1233;
		String nombre3 = "Lara";
		String apellido3 = "Daniela";
		Integer edad3 = 32;

		Cliente cliente3 = new Cliente(dni3, nombre3, apellido3, edad3);

		compania.agregarCliente(cliente1);
		compania.agregarCliente(cliente2);
		compania.agregarCliente(cliente3);

		// PLANES PREMIUN ;

		Integer IdPlan3 = 17;
		String nombrePlan3 = "HD-PLUS";
		Plan planPremiun3 = new PlanPremium(IdPlan3, nombrePlan3);

		Integer IdPlan4 = 18;
		String nombrePlan4 = "FULL-MAX";
		Plan planPremiun4 = new PlanPremium(IdPlan4, nombrePlan4);

		// PLANES BASICOS (3)

		Integer IdPlan5 = 1;
		String nombrePlan5 = "FULL-MAX";
		Plan planBasico1 = new PlanBasico(IdPlan5, nombrePlan5);

		// PLANES BASICOS (3)

		Integer IdPlan6 = 99;
		String nombrePlan6 = "FULL-MAX";
		Plan planBasico6 = new PlanBasico(IdPlan6, nombrePlan6);
		// AGREGAR PLANES A LA COMPANIA

		compania.agregarPlan(planPremiun3);
		compania.agregarPlan(planPremiun4);
		compania.agregarPlan(planBasico1);
		compania.agregarPlan(planBasico6);

		// CANALES BASICOS
		Integer numeroCanal1 = 10;
		String nombreCanal1 = "Telefe";
		Canal canal10 = new Canal(numeroCanal1, nombreCanal1, TipoDeCanal.VARIOS, TipoClasificacion.BASICO);

		Integer numeroCanal13 = 13;
		String nombreCanal13 = "Trece";
		Canal canal13 = new Canal(numeroCanal13, nombreCanal13, TipoDeCanal.VARIOS, TipoClasificacion.BASICO);

		Integer numeroCanal9 = 9;
		String nombreCanal9 = "Nueve";
		Canal canal9 = new Canal(numeroCanal9, nombreCanal9, TipoDeCanal.VARIOS, TipoClasificacion.BASICO);

		// CANALES PREMIUN
		Integer numeroCanal40 = 40;
		String nombreCanal40 = "FOX";
		Canal canal40 = new Canal(numeroCanal40, nombreCanal40, TipoDeCanal.VARIOS, TipoClasificacion.PREMIUM);

		Integer numeroCanal41 = 41;
		String nombreCanal41 = "FOX-PREMIUM";
		Canal canal41 = new Canal(numeroCanal41, nombreCanal41, TipoDeCanal.DEPORTE, TipoClasificacion.PREMIUM);

		Integer numeroCanal42 = 42;
		String nombreCanal42 = "FOX-SPORTS";
		Canal canal42 = new Canal(numeroCanal42, nombreCanal42, TipoDeCanal.DEPORTE, TipoClasificacion.PREMIUM);

		Integer numeroCanal50 = 50;
		String nombreCanal50 = "DISNEY-PLUS";
		Canal canal50 = new Canal(numeroCanal50, nombreCanal50, TipoDeCanal.INFANTIL, TipoClasificacion.PREMIUM);

		compania.agregarCanal(canal10);
		compania.agregarCanal(canal13);
		compania.agregarCanal(canal9);
		compania.agregarCanal(canal40);
		compania.agregarCanal(canal41);
		compania.agregarCanal(canal42);
		compania.agregarCanal(canal50);

		HashSet<Canal> listadoPlanes = compania.obtenerListadoDeCanales();

		Suscripcion suscripcion1 = new Suscripcion(cliente1, planBasico1, listadoPlanes);
		Suscripcion suscripcion2 = new Suscripcion(cliente2, planPremiun4, listadoPlanes);
		Suscripcion suscripcion3 = new Suscripcion(cliente3, planBasico1, listadoPlanes);

		compania.agregarSuscripcion(suscripcion1);
		compania.agregarSuscripcion(suscripcion2);
		compania.agregarSuscripcion(suscripcion3);

		Map<Plan, Set<Cliente>> reporte = compania.obtenerReporteDePlanes();

		assertTrue(reporte.containsKey(planBasico1));
		assertTrue(reporte.containsKey(planPremiun4));
		assertFalse(reporte.containsKey(planBasico6));

		Set<Cliente> clientesBasico = reporte.get(planBasico1);
		Set<Cliente> clientesPremium = reporte.get(planPremiun4);

		assertNotNull(clientesBasico);
		assertNotNull(clientesPremium);

		assertEquals(2, clientesBasico.size()); // PARA EL PLAN BASICO TIENE DOS CLIENTES
		assertEquals(1, clientesPremium.size());
	}

}

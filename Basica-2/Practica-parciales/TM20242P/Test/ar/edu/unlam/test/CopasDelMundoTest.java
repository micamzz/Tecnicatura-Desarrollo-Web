package ar.edu.unlam.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.dominio.Cliente;
import ar.edu.unlam.dominio.ClienteDuplicadoException;
import ar.edu.unlam.dominio.Copa;
import ar.edu.unlam.dominio.CopaDelMundoNoEncontradaException;
import ar.edu.unlam.dominio.CopaEstandar;
import ar.edu.unlam.dominio.CopaPersonalizada;
import ar.edu.unlam.dominio.Fabrica;
import ar.edu.unlam.dominio.TipoMaterial;
import ar.edu.unlam.dominio.tipoAtril;

public class CopasDelMundoTest {

	Fabrica fabrica;

	@Before
	public void inicializacion() {
		fabrica = new Fabrica();
	}

	@Test
	public void dadoQueExisteUnaFabricaDeCopasDelMundoSePuedeAgregarUnaCopaDelMundoEstandar() {
		TipoMaterial tipo = TipoMaterial.YESO;
		Copa copaEstandar = new CopaEstandar(tipo);
		Boolean seAgrego = fabrica.agregarCopaDelMundo(copaEstandar);
		assertTrue(seAgrego);
	}

	@Test
	public void dadoQueExisteUnaFabricaDeCopasDelMundoSePuedeAgregarUnaCopaDelMundoPersonalizada() {

		TipoMaterial tipoMaterial = TipoMaterial.YESO;
		tipoAtril tipoColor = tipoAtril.ROBLE_OSCURO;

		Copa copaPersonalizada = new CopaPersonalizada(tipoMaterial, tipoColor);
		Boolean seAgrego = fabrica.agregarCopaDelMundo(copaPersonalizada);
		assertTrue(seAgrego);

	}

	@Test(expected = ClienteDuplicadoException.class)
	public void dadoQueExisteUnaFabricaDeCopasDelMundoAlAgregarUnClienteExistenteSeLanzaUnaClienteDuplicadoException()
			throws ClienteDuplicadoException {

		Cliente cliente1 = new Cliente("Carlos", "Baute", 12345);
		Cliente cliente2 = new Cliente("Oscar", "Sosa", 12345);

		fabrica.agregarCliente(cliente1);
		fabrica.agregarCliente(cliente2);

	}

	@Test

	public void dadoQueExisteUnaFabricaQuePoseeCopasDelMundoSePuedenObtenerLasCopasDelMundoEstandar() {

		TipoMaterial tipo = TipoMaterial.YESO;
		Copa copaEstandar = new CopaEstandar(tipo);
		fabrica.agregarCopaDelMundo(copaEstandar);

		TipoMaterial tipo2 = TipoMaterial.RESINA;
		Copa copaEstandar2 = new CopaEstandar(tipo2);
		fabrica.agregarCopaDelMundo(copaEstandar2);

		TipoMaterial tipo3 = TipoMaterial.YESO;
		Copa copaEstandar3 = new CopaEstandar(tipo3);
		fabrica.agregarCopaDelMundo(copaEstandar3);

		TipoMaterial tipoMaterial = TipoMaterial.YESO;
		tipoAtril tipoColor = tipoAtril.ROBLE_OSCURO;
		Copa copaPersonalizada = new CopaPersonalizada(tipoMaterial, tipoColor);

		fabrica.agregarCopaDelMundo(copaPersonalizada);

		ArrayList<CopaEstandar> listadoObtenido = fabrica.obtenerCopasDelMundoEstadandar();

		assertEquals(3, listadoObtenido.size());
		assertFalse(listadoObtenido.contains(copaPersonalizada));
	}

	@Test
	public void dadoQueExisteUnaFabricaDeCopasDelMundoConCopasDelMundoPuedoObtenerUnaCopaDelMundoPorSuId()
			throws CopaDelMundoNoEncontradaException {

		TipoMaterial tipo = TipoMaterial.YESO;
		Copa copaEstandar = new CopaEstandar(tipo);
		fabrica.agregarCopaDelMundo(copaEstandar);

		TipoMaterial tipo2 = TipoMaterial.RESINA;
		Copa copaEstandar2 = new CopaEstandar(tipo2);
		fabrica.agregarCopaDelMundo(copaEstandar2);

		TipoMaterial tipoMaterial = TipoMaterial.YESO;
		tipoAtril tipoColor = tipoAtril.ROBLE_OSCURO;
		Copa copaPersonalizada = new CopaPersonalizada(tipoMaterial, tipoColor);
		fabrica.agregarCopaDelMundo(copaPersonalizada);

		Integer idBuscado = copaPersonalizada.getId();
		System.out.println(idBuscado);

		Copa resultadoObtenido = fabrica.obtenerCopaPorId(idBuscado);

		assertEquals(copaPersonalizada, resultadoObtenido);

	}

	@Test(expected = CopaDelMundoNoEncontradaException.class)
	public void dadoQueExisteUnaFabricaDeCopasDelMundoConCopasDelMundoPuedoObtenerUnaCopaDelMundoPorSuIdSeObtieneUnaExcepcion()
			throws CopaDelMundoNoEncontradaException {

		TipoMaterial tipo = TipoMaterial.YESO;
		Copa copaEstandar = new CopaEstandar(tipo);
		fabrica.agregarCopaDelMundo(copaEstandar);

		TipoMaterial tipo2 = TipoMaterial.RESINA;
		Copa copaEstandar2 = new CopaEstandar(tipo2);
		fabrica.agregarCopaDelMundo(copaEstandar2);

		TipoMaterial tipoMaterial = TipoMaterial.YESO;
		tipoAtril tipoColor = tipoAtril.ROBLE_OSCURO;
		Copa copaPersonalizada = new CopaPersonalizada(tipoMaterial, tipoColor);
		fabrica.agregarCopaDelMundo(copaPersonalizada);

		Integer idBuscado = 8;

		Copa resultadoObtenido = fabrica.obtenerCopaPorId(idBuscado);

	}

	@Test
	public void dadoQueExisteUnaFabricaDeCopasAlAgregarCincoCopasDelMundoAUnaVentaDeCopasDelMundoEstandarParaUnClienteSeDescuentanCincoUnidadesDelStockDeCopasDelMundoEstandar()
			throws ClienteDuplicadoException, CopaDelMundoNoEncontradaException {
		TipoMaterial tipo = TipoMaterial.YESO;
		Copa copaEstandar = new CopaEstandar(tipo);
		fabrica.agregarCopaDelMundo(copaEstandar);

		TipoMaterial tipo2 = TipoMaterial.RESINA;
		Copa copaEstandar2 = new CopaEstandar(tipo2);
		fabrica.agregarCopaDelMundo(copaEstandar2);

		TipoMaterial tipo3 = TipoMaterial.YESO;
		Copa copaEstandar3 = new CopaEstandar(tipo3);
		fabrica.agregarCopaDelMundo(copaEstandar3);

		TipoMaterial tipo4 = TipoMaterial.YESO;
		Copa copaEstandar4 = new CopaEstandar(tipo4);
		fabrica.agregarCopaDelMundo(copaEstandar4);

		TipoMaterial tipo5 = TipoMaterial.RESINA;
		Copa copaEstandar5 = new CopaEstandar(tipo5);
		fabrica.agregarCopaDelMundo(copaEstandar5);

		TipoMaterial tipo6 = TipoMaterial.YESO;
		Copa copaEstandar6 = new CopaEstandar(tipo6);
		fabrica.agregarCopaDelMundo(copaEstandar6);

		Cliente cliente1 = new Cliente("Carlos", "Baute", 12345);
		fabrica.agregarCliente(cliente1);

		fabrica.realizarUnaVenta(cliente1, copaEstandar);
		fabrica.realizarUnaVenta(cliente1, copaEstandar2);
		fabrica.realizarUnaVenta(cliente1, copaEstandar3);
		
		Integer resultadoEsperado = 97;
		assertEquals(resultadoEsperado, fabrica.chequearStock());

	}

	@Test
	public void dadoQueExisteUnaFabricaDeCopasDelMundoConCopasDelMundoAlAgregarUnaVentaDeCopasDelMundoPersonalizadaParaUnClienteSeRemueveLaCopaDelMundoPersonalizadaDeLaFabrica()
			throws ClienteDuplicadoException, CopaDelMundoNoEncontradaException {

		TipoMaterial tipoMaterial = TipoMaterial.YESO;
		tipoAtril tipoColor = tipoAtril.ROBLE_OSCURO;
		Copa copaPersonalizada = new CopaPersonalizada(tipoMaterial, tipoColor);
		fabrica.agregarCopaDelMundo(copaPersonalizada);

		TipoMaterial tipoMaterial2 = TipoMaterial.YESO;
		tipoAtril tipoColor2 = tipoAtril.ROBLE_OSCURO;
		Copa copaPersonalizada2 = new CopaPersonalizada(tipoMaterial2, tipoColor2);
		fabrica.agregarCopaDelMundo(copaPersonalizada2);

		TipoMaterial tipoMaterial3 = TipoMaterial.YESO;
		tipoAtril tipoColor3 = tipoAtril.ROBLE_OSCURO;
		Copa copaPersonalizada3 = new CopaPersonalizada(tipoMaterial3, tipoColor3);
		fabrica.agregarCopaDelMundo(copaPersonalizada3);

		Cliente cliente1 = new Cliente("Carlos", "Baute", 12345);
		fabrica.agregarCliente(cliente1);

		Integer valorEsperado = 3;
		Integer valorObtenido = fabrica.obtenerCantidadDeCopas();
		assertEquals(valorEsperado, valorObtenido);

		fabrica.realizarUnaVenta(cliente1, copaPersonalizada2);

		Integer valorEsperado2 = 2;
		Integer valorObtenido2 = fabrica.obtenerCantidadDeCopas();
		assertEquals(valorEsperado2, valorObtenido2);
	}

	@Test

	public void dadoQueExisteUnaFabricaDeCopasDelMundoConCopasDelMundoPersonalizadasSePuedeObtenerElPrecioDeUnaCopaDelMundoPersonalizada()
			throws ClienteDuplicadoException {

		TipoMaterial tipoMaterial3 = TipoMaterial.YESO;
		tipoAtril tipoColor3 = tipoAtril.ROBLE_OSCURO;
		Copa copaPersonalizada3 = new CopaPersonalizada(tipoMaterial3, tipoColor3);
		fabrica.agregarCopaDelMundo(copaPersonalizada3);

		Cliente cliente1 = new Cliente("Carlos", "Baute", 12345);
		fabrica.agregarCliente(cliente1);

		Double valorEsperado = 2600D;
		Double valorObtenido = fabrica.calcularPrecioFinal();
		assertEquals(valorEsperado, valorObtenido);
	}

	@Test

	public void dadoQueExisteUnaFabricaDeCopasDelMundoConVentasDeCopasDelMundoEstandarYPersonalizadasVendidasAClientesSePuedeObtenerUnMapaConClaveClienteYTotalDeVentasDeCopasEstandarOrdenadoPorCliente()
			throws ClienteDuplicadoException, CopaDelMundoNoEncontradaException {

		TipoMaterial tipo = TipoMaterial.YESO;
		Copa copaEstandar = new CopaEstandar(tipo);
		fabrica.agregarCopaDelMundo(copaEstandar);

		TipoMaterial tipo2 = TipoMaterial.RESINA;
		Copa copaEstandar2 = new CopaEstandar(tipo2);
		fabrica.agregarCopaDelMundo(copaEstandar2);

		TipoMaterial tipo3 = TipoMaterial.YESO;
		Copa copaEstandar3 = new CopaEstandar(tipo3);
		fabrica.agregarCopaDelMundo(copaEstandar3);

		TipoMaterial tipo4 = TipoMaterial.YESO;
		Copa copaEstandar4 = new CopaEstandar(tipo4);
		fabrica.agregarCopaDelMundo(copaEstandar4);

		TipoMaterial tipo5 = TipoMaterial.RESINA;
		Copa copaEstandar5 = new CopaEstandar(tipo5);
		fabrica.agregarCopaDelMundo(copaEstandar5);

		TipoMaterial tipo6 = TipoMaterial.YESO;
		Copa copaEstandar6 = new CopaEstandar(tipo6);
		fabrica.agregarCopaDelMundo(copaEstandar6);

		Cliente cliente1 = new Cliente("Carlos", "Baute", 12345);
		fabrica.agregarCliente(cliente1);

		Cliente cliente2 = new Cliente("Carlos", "Basd", 55555);
		fabrica.agregarCliente(cliente2);

		Cliente cliente3 = new Cliente("Cas", "menen", 7777);
		fabrica.agregarCliente(cliente3);

		fabrica.realizarUnaVenta(cliente1, copaEstandar);
		fabrica.realizarUnaVenta(cliente1, copaEstandar2);
		// 2 copas
		fabrica.realizarUnaVenta(cliente2, copaEstandar5);
		fabrica.realizarUnaVenta(cliente2, copaEstandar6);
		// cliente 3 sin copas

		TreeMap<Cliente, ArrayList<CopaEstandar>> reporte = fabrica.obtenerReporteEstandar();

		assertTrue(reporte.containsKey(cliente1));
		assertTrue(reporte.containsKey(cliente2));
		assertFalse(reporte.containsKey(cliente3));
	}
}

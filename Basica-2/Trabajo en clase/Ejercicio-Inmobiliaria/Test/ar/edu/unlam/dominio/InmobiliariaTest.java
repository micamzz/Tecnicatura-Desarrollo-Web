package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

public class InmobiliariaTest {

	// CASO 1
	/*
	 * 1. Agregar nuevas propiedades (Las propiedades se pueden repetir, porque
	 * distintos vendedores pueden cargar una misma propiedad con diferentes valores
	 * de venta por ejemplo)
	 */
	@Test
	public void dadoQueSeQuiereAgregarUnaPropiedadVerificarQueSePuedaRepetir() {

		Inmobiliaria primerCaso = new Inmobiliaria();

		Propiedad primeraPropiedad = new Propiedad("Moron", 65.000, 00001);
		Propiedad segundaPropiedad = new Propiedad("Castelar", 69.000, 00002);
		Propiedad terceraPropiedad = new Propiedad("Moron", 68.000, 00001);

		boolean seAgregoPropiedad1 = primerCaso.agregarPropiedadAlArray(primeraPropiedad);
		boolean seAgregoPropiedad2 = primerCaso.agregarPropiedadAlArray(segundaPropiedad);
		boolean seAgregoPropiedad3 = primerCaso.agregarPropiedadAlArray(terceraPropiedad);

		assertTrue(seAgregoPropiedad1);
		assertTrue(seAgregoPropiedad2);
		assertTrue(seAgregoPropiedad3);

	}
	
	@Test 
	public void dadoQueSeBuscaUnaPropiedadPorElCodigoModificarElvalor() {
	
		Inmobiliaria primerCaso = new Inmobiliaria();

		Propiedad primeraPropiedad = new Propiedad("Moron", 65.000, 2223);
		Propiedad segundaPropiedad = new Propiedad("Castelar", 69.000, 2224);
		Propiedad terceraPropiedad = new Propiedad("Moron", 68.000, 2225);

		 primerCaso.agregarPropiedadAlArray(primeraPropiedad);
		 primerCaso.agregarPropiedadAlArray(segundaPropiedad);
		 primerCaso.agregarPropiedadAlArray(terceraPropiedad);
		 
		 //CAMBIA EL VALOR DE LA SEGUNDA PROPIEDAD 
	     primerCaso.modificarElPrecioDeLaPropiedadPorCodigo(2224, 15.000);
		
		Double valorEsperado = 15.000;
		
		
		Double valorObtenido = segundaPropiedad.getPrecio();
		
		assertEquals(valorEsperado, valorObtenido);
	
	}
	


	/*
	 * 3. Agregar clientes (Son aquellos que se encuentran en búsqueda de una
	 * propiedad. No se puede agregar dos clientes con un mismo DNI)
	 * 
	 */
	@Test
	public void dadoQueSeQuiereAgregarUnNuevoClienteSiElDniYaExisteQueNoPuedaAgregarse() {

		Inmobiliaria primerCaso = new Inmobiliaria();

		Cliente primerCliente = new Cliente("MARIA", "LOPEZ", 12345);

		Cliente segundoCliente = new Cliente("CARLOS", "LOPEZ", 12345);

		Cliente tercerCliente = new Cliente("Pedro", "rojo", 7777);
		Cliente cuartoCliente = new Cliente("Gustavo", "dominguez", 7777);

		boolean clienteAgregado1 = primerCaso.agregarUnCliente(primerCliente);
		boolean clienteAgregado2 = primerCaso.agregarUnCliente(segundoCliente);
		boolean clienteAgregado3 = primerCaso.agregarUnCliente(tercerCliente);
		boolean clienteAgregado4 = primerCaso.agregarUnCliente(cuartoCliente);

		assertTrue(clienteAgregado1); // True si el cliente se agrego
		assertFalse(clienteAgregado2); // False si el cliente no se pudo agregar.
		assertTrue(clienteAgregado3); // True porque el DNI es diferente
		// assertTrue(clienteAgregado4); falla deberia ser false.
	}

	@Test
	public void dadoQuePasaUnPrecioPorParametroBuscaLaPropiedadConEsePrecio() {

		Inmobiliaria primerCaso = new Inmobiliaria();

		Propiedad primeraPropiedad = new Propiedad("Moron", 65.000, 00001);
		Propiedad segundaPropiedad = new Propiedad("Castelar", 65.000, 00002);
		Propiedad terceraPropiedad = new Propiedad("Moron", 69.000, 00003);

		primerCaso.agregarPropiedadAlArray(primeraPropiedad);
		primerCaso.agregarPropiedadAlArray(segundaPropiedad);
		primerCaso.agregarPropiedadAlArray(terceraPropiedad);

		// Propiedad valorEsperado = segundaPropiedad; NO PASA
		
		Propiedad valorEsperado = terceraPropiedad; // PASA 
		Propiedad valorBuscado = primerCaso.buscarPropiedadPorPrecio(69.000);
		
		assertEquals(valorEsperado, valorBuscado);
		
		// El metodo devuelve una propiedad , que se deberia usar para el test?
		
		Propiedad valorEsperado2 = primeraPropiedad; // PASA 
		Propiedad valorBuscado2 = primerCaso.buscarPropiedadPorPrecio(65.000);
		
		
		assertEquals(valorEsperado2, valorBuscado2);
	}

	@Test
	 public void dadoQuePasaUnaUbicacionPorParametroBuscaLaPropiedadQueEstaEnEsaUbicacion() {
		
		Inmobiliaria primerCaso = new Inmobiliaria();

		Propiedad primeraPropiedad = new Propiedad("Moron", 65.000, 00001);
		Propiedad segundaPropiedad = new Propiedad("Castelar", 65.000, 00002);
		Propiedad terceraPropiedad = new Propiedad("Moron", 69.000, 00003);

		primerCaso.agregarPropiedadAlArray(primeraPropiedad);
		primerCaso.agregarPropiedadAlArray(segundaPropiedad);
		primerCaso.agregarPropiedadAlArray(terceraPropiedad);

		 // Test 1: Morón → debería devolver [primeraPropiedad, terceraPropiedad]
	    ArrayList<Propiedad> esperadoMoron = new ArrayList<>();
	    esperadoMoron.add(primeraPropiedad);
	    esperadoMoron.add(terceraPropiedad);

	    ArrayList<Propiedad> resultadoMoron = primerCaso.buscarPropiedadesPorUbicacion("Moron");
	    assertEquals(esperadoMoron, resultadoMoron);

	    // Test 2: Castelar → debería devolver [segundaPropiedad]
	    ArrayList<Propiedad> esperadoCastelar = new ArrayList<>();
	    esperadoCastelar.add(segundaPropiedad);

	    ArrayList<Propiedad> resultadoCastelar = primerCaso.buscarPropiedadesPorUbicacion("Castelar");
	    assertEquals(esperadoCastelar, resultadoCastelar);

	    // Test 3: Ubicación inexistente → lista vacía
	    ArrayList<Propiedad> esperadoNada = new ArrayList<>();
	    ArrayList<Propiedad> resultadoNada = primerCaso.buscarPropiedadesPorUbicacion("Haedo");
	    assertEquals(esperadoNada, resultadoNada);
		
//		Propiedad valorEsperado = primeraPropiedad; // PASA 
//		ArrayList<Propiedad> valorBuscado = primerCaso.buscarPropiedadesPorUbicacion("Moron");
//		
//		assertEquals(valorEsperado, valorBuscado);
//		
//		// ESTE TEST NO PASA, PORQ ENCUENTRA A LA PRIMERA PROPIEDAD 
//		Propiedad valorEsperado2 = terceraPropiedad;
//		ArrayList<Propiedad>valorBuscado2 = primerCaso.buscarPropiedadesPorUbicacion("Moron");
//		
//		assertEquals(valorEsperado2, valorBuscado2);
//		
//		
//		// El metodo devuelve una propiedad , que se deberia usar para el test?
//		
//		Propiedad  valorEsperado3 = segundaPropiedad; // PASA 
//		ArrayList<Propiedad> valorBuscado3 = primerCaso.buscarPropiedadesPorUbicacion("Castelar");
//		
//		assertEquals(valorEsperado3, valorBuscado3);

	}
	
	@Test

	public void dadoQueSeSeBuscaUnaPropiedadPorCodigoSeRealizaLaVentaDeEsaPropiedad() {

		Inmobiliaria primerCaso = new Inmobiliaria();

		Propiedad primeraPropiedad = new Propiedad("Moron", 65.000, 00001);
		Propiedad segundaPropiedad = new Propiedad("Castelar", 65.000, 00002);
		Propiedad terceraPropiedad = new Propiedad("Moron", 69.000, 00003);

		// AGREGAR LAS PROPIEDADES A LA COLECCION
		primerCaso.agregarPropiedadAlArray(primeraPropiedad);
		primerCaso.agregarPropiedadAlArray(segundaPropiedad);
		primerCaso.agregarPropiedadAlArray(terceraPropiedad);

		// REALIZA VENTA DE UNA PROPIEDAD
		primerCaso.realizarVentaDeUnaPropiedad(00001); // SE BUSCA POR CODIGO
		

		boolean resultadoDeLaPropiedadVendida = primeraPropiedad.getEstaVendida();
		boolean resultadoDePropiedadNovendida = segundaPropiedad.getEstaVendida();

	   //DE LA PROPIEDAD VENDIDA --> TRUE / PROP.NO VENDIDA --> FALSE
		assertTrue(resultadoDeLaPropiedadVendida);
		assertFalse(resultadoDePropiedadNovendida);

	}

}

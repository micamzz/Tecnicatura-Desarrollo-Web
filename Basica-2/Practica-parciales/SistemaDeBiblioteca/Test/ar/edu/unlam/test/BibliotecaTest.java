package ar.edu.unlam.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import org.junit.Before;
import org.junit.Test;
import ar.edu.unlam.dominio.*;

public class BibliotecaTest {

	private Biblioteca nuevaBiblio;
	private Libro libroHistoria;
	private Libro libroGeografia ;
	private Libro libroMate;
	private Estudiante estudiante;
	private Estudiante estudiante2;
	
	
	@Before 
	public void inicializacionDeVariables() {
		nuevaBiblio = new Biblioteca();
		libroMate = new Matematica(001, "polinomios", "moyano,carlos");
		libroGeografia = new Geografia(005,"Geografia Argentina", "Carla Lopez");
		libroHistoria = new Historia(010,"Historia Argentina","Gustavo Domingez");
		estudiante = new Estudiante(38662441, "Marcos","Lopez");
		estudiante2 = new Estudiante(3656271, "Cinthia", "Fernandez");

		nuevaBiblio.agregarLibro(libroMate);
		nuevaBiblio.agregarLibro(libroGeografia);
		nuevaBiblio.agregarLibro(libroHistoria);
	
	}
	
	
	
	@Test
	public void dadoQueHayUnLibroDisponibleElEstudiantePuedePedirlo() {
	
		Boolean sePresto = nuevaBiblio.prestarLibro(libroGeografia, estudiante);
		assertTrue(sePresto);
	
	}
	
	
	@Test
	public void dadoQueUnLibroFuePrestadoOtroEstudianteNoPuedePedirlo() {
		
		nuevaBiblio.prestarLibro(libroGeografia, estudiante);
		Boolean noSePudo= nuevaBiblio.prestarLibro(libroGeografia, estudiante2);
		
		assertFalse(noSePudo);	
	}
	
	@Test
	public void dadoQueUnEstudiantePidio2LibrosNoPuedeSolicitarOtroMas() {
		
		Boolean sePresto = nuevaBiblio.prestarLibro(libroGeografia, estudiante);
		Boolean sePresto2 = nuevaBiblio.prestarLibro(libroHistoria, estudiante);
		Boolean sePresto3 = nuevaBiblio.prestarLibro(libroMate, estudiante);
		
		assertTrue(sePresto);
		assertTrue(sePresto2);
		assertFalse(sePresto3);
		
		Integer resultadoEsperado = 2;
		Integer resultadoObtenido = estudiante.getLibrosPrestados();
		assertEquals(resultadoEsperado,resultadoObtenido);
		
	}
	
	
	@Test 
	
	public void dadoQueUnLibroPrestadoFueDevueltoSePuedePrestarDeNuevo() {

		Boolean sePresto = nuevaBiblio.prestarLibro(libroGeografia, estudiante);
		assertTrue(sePresto);
		nuevaBiblio.devolverLibro(libroGeografia,estudiante);
		
		Integer resultadoEsperado =0;
		Integer resultadoObtenido = estudiante.getLibrosPrestados();
		assertEquals(resultadoEsperado,resultadoObtenido);
		
		Boolean sePresto2 = nuevaBiblio.prestarLibro(libroGeografia, estudiante2);
		assertTrue(sePresto2);
		
	}
	@Test
	public void dadoQueHayUnLibroDeMatematicaFotocopiableSePuedeObtenerSuTexto() {

	    String resultadoEsperado="libro de matematica";
	    String resultadoObtenido = nuevaBiblio.obtenerFotocopiable();
	    
		assertEquals(resultadoEsperado,resultadoObtenido);
	    
	}

}

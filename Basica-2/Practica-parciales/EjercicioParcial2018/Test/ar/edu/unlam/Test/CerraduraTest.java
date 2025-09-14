package ar.edu.unlam.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.dominio.Cerradura;

public class CerraduraTest {

	private Cerradura nuevaCerradura;
	@Before
	
	
	public void instanciarCerraduraDePrueba() {
		
   nuevaCerradura = new Cerradura(98765, 3);
		
	}
	
	
	@Test
	public void dadoQueEsUnaCerraduraNuevaVerificarQueEsteCerrada() {

		assertTrue(nuevaCerradura.estaCerrada());
		assertFalse(nuevaCerradura.estaAbierta());
	}
	
	
	@Test
	public void dadoQueIngresoUnaClaveCorrectaLaCerraduraSeAbre() {

		nuevaCerradura.abrirCerradura(98765);
		assertTrue(nuevaCerradura.estaAbierta());

	}

	@Test
	public void dadoQueIngresoUnaClaveIncorrectaLaCerraduraNoSeAbre() {

		nuevaCerradura.abrirCerradura(987533);
    	assertFalse(nuevaCerradura.estaAbierta());
	}

	
	@Test
	public void dadoQueSeIngresaMalLaContrasenia3VecesSeBloquea() {
		
		nuevaCerradura.abrirCerradura(324324);
		nuevaCerradura.abrirCerradura(1234);
		nuevaCerradura.abrirCerradura(3122);
		
		assertTrue(nuevaCerradura.fueBloqueada());
	
	}
	
	@Test
	public void dadoQueSeIngresaMalLaContrasenia2SeObtiene2intentosfallidos() {

		nuevaCerradura.abrirCerradura(324324);
		nuevaCerradura.abrirCerradura(1234);
		
		Integer valorEsperado = 2;
		Integer valorObtenido = nuevaCerradura.contarAperturasFallidas();
		
		assertEquals(valorEsperado,valorObtenido);
	}

	@Test
	public void dadoQueLaCerraduraEstaBloqueadaNoSePuedeAbrirConClaveCorrecta() {
		
		nuevaCerradura.abrirCerradura(324324);
		nuevaCerradura.abrirCerradura(1234);
		nuevaCerradura.abrirCerradura(3224);
		
		assertTrue(nuevaCerradura.fueBloqueada());
		
		nuevaCerradura.abrirCerradura(98765);
		
		assertFalse(nuevaCerradura.estaAbierta());
	}
}

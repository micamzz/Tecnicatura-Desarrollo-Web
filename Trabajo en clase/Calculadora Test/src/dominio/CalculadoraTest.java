package dominio;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class CalculadoraTest {

	private Calculadora calculadoraMica;

	@Before
	public void inicializacion() {
		this.calculadoraMica = new Calculadora();
	}

	@Test
	public void laSumaDe4Mas8es12() {
		// Preparacion

		Integer resultadoEsperado = 12;

		// ejecucion

		// verificacion

		assertEquals(resultadoEsperado, calculadoraMica.sumar(4, 8));
	}

	@Test
	public void laRestaDe215menos76es139() {
		Integer resultadoEsperado = 139;

		assertEquals(resultadoEsperado, calculadoraMica.restar(215, 76));

	}

	@Test
	public void multiplicar9Por8da72() {
		Integer resultadoEsperado = 72;

		assertEquals(resultadoEsperado, calculadoraMica.multiplicar(9, 8));

	}

	@Test
	public void dividir15por0da0() {
		Integer resultadoEsperado = 0;

		assertEquals(resultadoEsperado, calculadoraMica.dividir(15, 0));

	}

}

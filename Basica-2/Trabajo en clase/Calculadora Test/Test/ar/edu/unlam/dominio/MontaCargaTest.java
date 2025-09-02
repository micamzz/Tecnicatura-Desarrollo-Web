package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MontaCargaTest {

	@Test

	public void dadoQueNoExisteUnaCargaAlCrearLaMismaSePuedeObtenerSuPeso() {

		Double peso = 100.0;
		Carga carga = new Carga(peso);

		Double valorEsperado = 100.0;
		Double valorObtenenido = carga.getPeso();

		assertEquals(valorEsperado, valorObtenenido);
	}

	@Test

	public void dadoQueNoExisteUnMontaCargaAlCrearLaMismaSePuedeObtenerSuPesoMaximoPermitido() {

		Double pesoMaximoPermitido = 1000.0;
		MontaCarga montaCarga = new MontaCarga(pesoMaximoPermitido);

		Double valorEsperado = 1000.0;
		Double valorObtenenido = montaCarga.getPesoMaximoPermitido();

		assertEquals(valorEsperado, valorObtenenido);

	}

	@Test
	public void dadoQueExisteUnMontaCargaVerificarQueSePuedaSubirUnaCarga() {
		Double peso = 100.0;
		Carga carga = new Carga(peso);

		Double pesoMaximoPermitido = 1000.0;
		MontaCarga montaCarga = new MontaCarga(pesoMaximoPermitido);

		montaCarga.cargar(carga);

		Integer valorEsperado = 1;
		Integer valorObtenenido = montaCarga.obtenerCantidadDeCargas();

		assertEquals(valorEsperado, valorObtenenido);
	}

	@Test
	public void dadoQueExisteUnMontaCargaYUnaCargaCuandoSuboLaCargaVerificarElPesoCargado() {

		Double peso = 100.0;
		Carga carga = new Carga(peso);
		Carga carga2 = new Carga(200.0);

		Double pesoMaximoPermitido = 1000.0;
		MontaCarga montaCarga = new MontaCarga(pesoMaximoPermitido);

		montaCarga.cargar(carga);
		montaCarga.cargar(carga2);

		Double valorEsperado = 300.0;
		Double valorObtenenido = montaCarga.obtenerPesoCargado();

		assertEquals(valorEsperado, valorObtenenido);
	}

	@Test
	public void dadoQueExisteUnMontaCargaConVariasCargasAlVaciarloObtengoComoPesoCargadoIgualACero() {

		Double peso = 100.0;
		Carga carga = new Carga(peso);
		Carga carga2 = new Carga(200.0);

		Double pesoMaximoPermitido = 1000.0;
		MontaCarga montaCarga = new MontaCarga(pesoMaximoPermitido);

		montaCarga.cargar(carga);
		montaCarga.cargar(carga2);

		montaCarga.vaciar();

		/*
		 * De esta manera comprobar el test o la de abajo Double valorEsperado = 0.0;
		 * Double valorObtenido = montaCarga.obtenerPesoCargado();
		 * 
		 */
		Integer valorEsperado2 = 0;
		Integer valorObtenido2 = montaCarga.obtenerCantidadDeCargas();

		assertEquals(valorEsperado2, valorObtenido2);

	}

}

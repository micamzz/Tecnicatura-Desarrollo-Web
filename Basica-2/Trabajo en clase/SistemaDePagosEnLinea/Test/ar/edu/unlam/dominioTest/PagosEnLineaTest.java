package ar.edu.unlam.dominioTest;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import ar.edu.unlam.dominio.*;

public class PagosEnLineaTest {

	@Test
	public void dadoQueSeRealizaUnPagoDe80000ConTransferenciaySeEsperaDeComoFinal80000() {
		MetodoDePago primerPago = new TransferenciaBancaria();

		primerPago.procesarPago(80000D);

		Double valorEsperado = 80000D;
		Double valorObtenido = primerPago.getSaldoAPagar();
		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void dadoQueSeRealizaUnPagoDe150000ConTransferenciaySeEsperaDeComoFinal151500() {
		MetodoDePago primerPago = new TransferenciaBancaria();

		primerPago.procesarPago(150000D);

		Double valorEsperado = 151500D;
		Double valorObtenido = primerPago.getSaldoAPagar();
		assertEquals(valorEsperado, valorObtenido);

	}

	@Test

	public void dadoQueSeQuierePagar9400ConMercadoPagoElPrecioFinalEs10528() {

		MetodoDePago mercadoPago = new MercadoPago();

		mercadoPago.procesarPago(9400D);

		Double valorEsperado = 10528D;
		Double valorObtenido = mercadoPago.getSaldoAPagar();

		assertEquals(valorEsperado, valorObtenido, 0.001D);

	}

	@Test
	public void dadoQueSeQuiereAbonarUnMontoMayorAlLimiteDeLaTCElComoResultadoNoSePuedePagar() {

		MetodoDePago visaGalicia = new TarjetaDeCredito(40000D); // LIMITE

		visaGalicia.procesarPago(41000D);

		Double valorEsperado = 0D;
		Double valorObtenido = visaGalicia.getSaldoAPagar();

		assertEquals(valorEsperado, valorObtenido);

	}

	@Test
	public void dadoQueSeQuiereAbonarUn15000ConTCSeAplicaElRecargo() {

		MetodoDePago visaGalicia = new TarjetaDeCredito(40000D); // LIMITE

		visaGalicia.procesarPago(15000D);

		Double valorEsperado = 18405D;
		Double valorObtenido = visaGalicia.getSaldoAPagar();

		assertEquals(valorEsperado, valorObtenido);

	}

}

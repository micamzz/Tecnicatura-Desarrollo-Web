package ar.edu.unlam.pb2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.dominio.*;

public class ClaseDeTestBanco {

	private CuentaAhorro ahorro;
	private Cliente cliente;
	private CuentaCorriente corriente;
	private Banco galicia;

	/*
	 * Cajas de ahorro --> Tiene un saldo,Id de cuenta(cbu),propietario. Cajas
	 * cuentaCorriente --> saldo,Id de cuenta(cbu),propietario, limiteDeDescubierto.
	 * 
	 * CA se puede hacer deposito, consultar saldo y extraer(No puedo extraer mas de
	 * lo que tiene el saldo). CC hacer deposito, consultar, extraer (puedo tener en
	 * negativo = al limiteDeDescubierto).
	 */

	@Before
	public void inicializacionDeVariables() {
		Integer dni = 1245;
		String apellido = "lopez";
		cliente = new Cliente(dni, apellido);

		Integer cbu = 11133;
		ahorro = new CuentaAhorro(cbu, cliente);

		Double limiteDescubierto = 500D;
		corriente = new CuentaCorriente(cbu, cliente, limiteDescubierto);

		galicia = new Banco();
	}

	@Test
	public void dadoQueExisteCajaDeAhorroPuedoConsultarSuSaldoInicial() {

		Double valorEsperado = 0D;
		Double valorObtenido = ahorro.getSaldo();

		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void dadoQueExisteCajaDeAhorroYRealizoUnDepositoDe1000pesosAlConsultarSuSaldoObtengoUnValorDe1000() {

		Double montoADepositar = 1000D;
		ahorro.depositar(montoADepositar);

		Double valorEsperado = 1000D;
		Double valorObtenido = ahorro.getSaldo();

		assertEquals(valorEsperado, valorObtenido);

	}

	@Test
	public void dadoQueExisteCajaDeAhorroConSaldo1000AlExtraer400ObtengoUnSaldoDe600() {

		Double montoADepositar = 1000D;
		ahorro.depositar(montoADepositar);

		Double montoAExtraer = 400D;
		;
		ahorro.extraer(montoAExtraer);

		Double valorEsperado = 600D;
		Double valorObtenido = ahorro.getSaldo();

		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void dadoQueExisteCajaDeAhorroConSaldo1000AlExtraer1400NoMePermiteExtraer() {
		// Monto a depositar
		Double montoADepositar = 1000D;
		ahorro.depositar(montoADepositar);

		// Monto a extraer (No permite más de lo que hay en la cuenta)
		Double montoAExtraer = 1400D;
		;
		ahorro.extraer(montoAExtraer);

		assertFalse(ahorro.extraer(montoAExtraer));

		Double valorEsperado = 1000D; // El saldo no se alteró.
		Double valorObtenido = ahorro.getSaldo();

		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void dadoQueExisteCuentaCorrienteConSaldo1000YUnDescubiertoDe500AlExtraer1400ObtengoUnSaldoDescubiertoDe400() {
		// Monto a depositar
		Double montoADepositar = 1000D;
		corriente.depositar(montoADepositar);

		// Monto a extraer (No permite más de lo que hay en la cuenta)
		Double montoAExtraer = 1400D;
		;
		Boolean seExtrajo = corriente.extraer(montoAExtraer);

		assertTrue(seExtrajo);

		Double valorEsperado = -400D; // El saldo no se alteró.
		Double valorObtenido = corriente.getSaldo();

		assertEquals(valorEsperado, valorObtenido);
	}

	/*
	 * Crear Clientes. No puede haber 2 clientes con el mismo Dni 
	 * Crear Cuenta
	 * Corriente Crear Cuenta Ahorro
	 *  No se puede crear una cuenta si el cliente no
	 * fue dado de alta 
	 * Para crear Una cuenta se debe pasar por parametro el dni del
	 * cliente banco.crearCuenta(dni,cbu) 
	 * metodo agregarCajaCorirente buscar por Id
	 * si existe, si existe lo agrego en la coleccion Hacer transferencia entre
	 * cuentas (id de cuenta , origen y cbu destino) buscar por dni buscar por
	 * destino a la cuenta origen le desucento la plata, y a la destino le deposito.
	 * Si no existen las cuentas no se realiza transferencias.
	 *  NO se puede realizar una transferencia si de la cuenta origen no hay suficiente dinero
	 */

	@Test
	public void dadoQueExisteUnBancoSeAgregaUnClienteYSeObtieneUnResultadoExitoso() {
		Boolean seAgrego = galicia.agregarCliente(cliente);
		assertTrue(seAgrego);
	}

	@Test
	public void dadoQueExisteUnBancoSeIntentaAgregarOtroClienteConMismoDniYElResultadoEsFalse() {
		Integer dni2 = 1245; // MISMO DNI QUE EL CLIENTE 1.
		String apellido = "dominguez";
		Cliente cliente2 = new Cliente(dni2, apellido);

		Boolean seAgrego = galicia.agregarCliente(cliente);
		Boolean seAgrego2 = galicia.agregarCliente(cliente2);

		assertTrue(seAgrego);
		assertFalse(seAgrego2);
	}

	@Test

	public void dadoQueExisteUnClienteQuiereCrearUnaCuentaCorrienteYElResultadoEsExitoso() {
		Integer dni2 = 1245; // MISMO DNI QUE EL CLIENTE 1.
		String apellido = "dominguez";
		Cliente cliente2 = new Cliente(dni2, apellido);
		Integer cbu = 230490;
		Double limiteDescubierto = 1000D;

		galicia.agregarCliente(cliente2);

		Boolean seAgrego = galicia.crearCuentaCorriente(dni2, cbu, limiteDescubierto);
		assertTrue(seAgrego);

	}

	@Test
	public void dadoQueNoExisteUnClienteQuiereCrearUnaCuentaCorrienteYElResultadoEsFalso() {
		Integer dni2 = 1245;
		String apellido = "dominguez";
		Cliente cliente2 = new Cliente(dni2, apellido);
		Integer cbu = 230490;
		Double limiteDescubierto = 1000D;

		// NO SE AGREGA AL CLIENTE !

		Boolean seAgrego = galicia.crearCuentaCorriente(dni2, cbu, limiteDescubierto);
		assertFalse(seAgrego);

	}

	@Test
	public void dadoQueExisteUnClienteLoBuscoPorDniYObtengoUnResultadoExitoso() {
		Integer dni = 1245;
		String apellido1 = "Martinez";
		Cliente cliente1 = new Cliente(dni, apellido1);

		Integer dni2 = 7777;
		String apellido2 = "dominguez";
		Cliente cliente2 = new Cliente(dni2, apellido2);

		galicia.agregarCliente(cliente1); // dni 1245
		galicia.agregarCliente(cliente2);

		Integer dniBuscado = 1245;

		Cliente resultadoEsperado = cliente1;
		Cliente resultadoObtenido = galicia.buscarClientePorDni(dniBuscado);

		assertEquals(resultadoEsperado, resultadoObtenido);

	}

	@Test
	public void dadoQueTengo2CuentasQuieroRealizarUnaTransferenciaDe1000PesosYElResultadoEsExitoso() {
		Integer dni = 1245;
		String apellido1 = "Martinez";
		Cliente cliente1 = new Cliente(dni, apellido1);
		Integer cbu = 5542123;

		Integer dni2 = 7777;
		String apellido2 = "dominguez";
		Cliente cliente2 = new Cliente(dni2, apellido2);
		Integer cbu2 = 3077734;

		galicia.agregarCliente(cliente1);
		galicia.agregarCliente(cliente2);

		galicia.crearCuentaAhorro(dni, cbu);
		galicia.crearCuentaAhorro(dni2, cbu2);

		Cuenta nuevaCuenta = galicia.buscarCuentaPorCliente(cliente1);
		nuevaCuenta.depositar(3000D);

		Double montoATransferir = 1000D;
		Boolean exito = galicia.realizarTransferencia(cliente1, montoATransferir, cliente2);
		assertTrue(exito);

		Double resultadoEsperado = 2000D;
		Double resultadoObtenido = nuevaCuenta.getSaldo();

		assertEquals(resultadoEsperado, resultadoObtenido);
		Cuenta nuevaCuenta2 = galicia.buscarCuentaPorCliente(cliente2);

		Double resultadoEsperado2 = 1000D;
		Double resultadoObtenido2 = nuevaCuenta2.getSaldo();

		assertEquals(resultadoEsperado2, resultadoObtenido2);

	}

	@Test

	public void dadoQueSeQuiereRealizarUnaTransferenciaLaCuentaDeOrigenNoTieneSaldoYNoSePuedeRealizar() {

		Integer dni = 1245;
		String apellido1 = "Martinez";
		Cliente cliente1 = new Cliente(dni, apellido1);
		Integer cbu = 5542123;

		Integer dni2 = 7777;
		String apellido2 = "dominguez";
		Cliente cliente2 = new Cliente(dni2, apellido2);
		Integer cbu2 = 3077734;

		galicia.agregarCliente(cliente1);
		galicia.agregarCliente(cliente2);

		galicia.crearCuentaAhorro(dni, cbu);
		galicia.crearCuentaAhorro(dni2, cbu2);

//		   Le deposito 3000 a la primer cuenta
		Cuenta nuevaCuenta = galicia.buscarCuentaPorCliente(cliente1);
		nuevaCuenta.depositar(3000D);

		Cuenta nuevaCuenta2 = galicia.buscarCuentaPorCliente(cliente2);

//		  Quiero transferir 4000 pesos .
		Double montoATransferir = 4000D;
		Boolean seAgrego = galicia.realizarTransferencia(cliente1, montoATransferir, cliente2);
		assertFalse(seAgrego);

		Double resultadoEsperado = 3000D;
		Double resultadoObtenido = nuevaCuenta.getSaldo();

//        Obtengo lo que deposite , No se pudo realizar la transferencia.
		assertEquals(resultadoEsperado, resultadoObtenido);

		// Verifico que la cuenta destino este en 0.
		Double resultadoEsperado2 = 0D;
		Double resultadoObtenido2 = nuevaCuenta2.getSaldo();

		assertEquals(resultadoEsperado2, resultadoObtenido2);
	}
	
	
	@Test	
	public void dadoQueNoExistenLasCuentasEnElSistemaNoSePuedeRealizarLaTransferencia() {
		
		Integer dniClienteOrigen = 1245;
		String apellido1 = "Martinez";
		Cliente cliente1 = new Cliente(dniClienteOrigen, apellido1);
		Integer cbu = 5542123;

		Integer dniClienteDestino= 7777;
		String apellido2 = "dominguez";
		Cliente cliente2 = new Cliente(dniClienteDestino, apellido2);
		Integer cbu2 = 3077734;

		galicia.agregarCliente(cliente1);
		galicia.agregarCliente(cliente2);

		//Crear cuenta de cliente 1
		galicia.crearCuentaAhorro(dniClienteOrigen, cbu);
	
//		   Le deposito 3000 a la primer cuenta
		Cuenta nuevaCuenta = galicia.buscarCuentaPorCliente(cliente1);
		nuevaCuenta.depositar(3000D);

//		
		assertNull(galicia.buscarCuentaPorCliente(cliente2));
		Double montoATransferir = 1000D;
		Boolean seAgrego = galicia.realizarTransferencia(cliente1, montoATransferir, cliente2);
		assertFalse(seAgrego);

	}

}

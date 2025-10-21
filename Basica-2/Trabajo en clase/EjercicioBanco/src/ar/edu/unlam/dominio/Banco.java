package ar.edu.unlam.dominio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Banco {

	private List<Cuenta> listadoDeCuentas;
	private Set<Cliente> listadoDeClientes;

	public Banco() {
		this.listadoDeClientes = new HashSet<>();
		this.listadoDeCuentas = new ArrayList<>();

	}

	/*
	 * Crear Clientes. No puede haber 2 clientes con el mismo Dni Crear Cuenta
	 * Corriente Crear Cuenta Ahorro No se puede crear una cuenta si el cliente no
	 * fue dado de alta Para crear Una cuenta se debe pasar por parametro el dni del
	 * cliente banco.crearCuenta(dni,cbu) metodo agregarCajaCorirente buscar por Id
	 * si existe, si existe lo agrego en la coleccion Hacer transferencia entre
	 * cuentas (id de cuenta , origen y cbu destino) buscar por dni buscar por
	 * destino a la cuenta origen le desucento la plata, y a la destino le deposito.
	 * Si no existen las cuentas no se realiza transferencias. NO se puede realizar
	 * una transferencia si de la cuenta origen no hay suficiente dinero
	 */

	public Boolean agregarCliente(Cliente cliente) {
		Boolean seAgrego = this.listadoDeClientes.add(cliente);
		return seAgrego;
	}

	public Boolean crearCuentaCorriente(Integer dni, Integer cbu, Double limiteDescubierto) {

		Cliente nuevo = buscarClientePorDni(dni);

		if (nuevo != null) {
			Cuenta nuevaCuenta = new CuentaCorriente(cbu, nuevo, limiteDescubierto);
			return this.listadoDeCuentas.add(nuevaCuenta);
		}

		return false;
	}

	public Boolean crearCuentaAhorro(Integer dni, Integer cbu) {
		Cliente nuevo = buscarClientePorDni(dni);
		if (nuevo != null) {
			Cuenta nuevaCuenta = new CuentaAhorro(cbu, nuevo);
			return this.listadoDeCuentas.add(nuevaCuenta);
		}
		return false;
	}

	public Cliente buscarClientePorDni(Integer dni) {
		for (Cliente cliente : listadoDeClientes) {
			if (cliente.getDni().equals(dni)) {
				return cliente;
			}
		}

		return null;
	}

	public Cuenta buscarCuentaPorCliente(Cliente clienteBuscado) {
		for (Cuenta cuenta : listadoDeCuentas) {
			if (cuenta.getCliente().equals(clienteBuscado)) {
				return cuenta;
			}
		}
		return null;
	}

	public Boolean realizarTransferencia(Cliente clienteOrigen, Double montoATransferir, Cliente clienteDestino) {

		Cuenta cuentaOrigen = buscarCuentaPorCliente(clienteOrigen);
		Cuenta cuentaDestino = buscarCuentaPorCliente(clienteDestino);

		if (cuentaOrigen == null || cuentaDestino == null) {
			return false;
		}

		if (cuentaOrigen.getSaldo() < montoATransferir) {
			return false;
		}

		cuentaOrigen.setSaldo(cuentaOrigen.getSaldo() - montoATransferir);
		cuentaDestino.depositar(montoATransferir);
		return true;

	}

//                      EXCEPCIONES
	public Cuenta buscarCuentaPorCbu(Integer cbu) throws CbuInexistenteException {

		for (Cuenta cuenta : listadoDeCuentas) {
			if (cuenta.getCbu().equals(cbu))
				return cuenta;
		}

		throw new CbuInexistenteException("No existe cuenta asociada con ese CBU en nuestro sistema");
	}

	public Cuenta buscarCuentaPorDni(Cliente clienteBuscado) throws NumeroDeCuentaInexistenteException {

		for (Cuenta cuenta : listadoDeCuentas) {
			if (cuenta.getCliente().getDni().equals(clienteBuscado.getDni())) {
				return cuenta;
			}
		}
		throw new NumeroDeCuentaInexistenteException("No existe cuenta asociada con ese DNI en nuestro sistema");
	}

	public Cuenta buscarCuentaPorNumeroDeCuenta(Integer numeroCuenta) throws NumeroDeCuentaInexistenteException {

		for (Cuenta cuenta : listadoDeCuentas) {
			if (cuenta.getId().equals(numeroCuenta))
				return cuenta;
		}

		throw new NumeroDeCuentaInexistenteException("El numero de cuenta no esta asociado a nuestro sistema.");
	}
	

	public Boolean realizarTransferenciaPorCbu(Integer numeroCuenta, Integer cbu, Double montoATransferir)
			throws NumeroDeCuentaInexistenteException, CbuInexistenteException, SaldoInsuficienteException {

		Cuenta cuentaOrigen = buscarCuentaPorNumeroDeCuenta(numeroCuenta);
		Cuenta cuentaDestino = buscarCuentaPorCbu(cbu);

		((Extraible) cuentaOrigen).extraer(montoATransferir);
	    cuentaDestino.depositar(montoATransferir);
	
	    return true;


	    /*	if (cuentaOrigen.getSaldo()  < montoATransferir) 
		 throw new SaldoInsuficienteException("Saldo insuficiente");
	cuentaOrigen.setSaldo(cuentaOrigen.getSaldo() - montoATransferir);
	cuentaDestino.depositar(montoATransferir);
	
	
	 COMO ES UNA INTERFACE VERIFICAR QUE LA CUENTA DE ORIGEN
	 IMPLEMENTE EXTRAIBLE, QUE ES DONDE ESTA EL METODO EXTRAER, CADA UNO CON SUS
	 VALIDACIONES
	 
	if (!(cuentaOrigen instanceof Extraible)) {
       throw new SaldoInsuficienteException("La cuenta origen no permite extraer.");
   }
	 SE CASTEA A EXTRAIBLE QUE ES LA INTERFACE QUE IMPLEMENTA EL METODO EXTRAER
	 QUE TIENE LAS EXCEPCIONES, PARA NO USAR EL SET.s */

	}

	

}

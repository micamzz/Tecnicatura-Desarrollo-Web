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
		cuentaDestino.setSaldo(montoATransferir);
		return true;

	}
	

//	public Boolean realizarTransferencia(Cliente clienteOrigen, Double montoATransferir, Cliente clienteDestino) { 
//		Cuenta cliente1 = buscarCuentaPorCliente(clienteOrigen);
//		Cuenta clienteDestino1 = buscarCuentaPorCliente(clienteDestino); 
//		if (cliente1.getSaldo() >= montoATransferir) {
//			cliente1.setSaldo(cliente1.getSaldo() - montoATransferir); 
//		clienteDestino1.depositar(montoATransferir); return true; 
//		}return false; 
//		}
//	
//
}

package ar.edu.unlam.dominio;

import java.util.ArrayList;
import java.util.List;

public class Vehiculo {

	private String patente;
	private Double pesoMaximo;
	private Integer capacidadDeCargaDePasajeros;
	List<Pasajero> listaDePasajeros;

	public Vehiculo(String patente, Double pesoMaximo, Integer capacidadDeCarga) {
		this.patente = patente;
		this.pesoMaximo = pesoMaximo;
		this.capacidadDeCargaDePasajeros = capacidadDeCarga;
		this.listaDePasajeros = new ArrayList<>();
	}

	public String getPatente() {
		return patente;
	}

	public Double getPesoMaximo() {
		return this.pesoMaximo;
	}

	public Boolean cargarPasajeros(Pasajero pasajeroNuevo) {
		Boolean seAgrego = false;

		if (this.obtenerCapacidadActualDePasajeros() < this.capacidadDeCargaDePasajeros
				&& this.obtenerPesoActualDePasajeros() + pasajeroNuevo.getPesoPasajero() < this.pesoMaximo) {
			seAgrego = this.listaDePasajeros.add(pasajeroNuevo);
		}

		return seAgrego;
	}

	public Double obtenerPesoActualDePasajeros() {
		Double pesoActual = 0.0;

		for (Pasajero pasajero : listaDePasajeros) {
			pesoActual += pasajero.getPesoPasajero();
		}
		return pesoActual;
	}

	public Integer obtenerCapacidadActualDePasajeros() {

		return listaDePasajeros.size();
	}

	public Integer obtenerCapacidadMaximaDePasajeros() {
		return this.capacidadDeCargaDePasajeros;
	}

	public Double obtenerPesoMaximo() {

		return this.pesoMaximo;
	}

}

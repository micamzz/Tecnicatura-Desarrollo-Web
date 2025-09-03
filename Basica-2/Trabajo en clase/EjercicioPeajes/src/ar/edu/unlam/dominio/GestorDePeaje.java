package ar.edu.unlam.dominio;

import java.util.HashSet;

public class GestorDePeaje {

	private HashSet<Pase> listadoDePases;
	private HashSet<Tarifa> listadoDeTarifas;

	public GestorDePeaje() {
		this.listadoDePases = new HashSet<>();
		this.listadoDeTarifas = new HashSet<>();
	}

	
	public Boolean agregarPase(Pase pase) {
		boolean seAgrego = this.listadoDePases.add(pase);
	
		return seAgrego;
	}

	public HashSet<Vehiculo> obtenerTodosLosVehiculos() {

		HashSet<Vehiculo> vehiculos = new HashSet();

		for (Pase pase : listadoDePases) {
			// if(!vehiculos.contains(pase.getVehiculo())) { // SI USO ARRAYLIST UTILIZAR LA
			// CONDICION.
			vehiculos.add(pase.getVehiculo());
		}

		return vehiculos;

	}

	public Double obtenerMontoAAbonarDeUnVehiculoParaUnMesDado(String patente, Integer anio, Integer mes) {
       Double montoAPagar = 0.0;
       
       
		return montoAPagar;
	}

	
	
	public Tarifa obtenerTarifaVigente() {

		for (Tarifa tarifas : this.listadoDeTarifas) {
			if (tarifas.getHasta() == null)
				return tarifas;

		}
		return null;
	}

}

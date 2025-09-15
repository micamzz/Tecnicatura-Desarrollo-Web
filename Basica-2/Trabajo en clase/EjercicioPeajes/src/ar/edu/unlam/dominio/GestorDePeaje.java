package ar.edu.unlam.dominio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

		HashSet<Vehiculo> vehiculos = new HashSet<>();

		for (Pase pase : listadoDePases) {
			// if(!vehiculos.contains(pase.getVehiculo())) { // SI USO ARRAYLIST UTILIZAR LA
			// CONDICION.
			vehiculos.add(pase.getVehiculo());
		}
		return vehiculos;
	}

	public Boolean agregarTarifa(Tarifa tarifa) {

		// VALIDAR QUE LA NUEVA TARIFA A AGREGAR LA FECHA DESDE SEA POSTERIOR A LA
		// TARIFA ACTUAL
		Tarifa tarifaAnterior = this.obtenerTarifaVigente();

		if(!this.listadoDeTarifas.isEmpty()) {
		if (!validarFechaVigenteDesde(tarifaAnterior.getDesde(), tarifa.getDesde())) {
			return false;
		}
		}
		for (Tarifa tarifaExistente : listadoDeTarifas) {
			// Que a la tarifa vigente si el hasta Null, que la setee con un dia anterior
			if (tarifaExistente.getHasta() == null) {
				tarifaExistente.setHasta(tarifa.getDesde().minusDays(1));
			}
		}

		return this.listadoDeTarifas.add(tarifa);
	}

	public Boolean validarFechaVigenteDesde(LocalDate desdeAnterior, LocalDate desdeActual) {
		return desdeAnterior.isBefore(desdeActual);
	}

	public Integer obtenerCantidadDeTarifas() {
		return this.listadoDeTarifas.size();
	}
	/*
	 * METODO PROFE- PARA CREAR NUEVA TARIFA
	 * 
	 * public Boolean crearNuevaTarifa(LocalDate desde, Double valor) {
	 * 
	 * Tarifa tarifaAnterior = this.obtenerTarifaVigente(); // Utiliza el método
	 * 
	 * if (tarifaAnterior != null) tarifaAnterior.setHasta(desde.minusDays(1));
	 * 
	 * Tarifa tarifaNueva = new Tarifa(desde,valor);
	 * 
	 * return this.listadoDeTarifas.add(tarifaNueva); }
	 */

	public Double obtenerMontoAAbonarDeUnVehiculoParaUnMesDado(String patente, Integer anio, Integer mes) {
		// Obtengo todos los pases para ese mes
		ArrayList<Pase> pasesParaUnaPatente = obtenerPases(patente, anio, mes);
		Double monto = 0D;

		for (Pase pase : pasesParaUnaPatente) {
			// obtengo la tarifa de ese mes para ese rango de fecha
			Tarifa tarifa = obtenerTarifa(pase.getFechaHora());
			monto += tarifa.getValor();
		}
		return monto;
	}

	private Tarifa obtenerTarifa(LocalDateTime fechaHora) {

		LocalDate fecha = LocalDate.of(fechaHora.getYear(), fechaHora.getMonthValue(), fechaHora.getDayOfMonth());
		return obtenerTarifa(fecha);
	}

	/*
	 * DESDE >= fecha <= hasta O DESDE <= FECHA && HASTA == NULL LocalDate .isAfter
	 * LocalDate .isBefore
	 */

	private Tarifa obtenerTarifa(LocalDate fecha) {
		for (Tarifa tarifa : this.listadoDeTarifas) {
			if ((tarifa.getDesde().minusDays(1L).isBefore(fecha) && tarifa.getHasta() == null)
					|| (tarifa.getDesde().minusDays(1L).isBefore(fecha)
							&& fecha.minusDays(1).isBefore(tarifa.getHasta()))) {
				return tarifa;
			}
		}
		return null;
	}

	private ArrayList<Pase> obtenerPases(String patente, Integer anio, Integer mes) {
		ArrayList<Pase> pases = new ArrayList<>();

		for (Pase pase : this.listadoDePases) {

			// Si coincide patente, mes y año lo agrego a la coleccion
			if (pase.getVehiculo().getPatente().equalsIgnoreCase(patente)
					&& pase.getFechaHora().getMonth().getValue() == mes.intValue()
					&& pase.getFechaHora().getMonth().getValue() == mes.intValue())
				pases.add(pase);

		}
		return pases; // devuelve todos los pases
	}

	public Tarifa obtenerTarifaVigente() {
		// La tarifa vigente la que fechaHasta es null
		for (Tarifa tarifas : this.listadoDeTarifas) {
			if (tarifas.getHasta() == null)
				return tarifas;
		}
		return null;
	}

}

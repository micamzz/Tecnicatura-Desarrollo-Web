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

		HashSet<Vehiculo> vehiculos = new HashSet<>();

		for (Pase pase : listadoDePases) {
			// if(!vehiculos.contains(pase.getVehiculo())) { // SI USO ARRAYLIST UTILIZAR LA
			// CONDICION.
			vehiculos.add(pase.getVehiculo());
		}

		return vehiculos;

	}

	public Double obtenerMontoAAbonarDeUnVehiculoParaUnMesDado(String patente, Integer anio, Integer mes) {
       Double montoAPagar = 0.0;
       Double tarifaDelMes = 0.0;
       
       for(Tarifa tarifas : listadoDeTarifas) {
    	   if(tarifas.getDesde().getYear() == anio && tarifas.getDesde().getMonthValue() == mes) {
    		   tarifaDelMes += tarifas.getValor();
    	   }
    	   
       
       for (Pase pase : listadoDePases) {
 if ( pase.getVehiculo().getPatente().equalsIgnoreCase(patente) && pase.getFechaHora().getYear() == anio && pase.getFechaHora().getMonthValue() == mes ) 
 
    		
    		   montoAPagar += tarifaDelMes;
    	   }
		
	}
       
       
		return montoAPagar;
	}

//	
//	public Boolean agregarTarifa(Tarifa tarifa) {
//		Boolean seAgrego = this.listadoDeTarifas.add(tarifa);
//		return seAgrego;
//	}
	
	public Boolean agregarTarifa(Tarifa tarifa) {
		
		for (Tarifa tarifaExistente :listadoDeTarifas) {
			if(tarifaExistente.getHasta() == null) {
				tarifaExistente.setHasta(tarifa.getDesde().minusSeconds(1));		
			}			
		}
		return this.listadoDeTarifas.add(tarifa);
	}
	
	
	public Tarifa obtenerTarifaVigente() {

		for (Tarifa tarifas : this.listadoDeTarifas) {
			if (tarifas.getHasta() == null)
				return tarifas;

		}
		return null;
	}

}

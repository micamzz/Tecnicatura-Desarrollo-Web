package ar.edu.unlam.dominio;

import java.util.HashSet;

public class SistemaDeTransporte {

	private HashSet <Vehiculo> listadoDeVehiculos;
	private HashSet <Conductor> listadoDeConductores;
	
	
	public SistemaDeTransporte() {
		this.listadoDeConductores = new HashSet<>();
		this.listadoDeVehiculos = new HashSet<>();
	}


	public Boolean agregarConductor (Conductor nuevoConductor) {
		return this.listadoDeConductores.add(nuevoConductor);
	}
	
	public Boolean agregarVehiculo (Vehiculo nuevoVehiculo) {
		return this.listadoDeVehiculos.add(nuevoVehiculo);
	}
	
	
	
	public Vehiculo buscarVehiculoPorPatente (String patente) {
		Vehiculo buscado = null;
		
		for (Vehiculo vehiculos : listadoDeVehiculos) {
			if(vehiculos.getPatente().equalsIgnoreCase(patente)) {
				buscado = vehiculos;
				break;
			}
		}
		
		return buscado;
		}
	
	}

	
	
			
			

	
	


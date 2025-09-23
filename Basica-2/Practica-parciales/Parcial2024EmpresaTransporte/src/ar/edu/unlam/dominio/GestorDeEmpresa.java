package ar.edu.unlam.dominio;

import java.util.HashSet;
import java.util.Set;

public class GestorDeEmpresa {

	private Set <Vehiculo> listadoDeVehiculos ;
	private Set <Chofer> listadoDeChoferes ;
	
	
	public GestorDeEmpresa() {
		listadoDeVehiculos = new HashSet<>();
		this.listadoDeChoferes = new HashSet<>();
	}
	
	

//	public Boolean agregarChofer(Chofer choferNuevo) {
//		return this.agregarChofer(choferNuevo);
//	}
	
	public Boolean agregarVehiculoAlaFlota(Vehiculo vehiculoNuevo) {
		return this.listadoDeVehiculos.add(vehiculoNuevo);		
	}

	
}

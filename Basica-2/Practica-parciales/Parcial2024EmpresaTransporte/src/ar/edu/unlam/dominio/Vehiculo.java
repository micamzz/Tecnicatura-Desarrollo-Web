package ar.edu.unlam.dominio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public  class Vehiculo {

	private Double kilometrosRecorridos;
	private List  <Pasajero> listadoDePasajero;
	private Set <Chofer> listadoDeChoferes ; // NO SE PUEDEN REPETIR CHOFERES POR DNI. 
	
	public Vehiculo() {
		this.kilometrosRecorridos=0D;
		this.listadoDeChoferes = new HashSet<>();
		this.listadoDePasajero = new ArrayList<>();
	}
	
	
	public Boolean asignarChofer(Chofer choferDesignado) {
		// SOLO UN CHOFER POR VEHICULO 
		if (!this.listadoDeChoferes.isEmpty()){
			return false;
		}
		return this.listadoDeChoferes.add(choferDesignado);
	}
	
	public Boolean cambiarChofer(Chofer choferACambiar) { 
	
	    if (!listadoDePasajero.isEmpty()) {
	        return false;
	    }
	    
	    listadoDeChoferes.clear(); // Para limpiar el Set. 
	    
	   
	    return listadoDeChoferes.add(choferACambiar);
	}
	
	/* O quizas un metodo para elegir a que chofer cambiar, por quien */

  
	public Boolean agregarPasajeros(Pasajero personaAcompañante) {
		return this.listadoDePasajero.add(personaAcompañante);
	}
	
	public Integer cantidadDePasajeros() {
		return this.listadoDePasajero.size();
	}

	public Double getKilometrosRecorridos() {
		return kilometrosRecorridos;
	}
	
	
	public void iniciarViaje(Double distanciaARecorrer) {
		this.kilometrosRecorridos += distanciaARecorrer;
		
	}
	
	
}

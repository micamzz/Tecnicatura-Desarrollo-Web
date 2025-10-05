package ar.edu.unlam.dominio;

import java.util.HashSet;

public class ClubDeJuegos {
	
	private HashSet <Torneo> listadoDeTorneo;
	private HashSet <Partida> listadoDePartidas;
	

	public ClubDeJuegos() {
		this.listadoDeTorneo = new HashSet <>();
		this.listadoDePartidas =  new HashSet <>();
	}
	
	public Boolean agregarTorneo(Torneo torneo) {
		return this.listadoDeTorneo.add(torneo);
		
	}

	
	public Boolean agregarpartida(Partida partid1) {
		return this.listadoDePartidas.add(partid1);
		
	}
	
	
	
	
	
}

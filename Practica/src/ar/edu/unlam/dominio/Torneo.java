package ar.edu.unlam.dominio;

import java.time.LocalDate;
import java.util.Objects;

import ar.edu.unlam.dominio.*;

public class Torneo {
	
	  private String nombreTorneo;
	  private JuegoDeMesa juego;
	  private LocalDate fechaInicio;
	  
	  
	public Torneo(String nombreTorneo, JuegoDeMesa juego, LocalDate fechaInicio) {
		super();
		this.nombreTorneo = nombreTorneo;
		this.juego = juego;
		this.fechaInicio = fechaInicio;
	}


	@Override
	public int hashCode() {
		return Objects.hash(fechaInicio, nombreTorneo);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Torneo other = (Torneo) obj;
		return Objects.equals(fechaInicio, other.fechaInicio) && Objects.equals(nombreTorneo, other.nombreTorneo);
	}
	  
	  
	  
	
	
	
	
}

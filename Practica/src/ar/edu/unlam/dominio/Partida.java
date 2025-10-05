package ar.edu.unlam.dominio;

import java.time.LocalDate;

public class Partida {
	
	  private Torneo torneo;
	  private LocalDate fecha;
	  private String resultado;
	  
	public Partida(Torneo torneo, LocalDate fecha) {
		super();
		this.torneo = torneo;
		this.fecha = fecha;
		
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public Torneo getTorneo() {
		return torneo;
	}

	public LocalDate getFecha() {
		return fecha;
	}
	  
	  
	  
	  

}

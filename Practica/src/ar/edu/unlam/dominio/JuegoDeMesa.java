package ar.edu.unlam.dominio;

import java.time.LocalDate;

public abstract class JuegoDeMesa {

	
  private String titulo;
  private LocalDate fechaDePublicacion;
  
  public JuegoDeMesa(String titulo, LocalDate fechaInicio) {
	  this.titulo = titulo;
	  this.fechaDePublicacion = fechaInicio;
  }
  
  
  public abstract String getDescripcion();
  
  
}

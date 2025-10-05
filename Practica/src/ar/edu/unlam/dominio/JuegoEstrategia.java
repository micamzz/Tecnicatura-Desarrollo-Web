package ar.edu.unlam.dominio;

import java.time.LocalDate;

public class JuegoEstrategia extends JuegoDeMesa {
	
	private String nivelDeComplejidad;

	public JuegoEstrategia(String titulo, LocalDate fechaInicio) {
		super(titulo, fechaInicio);
		// TODO Auto-generated constructor stub
	}

	
	
	
	@Override
	public String getDescripcion() {
		// TODO Auto-generated method stub
		return "Nivel de compeljidad " + this.nivelDeComplejidad;
	}

	
	

}

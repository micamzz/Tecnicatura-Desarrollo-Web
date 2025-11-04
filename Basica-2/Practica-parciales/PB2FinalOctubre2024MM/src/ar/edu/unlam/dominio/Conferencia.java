package ar.edu.unlam.dominio;

import java.time.LocalDate;

public class Conferencia extends Evento {
	
	
	private Integer cupoParticipantes;

	public Conferencia(String iD, LocalDate fecha, TipoSala tipoDeSala, String cliente) {
		super(iD, fecha, tipoDeSala, cliente);
		this.setPrecioBase(15000D);
		this.cupoParticipantes=0;
	}

	

	
	public void incrementarCupo() {
		this.cupoParticipantes++;
	}
	
	@Override
	public Double calcularPrecio() {
		return this.cupoParticipantes * super.getPrecioBase();
	}

}

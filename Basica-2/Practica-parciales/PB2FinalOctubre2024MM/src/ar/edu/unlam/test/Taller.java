package ar.edu.unlam.test;

import java.time.LocalDate;

import ar.edu.unlam.dominio.*;

public class Taller extends Evento {

	private Integer duracionEnHoras;
	private final Integer CUPO_MAXIMO;
	private Integer cupoParticipantes;
	private Double precioBase= 25000D;
	
	
	public Taller(String iD, LocalDate fecha, TipoSala tipoDeSala, String exponente, Integer CUPO_MAXIMO,Integer duracion) {
		super(iD, fecha, tipoDeSala, exponente);
		this.setPrecioBase(precioBase);
		this.CUPO_MAXIMO = CUPO_MAXIMO;
		this.duracionEnHoras = duracion;
		this.cupoParticipantes=0;
	}


	
	public void incrementarCupo() {
		this.cupoParticipantes++;
	}


	public Integer getCUPO_MAXIMO() {
		return CUPO_MAXIMO;
	}



	public Integer getCupoParticipantes() {
		return cupoParticipantes;
	}



	@Override
	public Double calcularPrecio() {
	
		return this.cupoParticipantes * super.getPrecioBase();
	}

}

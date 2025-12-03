package ar.edu.unlam.dominio;

import java.util.Objects;

public  abstract  class Nave {

	
	private String idUnico;
	private String nombre;
	private Double capacidadMaximaCombustible;
	private Double consumoBase;
	
	
	
	public Nave(String idUnico, String nombre) {
		this.idUnico = idUnico;
		this.nombre = nombre;
	}


	public Double getCapacidadMaximaCombustible() {
		return capacidadMaximaCombustible;
	}



	public void setCapacidadMaximaCombustible(Double capacidadMaximaCombustible) {
		this.capacidadMaximaCombustible = capacidadMaximaCombustible;
	}



	public String getNombre() {
		return nombre;
	}


	public Double getConsumoBase() {
		return consumoBase;
	}


	public void setConsumoBase(Double consumoBase) {
		this.consumoBase = consumoBase;
	}


	public String getIdUnico() {
		return idUnico;
	}


	public abstract Double calcularConsumo();
	
	@Override
	public int hashCode() {
		return Objects.hash(idUnico);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
//		if (getClass() != obj.getClass())
//			return false;
		Nave other = (Nave) obj;
		return Objects.equals(idUnico, other.idUnico);
	}


	
	
	
	
	
	
	
	
}

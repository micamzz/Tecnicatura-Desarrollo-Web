package ar.edu.unlam.dominio;

public abstract  class Vehiculo {

	private Integer numeroUnico;
	private String nombre;
	private Boolean estaDisponible;
	private  Double precioBase;
	
	
	
	public Vehiculo(Integer numeroUnico, String nombre) {
		this.numeroUnico = numeroUnico;
		this.nombre = nombre;
		this.estaDisponible = true;
	}



	public Integer getNumeroUnico() {
		return numeroUnico;
	}



	public Double getPrecioBase() {
		return precioBase;
	}



	public void setPrecioBase(Double precioBase) {
		this.precioBase = precioBase;
	}



	public Boolean getEstaDisponible() {
		return estaDisponible;
	}



	public void setEstaDisponible(Boolean estaDisponible) {
		this.estaDisponible = estaDisponible;
	}


public abstract Double obtenerPrecio(Integer horas);
}
	
	
	
	
	


package ar.edu.unlam.dominio;

import java.util.Objects;

public class Vehiculo {

	private String patente;
	private String modelo;
	private String marca;
	
	public Vehiculo(String patente, String modelo, String marca) {
		this.patente = patente;
		this.modelo = modelo;
		this.marca = marca;
		
	}

	
	public String getPatente() {
		return patente;
	}


	public void setPatente(String patente) {
		this.patente = patente;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	@Override
	public int hashCode() {
		return Objects.hash(patente);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehiculo other = (Vehiculo) obj;
		return Objects.equals(patente, other.patente);
	}



	
	
	
	
	
}

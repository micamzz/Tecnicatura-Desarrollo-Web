package ar.edu.unlam.dominio;

import java.util.Objects;

public class Vehiculo {

	private String patente;
	private String marca;
	Integer anioDeFabricacion;
	
	public Vehiculo(String patente, String marca, Integer anioDeFabricacion) {
		this.patente = patente;
		this.marca = marca;
		this.anioDeFabricacion = anioDeFabricacion;
	}
	public Vehiculo() {
		
	}
	
	public String getPatente() {
		return patente;
	}


	public String getMarca() {
		return marca;
	}


	public Integer getAnioDeFabricacion() {
		return anioDeFabricacion;
	}
	
	public Double calcularCostoDeMantenimiento() {
		
		return 0d;
	};

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

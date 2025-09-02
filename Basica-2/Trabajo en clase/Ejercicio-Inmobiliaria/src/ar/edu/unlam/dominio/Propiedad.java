package ar.edu.unlam.dominio;

import java.util.Objects;

public class Propiedad {
	private String ubicacion;
	private Double precio;
	private Integer codigoPropiedad;
	private Boolean estaVendida;
	
	public Propiedad(String ubicacion, Double precio,Integer codigoPropiedad) {
		this.ubicacion = ubicacion;
		this.precio = precio;
		this.codigoPropiedad = codigoPropiedad;
		this.estaVendida = false;
		
	}
	
	public Integer getCodigoPropiedad() {
		return this.codigoPropiedad;
	}
	public Double getPrecio() {
		return this.precio;
	}
	
	public String getUbicacion() {
		return this.ubicacion;
	}
	
	public void setPrecioDeLaPropiedad(Double precioActualizado) {
		this.precio = precioActualizado;
	}
	public void setEstaVendida(Boolean estaVendida) {
		this.estaVendida = estaVendida;
	}


	public Boolean getEstaVendida() {
		return this.estaVendida;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoPropiedad, ubicacion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Propiedad other = (Propiedad) obj;
		return Objects.equals(codigoPropiedad, other.codigoPropiedad) && Objects.equals(ubicacion, other.ubicacion);
	}
	
	
	
}

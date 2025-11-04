package ar.edu.unlam.dominio;

import java.util.Objects;

import ar.edu.unlam.enums.TipoClasificacion;
import ar.edu.unlam.enums.TipoDeCanal;

public class Canal {
	
	private Integer numeroCanal;
	private String nombre;
	private TipoDeCanal tipoCanal;
	private TipoClasificacion tipoClas;
	
	
	public Canal(Integer numeroCanal, String nombre, TipoDeCanal tipoCanal, TipoClasificacion tipoClas) {
		super();
		this.numeroCanal = numeroCanal;
		this.nombre = nombre;
		this.tipoCanal = tipoCanal;
		this.tipoClas = tipoClas;
	}

	
	public TipoClasificacion getTipoClas() {
		return tipoClas;
	}


	@Override
	public int hashCode() {
		return Objects.hash(numeroCanal);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Canal other = (Canal) obj;
		return Objects.equals(numeroCanal, other.numeroCanal);
	}
	
	
	
	
	
	
}

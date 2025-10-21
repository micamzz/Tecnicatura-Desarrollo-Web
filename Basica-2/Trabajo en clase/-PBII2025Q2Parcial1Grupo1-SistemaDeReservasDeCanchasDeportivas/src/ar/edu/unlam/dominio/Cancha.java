package ar.edu.unlam.dominio;

import java.util.Objects;

public abstract class Cancha implements Comparable<Cancha> {

	private Double precioBasePorHora;
	private Integer idCancha;
	protected String tipoDeCancha;

	public Cancha( Double precioBasePorHora) {
		this.precioBasePorHora = precioBasePorHora;
	}
	
	public abstract Integer getCapacidadMax();

	public Double getPrecioBasePorHora() {
		return precioBasePorHora;
	}

	public void setIdCancha(Integer idCancha) {
		this.idCancha = idCancha;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCancha);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		//GetClass de la clase que esta utilizando con la que quiero meter dentro de la coleccion
		// hay un error, si utilizo herencia. Hay que sacar esta restriccion
//		if (getClass() != obj.getClass())
//			return false;
		Cancha other = (Cancha) obj;
		return Objects.equals(idCancha, other.idCancha);
	}

	public Integer getIdCancha() {
		return idCancha;
	}

	public String getTipoDeCancha() {
		return tipoDeCancha;
	}

	@Override
	public String toString() {
		return this.tipoDeCancha + " por $" + this.precioBasePorHora + "/hora.  ID: " + idCancha;
	}
	
	/*
	 * Sobreescribir el compareTo cuando se implementa un comparable Compareto -
	 * Criterio devuelve 0 son iguales. Si devuelve menor a cero es mas chico Si es
	 * > 0 es más grande
	 *  */
	
	
	  @Override public int compareTo(Cancha o){
//	  Le doy la logica al compareTo En ese caso compara el Id de cancha con el id
//	  de cancha pasado por parametro
//	  
//	  ORDEN DESCENDIENTE
//	  
	  return this.idCancha.compareTo(o.idCancha) * (-1); }
	 

//	@Override
//	public int compareTo(Cancha o){
//		
//		 ORDEN ASCENDENTE POR PRECIO HORA BASE PARA EL TEST
//		 dadoQueExistenMuchasCanchasPuedoObtenerUnListadoDeLasCanchasDeFutbol5OrdenadasPorSuPrecioHora() 
//	
//		return this.getPrecioBasePorHora().compareTo(o.getPrecioBasePorHora());
//	}
	 
}

package ar.edu.unlam.dominio;

public abstract  class MaquinaVirtual implements Comparable <MaquinaVirtual> {

	private final Double CAPACIDAD_DE_ALMACENAMIENTO;
	private Double costoInicial;
	private Usuario usuario;
	
	
	public MaquinaVirtual(Double capacidadDeAlmacenamiento,Double costoInicial) {
		this.CAPACIDAD_DE_ALMACENAMIENTO = capacidadDeAlmacenamiento;
		this.costoInicial = costoInicial;
	}


	public Double getCapacidadDeAlmacenamiento() {
		return CAPACIDAD_DE_ALMACENAMIENTO;
	}

	

	public Usuario getUsuario() {
		return usuario;
	}


	public Double getCostoInicial() {
		return costoInicial;
	}
	
	
	public abstract Double calcularCostoTotal();
	



	public void setUsuario(Usuario usuario) {
		this.usuario =usuario;
		
	}
	
	
	
	
	
	
	
	
}

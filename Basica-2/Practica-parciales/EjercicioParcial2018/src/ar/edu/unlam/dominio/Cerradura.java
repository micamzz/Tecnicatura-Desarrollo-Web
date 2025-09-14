package ar.edu.unlam.dominio;

public class Cerradura {

	private Integer claveDeApertura;
	private Integer cantidadDeFallosConsecutivosQueLaBloquean;
	private Boolean estaAbierta;
	private Boolean estaBloqueada;
	private Integer contadorDeFallos;
	private Integer contadorDeAperturas;

	public Cerradura(Integer claveDeApertura, Integer cantidadDeFallosConsecutivosQueLaBloquean) {
		this.claveDeApertura = claveDeApertura;
		this.cantidadDeFallosConsecutivosQueLaBloquean = cantidadDeFallosConsecutivosQueLaBloquean;
		this.estaAbierta = false;
		this.estaBloqueada = false;
		this.contadorDeAperturas = 0;
		this.contadorDeFallos = 0;
	}

	public void abrirCerradura(Integer clave) {
		
		if (this.estaBloqueada) return;
		
		if (this.claveDeApertura.equals(clave)) {
			this.estaAbierta = true;
			contadorDeAperturas++;
			contadorDeFallos = 0;

		} else {
			contadorDeFallos++;
			if (contadorDeFallos >= this.cantidadDeFallosConsecutivosQueLaBloquean) {
				this.estaBloqueada = true;
			}
		}

	}

	public void cerrarCerradura() {
		if (this.estaAbierta) {
			this.estaAbierta = false;
		}
	}

	public Boolean estaAbierta() {
		return estaAbierta;
	}

	public Boolean estaCerrada() {
		return !estaAbierta;
	}

	public boolean fueBloqueada() {

		return this.estaBloqueada;
	}

	public Integer contarAperturasExitosas() {
		return this.contadorDeAperturas;
	}

	public Integer contarAperturasFallidas() {
		return this.contadorDeFallos;
	}

	public Integer getClaveDeApertura() {
		return claveDeApertura;
	}

	public void setClaveDeApertura(Integer claveDeApertura) {
		this.claveDeApertura = claveDeApertura;
	}

}

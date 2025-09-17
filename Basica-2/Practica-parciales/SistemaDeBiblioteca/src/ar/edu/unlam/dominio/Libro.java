package ar.edu.unlam.dominio;

public class Libro {

	private Integer codigo;
	private String nombre;
	private String autor;
	private Boolean estaDisponible;
	private Boolean fuePrestado;
	
	
	public Libro(Integer codigo, String nombre, String autor) {

		this.codigo = codigo;
		this.nombre = nombre;
		this.autor = autor;
		this.fuePrestado=false;
		this.estaDisponible=true;
	}


	public Integer getCodigo() {
		return codigo;
	}


	public String getNombre() {
		return nombre;
	}

	public String getAutor() {
		return autor;
	}

	public Boolean getEstaDisponible() {
		return estaDisponible;
	}

	public void setEstaDisponible(Boolean estaDisponible) {
		this.estaDisponible = estaDisponible;
	}


	public Boolean getFuePrestado() {
		return fuePrestado;
	}


	public void setFuePrestado(Boolean fuePrestado) {
		this.fuePrestado = fuePrestado;
	}


	

	
	
	
	
}

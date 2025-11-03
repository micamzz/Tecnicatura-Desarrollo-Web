package ar.edu.unlam.dominio;

public class Usuario implements Comparable <Usuario>{

	private String correo;
	private String contrasenia;

	
	
	public Usuario(String correo, String contrasenia) {
		this.contrasenia= contrasenia;
		this.correo = correo;
	}
	
	
	public String getCorreo() {
		return correo;
	}


	@Override
	public int compareTo(Usuario o) {
		return this.correo.compareTo(o.getCorreo()) * (-1);
	}
	
	
	
	
	
	
	
}

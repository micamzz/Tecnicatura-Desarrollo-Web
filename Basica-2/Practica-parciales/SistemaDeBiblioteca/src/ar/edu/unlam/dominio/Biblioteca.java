package ar.edu.unlam.dominio;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

	private List <Libro> listadoDeLibros;
	private List <Estudiante> listadoDeEstudiante;
	
	
	public Biblioteca() {
		this.listadoDeLibros = new ArrayList<>();
		this.listadoDeEstudiante = new ArrayList<>();
	}
	
	
	
	public Boolean agregarLibro(Libro nuevoLibro) {
		return this.listadoDeLibros.add(nuevoLibro);
		}
	
	public Integer cantidadDeLibrosPrestados() {
		return this.listadoDeLibros.size();
	}
	
	public Boolean prestarLibro(Libro libroPrestado,Estudiante estudiante) {
		
		if(!estudiante.puedePrestarLibro()) {return false;}
		
		for (Libro libro : listadoDeLibros) {
			if(libro.equals(libroPrestado) && libro.getEstaDisponible()) {
				libro.setFuePrestado(true);
				libro.setEstaDisponible(false);
				estudiante.prestarLibro();
				return true;
			}
		}
		
		return false;
	}
	
	
	public Boolean devolverLibro(Libro libroADevolver,Estudiante estudiante) {
		
		for (Libro libro : listadoDeLibros) {
			if(libro.getFuePrestado() && libro.equals(libroADevolver)) {
				libro.setEstaDisponible(true);
				libro.setFuePrestado(false);
				estudiante.devuelveLibro();
				return true;
			}
			
		}
		return false;
	}
	
	public String obtenerFotocopiable() {
	    for (Libro libro : listadoDeLibros) {
	        if (libro instanceof Fotocopiable) {
	            return ((Fotocopiable) libro).fotocopiar();
	        }
	    }
	    return null;
	
	
}
}

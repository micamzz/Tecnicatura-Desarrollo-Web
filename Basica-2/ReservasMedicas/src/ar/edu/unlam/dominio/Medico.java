package ar.edu.unlam.dominio;

import ar.edu.unlam.menum.Especialidad;

public class Medico extends Persona{
	
	private Especialidad tipoEspecialidad;

	public Medico(String nombre, String apellido, Integer dni, Integer edad,Especialidad tipoEspecialidad) {
		super(nombre, apellido, dni, edad);
		this.tipoEspecialidad = tipoEspecialidad;
	}

	
	@Override
	public String toString() {
		return "Médico: " + getNombreCompleto() + ". Especialidad " + tipoEspecialidad ;
}


	public Especialidad getTipoEspecialidad() {
		return this.tipoEspecialidad;
	}
	
	
	

}
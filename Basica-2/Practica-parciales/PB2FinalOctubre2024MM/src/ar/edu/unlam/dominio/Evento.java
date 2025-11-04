package ar.edu.unlam.dominio;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;

public abstract class Evento {

	private String ID;
	private LocalDate fecha;
	private TipoSala tipoDeSala;
	private String exponente;
	private HashSet <Cliente> listadoDeParticipantes;
	private Double precioBase;

	
	
	
	public Evento(String iD, LocalDate fecha, TipoSala tipoDeSala, String exponente) {
		ID = iD;
		this.fecha = fecha;
		this.tipoDeSala = tipoDeSala;
		this.exponente = exponente;
		this.listadoDeParticipantes = new HashSet <>();
	}

	
	
	public void setListadoDeParticipantes(HashSet<Cliente> listadoDeParticipantes) {
		this.listadoDeParticipantes = listadoDeParticipantes;
	}


	public String getID() {
		return ID;
	}


	public Double getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(Double precioBase) {
		this.precioBase = precioBase;
	}



	public HashSet<Cliente> getListadoDeParticipantes() {
		return listadoDeParticipantes;
	}



	@Override
	public int hashCode() {
		return Objects.hash(exponente, fecha);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		return Objects.equals(exponente, other.exponente) && Objects.equals(fecha, other.fecha);
	}


	
public abstract Double calcularPrecio();


	
	
	
	
	
	
	
}

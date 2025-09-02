package ar.edu.unlam.dominio;

import java.util.Objects;

public class Carga {

	// Atributos
	private Double peso;
	private Long id;
	
	// Constructor
	public Carga(Double peso) {
         this.peso = peso;
	}
	
	public Carga(Long id, Double peso) {
		this.id = id;
		this.peso = peso;
	}

	// Getters
	public Double getPeso() {
		return this.peso;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, peso);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carga other = (Carga) obj;
		return Objects.equals(id, other.id) && Objects.equals(peso, other.peso);
	}
	
	
	
	
	
}

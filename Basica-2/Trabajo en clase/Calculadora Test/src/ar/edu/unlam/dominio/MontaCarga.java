package ar.edu.unlam.dominio;

import java.util.ArrayList;

public class MontaCarga {

	private Double pesoMaximoPermitido;

	// Atributo del arrayList

	private ArrayList<Carga> listadoDeCargas = new ArrayList<>();

	public MontaCarga(Double pesoMaximoPermitido) {
		this.pesoMaximoPermitido = pesoMaximoPermitido;
	}

	public Double getPesoMaximoPermitido() {
		return this.pesoMaximoPermitido;
	}

	public Integer obtenerCantidadDeCargas() {

		// tamaño de la coleccion con size()
		return this.listadoDeCargas.size();
	}

	public Double obtenerPesoCargado() {

		Double totalCargado = 0.0;

		for (Carga carga : this.listadoDeCargas) {

			totalCargado += carga.getPeso();
		}
		return totalCargado;

	}

	// Agrega un elemento al arrayList
	public void cargar(Carga carga) {

		this.listadoDeCargas.add(carga);
   }

	// Metodo para vaciar/limpiar el arrayList.
	public void vaciar() {
		this.listadoDeCargas.clear();

	}

}

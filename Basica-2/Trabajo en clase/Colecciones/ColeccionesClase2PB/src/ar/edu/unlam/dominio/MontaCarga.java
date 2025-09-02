package ar.edu.unlam.dominio;

import java.util.ArrayList;
import java.util.HashSet;

public class MontaCarga {

	private Double pesoMaximoPermitido;

	// Atributo del arrayList
	private ArrayList<Carga> listadoDeCargas = new ArrayList<>();

	private HashSet<Carga> cargaSinDuplicados;

	public MontaCarga(Double pesoMaximoPermitido) {
		this.pesoMaximoPermitido = pesoMaximoPermitido;
		this.cargaSinDuplicados = new HashSet<>();
	}

	// Agrega un elemento al arrayList
	public void cargar(Carga carga) {

		this.listadoDeCargas.add(carga);
	}

	// Metodo para vaciar/limpiar el arrayList.
	public void vaciar() {
		this.listadoDeCargas.clear();

	}

	public boolean agregarCarga(Carga carga) {
		boolean agregada = this.cargaSinDuplicados.add(carga);
		return agregada;
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

	public boolean existe(Carga cargaABuscar) {
		// Este metodo no tiene pruebas, es para mostrar como comparar con equals en
		// lugar de accerer al ID del objeto en la coleccion

		return this.listadoDeCargas.contains(cargaABuscar);

		// Carga1
		// Carga2
		// Carga3

//		for (Carga carga : this.cargas) {
//
//			if (carga.equals(cargaABuscar)) {
//				return true;
//			}
//
//		}
//		return false;

//		for (int i = 0; i < array.length; i++) {
//			
//			if(array[i] != null && array[i].getId() == id) {
//				
//			}
//		}
	}

}

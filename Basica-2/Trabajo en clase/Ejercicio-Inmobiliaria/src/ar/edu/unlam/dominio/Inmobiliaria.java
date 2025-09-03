package ar.edu.unlam.dominio;

import java.util.ArrayList;
import java.util.HashSet;

public class Inmobiliaria {

	// Atributos

	ArrayList <Propiedad> listadoDePropiedades;
	HashSet <Cliente> listadoDeClientes;

	public Inmobiliaria() {
		this.listadoDePropiedades = new ArrayList<>();
		this.listadoDeClientes = new HashSet<>();
	}

	/*
	 * 1. Agregar nuevas propiedades (Las propiedades se pueden repetir, porque
	 * distintos vendedores pueden cargar una misma propiedad con diferentes valores
	 * de venta por ejemplo)
	 */

	public Boolean agregarPropiedadAlArray(Propiedad nuevaPropiedad) {
		boolean seAgrego = this.listadoDePropiedades.add(nuevaPropiedad);
		return seAgrego;
	}

	/*
	 * 2. Modificar propiedades existentes (La búsqueda de propiedad se realiza por
	 * código)
	 */

	public void modificarElPrecioDeLaPropiedadPorCodigo(Integer codigoBuscado, Double nuevoPrecio) {

		for (Propiedad propiedad : listadoDePropiedades) {
			if (propiedad.getCodigoPropiedad().equals(codigoBuscado)) { // PREGUNTAR SI VA ACA O EN EL TEST EL SET.
				propiedad.setPrecioDeLaPropiedad(nuevoPrecio);
			}
		}

	}

	// 3. Agregar clientes (Son aquellos que se encuentran en búsqueda de una
	// propiedad. No se puede
	// agregar dos clientes con un mismo DNI)

	public Boolean agregarUnCliente(Cliente clienteNuevo) {

		return this.listadoDeClientes.add(clienteNuevo);
	}

	/*
	 * 4. Buscar propiedades por diferentes parámetros: a. Rango de precios b.
	 * Ubicación (Ciudad)
	 * 
	 */

	public Propiedad buscarPropiedadPorPrecio(Double precioBuscado) {

		for (Propiedad propiedad : this.listadoDePropiedades) {

			if (propiedad.getPrecio().equals(precioBuscado))
				return propiedad;
		}

		return null;
	}

//	public Propiedad buscarPropiedadPorUbicacion(String ubicacionBuscada) {
//
//		for (Propiedad propiedad : listadoDePropiedades) {
//
//			if (propiedad.getUbicacion().equalsIgnoreCase(ubicacionBuscada))
//				return propiedad;
//		}
//		return null;
//	}

	public ArrayList<Propiedad> buscarPropiedadesPorUbicacion(String ubicacionBuscada) {
	    ArrayList<Propiedad> propiedadesEncontradas = new ArrayList<>();

	    for (Propiedad propiedad : listadoDePropiedades) {
	        if (propiedad.getUbicacion().equalsIgnoreCase(ubicacionBuscada)) {
	            propiedadesEncontradas.add(propiedad);
	        }
	    }

	    return propiedadesEncontradas; // Devuelve la lista completa (puede estar vacía si no hay coincidencias)
	}
	/*
	 * 5. Realizar la venta de una propiedad
	 * 
	 */
	public void realizarVentaDeUnaPropiedad(Integer codigoPropiedadAVender) {

		for (Propiedad datosPropiedades : listadoDePropiedades) {

			if (datosPropiedades.getCodigoPropiedad().equals(codigoPropiedadAVender)) {
				datosPropiedades.setEstaVendida(true);
			}
		}
	}

}

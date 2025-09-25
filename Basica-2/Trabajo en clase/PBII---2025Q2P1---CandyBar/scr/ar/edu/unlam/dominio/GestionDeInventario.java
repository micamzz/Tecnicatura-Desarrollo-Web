package ar.edu.unlam.dominio;

import java.util.HashSet;
import java.util.Set;

public class GestionDeInventario {

	private Set <Producto> listadoDeProductos;
	
	public GestionDeInventario() {
		this.listadoDeProductos = new HashSet <> ();
	}
	
	
	public Boolean agregarProducto(Producto producto) {
		return this.listadoDeProductos.add(producto);
	}
	
	
	
}

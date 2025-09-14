package ar.edu.unlam.dominio;

import java.util.ArrayList;
import java.util.List;

public class GestionDeFacturacion {

	List <Producto> listadoDeProductos;

	public GestionDeFacturacion() {
		this.listadoDeProductos = new ArrayList<>();
	}
	
	
	public boolean agregarUnProducto(Producto producto) {
		return this.listadoDeProductos.add(producto);
	}

	
	public Integer obtenerCantidadDeProductos() {
		return listadoDeProductos.size();
	}
	
	public Double obtenerPrecioFinalDeCompra() {
		Double precioFinal = 0D;
		
		for (Producto producto : listadoDeProductos) {
			precioFinal += producto.calcularPrecioFinal();
			
		}
		return precioFinal;
	}
	
}

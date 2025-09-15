package ar.edu.unlam.dominio;

import java.util.ArrayList;
import java.util.List;

public class GestionDeProductos {

	private List<Producto> listadoDeProductos;

	public GestionDeProductos() {
		this.listadoDeProductos = new ArrayList<>();
	}

	public Boolean agregarProductosAVender(Producto productoVenta) {

		return this.listadoDeProductos.add(productoVenta);
	}

	public Double obtenerPrecioTotal() {
		Double precioFinal = 0D;
		for (Producto producto : listadoDeProductos) {
			precioFinal += producto.obtenerPrecio();
		}
		return precioFinal;
	}

	
	public Double obtenerPrecioFinalPerecedero() {
		Double precioFinal = 0D;

		for (Producto producto : listadoDeProductos) {
			if (producto instanceof ProductoPerecedero) {
				precioFinal += producto.obtenerPrecio();
			}
		}
		return precioFinal;
	}

	public Double obtenerPrecioFinalNoPerecedero() {
		Double precioFinal = 0D;

		for (Producto producto : listadoDeProductos) {
			if (producto instanceof ProductoNoPerecedero) {
				precioFinal += producto.obtenerPrecio();
			}
		}
		return precioFinal;
	}

}

package ar.edu.unlam.dominio;

import java.util.ArrayList;
import java.util.List;

public class CandyBar {

	private Integer cantidad;
	private List <Producto> listadoDeProductos;
	
	public CandyBar (Integer cantidad) {
		this.cantidad = cantidad;
		this.listadoDeProductos = new ArrayList<>();
	}
	
	
	
	public Boolean agregarProducto(Producto producto) {
		   if (this.listadoDeProductos.size() < cantidad) {
		        return this.listadoDeProductos.add(producto);
		    }
		    return false;
		}
	
//	public Integer contarProductosEnInventario() {
//		return this.listadoDeProductos.size();
//	}
	
	public Boolean eliminarProducto (String nombre) {
		
	for (int i = 0; i < listadoDeProductos.size(); i++) {
		   Producto p = listadoDeProductos.get(i);
		if(p !=null && listadoDeProductos.get(i).getNombre().equalsIgnoreCase(nombre)){
			listadoDeProductos.set(i, null);
			return true;	
	}
			}
	
		
		return false;
	}



	public Producto [] obtenerInventario() {
		Producto [] inventarioArray = new Producto [cantidad];
		for (int i = 0; i < listadoDeProductos.size(); i++) {
			inventarioArray[i] = listadoDeProductos.get(i);			
		}
		return inventarioArray;
	}
	
}

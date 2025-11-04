package ar.edu.unlam.dominio;

import ar.edu.unlam.interfaces.Calculable;

public abstract class Plan implements Calculable{
	
 private Integer IdPlan; 
 private String nombre;
 private Double precioBase;
 
 public Plan (Integer id, String nombre) {
	 this.IdPlan = id;
	 this.nombre = nombre;
	 this.precioBase=5000D;
 }

public Double getPrecioBase() {
	return precioBase;
}


  
 
 
}

package ar.edu.unlam.dominio;

public class ProductoElectronico extends Producto{

       private Double porcentajeDeRecargo;
	
	public ProductoElectronico(String nombre, Double precio, String descripcion) {
		super(nombre, precio, descripcion);
		
		this.porcentajeDeRecargo = 0.15;
	}
	

	@Override
	public Double calcularPrecioFinal() {

      Double montoFinal=0.0;
      
      montoFinal = getPrecio() +(getPrecio() * this.porcentajeDeRecargo);
	 
      return montoFinal;
		
	}
	
	
	

}

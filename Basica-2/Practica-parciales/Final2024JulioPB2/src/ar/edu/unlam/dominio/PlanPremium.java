package ar.edu.unlam.dominio;

public class PlanPremium extends Plan {

	private Double porcentaje = 0.20;
	
	
	public PlanPremium(Integer id, String nombre) {
		super(id, nombre);
		
	}


	
	@Override
	public Double obtenerPrecio() {
		Double precio = 0D;

		precio = super.getPrecioBase() + (super.getPrecioBase() * this.porcentaje);

		return precio;

	}

}

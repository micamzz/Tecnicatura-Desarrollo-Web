package ar.edu.unlam.dominio;

public class PlanBasico extends Plan {

	
	private Double precioBase=5000D;
	
	
	public PlanBasico(Integer id, String nombre) {
		super(id, nombre);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Double obtenerPrecio() {
		return super.getPrecioBase();
	}

}

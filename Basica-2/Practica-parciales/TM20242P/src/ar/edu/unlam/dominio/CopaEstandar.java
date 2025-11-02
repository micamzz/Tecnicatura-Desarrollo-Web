package ar.edu.unlam.dominio;

public class CopaEstandar extends Copa {

	
	private static Integer stock=100;
	
	
	public CopaEstandar(TipoMaterial tipoMaterial) {
		super(tipoMaterial);
		 this.manoDeObra = 0.20D;
		
	}

	
	public static Integer getStock() {
		return stock;
	}



	public void restarStock() {
		stock--;
		
	}

	@Override
	public Double obtenerPrecio() {
		Double precioFinal = super.getPRECIO_BASE();
		
		precioFinal += (precioFinal * this.manoDeObra );
		
		return precioFinal;
	}



	
	
	
	

}

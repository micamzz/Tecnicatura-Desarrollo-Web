package ar.edu.unlam.dominio;

public class CopaPersonalizada extends Copa {

	
	private tipoAtril tipoColor;
	
	public CopaPersonalizada(TipoMaterial tipoMaterial,tipoAtril tipoColor) {
		super(tipoMaterial);
		this.tipoColor= tipoColor;
		 this.manoDeObra = (0.15D + tipoColor.getDescuento());
	}

	@Override
	public Double obtenerPrecio() {
		Double precioFinal = super.getPRECIO_BASE();
		
		precioFinal += (precioFinal * this.manoDeObra );
		
		return precioFinal;
	}

}

package ar.edu.unlam.menum;

public enum TipoBicicleta {
	
	
	PASEO(0D),
	MONTANIA(0.20D);
	
	 Double porcentaje;
	
	TipoBicicleta(Double porcentaje){
		this.porcentaje = porcentaje;
	}

	public Double getPorcentaje() {
		return porcentaje;
	}

}

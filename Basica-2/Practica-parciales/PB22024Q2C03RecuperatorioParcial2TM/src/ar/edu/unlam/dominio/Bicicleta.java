package ar.edu.unlam.dominio;

import ar.edu.unlam.menum.TipoBicicleta;

public class Bicicleta extends Vehiculo {

	
	private TipoBicicleta tipoBici;
	private Boolean tieneFrenoADisco;
	
	public Bicicleta(Integer numeroUnico, String nombre, TipoBicicleta tipoBici) {
		super(numeroUnico, nombre);
		this.tipoBici = tipoBici;
		this.setPrecioBase(5000D);
		
		if(tipoBici == TipoBicicleta.PASEO) {
			this.tieneFrenoADisco = false;
		} 
		else if(tipoBici == TipoBicicleta.MONTANIA) {
			this.tieneFrenoADisco = true;
		} 
	}

	public TipoBicicleta getTipoBici() {
		return tipoBici;
	}

	@Override
	public Double obtenerPrecio(Integer horas) {
		Double precioFinal =0D;
		
		if(tipoBici == TipoBicicleta.PASEO) {
			precioFinal = this.getPrecioBase() * horas;
		}
		
		if(tipoBici == TipoBicicleta.MONTANIA) {
			precioFinal = this.getPrecioBase() * horas * (1 + tipoBici.getPorcentaje());
		}
		return precioFinal;
	}

	
	

}

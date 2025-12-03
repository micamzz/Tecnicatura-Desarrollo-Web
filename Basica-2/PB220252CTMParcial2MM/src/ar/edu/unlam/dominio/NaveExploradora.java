package ar.edu.unlam.dominio;

import ar.edu.unlam.menum.TipoAlcance;

public class NaveExploradora extends Nave {

	
 	private TipoAlcance tipoAlcance;
	
	public NaveExploradora(String idUnico, String nombre, TipoAlcance tipoAlcance) {
		super(idUnico, nombre);
		
		super.setCapacidadMaximaCombustible(10000D);
		this.tipoAlcance  = tipoAlcance;
		super.setConsumoBase(50D);
	}

	@Override
	public Double calcularConsumo() {
		Double consumo =0D;
		
		if(this.tipoAlcance == TipoAlcance.CORTO) {
			consumo  = super.getConsumoBase() * 0.9;
		}
		
		if(this.tipoAlcance == TipoAlcance.LARGO) {
			consumo  = super.getConsumoBase() * 0.8;
		}
		
		return consumo;
		
	}

	@Override
    public String toString() {
        return "NaveExploradora { nombre=" + super.getIdUnico() + ", id=" + super.getIdUnico()+ " }";
    }
}

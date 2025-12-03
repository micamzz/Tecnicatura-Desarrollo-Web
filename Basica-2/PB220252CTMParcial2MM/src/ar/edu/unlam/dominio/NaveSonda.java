package ar.edu.unlam.dominio;

public class NaveSonda extends Nave {

	

	public NaveSonda(String idUnico, String nombre) {
		super(idUnico, nombre);
		super.setConsumoBase(10D);
		super.setCapacidadMaximaCombustible(80D);
	}

	

	@Override
	public Double calcularConsumo() {
		return super.getConsumoBase();
	}

}

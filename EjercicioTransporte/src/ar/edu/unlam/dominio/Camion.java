package ar.edu.unlam.dominio;

public class Camion extends Vehiculo  {

	private Double capacidadDeToneladas;
	
	public Camion(String patente, String marca, Integer anioDeFabricacion, Double capacidadDeToneladas) {
		super(patente, marca, anioDeFabricacion);
		
		this.capacidadDeToneladas = capacidadDeToneladas;
	
	}


	@Override
	public Double calcularCostoDeMantenimiento() {
		final Double COSTO_MANTENIMIENTO=5000D;
		
		return this.capacidadDeToneladas * COSTO_MANTENIMIENTO;
	}

}

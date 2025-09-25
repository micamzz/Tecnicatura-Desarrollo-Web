package ar.edu.unlam.dominio;

public class Auto extends Vehiculo {

	private Integer cantidadDePuertas;
	
	public Auto(String patente, String marca, Integer anioDeFabricacion,Integer cantidadDePuertas) {
		super(patente, marca, anioDeFabricacion);
		this.cantidadDePuertas = cantidadDePuertas;
		
	}

	@Override
	public Double calcularCostoDeMantenimiento() {
		final Double COSTO_MANTENIMIENTO=1000D;
		
		return this.cantidadDePuertas * COSTO_MANTENIMIENTO;
	}

	
}

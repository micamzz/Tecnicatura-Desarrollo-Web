package ar.edu.unlam.dominio;

public class Moto extends Vehiculo   {

	
	private String patente;
	private Integer litros;
	private Integer cilindrada;
	
	
	public Moto(Integer numeroUnico, String nombre, String patente, Integer litros, Integer cilindrada) {
		super(numeroUnico, nombre);
		this.patente = patente;
		this.litros = litros;
		this.cilindrada = cilindrada;
		this.setPrecioBase(10000D);
	}


	public String getPatente() {
		return patente;
	}


	@Override
	public Double obtenerPrecio(Integer horas) {
		
		return this.getPrecioBase() * horas;
	}






}

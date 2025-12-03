package ar.edu.unlam.dominio;

public class NaveCarguera extends Nave {

	
	private Double tonelajeDeCarga;
	private Double cilindradaDelMotor;
	
	
	
	
	public NaveCarguera(String idUnico, String nombre,Double tonelajeDeCarga, Double cilindradaDelMotor) {
		super(idUnico, nombre);
		super.setCapacidadMaximaCombustible(10000D);
		this.tonelajeDeCarga = tonelajeDeCarga;
		this.cilindradaDelMotor = cilindradaDelMotor;
		super.setConsumoBase(40D);
	}




	public Double getTonelajeDeCarga() {
		return tonelajeDeCarga;
	}



	@Override
	public Double calcularConsumo() {
		Double porcentaje = 0.05;
		Double consumo=0D;
		
		consumo = super.getConsumoBase() + (super.getConsumoBase() * porcentaje * this.tonelajeDeCarga);
		return consumo;
	}

	
	
	
	
	
	
	
}

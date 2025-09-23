package ar.edu.unlam.dominio;

public class CuentaCorriente extends Cuenta implements Extraible{

	private Double limiteDescubierto;
	
	public CuentaCorriente(Integer cbu, Cliente cliente,Double limiteDescubierto) {
		super(cbu, cliente);
	 this.limiteDescubierto = limiteDescubierto;
	}


	@Override
	public Boolean extraer(Double montoAExtraer) {
		Boolean seExtrajo = false;

		if (montoAExtraer <= (super.getSaldo() + this.limiteDescubierto)) {
			Double montoAActualizar = getSaldo() - montoAExtraer;
			super.setSaldo(montoAActualizar);
			seExtrajo = true;
		}

		return seExtrajo;
	}
	
}

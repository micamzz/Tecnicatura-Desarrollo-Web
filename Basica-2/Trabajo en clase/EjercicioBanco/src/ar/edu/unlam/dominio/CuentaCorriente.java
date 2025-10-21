package ar.edu.unlam.dominio;

public class CuentaCorriente extends Cuenta implements Extraible{

	private Double limiteDescubierto;
	
	public CuentaCorriente(Integer cbu, Cliente cliente,Double limiteDescubierto) {
		super(cbu, cliente);
	 this.limiteDescubierto = limiteDescubierto;
	}


	@Override
	public Boolean extraer(Double montoAExtraer) throws SaldoInsuficienteException {
	
		Double saldoTotalEnCuenta = super.getSaldo() + this.limiteDescubierto;
		
		if (montoAExtraer > saldoTotalEnCuenta)
			throw new SaldoInsuficienteException("No se puede extraer mas del saldo permitido");
		
		Double montoAActualizar = getSaldo() - montoAExtraer;
			super.setSaldo(montoAActualizar);

		return true;
	
}
	
}

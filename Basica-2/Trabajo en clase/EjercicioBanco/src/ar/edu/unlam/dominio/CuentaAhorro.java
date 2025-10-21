package ar.edu.unlam.dominio;

public class CuentaAhorro extends Cuenta implements Extraible{

	public CuentaAhorro(Integer cbu, Cliente cliente) {
		super(cbu, cliente);
		
	}

	
	@Override
	public Boolean extraer(Double montoAExtraer) throws SaldoInsuficienteException {

		if (montoAExtraer > super.getSaldo()) {
			throw new SaldoInsuficienteException("No se puede extraer mas del saldo disponible");
		}

		this.setSaldo(getSaldo() - montoAExtraer);
		return true;

	}





	
	
}

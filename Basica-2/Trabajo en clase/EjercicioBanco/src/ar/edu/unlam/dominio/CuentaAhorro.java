package ar.edu.unlam.dominio;

public class CuentaAhorro extends Cuenta implements Extraible{

	public CuentaAhorro(Integer cbu, Cliente cliente) {
		super(cbu, cliente);
		
	}

	
	@Override
	public Boolean extraer(Double montoAExtraer) {
	Boolean seExtrajo = false;

	if (montoAExtraer <= super.getSaldo()) {
		this.setSaldo(getSaldo()-montoAExtraer);
		seExtrajo = true;
	}

	return seExtrajo;
}





	
	
}

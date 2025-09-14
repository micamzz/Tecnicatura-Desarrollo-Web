package ar.edu.unlam.dominio;

public class MercadoPago  extends MetodoDePago {

	private static final Double RECARGO= 1.12D;


	public MercadoPago() {
		super();
	}


	@Override
	public Double procesarPago(Double monto) {
		 Double montoAPagar = monto * RECARGO;
		 
		 super.setSaldoAPagar(montoAPagar);
		return montoAPagar;
	}
	
	
}

package ar.edu.unlam.dominio;

public class TransferenciaBancaria extends MetodoDePago {


	public static final Double COSTO_DE_TRANSACCION = 0.01;
	 private static final Double LIMITE_SIN_RECARGO = 100000D;

	public TransferenciaBancaria() {
		super();
	}


	@Override
	public Double procesarPago(Double monto) {
	
		Double montoAPagar = monto;

		if (monto > LIMITE_SIN_RECARGO) {
			montoAPagar += monto * COSTO_DE_TRANSACCION;

		}
         super.setSaldoAPagar(montoAPagar);
		return montoAPagar;
	}

	
	
}
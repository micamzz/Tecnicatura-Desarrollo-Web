package ar.edu.unlam.dominio;

public class TarjetaDeCredito extends MetodoDePago{

	private Double saldoDisponible;
	private static final Double RECARGO= 1.227D;
	
	
	public TarjetaDeCredito(Double saldoDisponible) {
		super();
		this.saldoDisponible = saldoDisponible;
	}


	@Override
	public Double procesarPago(Double monto) {
		
		if (this.saldoDisponible < monto) {
			return 0D;
		}
			
		Double montoAPagar  = monto * RECARGO;

         super.setSaldoAPagar(montoAPagar);
		return montoAPagar;
	}


	
}

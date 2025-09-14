package ar.edu.unlam.dominio;

public class MetodoDePago {

	private Double saldoAPagar;
	
	public MetodoDePago() {
		this.saldoAPagar =0D;
	
	}


	public Double getSaldoAPagar() {
		return this.saldoAPagar;
	}
	
	 public void setSaldoAPagar(Double saldoAPagar) {
	        this.saldoAPagar = saldoAPagar;
	    }

	public Double procesarPago(Double monto) {
		this.saldoAPagar += monto;
		return this.saldoAPagar;
	}
	
	

	
	
	
}

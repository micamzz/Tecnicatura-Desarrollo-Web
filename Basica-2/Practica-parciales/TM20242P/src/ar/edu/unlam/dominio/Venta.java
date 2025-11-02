package ar.edu.unlam.dominio;

public class Venta {

	private Cliente comprador;
	private Copa copaComprada;
	
	public Venta(Cliente comprador, Copa copa) {
		this.comprador = comprador;
		this.copaComprada = copa;
		
	}

	public Cliente getComprador() {
		return comprador;
	}

	public void setComprador(Cliente comprador) {
		this.comprador = comprador;
	}

	public Copa getCopaComprada() {
		return copaComprada;
	}

	public void setCopaComprada(Copa copaComprada) {
		this.copaComprada = copaComprada;
	}
	
	
	
	
	
}

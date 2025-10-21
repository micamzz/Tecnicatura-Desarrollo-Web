package ar.edu.unlam.dominio;

public abstract class Cuenta {
	
	public static Integer proximoId=0;
	private Integer id;
	private Integer cbu;
	private Cliente cliente;
	private Double saldo;

	
	
	public Cuenta(Integer cbu, Cliente cliente) {
		this.cbu = cbu;
		this.cliente = cliente;
		this.saldo = 0D;
		
		this.id=++proximoId;// Primero incrementa
	}
	
	public Double getSaldo() {
		return this.saldo;
	}


	public void depositar(Double montoADepositar) {
		this.saldo += montoADepositar;
		
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setSaldo(Double montoAActualizar) {
		this.saldo = montoAActualizar;
	}


	public Integer getCbu() {
		return cbu;
	}

	public void setCbu(Integer cbu) {
		this.cbu = cbu;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	
}

package ar.edu.unlam.dominio;

public class BaseDeDato extends MaquinaVirtual{

	private  final static Double PRECIO_BASE=1000D;
	private  final Integer LIMITE_DE_USO_EN_HS;
	private Integer almacenamientoOcupado;
	private Integer horasDeUso;
	
	
	public BaseDeDato(Integer almacenamientoOcupado) {
		super(20D, PRECIO_BASE);
		this.almacenamientoOcupado = almacenamientoOcupado;
		this.LIMITE_DE_USO_EN_HS = 100;
		this.horasDeUso = 0;
	}


	public Integer getAlmacenamientoOcupado() {
		return almacenamientoOcupado;
	}


	public void setAlmacenamientoOcupado(Integer almacenamientoOcupado) {
		this.almacenamientoOcupado = almacenamientoOcupado;
	}


	public Integer getLIMITE_DE_USO_EN_HS() {
		return LIMITE_DE_USO_EN_HS;
	}

	public void setHorasDeUso(Integer horas) {
	this.horasDeUso = horas;
	}

	@Override
	public Double calcularCostoTotal() {
	Double precio = PRECIO_BASE;
	
	precio += (almacenamientoOcupado * 10) + (this.horasDeUso * 5) ;
	
	return precio;
	
	}


	@Override
	public int compareTo(MaquinaVirtual o) {
		return this.calcularCostoTotal().compareTo(o.calcularCostoTotal()) * (-1);
	}


	
	
	
}
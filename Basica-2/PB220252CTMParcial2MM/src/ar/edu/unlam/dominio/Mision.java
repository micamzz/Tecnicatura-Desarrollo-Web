package ar.edu.unlam.dominio;

public class Mision {

	
	private static Integer proximoId=0;
	private Integer id;
	private Integer horasMision;
	private Nave nave;

	public Mision(Nave nav, Integer horasMision) {
		this.nave = nav;
		this.horasMision = horasMision;
		this.id = ++proximoId;
	}

	public Nave getNave() {
		return nave;
	}

	
	
	public Double obtenerConsulmoDeCombustiblePorMision() {
		return nave.calcularConsumo() * this.horasMision;
		
	}

	public Integer getId() {
		return id;
	}
	
	
	
	
	
}

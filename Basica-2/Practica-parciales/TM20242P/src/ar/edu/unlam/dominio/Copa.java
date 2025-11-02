package ar.edu.unlam.dominio;

public abstract class Copa {
	
	private static Integer proximoId=0;
	private Integer id;
	private final  Double PRECIO_BASE;
	private TipoMaterial tipoMaterial;
	 protected Double manoDeObra;
	
	
	public Copa (TipoMaterial tipoMaterial) {
		this.tipoMaterial= tipoMaterial;
		this.id = ++this.proximoId;		
		this.PRECIO_BASE = 2000D;
		
	}
	

	public Double getPRECIO_BASE() {
		return PRECIO_BASE;
	}
	
	public abstract Double obtenerPrecio();

	public Integer getId() {
		return id;
	}


	
	
	

}

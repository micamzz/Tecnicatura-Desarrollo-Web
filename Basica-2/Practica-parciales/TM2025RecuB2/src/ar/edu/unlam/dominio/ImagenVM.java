package ar.edu.unlam.dominio;

public class ImagenVM extends MaquinaVirtual{

	private  final static Double PRECIO_BASE=500D;
	
	private final Integer LIMITE_DE_LECTURAS;
	private final Integer LIMITE_DE_ESCRITURAS;
	private Integer horasLectura;
	private Integer horasEscritura;
	
	public ImagenVM() {
		super(5D, PRECIO_BASE);
		this.LIMITE_DE_ESCRITURAS = 100;
		this.LIMITE_DE_LECTURAS = 100;
		this.horasLectura=0;
		this.horasEscritura=0;
	}

	
	public static Double getPrecioBase() {
		return PRECIO_BASE;
	}


	public Integer getLIMITE_DE_LECTURAS() {
		return LIMITE_DE_LECTURAS;
	}


	public Integer getLIMITE_DE_ESCRITURAS() {
		return LIMITE_DE_ESCRITURAS;
	}
	
	
	public void setHoraslectura(Integer horaslectura) {
		this.horasLectura += horaslectura;
	}


	public void setHorasEscritura(Integer horasEscritura) {
		this.horasEscritura += horasEscritura;
	}


	@Override
	public Double calcularCostoTotal() {
	
		 Double costoLecturas = horasLectura * 1.0;
		 Double costoEscrituras = horasEscritura * 2.0;
	    return PRECIO_BASE + costoLecturas + costoEscrituras;
	    
	    
//	    Double precio = PRECIO_BASE;
//	    precio += (horasLectura * 1) + (horasEscritura * 2);
//	    return precio;
	}


	@Override
	public int compareTo(MaquinaVirtual o) {
		return this.calcularCostoTotal().compareTo(o.calcularCostoTotal()) * (-1);
	}


}

package ar.edu.unlam.dominio;

public enum TipoDePlanMedico {
	
	NO_POSEE(1500D, "1 - No Posee"),
	BASICO(800D, "2 -Plan Basico"),
	PLUS(300D, "3 - Plan Plus"),
	PREMIUN(0D, "4- Plan Premium");

	Double precioCopago;
	String mensaje;
	
	TipoDePlanMedico(Double precioCopago, String mensaje){
		this.precioCopago = precioCopago;
		this.mensaje =mensaje;
	
	}
	
	
	public Double getPrecioCopago() {
		return this.precioCopago;
	}
	public String getMensaje() {
		return mensaje;
	}
}

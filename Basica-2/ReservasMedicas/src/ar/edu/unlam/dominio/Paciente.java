package ar.edu.unlam.dominio;

public class Paciente extends Persona{

	private TipoDePlanMedico tipoDePlan;
	
	public Paciente(String nombre, String apellido, Integer dni, Integer edad,TipoDePlanMedico tipoDePlan) {
		super(nombre, apellido, dni, edad);
		
		this.tipoDePlan = tipoDePlan;
	}

	
	
	
	
	public TipoDePlanMedico getTipoDePlan() {
		return tipoDePlan;
	}





	public void setTipoDePlan(TipoDePlanMedico tipoDePlan) {
		this.tipoDePlan = tipoDePlan;
	}





	@Override
	public String toString() {
		return "Paciente " + getNombreCompleto() ;
}

}

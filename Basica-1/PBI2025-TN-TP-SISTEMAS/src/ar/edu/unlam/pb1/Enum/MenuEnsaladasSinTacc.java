package ar.edu.unlam.pb1.Enum;

public enum MenuEnsaladasSinTacc {
	CAESAR ("1- Caesar (Lechuga manteca, queso parmesano, crutones y aderezo"),
	COLESLAW ("2 - Pollo Crispy ( Repollo, zanahoria, cebolla, pollo crispy, crutones con aderezo coleslaw"),
	GUACAMOLE ("3 - Guacamole (Lechuga, guacamole, tomate, pollo, pepinillos, garbanzos fritos y queso prato");
	
	private String mensaje;
	
	
	private MenuEnsaladasSinTacc(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public String toString() {
		return this.mensaje;
	}

}

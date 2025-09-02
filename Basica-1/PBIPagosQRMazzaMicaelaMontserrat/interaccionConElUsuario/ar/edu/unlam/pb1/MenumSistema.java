package ar.edu.unlam.pb1;

public enum MenumSistema {
AGREGAR_PRODUCTO ("1 - Agregar producto"),
AGREGAR_VENTA("2 - Agregar una venta"),
VER_RESUMEN("3 - Ver resumen"),
SALIR("4 - Salir");



private String mensaje;
	
private MenumSistema(String mensaje) {
	this.mensaje = mensaje;
	
}


public String toString() {
	return this.mensaje;
	
}

}

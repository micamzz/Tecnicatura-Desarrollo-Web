package ar.edu.unlam.pb1.parcial.dominio;

public enum MenuRestaurante {
	
	AGREGAR_INGREDIENTES("1 - Agregar ingredientes"),
	CREAR_ENSALADA("2 - Crear ensaladas"),
	CREAR_PEDIDO("3 - Crear pedido"),
	FINALIZAR_PEDIDO("4 - Finalizar pedido"),
	SALIR("5 - Salir");
	
	
	private String mensaje;
	
	private MenuRestaurante(String mensaje) {
		this.mensaje = mensaje;
	}

	
	public String toString(){
		
		return mensaje;
	}
	
}

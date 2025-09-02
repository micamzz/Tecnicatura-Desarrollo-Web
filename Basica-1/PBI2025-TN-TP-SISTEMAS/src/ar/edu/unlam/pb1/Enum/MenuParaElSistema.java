package ar.edu.unlam.pb1.Enum;

public enum MenuParaElSistema {
	ACTUALIZAR_NOMBRE_DEL_SISTEMA("1 - Actualizar el nombre del Sistema"),
	AGREGAR_UN_NUEVO_USUARIO("2 - Agregar un nuevo usuario"),
	LOGUEAR_DESLOGUEAR_UN_USUARIO("3 - Para iniciar o finalizar la sesion"),
	DESBLOQUEAR_USUARIO("4 - Desbloquear usuario"), VER_ESTADO_DE_LOS_USUARIOS("5 - Ver estado de los usuarios"),
	BUSCAR_USUARIO_POR_NOMBRE_DE_USUARIO("6 - Buscar un usuario por nombre de Usuario"),
	BUSCAR_USUARIOS_BLOQUEADOS("7 - Buscar usuarios bloqueados"),
	BUSCAR_USUARIOS_LOGUEADOS("8 - Buscar usuarios logueados "),
	CALCULAR_CANTIDAD_DE_USUARIOS_MENORES("9 - Calcular la cantidad de usuarios menores de edad"),
	CALCULAR_EL_PROMEDIO_DE_EDAD("10 - Calcular el promedio de edad de los usuarios registrados"),
	BUSCAR_AL_USUARIO_MAS_PEQUENIO("11 - Buscar al usuario mas pequeño"),
	BUSCAR_AL_USUARIO_MAS_VIEJO("12 - Buscar al usuario mas viejo"), SALIR("13 - Salir");

	private String mensaje;

	// Constructor
	private MenuParaElSistema(String mensaje) {
		this.mensaje = mensaje;
	}

	public String toString() {
		return mensaje;
	}

}

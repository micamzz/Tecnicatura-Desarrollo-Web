package ar.edu.unlam.pb1.dominio;

public class Sistema {

	// Atributos
	private String nombre;
	private Usuario listaDeUsuarios[]; // Arraylist de tipo objeto Usuario
	private final int CANTIDAD_MAXIMA_DE_USUARIOS = 5; // Constante para declarar la cantidad de usuarios para ingresar
														// en el array

	// Constructor

	public Sistema(String nombre) {
		this.nombre = nombre;
		this.listaDeUsuarios = new Usuario[CANTIDAD_MAXIMA_DE_USUARIOS];
	}

	// Métodos

	public void setNombreSistema(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreSistema() {
		return this.nombre;
	}

	// Método para ingresar usuario

	public boolean ingresarUsuarios(Usuario usuarioNuevo) { // al objeto Usuario para que se guarden los datos ahi.

		for (int i = 0; i < listaDeUsuarios.length; i++) {
			if (listaDeUsuarios[i] == null) { // Si hay un lugar vacio en el array que guarde al Usuario
				listaDeUsuarios[i] = usuarioNuevo;
				return true;
			}
		}
		return false;
	}

	// Método para comprobar si esta lleno el array
	public boolean estaLleno() {
		for (int i = 0; i < listaDeUsuarios.length; i++) {
			if (listaDeUsuarios[i] == null)
				return false; // Si hay lugar en el array, devuelve false }
		}
		return true; // si esta lleno devuelve true. }
	}

	// Método que compruebe si al menos hay un usuario cargado

	public boolean hayUsuariosIngresados() {
		for (int i = 0; i < listaDeUsuarios.length; i++) {
			if (listaDeUsuarios[i] != null) {
				return true;
			}
		}
		return false;
	}

	// Método para comprobar si el usuario existe

	public boolean existeElUsuario(String nombreUsuario) {

		for (int i = 0; i < listaDeUsuarios.length; i++) {
			// si el array es distinto de vacio y coincide el nombre de usuario con uno ya
			// guardado
			if (listaDeUsuarios[i] != null && listaDeUsuarios[i].existeElUsuario(nombreUsuario)) {
				return true;
			}
		}
		return false;
	}

	// Método compara si el dni ya existe
	public boolean existeEldni(int dni) {
		for (int i = 0; i < listaDeUsuarios.length; i++) {
			if (listaDeUsuarios[i] != null && listaDeUsuarios[i].dniRegistrado(dni)) {
				return true;
			}
		}
		return false;
	}

	public boolean elDniYaEstaLogueado(int dni) {

		for (int i = 0; i < listaDeUsuarios.length; i++) {
			if (listaDeUsuarios[i] != null && listaDeUsuarios[i].dniRegistrado(dni)
					&& listaDeUsuarios[i].estaLogueado() == true) {
				return true;
			}
		}
		return false;
	}

	// Métodos para loguear el usuario

	public boolean loguearUsuario(int dni, String Usuario, String Contrasenia) {

		for (int i = 0; i < listaDeUsuarios.length; i++) {

			if ((listaDeUsuarios[i] != null) && listaDeUsuarios[i].dniRegistrado(dni)) {

				if (listaDeUsuarios[i].getUsuario().equalsIgnoreCase(Usuario)
						&& listaDeUsuarios[i].getContrasenia().equals(Contrasenia)) {
					listaDeUsuarios[i].setEstadoDeLogueo(true);
					return true;

				} else { // si no coincide usuario y contra que incremente el contador
					int contadorDeIntentos = listaDeUsuarios[i].getContadorDeIntentos() + 1;
					listaDeUsuarios[i].setContadorDeIntentos(contadorDeIntentos);

					if (contadorDeIntentos >= 3) {
						listaDeUsuarios[i].setBloqueado(true);

						return false;
					}
				}

			}
		}
		return false;
	}

	// Método para verificar si el usuario esta bloqueado
	public boolean estaBloqueado(String nombre) {

		for (int i = 0; i < listaDeUsuarios.length; i++) {

			if ((listaDeUsuarios[i] != null) && listaDeUsuarios[i].getUsuario().equals(nombre)) {
				listaDeUsuarios[i].setEstadoDeLogueo(false);
				return listaDeUsuarios[i].estaBloqueado(); // devuelve el estado del bloqueo
			}
		}
		return false;
	}

	public boolean estaBloqueado(int dni) {

		for (int i = 0; i < listaDeUsuarios.length; i++) {

			if ((listaDeUsuarios[i] != null) && listaDeUsuarios[i].getDni() == dni) {
				listaDeUsuarios[i].setEstadoDeLogueo(false);
				return listaDeUsuarios[i].estaBloqueado(); // devuelve el estado del bloqueo
			}
		}
		return false;
	}

	// Métodos para bloquear usuario

	public boolean bloquearUsuario(int dni) {

		for (int i = 0; i < listaDeUsuarios.length; i++) {
			if ((listaDeUsuarios[i] != null) && listaDeUsuarios[i].getDni() == dni) {
				listaDeUsuarios[i].setEstadoDeLogueo(false);
				listaDeUsuarios[i].setBloqueado(true);
				return true;
			}
		}
		return false;
	}

	// Método para cerrar sesión

	public boolean cerrarSesion(String nombreUser) {

		for (int i = 0; i < listaDeUsuarios.length; i++) {

			// si el array no esta vacio y el usuario esta logueado
			if (listaDeUsuarios[i] != null && listaDeUsuarios[i].getUsuario().equalsIgnoreCase(nombreUser)
					&& (listaDeUsuarios[i].estaLogueado() == true)) {
				listaDeUsuarios[i].setEstadoDeLogueo(false); // que cambie el estado de logueo a false
				return true;
			}
		}
		return false;
	}

	// Método para desbloquear usuario

	public boolean desbloquearUsuario(int dni) {

		for (int i = 0; i < listaDeUsuarios.length; i++) {

			// Compara el dni ingresado con el dni del array para desbloquear al usuario
			if ((listaDeUsuarios[i] != null) && listaDeUsuarios[i].getDni() == dni) {
				listaDeUsuarios[i].setBloqueado(false);
				return true;
			}
		}
		return false;
	}

	// Método para buscar por nombre de usuario

	public Usuario buscarUsuario(String usuario) {
		for (int i = 0; i < listaDeUsuarios.length; i++) {
			// busca el nombre en el array y lo devuelve, si no devuelve vacio
			if (listaDeUsuarios[i] != null && listaDeUsuarios[i].getUsuario().equalsIgnoreCase(usuario)) {
				return listaDeUsuarios[i];
			}
		}
		return null;
	}

	// Método para buscar por estado bloqueado

	public Usuario[] buscarUsuarioBloqueados() {

		Usuario resultado[] = new Usuario[listaDeUsuarios.length];

		for (int i = 0; i < listaDeUsuarios.length; i++) {
			if (listaDeUsuarios[i] != null && (listaDeUsuarios[i].estaBloqueado() == true)) {
				resultado[i] = listaDeUsuarios[i];
			}
		}
		return resultado;
	}

	// Método para buscar usuarios por estado de Logueo

	public Usuario[] buscarUsuariosLogueados() {

		Usuario resultado[] = new Usuario[listaDeUsuarios.length];

		for (int i = 0; i < listaDeUsuarios.length; i++) {
			if (listaDeUsuarios[i] != null && listaDeUsuarios[i].estaLogueado()) {
				resultado[i] = listaDeUsuarios[i];
			}
		}
		return resultado;
	}

	// Método para calcular la cantidad de usuarios menores de edad

	public int calcularLaCantidadDeUsuariosMenoresDeEdad() {
		int contador = 0;
		for (int i = 0; i < listaDeUsuarios.length; i++) {
			if ((listaDeUsuarios[i] != null) && (listaDeUsuarios[i].getEdad() < 18)) {
				contador++;
			}
		}
		return contador;
	}

	// Método que devuelve los usuarios menores de edad
	public Usuario[] buscarUsuariosMenoresDeEdad() {
		Usuario resultado[] = new Usuario[listaDeUsuarios.length];

		for (int i = 0; i < listaDeUsuarios.length; i++) {
			if ((listaDeUsuarios[i] != null) && (listaDeUsuarios[i].getEdad() < 18)) {
				resultado[i] = listaDeUsuarios[i];
			}
		}
		return resultado;
	}
	// Método para calcular el promedio de los usuarios registrados en el sistema

	public double calcularElPromedioDeEdadDeLosUsuarios() {
		int sumaDeLasEdades = 0;
		int contadorDePersonasAgregadasEnElSistema = 0;

		for (int i = 0; i < listaDeUsuarios.length; i++) {
			if (listaDeUsuarios[i] != null) {
				sumaDeLasEdades += listaDeUsuarios[i].getEdad();
				contadorDePersonasAgregadasEnElSistema++;
			}
		}
		double promedioDeEdad = (double) sumaDeLasEdades / contadorDePersonasAgregadasEnElSistema;

		return promedioDeEdad;
	}

	// Método para buscar al usuario mas chico de edad

	public Usuario buscarAlUsuarioMasChico() {
		Usuario usuarioMasChico = null;

		for (int i = 0; i < listaDeUsuarios.length; i++) {
			if (listaDeUsuarios[i] != null) {
				if (usuarioMasChico == null || listaDeUsuarios[i].getEdad() < usuarioMasChico.getEdad()) {
					usuarioMasChico = listaDeUsuarios[i];
				}
			}
		}
		return usuarioMasChico;
	}

	// Método para buscar al usuario mas grande de edad

	public Usuario buscarAlUsuarioMasGrande() {
		Usuario usuarioMasGrande = null;
		for (int i = 0; i < listaDeUsuarios.length; i++) {

			if (listaDeUsuarios[i] != null) {
				if (usuarioMasGrande == null || listaDeUsuarios[i].getEdad() > usuarioMasGrande.getEdad()) {
					usuarioMasGrande = listaDeUsuarios[i];
				}
			}
		}
		return usuarioMasGrande;
	}

	public String toString() {
		String resultado = "";

		for (int i = 0; i < listaDeUsuarios.length; i++) {
			if (listaDeUsuarios[i] != null) {
				resultado += listaDeUsuarios[i] + "\n";
			}
		}
		return "Nombre del sistema " + this.nombre.toUpperCase() + " . \n  Los usuarios registrados son : \n"
				+ resultado;

	}

}

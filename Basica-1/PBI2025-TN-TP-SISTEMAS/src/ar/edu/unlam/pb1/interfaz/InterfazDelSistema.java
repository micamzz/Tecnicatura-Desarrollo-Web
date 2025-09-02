package ar.edu.unlam.pb1.interfaz;

import java.util.Arrays;
import java.util.Scanner;

import ar.edu.unlam.pb1.Enum.MenuParaElSistema;
import ar.edu.unlam.pb1.dominio.Sistema;
import ar.edu.unlam.pb1.dominio.Usuario;

public class InterfazDelSistema {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Sistema peya = new Sistema("Pedidos Ya");
		MenuParaElSistema opcionMenu = MenuParaElSistema.AGREGAR_UN_NUEVO_USUARIO;
		// values para que devuelva un array con los valores del enum
		MenuParaElSistema opciones[] = MenuParaElSistema.values();

		System.out.println("============== BIENVENIDO AL SISTEMA " + peya.getNombreSistema().toUpperCase()
				+ "====================");

		do {
			mostrarMenuDeOpciones(opciones);
			int opcionIngresada = teclado.nextInt();
			teclado.nextLine(); // Para limpiar el buffer

			if (opcionIngresada > 0 && opcionIngresada <= opciones.length) {
				MenuParaElSistema opcionSeleccionada = opciones[opcionIngresada - 1];
				opcionMenu = opcionSeleccionada;

				switch (opcionSeleccionada) {

				case ACTUALIZAR_NOMBRE_DEL_SISTEMA:
					actualizarNombreDelSistema(teclado, peya);
					break;

				case AGREGAR_UN_NUEVO_USUARIO:
					agregarUnNuevoUsuario(teclado, peya);
					break;

				case LOGUEAR_DESLOGUEAR_UN_USUARIO:
					iniciarOCerrarSesion(teclado, peya);
					break;

				case DESBLOQUEAR_USUARIO:
					desbloquearUsuario(teclado, peya);
					break;

				case VER_ESTADO_DE_LOS_USUARIOS:
					verEstadoDeLosUsuariosIngresadosEnElSistema(peya);
					break;

				case BUSCAR_USUARIO_POR_NOMBRE_DE_USUARIO:

					buscarUsuarioPorNombre(teclado, peya);
					break;

				case BUSCAR_USUARIOS_BLOQUEADOS:
					buscarUsuariosBloqueadosEnElSistema(peya);
					break;

				case BUSCAR_USUARIOS_LOGUEADOS:
					buscarUsuariosLogueadosEnElSistema(peya);
					break;

				case CALCULAR_CANTIDAD_DE_USUARIOS_MENORES:
					calcularCantidadDeUsuariosMenoresDeEdadEnElSistema(peya);
					break;

				case CALCULAR_EL_PROMEDIO_DE_EDAD:
					calcularElPromedioDeEdadDeLosUsuarios(peya);
					break;

				case BUSCAR_AL_USUARIO_MAS_PEQUENIO:
					buscarAlUsuarioMasChico(peya);
					break;

				case BUSCAR_AL_USUARIO_MAS_VIEJO:
					buscarAlUsuarioMasGrandeDeEdad(peya);
					break;
				case SALIR:
					System.out.println("Saliendo... \nGracias por utilizar el servicio");
					break;
				}
			}
		} while (opcionMenu != MenuParaElSistema.SALIR);

	}

	// MÉTODO MENU
	private static void mostrarMenuDeOpciones(MenuParaElSistema[] menuDeOpciones) {
		System.out.println("================== MENÚ PRINCIPAL ==================");
		System.out.println("Por favor, ingrese la opcion deseada");

		for (int i = 0; i < menuDeOpciones.length; i++) { // For para que recorra el aray y muestre las opciones del
															// enum
			System.out.println(menuDeOpciones[i]);
		}
		System.out.println("======================================================");
	}

	// CASE 1
	private static void actualizarNombreDelSistema(Scanner teclado, Sistema peya) {
		System.out.println("Por favor, ingrese el nuevo nombre del sistema");
		String nuevoNombreSistema = teclado.nextLine();
		peya.setNombreSistema(nuevoNombreSistema);
		System.out.println("El nombre " + peya.getNombreSistema().toUpperCase() + " ha sido registrado con éxito \n");
	}

	// CASE 2
	private static void agregarUnNuevoUsuario(Scanner teclado, Sistema peya) {
		boolean resultado = false;

		if (peya.estaLleno()) {
			System.out.println("No se pueden registras más usuarios \n");
			return;
		}

		// Primero que ingrese los datos del usuario
		System.out.print("Ingrese su nombre : ");
		String nombre = teclado.nextLine();

		System.out.print("Ingrese su apellido : ");
		String apellido = teclado.nextLine();

		int numeroDni = ingresarNumeroDeDocumento(teclado);

		// Mensaje de aviso que el dni ya esta registrado en el sistema
		if (peya.existeEldni(numeroDni)) {
			System.out.println("El numero de documento ya se encuentra registrado en el sistema \n");
			return;
		}

		System.out.print("Ingrese su edad : ");
		int edad = teclado.nextInt();
		teclado.nextLine(); // para limpiar buffer

		// Ingresar nombre de usuario y contraseña

		String nombreUsuarioNuevo = ingresarNombreDeUsuario(teclado);

		// Si el usuario esta registrado que intente con otro nombre
		while (peya.existeElUsuario(nombreUsuarioNuevo)) {
			System.out.print("El usuario ingresado ya existe. Por favor, intente con otro: ");
			nombreUsuarioNuevo = teclado.nextLine();
		}

		// Si no esta registrado el usuario puede registrar la contraseña
		System.out
				.print("Ingrese su contraseña.  La misma debe tener una longitud minima de 8 caracteres, 3 minusculas,"
						+ "1 mayuscula y un digito especial:  ");
		String contraseniaNuevoUsuario = teclado.nextLine();

		// Mientras que no ingrese la contraseña correcta, que la pida por teclado hasta
		// que la pueda guardar.
		while (!Usuario.esContraseniaValida(contraseniaNuevoUsuario)) {

			System.out.print("Contraseña incorrecta. Por favor ingrese nuevamente: ");
			contraseniaNuevoUsuario = teclado.nextLine();
		}

		// SI ingresa todos los datos de forma correcta, se crea el objeto con los datos
		// ingresados

		Usuario nuevoUsuarioIngresado = new Usuario(nombreUsuarioNuevo, contraseniaNuevoUsuario, nombre, apellido,
				numeroDni, edad);

		resultado = peya.ingresarUsuarios(nuevoUsuarioIngresado);

		if (resultado) { // Mensaje
			System.out.println("Usuario ingresado con éxito \n");
		}
	}// else System.out.println("No se pudo guardar al Usuario en el Sistema \n");

	private static String ingresarNombreDeUsuario(Scanner teclado) {
		System.out.print("Ingrese el nombre de usuario : ");
		String nombreUsuarioNuevo = teclado.nextLine();
		return nombreUsuarioNuevo;
	}

	private static int ingresarNumeroDeDocumento(Scanner teclado) {
		System.out.print("Ingrese su número de DNI - Sin puntos : ");
		int numeroDni = teclado.nextInt();
		return numeroDni;
	}

	// CASE 3
	private static void iniciarOCerrarSesion(Scanner teclado, Sistema peya) {

		final int OPCION_LOGUEARSE = 1;
		final int OPCION_DESLOGUEARSE = 2;
		boolean acceso = false;
		String contrasenia;

		System.out.print("Elija la opcion deseada \n " + " 1 para Iniciar sesión o " + " 2 para Cerrar Sesión  ");
		int opcionElegida = teclado.nextInt();
		teclado.nextLine();
		switch (opcionElegida) {

		case OPCION_LOGUEARSE:

			if (!peya.hayUsuariosIngresados()) {
				mensajeDeNoHayUsuariosRegistradosEnElSistema(peya);
				break;
			}

			int numeroDni = ingresarNumeroDeDocumento(teclado);
			teclado.nextLine();

			if (!validarInicioDeSesion(peya, numeroDni))
				break;

			String nombreUsuarioNuevo = ingresarNombreDeUsuario(teclado);

			System.out.print("Ingrese la contraseña: ");
			contrasenia = teclado.nextLine();

			acceso = peya.loguearUsuario(numeroDni, nombreUsuarioNuevo, contrasenia);

			// Si se puede ingresar el usuario al sistema msj de ingreso exitoso
			mostrarResultadoDeLogueo(acceso);
			
			break;

		case OPCION_DESLOGUEARSE:

			 nombreUsuarioNuevo = ingresarNombreDeUsuario(teclado);

			if (peya.cerrarSesion(nombreUsuarioNuevo)) { // verifica si el usuario esta ingresado para cerrar la sesion
				System.out.println("Se ha cerrado la sesión \n");
			} else
				System.out.println("El usuario NO está logueado \n");
		}
	}

	private static boolean validarInicioDeSesion(Sistema peya, int dni) {
		if (!peya.existeEldni(dni)) {
			System.out.println("El número de DNI no se encuentra registrado en el sistema \n");
			return false;
		}
		if (peya.elDniYaEstaLogueado(dni)) {
			System.out.println("El usuario ya está logueado en el sistema \n");
			return false;
		}
		if (peya.estaBloqueado(dni)) {
			System.out.println("USUARIO BLOQUEADO - Debe desbloquear su usuario para poder ingresar \n");
			return false;
		}
		return true;
	}

	private static void mostrarResultadoDeLogueo(boolean acceso) {
		if (acceso) {
			System.out.println("Ingreso con éxito \n");
		} else {
			System.out.println("No se pudo ingresar. Verifique sus datos \n");
		}
	}

	// CASE 4
	private static void desbloquearUsuario(Scanner teclado, Sistema peya) {
		if (peya.hayUsuariosIngresados()) {

			System.out.println("*** Desbloquear usuario***");
			int numeroDni = ingresarNumeroDeDocumento(teclado);
			teclado.nextLine(); // limpiar buffer

			if (peya.desbloquearUsuario(numeroDni)) {
				System.out.println("USUARIO DESBLOQUEADO \n");
			} else
				System.out.println("El número de documento no se encuentra registrado \n");
		} else
			mensajeDeNoHayUsuariosRegistradosEnElSistema(peya);
	}

	// CASE 5
	private static void verEstadoDeLosUsuariosIngresadosEnElSistema(Sistema peya) {
		if (peya.hayUsuariosIngresados()) {
			System.out.println(peya);
		} else
			mensajeDeNoHayUsuariosRegistradosEnElSistema(peya);
	}

	private static void mensajeDeNoHayUsuariosRegistradosEnElSistema(Sistema peya) {
		System.out.println("No hay usuarios registrados en el sistema " + peya.getNombreSistema().toUpperCase() + "\n");
	}

	// CASE 6
	private static void buscarUsuarioPorNombre(Scanner teclado, Sistema peya) {

		if (peya.hayUsuariosIngresados()) {

			System.out.println("---- Buscar Usuario por nombre----");
			String nombreUsuarioNuevo = ingresarNombreDeUsuario(teclado);

			Usuario buscado = peya.buscarUsuario(nombreUsuarioNuevo);

			if (buscado != null) {
				System.out.print("Usuario encontrado: ");
				System.out.println(buscado);
			} else
				System.out.println("No se encontro el nombre usuario en el sistema \n");

		} else
			mensajeDeNoHayUsuariosRegistradosEnElSistema(peya);

	}

	// CASE 7
	private static void buscarUsuariosBloqueadosEnElSistema(Sistema peya) {
		if (peya.hayUsuariosIngresados()) {

			System.out.println("--- Lista de Usuarios bloqueados en el sistema " + peya.getNombreSistema() + " ---");
			System.out.println(Arrays.toString(peya.buscarUsuarioBloqueados()) + "\n"); // Usar Arrays.toString para
																						// devolver varios arrays
		} else
			mensajeDeNoHayUsuariosRegistradosEnElSistema(peya);
	}

	// CASE 8
	private static void buscarUsuariosLogueadosEnElSistema(Sistema peya) {
		if (peya.hayUsuariosIngresados()) {
			System.out.println(
					"--- Lista de Usuarios logueados en el sistema " + peya.getNombreSistema().toUpperCase() + " ---");
			System.out.println(Arrays.toString(peya.buscarUsuariosLogueados()) + "\n");
		} else
			mensajeDeNoHayUsuariosRegistradosEnElSistema(peya);
	}

	// CASE 9
	private static void calcularCantidadDeUsuariosMenoresDeEdadEnElSistema(Sistema peya) {
		if (peya.hayUsuariosIngresados()) {
			System.out.print("--- La cantidad de usuarios menores de 18 años ingresados en el sistema "
					+ peya.getNombreSistema().toUpperCase() + " --- son :");
			System.out.print(peya.calcularLaCantidadDeUsuariosMenoresDeEdad() + "\n"); // Devuelve cantidad
			System.out.println(Arrays.toString(peya.buscarUsuariosMenoresDeEdad()) + "\n"); // Muestra a los usuarios
																							// menores
		} else
			mensajeDeNoHayUsuariosRegistradosEnElSistema(peya);
	}

	// CASE 10
	private static void calcularElPromedioDeEdadDeLosUsuarios(Sistema peya) {
		if (peya.hayUsuariosIngresados()) {
			System.out.print("--- El promedio de edad de los usuarios ingresados en el sistema  "
					+ peya.getNombreSistema().toUpperCase() + " es de :");
			System.out.println(peya.calcularElPromedioDeEdadDeLosUsuarios() + " años--- ");
		} else
			mensajeDeNoHayUsuariosRegistradosEnElSistema(peya);
	}

	// CASE 11
	private static void buscarAlUsuarioMasChico(Sistema peya) {
		if (peya.hayUsuariosIngresados()) {
			System.out.println(
					" En usuario mas chico de edad en el sistema " + peya.getNombreSistema().toUpperCase() + " es:");
			System.out.print(peya.buscarAlUsuarioMasChico() + "\n");
		} else
			mensajeDeNoHayUsuariosRegistradosEnElSistema(peya);
	}

	// CASE 12
	private static void buscarAlUsuarioMasGrandeDeEdad(Sistema peya) {
		if (peya.hayUsuariosIngresados()) {
			System.out.println(
					" En usuario mas grande de edad en el sistema " + peya.getNombreSistema().toUpperCase() + " es:");
			System.out.print(peya.buscarAlUsuarioMasGrande() + "\n");
		} else
			mensajeDeNoHayUsuariosRegistradosEnElSistema(peya);
	}

}

package ar.edu.unlam.pb1.parcial.interfaz;

import java.util.Arrays;
import java.util.Scanner;

import ar.edu.unlam.pb1.parcial.dominio.*;

public class InterfazRestaurant {

	static Scanner teclado = new Scanner(System.in);
	static Origen[] origenDelIngrediente = Origen.values();

	static Ingrediente nuevoIngrediente;
	static Ensalada nuevaEnsalada = new Ensalada("");
	static Pedido nuevoPedido = new Pedido("");

	public static void main(String args[]) {

		MenuRestaurante[] opciones = MenuRestaurante.values();
		MenuRestaurante opcionSeleccionada = MenuRestaurante.AGREGAR_INGREDIENTES;

		System.out.println("Bienvenido The Green Table!!");
		/*
		 * En esta secci�n del c�digo se debe generar la interacci�n con el usuario. Se
		 * pueden incorporar tantos m�todos como considere necesario. M�nimamente se
		 * debe invocar a los siguientes m�todos:
		 * 
		 * incorporarNuevoIngrediente crearUnNuevaEnsalada crearUnNuevoPedido
		 */

		do {
			mostrarMenu(opciones);
			System.out.print(" Ingrese la opcion deseada :  ");
			int opcionIngresada = teclado.nextInt();
			teclado.nextLine();

			if (opcionIngresada > 0 && opcionIngresada <= opciones.length) {
				opcionSeleccionada = opciones[opcionIngresada - 1];

				switch (opcionSeleccionada) {

				case AGREGAR_INGREDIENTES:
					incorporarNuevoIngrediente();
					break;
				case CREAR_ENSALADA:
					crearUnNuevaEnsalada();
					break;
				case CREAR_PEDIDO:
					crearUnNuevoPedido();
					break;
				case FINALIZAR_PEDIDO:
					finalizarPedido();
					break;
				case SALIR:
					System.out.println("Saliendo...");
					break;
				}
			}
		} while (opcionSeleccionada != MenuRestaurante.SALIR);

		System.out.println("Usted salio del programa");

	}

	private static void mostrarMenu(MenuRestaurante[] opciones) {
		System.out.println("- - - - - - - - - - - - - - - -");
		for (int i = 0; i < opciones.length; i++) {
			System.out.println(opciones[i]);
		}
		System.out.println("- - - - - - - - - - - - - - - -");
	}

	private static void incorporarNuevoIngrediente() {
		/*
		 * Se crean nuevos ingredientes los cuales pueden ser utilizados en los platos
		 */

		String nombre;
		int origen, precioIngrediente = 1500;
		Origen seleccion;
		char opcion;
		boolean sePudoIncorporar;

		System.out.print("Ingrese el nombre del ingrediente:  \n");
		nombre = teclado.nextLine();

		System.out.println("Ingrese el origen: \n1-VEGETAL \n2-ANIMAL \n3-TACC \n4-LECHE \n5-HUEVO  ");
		origen = teclado.nextInt();

		seleccion = origenDelIngrediente[origen - 1];

		nuevoIngrediente = new Ingrediente(nombre, seleccion);
		nuevoIngrediente.setPrecio(precioIngrediente);

		sePudoIncorporar = nuevaEnsalada.agregarIngrediente(nuevoIngrediente);

		if (sePudoIncorporar) {
			System.out.println("Ingrediente agregado correctamente \n" + nuevoIngrediente);

		} else {
			System.err.println("No se pudo incorporar intente nuevamente");
		}

	}

	private static void crearUnNuevaEnsalada() {

		String nombreEnsalada;
		char letra;
		boolean seAgrego;
		final int CANTIDAD_MAXIMA_INGREDIENTES = 8;
		int origen, contador = 0;
		/*
		 * Se visualiza el listado de ingredientes disponibles y a partir de ah� se
		 * crean nuevos platos, los cuales pueden ser solicitados por los clientes
		 */
		System.out.println("Los ingredientes disponibles para crear ensalada son : ");
		System.out.println(Arrays.toString(nuevaEnsalada.buscarIngredientesDisponibles()));

		System.out.print("Ingrese el nombre de la ensalada: \n ");
		nombreEnsalada = teclado.nextLine();

		System.out.println(" Cuantos ingredientes deseas agregar? ");
		int ingredientesAgregados = teclado.nextInt();
		teclado.nextLine();

		Ensalada ensaladaDelCheff = new Ensalada(nombreEnsalada);

		do {
			System.out.print("Ingrese el nombre del ingrediente que desea agregar : \n");
			String nombreIngrediente = teclado.nextLine();

			Ingrediente ingredienteEncontrado = nuevaEnsalada.buscarIngredientePorNombre(nombreIngrediente);

			if (ingredienteEncontrado != null) {
				seAgrego = ensaladaDelCheff.agregarIngrediente(ingredienteEncontrado);

				System.out.println(" Se agrego " + ingredienteEncontrado.getNombre() + " a la ensalada \n");
			} else {
				System.out.println("Lo siento :( hoy no tenemos tenemos ese ingrediente disponible \n");
			}

			contador++;

		} while (contador < ingredientesAgregados);

		System.out.println("Ingredientes agregados a la ensalada:");
		Ingrediente[] ingredientes = ensaladaDelCheff.getIngredientesAgregadosALaEnsalada();
		for (int i = 0; i < ingredientes.length; i++) {
			System.out.println("- " + ingredientes[i].getNombre() + " (" + ingredientes[i].getOrigen() + ")");
		}

		boolean seAgregoEnsalada = nuevoPedido.agregarNuevaEnsalada(ensaladaDelCheff);
		if (seAgregoEnsalada) {
			System.out.println("¡Ensalada guardada! ");
		} else {
			System.out.println("No se pudo agregar.");
		}
	}

	private static void crearUnNuevoPedido() {
		int ensaladasAgregadas = 0, contador = 0;
		boolean seAgrego;
		/*
		 * Se muestra el listado de ensaladas, y el cliente elige la ensalada deseada.
		 * Una vez elegida la ensalada el cliente puede incorporar nuevos ingredientes.
		 * Al finalizar informa el valor que debe abonar.
		 */
		System.out.println("Ingrese su nombre: ");
		String nombreUsuario = teclado.next();

		System.out.print("Las ensaladas disponibles son : \n");

		System.out.println(Arrays.toString(nuevoPedido.mostrarEnsaladasDisponibles()));

		System.out.println("Ingrese el numero de ensaladas a agregar");
		ensaladasAgregadas = teclado.nextInt();

		teclado.nextLine();

		nuevoPedido.setNombreDelCliente(nombreUsuario);

		do {
			System.out.print("Ingrese el nombre de la ensalada que desea agregar: \n");
			String nombreDeLaEnsalada = teclado.nextLine();

			Ensalada ensaladaEncontrada = nuevoPedido.buscarEnsaladaPorNombre(nombreDeLaEnsalada);

			if (ensaladaEncontrada != null) {
				seAgrego = nuevoPedido.agregarEnsaladaAlPedido(ensaladaEncontrada);

				System.out.println("Se agrego " + ensaladaEncontrada.getNombreDeLaEnsalada() + " al pedido \n");

			} else {
				System.out.println("Lo siento :( hoy no tenemos tenemos esa ensalada disponible \n");
			}

			contador++;

		} while (contador < ensaladasAgregadas);

	}

	private static void finalizarPedido() {
		double propina;
		System.out.println("Este es su pedido: " + nuevoPedido + "\nSu total seria: " + nuevoPedido.getImporte());

		System.out.println("¿Desea Agregar propina? si/no");
		char opcion = teclado.next().toUpperCase().charAt(0);

		if (opcion == 'S') {
			System.out.print("Ingrese el valor de la propina: $");
			propina = teclado.nextDouble();

			System.out.println("El valor total de su compra es: $" + (nuevoPedido.getImporte() + propina));
			System.out.println("Pedido finalizado, su codigo de retiro es: " + nuevoPedido.generarCodigoDePedido());
		} else {
			System.out.println("Pedido finalizado, su codigo de retiro es: " + nuevoPedido.generarCodigoDePedido());
		}
	}
}

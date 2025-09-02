package ar.edu.unlam.pb1.parcial.dominio;

import java.util.Arrays;

public class Ensalada {

	private String nombreDeLaEnsalada;
	private Ingrediente ingredientes[];
	private Origen origen;
	private final int CANTIDAD_MAXIMA_DE_INGREDIENTES = 50;
	private int codigo;
	private int contadorDeEnsaladas;

	public Ensalada(String nombre) {
		this.nombreDeLaEnsalada = nombre;
		this.ingredientes = new Ingrediente[CANTIDAD_MAXIMA_DE_INGREDIENTES];
		this.origen = origen;
		this.codigo = codigo;
		this.contadorDeEnsaladas = 0;
	}

	// Incorpora un nuevo ingrediente a la ensalada
	public boolean agregarIngrediente(Ingrediente nuevo) {
		for (int i = 0; i < ingredientes.length; i++) {
			if (ingredientes[i] == null) {
				ingredientes[i] = nuevo;
				return true;
			}
		}

		return false;
	}

	// Cuenta los ingredientes ingresados
	private int contarIngredientesDisponibles() {
		int cantidadDeIngredientesDisponibles = 0;

		for (int i = 0; i < ingredientes.length; i++) {
			if (ingredientes[i] != null && !ingredientes[i].isIngredienteEstaDisponible()) {
				cantidadDeIngredientesDisponibles++;
			}
		}
		return cantidadDeIngredientesDisponibles;
	}

	// Busca los ingredientes disponibles
	public Ingrediente[] buscarIngredientesDisponibles() {
		Ingrediente[] ingredientesDisponibles = new Ingrediente[contarIngredientesDisponibles()];
		int cantidadDeIngredientesDisponibles = 0;

		for (int i = 0; i < ingredientesDisponibles.length; i++) {
			if (ingredientes[i] != null && !ingredientes[i].isIngredienteEstaDisponible()) {
				ingredientesDisponibles[cantidadDeIngredientesDisponibles++] = ingredientes[i];

			}
		}
		return ingredientesDisponibles;
	}

	// buscar Ingrediente por nombnre

	public Ingrediente buscarIngredientePorNombre(String nombreIngrediente) {
		for (int i = 0; i < ingredientes.length; i++) {
			if (ingredientes[i] != null && ingredientes[i].getNombre().equalsIgnoreCase(nombreIngrediente)) {
				return ingredientes[i];
			}

		}
		return null;

	}

	public int getIngredientesCargados() {
		int contador = 0;
		for (int i = 0; i < ingredientes.length; i++) {
			if (ingredientes[i] != null) {
				contador++;
			}

		}
		return contador;
	}

	public Ingrediente[] getIngredientesAgregadosALaEnsalada() {

		int contadorDeNoNulos = 0;
		for (int i = 0; i < ingredientes.length; i++) {
			if (ingredientes[i] != null) {
				contadorDeNoNulos++;
			}
		}

		Ingrediente[] validos = new Ingrediente[contadorDeNoNulos];
		int indice = 0;
		for (int i = 0; i < ingredientes.length; i++) {
			if (ingredientes[i] != null) {
				validos[indice++] = ingredientes[i];
			}
		}
		return validos;
	}

	public Ingrediente[] crearNuevaEnsalada(String nombreingredieString) {

		Ingrediente nuevaEnsalada[] = new Ingrediente[contarIngredientesDisponibles()];

		for (int i = 0; i < ingredientes.length; i++) {
			if (ingredientes[i] != null && ingredientes[i].getNombre().equalsIgnoreCase(nombreingredieString)) {
				nuevaEnsalada[i] = ingredientes[i];
				contadorDeEnsaladas++;
			}
		}

		return nuevaEnsalada;
	}

	public String getNombreDeLaEnsalada() {
		return nombreDeLaEnsalada;
	}

	public void setNombreDeLaEnsalada(String nombreDeLaEnsalada) {
		this.nombreDeLaEnsalada = nombreDeLaEnsalada;
	}

	public Ingrediente[] getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(Ingrediente[] ingredientes) {
		this.ingredientes = ingredientes;
	}

	public Origen getOrigen() {
		return origen;
	}

	public void setOrigen(Origen origen) {
		this.origen = origen;
	}

	// Devuelve true si ningun ingrediente es de origen TACC
	public boolean esAptoCeliaco() {
		for (int i = 0; i < ingredientes.length; i++) {
			if (ingredientes[i] != null && ingredientes[i].getOrigen() == origen.TACC) {
				return false;
			}
		}

		return true;
	}

	// devuelve true si ningun ingrediente es de origen ANIMAL
	public boolean esAptoVegetariano() {

		for (int i = 0; i < ingredientes.length; i++) {
			if (ingredientes[i] != null && ingredientes[i].getOrigen() == Origen.ANIMAL) {
				return false;
			}

		}

		return true;
	}

	public boolean esAptoVegano() {
		for (int i = 0; i < ingredientes.length; i++) {
			if (ingredientes[i] != null) {
				Origen tipo = ingredientes[i].getOrigen();
				if (tipo == Origen.ANIMAL || tipo == Origen.HUEVO || tipo == Origen.LECHE) {
					return false;
				}
			}
		}
		return true;
	}

	/*
	 * Devuelve un String con el nombre de la ensalada y el detalle de los
	 * ingredientes que la componen
	 */
	public String toString() {
		String ingredientesNoNull = "";
		int i = 0;
		boolean esApto = false;
		String mensaje = "";

		if (!esAptoCeliaco()) {
			esApto = true;
			mensaje += " No es apta para celiacos.\n";
		}
		if (esAptoVegetariano()) {
			esApto = true;
			mensaje += " Es apto Vegetarianos.\n";
		}
		if (esAptoVegano()) {
			esApto = true;
			mensaje += " Es apto Veganos. \n";

		}

		while (i < ingredientes.length) {
			if (ingredientes[i] != null) {
				ingredientesNoNull += "Ingrediente [nombre=" + ingredientes[i].getNombre() + ", origen="
						+ ingredientes[i].getOrigen() + "]\n";
			}
			i++;
		}

		return "Ensalada :" + nombreDeLaEnsalada + "\n" + ingredientesNoNull +"\n " + mensaje
				+ "\n";
	}

	public int getCodigo() {
		return codigo;
	}

}

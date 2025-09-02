package ar.edu.unlam.pb1.parcial.dominio;

import java.util.Arrays;

public class Pedido {

	private String nombreDelCliente;
	private Ensalada[] ensaladas;
	private Ensalada[] ensaladasElegidasPorElCliente;
	private final int CANTIDAD_MAXIMA_DE_ENSALADAS_POR_PEDIDO = 10;
	private final double PRECIO_POR_INGREDIENTE = 1000;
	private int valorMinimo = 0;
	private int contadorDeEnsaladasAgregadas;
	private int contadorDeEnsaladasPedidas;

	public Pedido(String nombreDelCliente) {
		this.nombreDelCliente = nombreDelCliente;
		this.ensaladas = new Ensalada[CANTIDAD_MAXIMA_DE_ENSALADAS_POR_PEDIDO];
		this.ensaladasElegidasPorElCliente = new Ensalada[CANTIDAD_MAXIMA_DE_ENSALADAS_POR_PEDIDO];
		this.contadorDeEnsaladasAgregadas = 0;
		this.contadorDeEnsaladasPedidas = 0;

	}

	// Se incorpora una nueva ensalada a la lista de ensaladas 
	public boolean agregarNuevaEnsalada(Ensalada nueva) {
		
//para que no se agrege dos veces la misma
		for (int i = 0; i < ensaladas.length; i++) {
			if (ensaladas[i] != null && ensaladas[i].getNombreDeLaEnsalada().equals(nueva.getNombreDeLaEnsalada())) {
				return false;
			}
		}
		for (int i = 0; i < ensaladas.length; i++) {
			if (ensaladas[i] == null) {
				ensaladas[i] = nueva;
				contadorDeEnsaladasAgregadas++;
				return true;
			}
		}

		return false;
	}

	// Se agrega la ensalada elegida por el cliente al pedido
	public boolean agregarEnsaladaAlPedido(Ensalada ensalada) {
		for (int i = 0; i < contadorDeEnsaladasPedidas; i++) {
			if (ensaladasElegidasPorElCliente[i] != null && ensaladasElegidasPorElCliente[i].getNombreDeLaEnsalada()
					.equalsIgnoreCase(ensalada.getNombreDeLaEnsalada())) {
				return false; // 
			}
		}

		if (contadorDeEnsaladasPedidas < ensaladasElegidasPorElCliente.length) {
			ensaladasElegidasPorElCliente[contadorDeEnsaladasPedidas++] = ensalada;
			return true;
		}
		return false;
	}

	public Ensalada[] mostrarEnsaladasDisponibles() {

		Ensalada[] ensaladasCargadas = new Ensalada[contadorDeEnsaladasAgregadas];

		for (int i = 0; i < contadorDeEnsaladasAgregadas; i++) {

			ensaladasCargadas[i] = ensaladas[i];

		}
		return ensaladasCargadas;
	}

	public double getImporte() {
		/*
		 * Calcula el importe en funci�n del precio de cada ingrediente
		 */
		double total = 0.0;

		for (int i = 0; i < contadorDeEnsaladasPedidas; i++) {
			if (ensaladasElegidasPorElCliente[i] != null) {
				int cantidadDeIngredientes = ensaladasElegidasPorElCliente[i].getIngredientesCargados();
				total += cantidadDeIngredientes * PRECIO_POR_INGREDIENTE;

			}
		}

		return total;

	}

	public int generarCodigoDePedido() {
		int codigo = 0;
		boolean repetido;

		do {
			repetido = false;
			codigo = (int) ((Math.random() * 1000) + valorMinimo);
			for (int i = 0; i < ensaladas.length; i++) {
				if (ensaladas[i] != null && ensaladas[i].getCodigo() == codigo) {
					repetido = true;
				}
			}
		} while (repetido);
		return codigo;
	}

	public Ensalada buscarEnsaladaPorNombre(String nombreEnsalada) {
		for (int i = 0; i < ensaladas.length; i++) {
			if (ensaladas[i] != null && ensaladas[i].getNombreDeLaEnsalada().equalsIgnoreCase(nombreEnsalada)) {
				return ensaladas[i];
			}

		}

		return null;
	}

	public String getNombreDelCliente() {
		return nombreDelCliente;
	}

	public void setNombreDelCliente(String nombreDelCliente) {
		this.nombreDelCliente = nombreDelCliente;
	}

	@Override
	public String toString() {
		String resultado = "Pedido del cliente: " + nombreDelCliente + "\nEnsaladas pedidas:\n";

		for (int i = 0; i < contadorDeEnsaladasPedidas; i++) {
			resultado += ensaladasElegidasPorElCliente[i] + "\n";
		}

		return resultado;
	}
}

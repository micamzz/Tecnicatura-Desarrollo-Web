package ar.edu.unlam.dominio;

public class Motocicletas extends Vehiculo {

	private final Integer CANTIDAD_MAXIMA_DE_ACOMPANIANTES = 1;

	public Motocicletas() {
		super();
	}

	@Override
	public Boolean agregarPasajeros(Pasajero personaAcompañante) {

		if (cantidadDePasajeros() >= CANTIDAD_MAXIMA_DE_ACOMPANIANTES) {
			return false;
		}

		return super.agregarPasajeros(personaAcompañante);
	}


	@Override
	public Boolean cambiarChofer(Chofer choferACambiar) {
		if (cantidadDePasajeros() == 1) {
			return false;
		}
		return super.cambiarChofer(choferACambiar);
	}
	
	
	
}

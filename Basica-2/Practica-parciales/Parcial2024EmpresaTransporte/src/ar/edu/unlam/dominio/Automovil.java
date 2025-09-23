package ar.edu.unlam.dominio;

public class Automovil extends Vehiculo {

	private final Integer CANTIDAD_MAXIMA_DE_ACOMPANIANTES = 3;

	public Automovil() {
		super();
	}

	@Override
	public Boolean asignarChofer(Chofer choferDesignado) {
		// TODO Auto-generated method stub
		return super.asignarChofer(choferDesignado);
	}

	@Override
	public Boolean cambiarChofer(Chofer choferACambiar) {
		if (cantidadDePasajeros() >= 1) {
			return false;
		}

		return super.cambiarChofer(choferACambiar);

	}

	@Override
	public Boolean agregarPasajeros(Pasajero personaAcompañante) {

		if (cantidadDePasajeros() >= CANTIDAD_MAXIMA_DE_ACOMPANIANTES) {
			return false;
		}

		return super.agregarPasajeros(personaAcompañante);
	}

}

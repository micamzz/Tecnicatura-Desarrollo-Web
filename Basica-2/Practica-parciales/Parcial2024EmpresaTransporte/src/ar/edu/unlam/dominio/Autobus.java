package ar.edu.unlam.dominio;

public class Autobus extends Vehiculo {
	
	private final Integer CANTIDAD_MAXIMA_DE_ASIENTOS=20;

	public Autobus() {
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

		if (cantidadDePasajeros() >= CANTIDAD_MAXIMA_DE_ASIENTOS) {
			return false;
		}

		return super.agregarPasajeros(personaAcompañante);
	}

	
	
	
}
	

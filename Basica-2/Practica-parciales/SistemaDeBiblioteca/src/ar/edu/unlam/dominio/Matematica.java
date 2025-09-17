package ar.edu.unlam.dominio;

public class Matematica extends Libro implements Fotocopiable{

	public Matematica(Integer codigo, String nombre, String autor) {
		super(codigo, nombre, autor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String fotocopiar() {

		return "libro de matematica";
	}

}

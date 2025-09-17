package ar.edu.unlam.dominio;

public class Geografia extends Libro implements Fotocopiable{

	public Geografia(Integer codigo, String nombre, String autor) {
		super(codigo, nombre, autor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String fotocopiar() {

		return "Libro de geografia";
	}

}

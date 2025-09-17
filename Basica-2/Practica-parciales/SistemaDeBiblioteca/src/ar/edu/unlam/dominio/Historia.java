package ar.edu.unlam.dominio;

public class Historia extends Libro implements Fotocopiable {

	public Historia(Integer codigo, String nombre, String autor) {
		super(codigo, nombre, autor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String fotocopiar() {
		// TODO Auto-generated method stub
		return "Libro de historia";
	}

}

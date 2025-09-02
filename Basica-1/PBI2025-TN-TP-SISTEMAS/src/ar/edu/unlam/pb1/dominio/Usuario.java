package ar.edu.unlam.pb1.dominio;

public class Usuario {

	// Atributos

	private String usuario;
	private String contrasenia;
	private String nombre;
	private String apellido;
	private int dni;
	private int edad;
	private boolean estaBloqueadoElUsuario;
	private boolean estadoDeLogueo;
    private int contadorDeIntentos;
    
	// Constructor
	public Usuario(String usuario, String contrasenia, String nombre, String apellido, int dni, int edad) {
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.edad = edad;
		this.estaBloqueadoElUsuario = false;
		this.estadoDeLogueo = false;
		this.contadorDeIntentos=0;
	}

	// Métodos getters
	public String getUsuario() {
		return this.usuario;
	}

	public String getContrasenia() {
		return this.contrasenia;
	}
	
	public int getDni() {
		return this.dni;
	}
	public int getEdad() {
		return this.edad;
	}
	
	public int getContadorDeIntentos() {
		return this.contadorDeIntentos;
	}
	
	
	// Métodos setters
	public void setEdad(int edad) {
		this.edad = edad;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	
	public void setEstadoDeLogueo(boolean estadoActual) { // para cambiar el estado de logueo
		this.estadoDeLogueo = estadoActual;
	}
	
	public void setBloqueado(boolean estado) { // para cambiar el estado de bloqueo
	    this.estaBloqueadoElUsuario = estado;
	}
	
	public void setContadorDeIntentos(int intentos) {
		this.contadorDeIntentos = intentos;
	}
	
	//Método para verificar si el usuario esta logueado o bloqueado
	
	public boolean estaLogueado() {
		return estadoDeLogueo;
	}
	
	public boolean estaBloqueado() {
		return estaBloqueadoElUsuario;
	}


	// Método para verificar si el usuario ya existe
	public  boolean existeElUsuario(String usuario) {

		if (this.usuario.equalsIgnoreCase(usuario)) {
			return true;
		}
      return false;
	}
	
	// Método para comparar si el DNI ya esta en el sistema
	public boolean dniRegistrado(int dni) {
		 // para verificar si el dni ya esta registrado
		if (this.dni == dni) {
			return true;
		}
		return false;
	}
	
	// Método para verificar si la contrasenia es segura.

	public static boolean esContraseniaValida(String contrasenia) {
		boolean tieneMayuscula = false;
		boolean tieneNumero = false;
		boolean tieneCaracterEspecial = false;
		int letraMinuscula = 0;

		if (contrasenia.length() < 8) { // Si la contrasenia es menor a 8 devuelve false
			return false;
		}
		for (int i = 0; i < contrasenia.length(); i++) {
			char letra = contrasenia.charAt(i); // para recorrer cada letra de la contraseña

			if (Character.isDigit(letra)) {
				tieneNumero = true;
			} else if (Character.isUpperCase(letra)) { // Verifica si hay alguna letra mayuscula
				tieneMayuscula = true;
			} else if (Character.isLowerCase(letra)) { // Si tiene letra minuscula, incrementa el contador
				letraMinuscula++;
			} else if (!Character.isLetterOrDigit(letra)) { // si NO es letra o Digito devuelve true
				tieneCaracterEspecial = true;
			}
		}

	return ((letraMinuscula >= 3) && tieneNumero && tieneMayuscula && tieneCaracterEspecial);

	}


	
	public String toString() {

		  return "[Usuario: " + usuario +
				  " - Contraseña: **********" +
		           " - Nombre y apellido: " + nombre + " " + apellido +
		           " - Edad: " + edad +
		           " - Logueado: " + estadoDeLogueo +
		           " - Bloqueado: " + estaBloqueadoElUsuario + "]";
}
	}


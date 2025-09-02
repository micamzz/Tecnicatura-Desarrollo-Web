package dominio;

public class Calculadora {

	
	
	public Integer sumar(Integer numero1, Integer numero2) {
		return numero1 + numero2;
	}
	
	
	
	public Integer restar(Integer numero1, Integer numero2) {
		return numero1 - numero2;
	}
	
	public Integer multiplicar(Integer numero1, Integer numero2) {
		return numero1 * numero2;
	}
	
	public Integer dividir(Integer numero1, Integer numero2) {
		
		if (numero2.equals(0)) {
			return 0;
		}
		
		return numero1 / numero2;
	}
	
	
	
	
	
	
	
	
	
}

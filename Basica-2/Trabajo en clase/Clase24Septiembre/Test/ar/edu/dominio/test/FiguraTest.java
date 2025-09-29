package ar.edu.dominio.test;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;

import org.junit.Test;

import ar.edu.dominio.*;

public class FiguraTest {

	@Test
	public void dadoQueExisteUnCuadradoRojoCalcularSuPerimetro() {
		String color = "rojo";
		Double lado = 5D;
		
		Cuadrado cuadrado = new Cuadrado(color,lado);
		
		Double valorEsperado =20D;
		Double valorObtenido = cuadrado.calcularPerimetro();
		
		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void dadoQueExisteUnCirculoRohoYRadio10CalcularSuPerimetro() {	
		String color = "rojo";
		Double radio = 10D;
		
		Circulo circulo = new Circulo (color,radio);
		
		Double valorEsperado =62.83;
		Double valorObtenido = circulo.calcularPerimetro();
		
		assertEquals(valorEsperado, valorObtenido,0.01);		
	}
	
	@Test
	public void xxx() {
		
		Figura  cir1 = new Circulo("rojo",5.0);
		Figura  cir2 = new Circulo("Amarillo",1.0);
		Figura  cuadrado1 = new Cuadrado("Verde",8.0);
		Figura  cuadrado2 = new Cuadrado("Azul",11.0);
		
		
		HashSet <Figura> listadoFigura = new HashSet<>();
		
		listadoFigura.add(cuadrado1);
		listadoFigura.add(cuadrado2);
		listadoFigura.add(cir2);
		listadoFigura.add(cir1);
		
		
		/* Puedo obtener circulos o cuadrados . SI casteo para llamar a un metodo propio de una subclase, a esa figura la tengo que castear segun el objeto que es. 
		 * Pero hay que usar instanceof para declarar que tipo de Objeto es.
		 */
		for (Figura figura : listadoFigura) {
			// Mismo objeto que se instancia de diferentes maneras UTILIZANDO ABSTRACTO QUE ESTA SOBREESCRITO EN CADA CLASE.
			System.out.println(figura.obtenerDescripcionFigura());
			
			
			if (figura instanceof Cuadrado)
			System.out.println(((Cuadrado)figura).metodoX());

			
			// SI ES INSTANCIA DE CIRCULO QUE MUESTRE EL METODO. 
			if (figura instanceof Circulo)
			System.out.println(((Circulo)figura).metodoY());
		}
		
		
	}

	@Test
	public void xxx2() {
		
		Figura  cir1 = new Circulo("rojo",5.0);
		Figura  cir2 = new Circulo("Amarillo",1.0);
		Figura  cuadrado1 = new Cuadrado("Verde",8.0);
		Figura  cuadrado2 = new Cuadrado("Azul",11.0);
		
		
		HashSet <Figura> listadoFigura = new HashSet<>();
		
		listadoFigura.add(cuadrado1);
		listadoFigura.add(cuadrado2);
		listadoFigura.add(cir2);
		listadoFigura.add(cir1);
		
		
		/* Puedo obtener circulos o cuadrados . SI casteo para llamar a un metodo propio de una subclase, a esa figura la tengo que castear segun el objeto que es. 
		 * Pero hay que usar instanceof para declarar que tipo de Objeto es.
		 */
		for (Figura figura : listadoFigura) {
			
			// SI LA FIGURA ES UNA INSTANCIA DE CUADRADO DEVUELVE EL METODO SOBREESCRITO DE DESCRIPCION.
			
			if (figura instanceof Cuadrado)
			System.out.println(((Cuadrado)figura).obtenerDescripcionFigura());

			
			// SI ES INSTANCIA DE CIRCULO QUE MUESTRE EL METODO. 
//			if (figura instanceof Circulo)
//			System.out.println(((Circulo)figura).metodoY()); // ACA SOLO DEVUELVE EL METODO PROPIO. 
		}
		
		
	}

}

package ar.edu.unlam.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ar.edu.unlam.dominio.*;

public class InventarioTest {

	@Test
	public void dadoQueAgregoUnProductoPerecederoDe1200ObtengoConElAgregado1260() {
		Producto alimentoPerecedero = new ProductoPerecedero("Leche", 1, 1200D);

		Double valorEsperado = 1260D;
		Double valorObtenido = alimentoPerecedero.obtenerPrecio();

		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void dadoQueAgregoDosProductosPerecederoIgualesEsperoComoResultado4672Con50() {
		// valor de cada pollo = 2225D
		Producto alimentoPerecedero = new ProductoPerecedero("Pollo", 2, 2225D);

		Double valorEsperado = 4672.50D;
		Double valorObtenido = alimentoPerecedero.obtenerPrecio();

		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void dadoQueAgregoUnProductoNoPerecederoDe2900ObtengoConElAgregado3103() {

		Producto alimentoNoPerecedero = new ProductoNoPerecedero("Arroz", 1, 2900D);

		Double valorEsperado = 3103D;
		Double valorObtenido = alimentoNoPerecedero.obtenerPrecio();

		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void dadoQueAgregoTresProductosNoPerecederoDe3425ObtengoConElAgregado10994Con25() {
		// Fideos cada uno 3425
		Producto alimentoNoPerecedero = new ProductoNoPerecedero("Fideos", 3, 3425D);

		Double valorEsperado = 10994.25D;
		Double valorObtenido = alimentoNoPerecedero.obtenerPrecio();

		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void dadoQueAgregoVariosProductosPerecederosDeDistintosValoresObtengoResultadoExitoso() {

		GestionDeProductos supermercado = new GestionDeProductos();

		Producto alimentoPerecedero = new ProductoPerecedero("Queso Fresco", 2, 1800D);
		Producto alimentoPerecedero2 = new ProductoPerecedero("Tomate", 4, 95D);
		Producto alimentoPerecedero3 = new ProductoPerecedero("Docena Huevos", 1, 720D);
		Producto alimentoPerecedero4 = new ProductoPerecedero("Lechuga", 3, 150D);

		supermercado.agregarProductosAVender(alimentoPerecedero);
		supermercado.agregarProductosAVender(alimentoPerecedero2);
		supermercado.agregarProductosAVender(alimentoPerecedero3);
		supermercado.agregarProductosAVender(alimentoPerecedero4);

		Double valorEsperado = 5407.5D;
		Double valorObtenido = supermercado.obtenerPrecioFinalPerecedero();
		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void dadoQueAgregoVariosProductosNoPerecederosDeDistintosValoresObtengoResultadoExitoso() {

		GestionDeProductos supermercado = new GestionDeProductos();

		Producto alimentoNoPerecedero = new ProductoNoPerecedero("Arroz", 5, 2900D);
		Producto alimentoNoPerecedero2 = new ProductoNoPerecedero("Fideos", 3, 3450D);
		Producto alimentoNoPerecedero3 = new ProductoNoPerecedero("Azucar", 4, 1285D);

		supermercado.agregarProductosAVender(alimentoNoPerecedero);
		supermercado.agregarProductosAVender(alimentoNoPerecedero2);
		supermercado.agregarProductosAVender(alimentoNoPerecedero3);

		Double valorEsperado = 32089.3D;
		Double valorObtenido = supermercado.obtenerPrecioFinalNoPerecedero();

		assertEquals(valorEsperado, valorObtenido);
	}

	@Test

	public void dadoQueAgregoVariosProductosVariadosObtengoUnResultadoExitoso() {
		GestionDeProductos supermercado = new GestionDeProductos();

		Producto alimentoPerecedero = new ProductoPerecedero("Pan", 4, 400D);
		Producto alimentoPerecedero2 = new ProductoPerecedero("Queso", 1, 2500D);

		Producto alimentoNoPerecedero = new ProductoNoPerecedero("Harina", 3, 1500D);
		Producto alimentoNoPerecedero2 = new ProductoNoPerecedero("Aceite", 2, 3800D);

		supermercado.agregarProductosAVender(alimentoPerecedero);
		supermercado.agregarProductosAVender(alimentoPerecedero2);

		supermercado.agregarProductosAVender(alimentoNoPerecedero);
		supermercado.agregarProductosAVender(alimentoNoPerecedero2);

		Double valorEsperado = 17252D;
		Double valorObtenido = supermercado.obtenerPrecioTotal();

		assertEquals(valorEsperado, valorObtenido);

	}
	
	@Test
	public void dadoQueProductoPerecederoConCantidadCeroElPrecioFinalEsCero() {
	    Producto perecedero = new ProductoPerecedero("Leche", 0, 1200D);
	    Double esperado = 0D;
	    Double obtenido = perecedero.obtenerPrecio();
	    assertEquals(esperado, obtenido);
	}

}

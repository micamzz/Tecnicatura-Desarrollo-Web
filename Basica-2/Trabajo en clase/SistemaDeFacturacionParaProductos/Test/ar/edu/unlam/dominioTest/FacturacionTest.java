package ar.edu.unlam.dominioTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ar.edu.unlam.dominio.GestionDeFacturacion;
import ar.edu.unlam.dominio.Producto;
import ar.edu.unlam.dominio.ProductoAlimenticio;
import ar.edu.unlam.dominio.ProductoElectronico;
import ar.edu.unlam.dominio.ProductoRopa;

public class FacturacionTest {

	// Test para Gestion de Facturacion

	@Test

	public void dadoQueSeAgregaUnProductoAFacturacionSeObtieneResultadoExistoso() {

		GestionDeFacturacion nuevaGestion = new GestionDeFacturacion();
		// Producto
		Producto productoNuevo = new Producto("Remera", 5.000D, "Remera Basica");

		Boolean seAgrego = nuevaGestion.agregarUnProducto(productoNuevo);

		assertTrue(seAgrego);

		Double valorEsperado = 5.000D;
		Double valorObtenido = productoNuevo.getPrecio();

		assertEquals(valorEsperado, valorObtenido);

	}

	@Test

	public void dadoQueSeAgregan3ProductosAFacturacionSeObtieneResultadoExistoso() {

		GestionDeFacturacion nuevaGestion = new GestionDeFacturacion();

		// Producto
		Producto productoNuevo = new Producto("Remera", 5.000D, "Remera Basica");
		Producto productoElectronico = new ProductoElectronico("Parlantes", 10000D, "Para escuchar musica");
		Producto productoAlimento = new ProductoAlimenticio("Fideos", 3250D, "fideos moñitos");

		nuevaGestion.agregarUnProducto(productoNuevo);
		nuevaGestion.agregarUnProducto(productoElectronico);
		nuevaGestion.agregarUnProducto(productoAlimento);

		Integer valorEsperado = 3;
		Integer valorObtenido = nuevaGestion.obtenerCantidadDeProductos();

	}

	@Test

	public void dadoQueSeAgreganVariosProductoDeRopaSeEsperaDeMontoFinal86625() {

		GestionDeFacturacion nuevaGestion = new GestionDeFacturacion();
		// Producto
		Producto productoNuevo = new ProductoRopa("Campera", 30000D, "campera de cuero");
		Producto productoNuevo2 = new ProductoRopa("Jean", 18000D, "jean oxford");
		Producto productoNuevo3 = new ProductoRopa("Remera", 9500D, "Remera estampada");
		Producto productoNuevo4 = new ProductoRopa("Zapatillas", 25000D, "adidas");

		nuevaGestion.agregarUnProducto(productoNuevo);
		nuevaGestion.agregarUnProducto(productoNuevo2);
		nuevaGestion.agregarUnProducto(productoNuevo3);
		nuevaGestion.agregarUnProducto(productoNuevo4);

		Double valorEsperado = 86625D;
		Double valorObtenido = nuevaGestion.obtenerPrecioFinalDeCompra();

		assertEquals(valorEsperado, valorObtenido);

	}

	@Test

	public void dadoQueSeAgregaUnProductoElectronicoQueVale10000conElRecargoSeEsperaDeResultado115000() {

		Producto productoElectronico = new ProductoElectronico("Parlantes", 10000D, "Para escuchar musica");

		Double valorEsperado = 11500D;
		Double valorObtenido = productoElectronico.calcularPrecioFinal();

		assertEquals(valorEsperado, valorObtenido);

	}

	@Test

	public void dadoQueSeAgregaUnProductoElectronicoQueSale7500ConElRecargoDel15SeEsperaDeResultado8625() {

		Producto productoElectronico = new ProductoElectronico("AURICULARES", 7500D, "Para escuchar musica");

		Double valorEsperado = 8625D;
		Double valorObtenido = productoElectronico.calcularPrecioFinal();

		assertEquals(valorEsperado, valorObtenido);

	}

	@Test

	public void dadoQueSeAgregaUnProductoDeRopaQueSale25000ConLaComisionDelVendedorDel5PorcientoSeEsperaDeResultado26250() {
		Producto productoRopa = new ProductoRopa("CAMPERA", 25000D, "Campera simil cuero");

		Double valorEsperado = 26250D;
		Double valorObtenido = productoRopa.calcularPrecioFinal();

		assertEquals(valorEsperado, valorObtenido);

	}

	@Test

	public void dadoQueSeAgregaUnProductoDeRopaQueSale40000ConLaComisionDelVendedorDel5PorcientoSeEsperaDeResultado42000() {

		Producto productoRopa = new ProductoRopa("CAMPERA", 40000D, "Campera simil cuero");

		Double valorEsperado = 42000D;
		Double valorObtenido = productoRopa.calcularPrecioFinal();

		assertEquals(valorEsperado, valorObtenido);
	}

	@Test

	public void dadoQueSeAgregaUnProductoDeAlimentosQueSale32500MasElValorFijoDe1000YElRecargoElResultadoEs4493() {

		Producto productoAlimento = new ProductoAlimenticio("Fideos", 3250D, "fideos moñitos");

		Double valorEsperado = 4493.75D;
		Double valorObtenido = productoAlimento.calcularPrecioFinal();

		assertEquals(valorEsperado, valorObtenido);

	}

	@Test

	public void dadoQueSeAgregaUnProductoDeAlimentosQueSale4800MasElValorFijoDe1000YElRecargoElResultadoEs6160() {
		Producto productoAlimento = new ProductoAlimenticio("Fideos", 4800D, "fideos moñitos");

		Double valorEsperado = 6160.00D;
		Double valorObtenido = productoAlimento.calcularPrecioFinal();

		assertEquals(valorEsperado, valorObtenido);

	}

}

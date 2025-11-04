package ar.edu.unlam.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.excepciones.DniDuplicadoException;
import ar.edu.unlam.excepciones.NoDisponibleException;
import ar.edu.unlam.menum.TipoBicicleta;
import ar.edu.unlam.dominio.*;

public class GestorAlquileresTest {

	private GestorAlquiler gestor;
	
	@Before
	public void inicializacion() {
		gestor = new GestorAlquiler();
		
	}
	
	@Test
	
	public void dadoQueExisteUnaEmpresaParaAlquilarVehiculosCuandoRegistroUnClienteInexistenteObtengoUnResultadoExitoso() throws DniDuplicadoException {
		Integer dni = 1234;
		String nombre = "Marcela";
		String apellido = "Lopez";
		
		Cliente cliente1 = new Cliente(dni,nombre,apellido);
		
		Boolean seAgrego = gestor.agregarCliente(cliente1);	
		assertTrue(seAgrego);
		
	}

	@Test (expected = DniDuplicadoException.class)
	public void dadoQueExisteUnaEmpresaParaAlquilarVehiculosCuandoRegistroUnOtroClienteConElMismoDNIObtengoUnaExcepcionDniDuplicadoException() throws DniDuplicadoException {
		
		Integer dni = 1234;
		String nombre = "Marcela";
		String apellido = "Lopez";
		
		Cliente cliente1 = new Cliente(dni,nombre,apellido);
		
		gestor.agregarCliente(cliente1);	
		
		Integer dni2 = 1234;
		String nombre2 = "Camila";
		String apellido2 = "Abal";
		
		Cliente cliente2 = new Cliente(dni2,nombre2,apellido2);
		
		 gestor.agregarCliente(cliente2);	
	
	}
	
	@Test 
	public void dadoQueExisteUnaEmpresaParaAlquilarVehiculosConVehiculosCuandoObtengoLosVehiculosBicicletaDePaseoObtengoUnaColeccionCon2Bicicletas() {
		
		Integer idbici1 = 1212;
		String nombre = "Bici playera";
		
		Vehiculo bicicleta1 = new Bicicleta(idbici1, nombre, TipoBicicleta.PASEO);
		
		Integer idbici2 = 1515;
		String nombre2 = "Bici playera";
		
		Vehiculo bicicleta2 = new Bicicleta(idbici2, nombre2, TipoBicicleta.PASEO);
		
		gestor.agregarVehiculo(bicicleta1);
		gestor.agregarVehiculo(bicicleta2);
		
		Integer resultadoEsperado = 2;
		Integer resultadoObtenido = gestor.obtenerListadoDeBicicletasDePaseo().size();
		
		assertEquals(resultadoEsperado, resultadoObtenido);	
	}

	@Test
	
	public void dadoQueExisteUnaEmpresaParaAlquilarVehiculosConVehiculosCuandoObtengoLosVehiculosMotoObtengoUnaColeccionCon3MotosOrdenadosPorPatenteAscendente() {
		
		Integer idmoto1= 2020;
		String nombre1 = "MOTO LA TANA";
		String patente1 = "ABD123";
		Integer combustibleLitros1 = 20;
		Integer cilindrada1 = 250;
		
		Vehiculo moto1 = new Moto(idmoto1, nombre1,patente1,combustibleLitros1,cilindrada1);
		
		Integer idmoto2= 2025;
		String nombre2 = "MOTO MAX";
		String patente2 = "LOE200";
		Integer combustibleLitros2 = 70;
		Integer cilindrada2 = 850;
		
		Vehiculo moto2 = new Moto(idmoto2, nombre2,patente2,combustibleLitros2,cilindrada2);
		
		
		Integer idmoto3= 2017;
		String nombre3 = "MOTO LOCURA";
		String patente3 = "ABC123";
		Integer combustibleLitros3 = 20;
		Integer cilindrada3 = 250;
		
		Vehiculo moto3 = new Moto(idmoto3, nombre3,patente3,combustibleLitros3,cilindrada3);
		
		gestor.agregarVehiculo(moto1);
		gestor.agregarVehiculo(moto2);
		gestor.agregarVehiculo(moto3);
		
		
		TreeSet <Moto> motosOrdenadas = gestor.obtenerMotosOrdenadasPorPatente();
		
		assertEquals(moto3, motosOrdenadas.first());
		assertEquals(moto2, motosOrdenadas.last());
	
	}
	
	@Test
	
	public void dadoQueExisteUnaEmpresaParaAlquilarVehiculosConVehiculosCuandoConsultoLosDatosDeUnVehiculoPorSuIdObtengoElVehiculo() {
		Integer idmoto1= 2020;
		String nombre1 = "MOTO LA TANA";
		String patente1 = "ABD123";
		Integer combustibleLitros1 = 20;
		Integer cilindrada1 = 250;
		
		Vehiculo moto1 = new Moto(idmoto1, nombre1,patente1,combustibleLitros1,cilindrada1);
		
		Integer idmoto2= 2025;
		String nombre2 = "MOTO MAX";
		String patente2 = "LOE200";
		Integer combustibleLitros2 = 70;
		Integer cilindrada2 = 850;
		
		Vehiculo moto2 = new Moto(idmoto2, nombre2,patente2,combustibleLitros2,cilindrada2);
		
		Integer idbici1 = 1212;
		String nombre = "Bici playera";
		
		Vehiculo bicicleta1 = new Bicicleta(idbici1, nombre, TipoBicicleta.PASEO);
		
		Integer idbici2 = 1515;
		String nombrebici2 = "Bici playera";
		
		Vehiculo bicicleta2 = new Bicicleta(idbici2, nombrebici2, TipoBicicleta.MONTANIA);
		
		gestor.agregarVehiculo(moto1);
		gestor.agregarVehiculo(moto2);
		gestor.agregarVehiculo(bicicleta1);
		gestor.agregarVehiculo(bicicleta2);
		
		Integer idBuscado = 2025;
		Vehiculo vehiculoBuscado = gestor.buscarVehiculoPorId(idBuscado);
		
		assertEquals(moto2,vehiculoBuscado);
	}
	
	@Test
	
	public void dadoQueExisteUnaEmpresaParaAlquilarVehiculosConVehiculosCuandoConsultoElPrecioDeAlquilerDeUnVehiculoBicicletaDeMontaniaPorOchoHorasObtengo48000() throws DniDuplicadoException {
		
		// BICICLETA
		Integer idbici2 = 1515;
		String nombrebici2 = "Bici playera";
		
		Vehiculo bicicleta2 = new Bicicleta(idbici2, nombrebici2, TipoBicicleta.MONTANIA);
		
	gestor.agregarVehiculo(bicicleta2);
		
		Integer tiempoAlquiler= 8;
		
		Double resultadoEsperado = 48000D;
		Double resultadoObtenido = bicicleta2.obtenerPrecio(tiempoAlquiler);
		assertEquals(resultadoEsperado,resultadoObtenido,0.01);
	
	}
	
	@Test
	public void dadoQueExisteUnaEmpresaParaAlquilarVehiculosConVehiculosYClientesCuandoAlquiloUnVehiculoMotoObtengoUnResultadoExitoso() throws DniDuplicadoException, NoDisponibleException {

		// CLIENTE

		Integer dni = 1234;
		String nombre = "Marcela";
		String apellido = "Lopez";

		Cliente cliente1 = new Cliente(dni, nombre, apellido);

		gestor.agregarCliente(cliente1);

		// MOTO
		Integer idmoto2 = 2025;
		String nombre2 = "MOTO MAX";
		String patente2 = "LOE200";
		Integer combustibleLitros2 = 70;
		Integer cilindrada2 = 850;

		Vehiculo moto2 = new Moto(idmoto2, nombre2, patente2, combustibleLitros2, cilindrada2);

		gestor.agregarVehiculo(moto2);
		Integer horasDeAlquiler = 5;

		Boolean seAlquilo = gestor.alquilarVehiculo(cliente1, moto2, horasDeAlquiler);

		assertTrue(seAlquilo);

	}
	
	@Test (expected = NoDisponibleException.class)
	public void dadoQueExisteUnaEmpresaParaAlquilarVehiculosConVehiculosYClientesCuandoQuieroAlquilarUnVehiculoMotoYaAlquiladoObtengoUnaExcepcionVehiculoNoDisponibleException() throws DniDuplicadoException, NoDisponibleException {
		// CLIENTE

				Integer dni = 1234;
				String nombre = "Marcela";
				String apellido = "Lopez";

				Cliente cliente1 = new Cliente(dni, nombre, apellido);
				
				Integer dni2 = 5859;
				String nombreCliente2 = "Camila";
				String apellido2 = "Abal";
				
				Cliente cliente2 = new Cliente(dni2,nombreCliente2,apellido2);
				
				gestor.agregarCliente(cliente1);
				gestor.agregarCliente(cliente2);
				
				// BICICLETA
				Integer idbici1 = 1212;
				String nombreBici = "Bici playera";
				
				Vehiculo bicicleta1 = new Bicicleta(idbici1, nombreBici, TipoBicicleta.PASEO);
				
				gestor.agregarVehiculo(bicicleta1);

				// MOTO
				Integer idmoto2 = 2025;
				String nombre2 = "MOTO MAX";
				String patente2 = "LOE200";
				Integer combustibleLitros2 = 70;
				Integer cilindrada2 = 850;

				Vehiculo moto2 = new Moto(idmoto2, nombre2, patente2, combustibleLitros2, cilindrada2);

				gestor.agregarVehiculo(moto2);
				Integer horasDeAlquiler = 5;

			   gestor.alquilarVehiculo(cliente1, moto2, horasDeAlquiler);
			   
			   Integer horasDeAlquiler2 = 9;
			   gestor.alquilarVehiculo(cliente2, moto2, horasDeAlquiler2);
	}

	@Test
	
	public void dadoQueExisteUnaEmpresaParaAlquilarVehiculosConVehiculosYClientesCuandoConsultoLosAlquileresDeClientesObtengoUnMapaDeClaveClienteYComoValorUnaColeccionConLosVehiculosAlquiladosPorElCliente() throws NoDisponibleException, DniDuplicadoException {
		// CLIENTE

		Integer dni = 1234;
		String nombre = "Marcela";
		String apellido = "Lopez";

		Cliente cliente1 = new Cliente(dni, nombre, apellido);
		
		Integer dni2 = 5859;
		String nombreCliente2 = "Camila";
		String apellido2 = "Abal";
		
		Cliente cliente2 = new Cliente(dni2,nombreCliente2,apellido2);
		
		Integer dni3 = 4040;
		String nombreCliente3 = "Abel";
		String apellido3 = "Pintos";
		
		Cliente cliente3 = new Cliente(dni3,nombreCliente3,apellido3);
		
		gestor.agregarCliente(cliente1);
		gestor.agregarCliente(cliente2);
		gestor.agregarCliente(cliente3);
		
		//VEHICULOS
		
		Integer idmoto1= 2020;
		String nombre1 = "MOTO LA TANA";
		String patente1 = "ABD123";
		Integer combustibleLitros1 = 20;
		Integer cilindrada1 = 250;
		
		Vehiculo moto1 = new Moto(idmoto1, nombre1,patente1,combustibleLitros1,cilindrada1);
		
		Integer idmoto2= 2025;
		String nombre2 = "MOTO MAX";
		String patente2 = "LOE200";
		Integer combustibleLitros2 = 70;
		Integer cilindrada2 = 850;
		
		Vehiculo moto2 = new Moto(idmoto2, nombre2,patente2,combustibleLitros2,cilindrada2);
		
		
		Integer idmoto3= 2017;
		String nombre3 = "MOTO LOCURA";
		String patente3 = "ABC123";
		Integer combustibleLitros3 = 20;
		Integer cilindrada3 = 250;
		
		Vehiculo moto3 = new Moto(idmoto3, nombre3,patente3,combustibleLitros3,cilindrada3);
		
		Integer idbici1 = 1212;
		String nombreBici = "Bici playera";
		
		Vehiculo bicicleta1 = new Bicicleta(idbici1, nombreBici, TipoBicicleta.PASEO);
		
		Integer idbici2 = 1515;
		String nombrebici2 = "Bici playera";
		
		Vehiculo bicicleta2 = new Bicicleta(idbici2, nombrebici2, TipoBicicleta.MONTANIA);
		
		gestor.agregarVehiculo(moto1);
		gestor.agregarVehiculo(moto2);
		gestor.agregarVehiculo(moto3);
		gestor.agregarVehiculo(bicicleta1);
		gestor.agregarVehiculo(bicicleta2);
	   
	   // CLIENTE 1 ALQUILA MOTO Y BICICLETA MONTAÑA
	   //CLIENTE 2 ALQUILA 2 MOTO
	   // CLIENTE 3 NO ALQUILA NADA. 
		
		gestor.alquilarVehiculo(cliente1, moto3,5);
		gestor.alquilarVehiculo(cliente1, bicicleta2,3);
		
		gestor.alquilarVehiculo(cliente2, moto2, 6);
		gestor.alquilarVehiculo(cliente2, moto1, 3);
		
		HashMap <Cliente, ArrayList <Vehiculo>> reporte = gestor.obtenerReportePorCliente();
		
		assertFalse(reporte.containsKey(cliente3));
	    assertTrue(reporte.containsKey(cliente1));
		assertTrue(reporte.containsKey(cliente2));
		
		
	}

}

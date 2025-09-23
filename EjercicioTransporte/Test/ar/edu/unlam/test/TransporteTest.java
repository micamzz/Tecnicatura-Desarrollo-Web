package ar.edu.unlam.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.dominio.*;

public class TransporteTest {
	
 private SistemaDeTransporte sistema ;
 
	@Before
	public void inicializacionDeVariables() {
		sistema = new SistemaDeTransporte();
	}
	
	@Test
	
	public void dadoQueExisteUnVehiculoNoPuedenExistirDosVehiculosConLaMismaPatente() {
	
		
		Vehiculo nuevoVehiculo = new Vehiculo("abc123", "volkswagen", 2025);
		Vehiculo nuevoVehiculo2 = new Vehiculo("abc123", "chevrolet", 2006);
		
		Boolean seAgrego =	sistema.agregarVehiculo(nuevoVehiculo);
		Boolean seAgrego2 =	sistema.agregarVehiculo(nuevoVehiculo2);
				
		assertTrue(seAgrego);
	    assertFalse(seAgrego2);
		
	}
	
	
	
	@Test
	
	public void dadoQueExisteUnSistemaDeConductoresNoPuedeHaberDosConductoresConLaMismaLicencia() {
		Conductor chofer = new Conductor("abc123", "1111");
		Conductor chofer2 = new Conductor("LOE643", "2222");
		Conductor chofer3 = new Conductor("KJH761", "8888");
		Conductor chofer4 = new Conductor("PGT165", "1111");
		
		Boolean seAgrego = sistema.agregarConductor(chofer);
		Boolean seAgrego2 = sistema.agregarConductor(chofer2);
		Boolean seAgrego3 = sistema.agregarConductor(chofer3);
		Boolean seAgrego4 = sistema.agregarConductor(chofer4);
		
		
		assertTrue(seAgrego);
		assertTrue(seAgrego2);
		assertTrue(seAgrego3);
		assertFalse(seAgrego4);
	
	}
	
	
	@Test
	public void dadoQueSeBuscaUnVehiculoPorPatenteSeObtieneUnResultadoExitoso() {
	    
		Vehiculo nuevoVehiculo = new Vehiculo("abc123", "volkswagen", 2025);
		Vehiculo nuevoVehiculo2 = new Vehiculo("MSJ183", "chevrolet", 2012);
		Vehiculo nuevoVehiculo3 = new Vehiculo("PGT165", "volkswagen", 2025);
		Vehiculo nuevoVehiculo4 = new Vehiculo("FLT776", "chevrolet", 2021);
		
		sistema.agregarVehiculo(nuevoVehiculo);
		sistema.agregarVehiculo(nuevoVehiculo2);
		sistema.agregarVehiculo(nuevoVehiculo3);
		sistema.agregarVehiculo(nuevoVehiculo4);
		
		String patenteBuscada = "pgt165";
		
		Vehiculo buscado = nuevoVehiculo3;
		Vehiculo obtenido = sistema.buscarVehiculoPorPatente(patenteBuscada);
		
		assertEquals(buscado,obtenido);
		
	}
	
	@Test
	public void dadoQueSeTieneUnAutoSeCalculaElCostoDeMantenimiento() {
		
		Vehiculo auto = new Auto("pgt165","volkswagen", 2022, 5);
		
		sistema.agregarVehiculo(auto);
		
		Double resultadoEsperado=5000d;
		Double resultadoObtenido = auto.calcularCostoDeMantenimiento();
		
		assertEquals(resultadoEsperado,resultadoObtenido);
		
	}
	
	@Test
	public void dadoQueSeTieneUnCamionSeCalculaElCostoDeMantenimiento() {
		
		Vehiculo camion = new Camion("LLL983","volkswagen", 2022, 10D);
		
		sistema.agregarVehiculo(camion);
		
		Double resultadoEsperado=50000d;
		Double resultadoObtenido = camion.calcularCostoDeMantenimiento();
		
		assertEquals(resultadoEsperado,resultadoObtenido);
		
	}
	
	
}

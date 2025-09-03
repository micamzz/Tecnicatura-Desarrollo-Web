package ar.edu.unlam.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Test;

import ar.edu.unlam.dominio.GestorDePeaje;
import ar.edu.unlam.dominio.Pase;
import ar.edu.unlam.dominio.Vehiculo;

public class TestPeaje {
	
@Test
	
	public void dadoQueExisteUnGestorDePeajesAlRegistrarUnPaseObtengoUnResultadoExistoso() {
	
	Vehiculo vehiculoNuevo = new Vehiculo("LOE321","CHEVROLET", "CELTA");
	Vehiculo vehiculoNuevo2 = new Vehiculo("PGT165","SUZUKI", "FUN");
	
	LocalDateTime fechaHora = LocalDateTime.of(2025, 9, 3, 9, 14,0);
	
	GestorDePeaje ausa = new GestorDePeaje();
	
	Pase pase = new Pase (vehiculoNuevo , fechaHora);
	Pase pase2 = new Pase (vehiculoNuevo2 , fechaHora);
	
	Boolean seAgrego = ausa.agregarPase(pase);
	Boolean seAgrego2 = ausa.agregarPase(pase2);
	
         assertTrue(seAgrego);
         assertTrue(seAgrego2);

}


	@Test 
	public void dadoQueExisteUnaEmpresaDePeajeVerificarQueUnVehiculoNoPuedaPasarDosVecesALaMismaFechaYHora() {
		LocalDateTime fechaHora = LocalDateTime.of(2025, 9, 3, 9, 14,0);
		
		Vehiculo vehiculoNuevo = new Vehiculo("LOE321","CHEVROLET", "CELTA");
		Vehiculo vehiculoNuevo2 = new Vehiculo("LOE321","CHEVROLET", "CELTA"); 
	
		Vehiculo vehiculoNuevo3  = new Vehiculo("PGT165","SUZUKI", "FUN"); 
		
		GestorDePeaje ausa = new GestorDePeaje();
			
		Pase pase = new Pase (vehiculoNuevo, fechaHora);
		Pase pase2 = new Pase (vehiculoNuevo2 , fechaHora);
		Pase pase3 = new Pase (vehiculoNuevo3 , fechaHora);
		
		
		Boolean seAgrego = ausa.agregarPase(pase);
		Boolean seAgrego2 = ausa.agregarPase(pase2);
		Boolean seAgrego3 = ausa.agregarPase(pase3);
		
	      assertTrue(seAgrego);
	      assertFalse(seAgrego2);
	      assertTrue(seAgrego3);

	}
	
	@Test

	public void dadoQueExisteUnGestorDePeajeAlRegistrar2PasesDeunVehiculoYotroPaseDeotroVheculoObtengoUnListadoConLos2Vehiculos() {
		GestorDePeaje ausa = new GestorDePeaje();
		
		LocalDateTime fechaHora = LocalDateTime.of(2025, 9, 3, 9, 14, 0);
		LocalDateTime fechaHora2 = LocalDateTime.now();
		LocalDateTime fechaHora3 = LocalDateTime.of(2025, 9, 3, 9, 30, 0);
	
		
	
		Vehiculo vehiculoNuevo = new Vehiculo("LOE321", "CHEVROLET", "CELTA");
		Vehiculo vehiculoNuevo2 = new Vehiculo("LOE421", "CHEVROLET", "CELTA");

	
		Pase pase = new Pase(vehiculoNuevo, fechaHora);
		Pase pase2 = new Pase(vehiculoNuevo2, fechaHora2);
		Pase pase3 = new Pase(vehiculoNuevo, fechaHora3);
		

		 ausa.agregarPase(pase);
		 ausa.agregarPase(pase2);
	     ausa.agregarPase(pase3);
	   

		HashSet <Vehiculo> vehiculos = ausa.obtenerTodosLosVehiculos();
		
		Integer valorEsperado = 2;
		Integer valorObtenido = vehiculos.size();
		
		assertEquals(valorEsperado, valorObtenido);

	}
	

	
	
	
	
	
	
}
	
	
	





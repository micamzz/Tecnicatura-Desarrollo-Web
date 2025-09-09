package ar.edu.unlam.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.dominio.GestorDePeaje;
import ar.edu.unlam.dominio.Pase;
import ar.edu.unlam.dominio.Tarifa;
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
	

	private GestorDePeaje ausa;

	@Before
	public void gestorAgregado() {
	    ausa = new GestorDePeaje();
	}
	@Test
	
	public void dadoQueExisteUnGestorDePeajeAgregarUnaNuevaTarifa() {
		
		
		
	}
	
	
	@Test
	public void agregarTarifas() {
			
		Integer id = 1111;
		Double valorJulio = 1000.0;
		LocalDateTime desdeJulio = LocalDateTime.of(2025, 7, 1, 0, 0);
	    LocalDateTime hastaJulio = null;

	    Tarifa tarifaJulio = new Tarifa(id, desdeJulio, hastaJulio, valorJulio);
	 
        Boolean seAgrego = ausa.agregarTarifa(tarifaJulio);
			
        assertTrue(seAgrego);	
	}
	
	@Test
	
	public void cuandoAgregoUnaTarifaModificoElHastaEnUnDiaAnterior() {
		
		Integer id = 1111;
		Double valorJulio = 1000.0;
		LocalDateTime desdeJulio = LocalDateTime.of(2025, 7, 1, 0, 0);
	    LocalDateTime hastaJulio = LocalDateTime.of(2025, 7, 31, 23, 59);

	    Integer id2 = 1112;
	    Double valorAgosto = 1000.0;
	    LocalDateTime desdeAgosto = hastaJulio.plusMinutes(1);
	    LocalDateTime hastaAgosto = null;

//	    Integer id3 = 1113;
//	    Double valorSeptiembre = 1000.0;
//	    LocalDateTime desdeSeptiembre = LocalDateTime.of(2025, 9, 1, 0, 0);
//	    LocalDateTime hastaSeptiembre = null; 

	    Tarifa tarifaJulio = new Tarifa(id, desdeJulio, hastaJulio, valorJulio);
	    Tarifa tarifaAgosto = new Tarifa(id2, desdeAgosto, hastaAgosto, valorAgosto);
//	    Tarifa tarifaOctubre = new Tarifa(id3, desdeSeptiembre, hastaSeptiembre, valorSeptiembre);
			
			Boolean seAgrego = ausa.agregarTarifa(tarifaJulio);
			Boolean seAgrego2 = ausa.agregarTarifa(tarifaAgosto);
//			Boolean seAgrego3 =ausa.agregarTarifa(tarifaOctubre);
			
			assertTrue(seAgrego);
			assertTrue(seAgrego2);
//			 assertTrue(seAgrego3);
		
	}

	@Test
	
	public void cuandoUnVehiculoPasaPorElPeajeSeAgregaLaTarifa() {
        
		LocalDateTime fechaHora = LocalDateTime.of(2025, 9, 3, 9, 14, 0);
		LocalDateTime fechaHora2 = LocalDateTime.now();
		LocalDateTime fechaHora3 = LocalDateTime.of(2025, 9, 3, 9, 30, 0);
	
	
		Vehiculo vehiculoNuevo = new Vehiculo("LOE321", "CHEVROLET", "CELTA");
		Vehiculo vehiculoNuevo2 = new Vehiculo("LOE421", "CHEVROLET", "CELTA");
		
		Pase pase = new Pase(vehiculoNuevo, fechaHora);
		Pase pase2 = new Pase(vehiculoNuevo2, fechaHora2);
		
		
		LocalDateTime  fechaDesde =	LocalDateTime.of(2025, 07, 1, 0, 0);
		LocalDateTime  fechaHasta =	LocalDateTime.of(2025, 07, 31, 0, 0);
		
		Tarifa nuevaTarifa = new Tarifa(01, fechaDesde, fechaHasta ,1000.0);
		
		ausa.agregarTarifa(nuevaTarifa);
		
	
	}
	
	
	
	@Test
	
	public void obtenerElValorDeUnMesDeUnVehiculoRegistrado() {
            GestorDePeaje ausa = new GestorDePeaje();
		// TARIFA 
  
    		LocalDateTime fechaDesde = LocalDateTime.of(2025,9,1,0,0);
    		LocalDateTime fechaHasta = null;
    		Double valorTarifa = 1000.0;
    		
    		
    		Tarifa nuevaTarifa = new Tarifa(01, fechaDesde, fechaHasta ,valorTarifa);
    		
    		assertTrue(ausa.agregarTarifa(nuevaTarifa));
    		
    		//VEHICULO Y PASE
		LocalDateTime fechaHora = LocalDateTime.of(2025, 9, 03,12,0);
	    LocalDateTime fechaHora2 = LocalDateTime.of(2025, 9, 7,12,0);

		Vehiculo vehiculoNuevo = new Vehiculo("LOE321", "CHEVROLET", "CELTA");
	
		Pase pase = new Pase(vehiculoNuevo, fechaHora);
		
		Pase pase2 = new Pase(vehiculoNuevo,fechaHora2);
      ausa.agregarPase(pase);
      ausa.agregarPase(pase2);
		
		Double valorEsperado = 2000.0;
		Double valorObtenido =  ausa.obtenerMontoAAbonarDeUnVehiculoParaUnMesDado("LOE321", 2025, 9);
		
		assertEquals(valorEsperado,valorObtenido);
		
		
		
		
	}
	
	
	/*test agregarTarifa
test de cuandoAgregoUnaTarifaModifico elHAsta en un dia Anterior
 
'test de que obtengo el prrecioPara un mes

//        desde    hasta

// 1   1/7/2025  31/7/2025    valor 1000.0
// 2   1/8/2025  2/9/2025       valor 1100.0
// 3   3/9/2025   null
 
	 * 
	 */
	
	
	
}
	
	
	





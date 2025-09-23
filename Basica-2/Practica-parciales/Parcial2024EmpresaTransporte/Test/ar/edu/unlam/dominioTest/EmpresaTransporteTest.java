package ar.edu.unlam.dominioTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.dominio.*;

public class EmpresaTransporteTest {

	private GestorDeEmpresa empresa;
	private Vehiculo  moto1 ;
	private Chofer nuevoChofer;
	private Chofer nuevoChofer2;
	private Pasajero pasajero1;
	private Pasajero pasajero2;
	private Autobus  colectivo166;
	private Autobus colectivo236;
	
	
	
@Before
public void inicializacion() {
	empresa = new GestorDeEmpresa();
	moto1 = new Motocicletas();
	nuevoChofer = new Chofer("PABLO","12345678");
	
	nuevoChofer2 = new Chofer("OSCAR","98765432");
	pasajero1 = new Pasajero("Camila");
	pasajero2 = new Pasajero("Marta");
	
	colectivo166 = new Autobus();
	colectivo236 = new Autobus();
	
	
	
	
}
	

@Test
public void dadoQueExisteUnaMotoSeQuiereAgregarUnAcompañanteYSeObtieneUnResultadoExitoso() {

	moto1.asignarChofer(nuevoChofer);

	Boolean seAgrego = moto1.agregarPasajeros(pasajero1);

	assertTrue(seAgrego);

}

@Test
public void dadoQueExisteUnaMotoConUnAcompañanteSeQuiereAgregarOtroAcompañanteYNoSePuedeAgregar() {

	moto1.asignarChofer(nuevoChofer);

	moto1.agregarPasajeros(pasajero1);
	Boolean seAgrego = moto1.agregarPasajeros(pasajero2);

	assertFalse(seAgrego);
}

@Test
public void dadoQueNoHayAcompañantesSeQuiereCambiarDeChoferYSeObtieneUnResultadoExitoso() {

	moto1.asignarChofer(nuevoChofer);
	Boolean seAgrego = moto1.cambiarChofer(nuevoChofer2);

	assertTrue(seAgrego);

}

@Test
public void dadoQueHayUnAcompañantesSeQuiereCambiarDeChoferSeEsperaQueNoSePuedaCambiar() {

	moto1.asignarChofer(nuevoChofer);
	moto1.agregarPasajeros(pasajero1);
	Boolean seAgrego = moto1.cambiarChofer(nuevoChofer2);

	assertFalse(seAgrego);

}

@Test

public void dadoQueExisteUnColectivoConUnPasajeroYSeQuiereCambiarDeChoferQueNoSePueda() {
	colectivo166.asignarChofer(nuevoChofer);
	
	colectivo166.agregarPasajeros(pasajero1);
	
	Boolean seAgrego = colectivo166.cambiarChofer(nuevoChofer2);
	assertFalse(seAgrego);
}


@Test

public void dadoQueExisteUnColectivoSeQuierenSubir21PasajerosYNoSePuede() {
	colectivo166.asignarChofer(nuevoChofer);
	

	// PARA NO INSTANCIAR A 21 PASAJEROS UTILIZAR EL FOR
	for (int i = 1; i <= 21; i++) {
		 Boolean seAgrego =   colectivo166.agregarPasajeros(new Pasajero("Pasajero" + i));
	    if (i == 21) {
       
            assertFalse(seAgrego);
        }
	}


    Integer resultadoEsperado =20;
    Integer resultadoObtenido = colectivo166.cantidadDePasajeros();
    
    assertEquals(resultadoEsperado,resultadoObtenido);
}
	
//  @Test
//  
//  public void dadoQueExisteUnVehiculoSeDeseaAgregarloALaEmpresaDeTransporteYSeObtieneUnResultadoExitoso() {
//	  
//	  empresa.agregarVehiculo(moto1);
//	  
//	  moto1.asignarChofer(nuevoChofer);
//	  
//	  moto1.agregarPasajeros(pasajero1);
//	  
//	  Boolean seCambio = moto1.cambiarChofer(nuevoChofer);
//	  
//	  assertTrue(seCambio);
//	  
//	  
//	  
//  }
}


package ar.edu.unlam.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.TreeMap;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.dominio.*;
public class VirtualTest {

	private GestorMaquinaVirtuales gestor;
	
	@Before
	public void inicializacion() {
		gestor = new GestorMaquinaVirtuales ();
		
	}
	
	
@Test(expected = CorreoDuplicadoException.class)
public void dadoQueExisteUnSistemaDeGestionDeMaquinasVirtualesCuandoAgregoUnUsuarioConUnCorreoExistenteObtengoUnaUsuarioDuplicadoException() throws CorreoDuplicadoException {
	
	String correo1 = "micaelamazza@hotmail.com"; 
	String contrasenia1 = "1234";
    
	Usuario usuario1 = new Usuario(correo1, contrasenia1);
	
	String correo2 = "micaelamazza@hotmail.com"; 
	String contrasenia2 = "7777";
	
	Usuario usuario2 = new Usuario(correo2, contrasenia2);
	
	gestor.agregarUsuario(usuario1);
	gestor.agregarUsuario(usuario2);
	}
	

@Test
public void  dadoQueExisteUnSistemaDeGestionDeMaquinasVirtualesConUsuariosValidosAlConsultarlosObtengoUnaColeccionDeUsuariosOrdenadosPorCorreoDescendente() throws CorreoDuplicadoException {
	
	String correo1 = "micaela@hotmail.com"; 
	String contrasenia1 = "1234";
    
	Usuario usuario1 = new Usuario(correo1, contrasenia1);
	
	String correo2 = "anacarla@hotmail.com"; 
	String contrasenia2 = "7777";
	
	Usuario usuario2 = new Usuario(correo2, contrasenia2);
	
	String correo3 = "cami@hotmail.com"; 
	String contrasenia3 = "666";
	
	Usuario usuario3 = new Usuario(correo3, contrasenia3);
	
	String correo4 = "analopez@hotmail.com"; 
	String contrasenia4 = "666";
	Usuario usuario4 = new Usuario(correo4, contrasenia4);
	
	gestor.agregarUsuario(usuario1);
	gestor.agregarUsuario(usuario2);
	gestor.agregarUsuario(usuario3);
	gestor.agregarUsuario(usuario4);
	
	TreeSet <Usuario> listadoOrdenado = gestor.obtenerUsuariosOrdenados();
	
	assertEquals(usuario2.getCorreo(), listadoOrdenado.last().getCorreo());
	
}

@Test
public void dadoQueExisteUnSistemaDeGestionDeMaquinasVirtualesConAlMenosUnUsuarioCuandoAgregoUnaVMBaseDeDatosObtengoUnResultadoExitoso() throws CorreoDuplicadoException {
	String correo1 = "micaela@hotmail.com"; 
	String contrasenia1 = "1234";
    
	Usuario usuario1 = new Usuario(correo1, contrasenia1);
	
	gestor.agregarUsuario(usuario1);
	
	
	Integer almacenamientoOcupado = 10;
	BaseDeDato virtualMachine = new BaseDeDato(almacenamientoOcupado);
	
	Boolean seAgrego = gestor.agregarMaquinaVirtual(usuario1,virtualMachine);
	
	assertTrue(seAgrego);
	
}

@Test

public void dadoQueExisteUnSistemaDeGestionDeMaquinasVirtualesConAlMenosUnUsuarioCuandoAgregoUnaVMAlmacenamientoDeImagenesObtengoUnResultadoExitoso() throws CorreoDuplicadoException {
	String correo1 = "micaela@hotmail.com"; 
	String contrasenia1 = "1234";
    
	Usuario usuario1 = new Usuario(correo1, contrasenia1);
	
	gestor.agregarUsuario(usuario1);
	
	ImagenVM virtualMachineImagen = new ImagenVM();
	
	Boolean seAgrego = gestor.agregarMaquinaVirtual(usuario1,virtualMachineImagen);
	
	assertTrue(seAgrego);
	
}


@Test (expected = CantidadDeHorasDeUsoExcedidaException.class)
public void dadoQueExisteUnSistemaDeGestionDeMaquinasVirtualesConAlMenosUnUsuarioYUnaVMBaseDeDatosCuandoSuperoLaCapacidadDeHorasDeUsoObtengoUnaCantidadDeHorasDeUsoExcedidaException() throws CorreoDuplicadoException, CantidadDeHorasDeUsoExcedidaException, CantidadDeEscriturasSuperadaException {
	String correo1 = "micaela@hotmail.com"; 
	String contrasenia1 = "1234";
    
	Usuario usuario1 = new Usuario(correo1, contrasenia1);
	
	gestor.agregarUsuario(usuario1);
	
	Integer almacenamientoOcupado = 10;
	BaseDeDato virtualMachine = new BaseDeDato(almacenamientoOcupado);
	
    gestor.agregarMaquinaVirtual(usuario1,virtualMachine);
    
    Integer horasDeUso= 101; //LIMITE 100 HS.
    gestor.usarMaquinaVirtualBDD(virtualMachine, horasDeUso);
	
}

@Test (expected = CantidadDeEscriturasSuperadaException.class)
public void dadoQueExisteUnSistemaDeGestionDeMaquinasVirtualesConAlMenosUnUsuarioYUnaVMAlmacenamientoDeImagenesCuandoSuperoUnaCantidadEscriturasObtengoUnaCantidadDeEscriturasSuperadaException() throws CorreoDuplicadoException, CantidadDeHorasDeUsoExcedidaException, CantidadDeEscriturasSuperadaException, CantidadDeLecturaSuperadaException {
	String correo1 = "micaela@hotmail.com"; 
	String contrasenia1 = "1234";
    
	Usuario usuario1 = new Usuario(correo1, contrasenia1);
	
	gestor.agregarUsuario(usuario1);
	
	ImagenVM virtualMachineImagen = new ImagenVM();
	
    gestor.agregarMaquinaVirtual(usuario1,virtualMachineImagen);
	
    Integer horasDeLectura= 20; //LIMITE 100 HS.
	 Integer horasDeEscritura = 101; // limite 100
	   gestor.usarMaquinaImg(virtualMachineImagen,  horasDeEscritura,horasDeLectura);
	
}

@Test
public void dadoQueExisteUnSistemaDeGestionDeMaquinasVirtualesConAlMenosUnUsuarioYUnaVMBaseDeDatosUsadaCuandoObtengoElCostoFinalPor10GBY5HorasRecibo1125() throws CorreoDuplicadoException, CantidadDeHorasDeUsoExcedidaException, CantidadDeEscriturasSuperadaException {
	
	String correo1 = "micaela@hotmail.com"; 
	String contrasenia1 = "1234";
    
	Usuario usuario1 = new Usuario(correo1, contrasenia1);
	
	gestor.agregarUsuario(usuario1);
	
	
	Integer almacenamientoOcupado = 10;
	BaseDeDato virtualMachine = new BaseDeDato(almacenamientoOcupado);
	
    gestor.agregarMaquinaVirtual(usuario1,virtualMachine);
    Integer horasDeUso=5;
    gestor.usarMaquinaVirtualBDD(virtualMachine, horasDeUso);
    
    Double valorObtenido = virtualMachine.calcularCostoTotal();
    
    
    assertEquals(1125D,valorObtenido,0.01);
}

@Test
public void dadoQueExisteUnSistemaDeGestionDeMaquinasVirtualesConAlMenosUnUsuarioYUnaVMAlmacenamientoDeImagenesUsadaCuandoObtengoElCostoFinalPor20LecturasY10EscriturasRecibo540() throws CorreoDuplicadoException, CantidadDeHorasDeUsoExcedidaException, CantidadDeEscriturasSuperadaException, CantidadDeLecturaSuperadaException {
	
	String correo1 = "micaela@hotmail.com"; 
	String contrasenia1 = "1234";
    
	Usuario usuario1 = new Usuario(correo1, contrasenia1);
	
	gestor.agregarUsuario(usuario1);
	
	ImagenVM virtualMachineImagen = new ImagenVM();
	
    gestor.agregarMaquinaVirtual(usuario1,virtualMachineImagen);
	
	 Integer horasDeLectura= 20; //LIMITE 100 HS.
	 Integer horasDeEscritura = 10;
	   gestor.usarMaquinaImg(virtualMachineImagen, horasDeLectura, horasDeEscritura);
}

@Test
public void dadoQueExisteUnSistemaDeGestionDeMaquinasVirtualesConUsuariosQuePoseenVMsCuandoConsultoLosCostosAPagarPorCadaClienteObtengoUnMapaConClaveUsuarioYUnaColeccionDeCostosComoValorOrdenadosPorCostoDescendentemente() throws CorreoDuplicadoException, CantidadDeEscriturasSuperadaException, CantidadDeLecturaSuperadaException, CantidadDeHorasDeUsoExcedidaException {
	String correo1 = "micaela@hotmail.com"; 
	String contrasenia1 = "1234";
    
	Usuario usuario1 = new Usuario(correo1, contrasenia1);
	
	String correo2 = "anacarla@hotmail.com"; 
	String contrasenia2 = "7777";
	
	Usuario usuario2 = new Usuario(correo2, contrasenia2);
	
	String correo3 = "cami@hotmail.com"; 
	String contrasenia3 = "666";
	
	Usuario usuario3 = new Usuario(correo3, contrasenia3);
	
	gestor.agregarUsuario(usuario1);
	gestor.agregarUsuario(usuario2);
	gestor.agregarUsuario(usuario3);

	
	ImagenVM virtualMachineImagen = new ImagenVM();
	ImagenVM virtualMachineImagen2 = new ImagenVM();
	ImagenVM virtualMachineImagen3 = new ImagenVM();
	
	Integer almacenamientoOcupado = 20;
	BaseDeDato virtualMachine = new BaseDeDato(almacenamientoOcupado);
	
	Integer almacenamientoOcupado2 = 10;
	BaseDeDato virtualMachine2 = new BaseDeDato(almacenamientoOcupado2);
	
	// agregar maquinas al gestor 
	gestor.agregarMaquinaVirtual(usuario1, virtualMachine2);
	gestor.agregarMaquinaVirtual(usuario1, virtualMachineImagen3);
	
    gestor.agregarMaquinaVirtual(usuario2, virtualMachineImagen);
	gestor.agregarMaquinaVirtual(usuario2, virtualMachine);
	gestor.agregarMaquinaVirtual(usuario2, virtualMachineImagen2);

	 
	//USARLAS 

	//base de datos
	 Integer horasDeUso=5;
	 gestor.usarMaquinaVirtualBDD(virtualMachine, horasDeUso); // 1000 + 200 + 25 = 1225
	  
	  Integer horasDeUso2=7; 
	  gestor.usarMaquinaVirtualBDD(virtualMachine2, horasDeUso2); // 1000 + 100 + 35 = 1135
	  
	  // IMAGEN
	 Integer horasDeLectura2= 15; 
	 Integer horasDeEscritura2 = 20; 
  gestor.usarMaquinaImg(virtualMachineImagen,horasDeEscritura2,horasDeLectura2); // 500 + 40 + 15 = 555
	      
	      
     Integer horasDeLectura= 10; 
    Integer horasDeEscritura = 10; 
	  gestor.usarMaquinaImg(virtualMachineImagen3,horasDeEscritura,horasDeLectura); // 500 + 20 + 10 = 530
	  
	Integer horasDeLectura3= 10; 
	Integer horasDeEscritura3 = 10; 
	  gestor.usarMaquinaImg(virtualMachineImagen2,horasDeEscritura3,horasDeLectura3); // 500 + 20 + 10 = 530
		
/*
 * usuario 1 -- > 2  ( 1135, 530)
 * usuario 2 ----> 3 1225, 555, 530
 * usuario 3 --- > 0

 */
	  TreeMap <Usuario, TreeSet <Double>> reportesObtenidos = gestor.reporteDeUso();

	 assertFalse(reportesObtenidos.containsKey(usuario3));
	 assertTrue(reportesObtenidos.containsKey(usuario1));
	   // Usuario 2: [1225, 555, 530]
	    assertTrue(reportesObtenidos.containsKey(usuario2));
	    
	    assertEquals(2, reportesObtenidos.size());
	    
	    // del reporte obtenido si la clave contiene un valor double de 1135
	    assertTrue(reportesObtenidos.get(usuario1).contains(1135D));
	    
	   
}

}







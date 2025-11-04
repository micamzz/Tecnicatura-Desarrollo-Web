package ar.edu.unlam.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;
import ar.edu.unlam.dominio.*;
import ar.edu.unlam.excepciones.ClienteExistenteEnEventoException;
import ar.edu.unlam.excepciones.EventoDuplicadoException;

public class TestDeEventos {

	private EmpresaDeEvento gestor;
	
	@Before
	public void inicializacion() {
		gestor = new EmpresaDeEvento();
	}
	
	@Test
	public void dadoQueExisteUnaEmpresaCuandoAgregoUnClienteObtengoUnResultadoExitoso() {
		Cliente cliente1 = new Cliente(1234,"marcelo","lopez");
		Boolean seAgrego = gestor.agregarCliente(cliente1);
		assertTrue(seAgrego);
	}

	
	@Test (expected =EventoDuplicadoException.class )
	public void dadoQueExisteUnaEmpresaCuandoAgregoUnEventoExistenteObtengoUnaEventoDuplicadoException() throws EventoDuplicadoException {
		
		String id = "23ABC";
		LocalDate fecha = LocalDate.of(2025, 11, 5);
		Cliente clienteExpone = new Cliente(999, "Marcela", "Tauro");
		
		String id2 = "1672FFF";
		LocalDate fecha2 = LocalDate.of(2025, 11, 5);
		Cliente clienteExpone2 = new Cliente(999, "Marcela", "Tauro");
		
		Evento evento1 = new Conferencia(id, fecha,TipoSala.CHICA, "LOPEZ MARIA");
		Evento evento2 = new Conferencia(id2,fecha2,TipoSala.MEDIANA, "LOPEZ MARIA");
		
	 gestor.agregarEvento(evento1);
     gestor.agregarEvento(evento2);
	
	}
	
	@Test
	public void dadoQueExisteUnaEmpresaConEventosCuandoBuscoUnEventoExistentePorSuCodigoObtengoElEvento() throws EventoDuplicadoException {
		
		String id = "23ABC";
		LocalDate fecha = LocalDate.of(2025, 11, 5);

		
		String id2 = "1672FFF";
		LocalDate fecha2 = LocalDate.of(2025, 11, 6);
		
		Evento evento1 = new Conferencia(id, fecha,TipoSala.CHICA, "LOPEZ MARIA");
		Evento evento2 = new Conferencia(id2,fecha2,TipoSala.MEDIANA, "LOPEZ MARIA");
		
	    gestor.agregarEvento(evento1);
        gestor.agregarEvento(evento2);

        Evento resultadoObtenido = gestor.buscarEventoPorCodigo("1672FFF");
        assertEquals(evento2, resultadoObtenido);	
	}
	
	
	@Test
	public void  dadoQueExisteUnaEmpresaConEventosCuandoVerificoSiUnClienteSeEncuentraEntreLosParticipantesDeUnEventoPorClienteYExisteObtengoUnResultadoPositivo() throws EventoDuplicadoException, ClienteExistenteEnEventoException {
		Cliente cliente1 = new Cliente(1234,"marcelo","lopez");
		 gestor.agregarCliente(cliente1);
	
//EVENTO
		String id = "23ABC";
		LocalDate fecha = LocalDate.of(2025, 11, 5);

		
	    Evento evento1 = new Conferencia(id, fecha,TipoSala.CHICA, "LOPEZ MARIA");
	
		 gestor.agregarEvento(evento1);
		 
		 gestor.agregarClienteAUnEvento(cliente1, evento1);
		
		Boolean existe =  gestor.verificarSiExisteElClienteEnUnEvento(cliente1);
		 
	      assertTrue(existe);
	}

	@Test (expected = ClienteExistenteEnEventoException.class)

	public void dadoQueExisteUnaEmpresaConEventosCuandoAgregoUnClienteAUnEventoDondeExisteElClienteObtengoUnaClienteExistenteEnEventoException() throws EventoDuplicadoException, ClienteExistenteEnEventoException {
		Cliente cliente1 = new Cliente(1234,"marcelo","lopez");
		 gestor.agregarCliente(cliente1);
	
             //EVENTO
		String id = "23ABC";
		LocalDate fecha = LocalDate.of(2025, 11, 5);

		String id2 = "1672FFF";
		LocalDate fecha2 = LocalDate.of(2025, 11, 6);
		Evento evento1 = new Conferencia(id, fecha,TipoSala.CHICA, "LOPEZ MARIA");
	    Evento evento2 = new Conferencia(id2,fecha2,TipoSala.MEDIANA, "LOPEZ MARIA");
	
		 gestor.agregarEvento(evento1);
		 gestor.agregarEvento(evento2);
		 
		 gestor.agregarClienteAUnEvento(cliente1, evento1);
		 gestor.agregarClienteAUnEvento(cliente1, evento1);
		
	  gestor.verificarSiExisteElClienteEnUnEvento(cliente1);
	}
	
	@Test
	public void dadoQueExisteUnaEmpresaConEventosCuandoAgregoUnClienteAUnTallerSinCupoDondeNoExisteElClienteObtengoUnResultadoFallido() throws EventoDuplicadoException, ClienteExistenteEnEventoException {
		Cliente cliente1 = new Cliente(1234,"marcelo","lopez");
		 gestor.agregarCliente(cliente1);
	
		 Cliente cliente2 = new Cliente(5555,"marcela","lopez");
		 gestor.agregarCliente(cliente2);
		 
		 Cliente cliente3 = new Cliente(7777,"carlos","lopez");
		 gestor.agregarCliente(cliente3);
            //EVENTO
		String id = "23ABC";
		LocalDate fecha = LocalDate.of(2025, 11, 5);
		Integer cupoMaximo=2;
		Integer duracion=1;

		String id2 = "1672FFF";
		LocalDate fecha2 = LocalDate.of(2025, 11, 6);
		Integer cupoMaximo2=100;
		Integer duracion2=1;
		Evento evento1 = new Taller(id, fecha,TipoSala.CHICA, "LOPEZ MARIA",cupoMaximo,duracion);
	    Evento evento2 = new Taller(id2,fecha2,TipoSala.MEDIANA, "LOPEZ MARIA",cupoMaximo2, duracion2);
	
		 gestor.agregarEvento(evento1);
		 gestor.agregarEvento(evento2);
		 
		 gestor.agregarClienteAUnEvento(cliente1, evento1);
		 gestor.agregarClienteAUnEvento(cliente2, evento1);
		boolean seAgrego =  gestor.agregarClienteAUnEvento(cliente3, evento1);
		
		assertFalse(seAgrego);
		
	}
	
	
	@Test
	
	public void dadoQueExisteUnaEmpresaConEventosCuandoConsultoLaRecaudacionTodalDeUnEventoTallerCon10ParticipantesRecibo250000() throws EventoDuplicadoException, ClienteExistenteEnEventoException {
		Cliente cliente1 = new Cliente(1234,"marcelo","lopez");
		 gestor.agregarCliente(cliente1);
		 Cliente cliente2 = new Cliente(4567,"marcela","lopez");
		 gestor.agregarCliente(cliente2);
		 Cliente cliente3 = new Cliente(8910,"marcelo","abal");
		 gestor.agregarCliente(cliente3);
		 Cliente cliente4 = new Cliente(1112,"mrcelo","cristian");
		 gestor.agregarCliente(cliente4);
		 Cliente cliente5 = new Cliente(1314,"marcelo","lopez");
		 gestor.agregarCliente(cliente5);
		 Cliente cliente6 = new Cliente(1516,"ana","lopez");
		 gestor.agregarCliente(cliente6);
		 Cliente cliente7 = new Cliente(1718,"carla","lopez");
		 gestor.agregarCliente(cliente7);
		 Cliente cliente8 = new Cliente(1920,"micaela","lopez");
		 gestor.agregarCliente(cliente8);
		 Cliente cliente9 = new Cliente(2122,"camila","lopez");
		 gestor.agregarCliente(cliente9);
		 Cliente cliente10 = new Cliente(2324,"pedro","lopez");
		 gestor.agregarCliente(cliente10);
		 
	      //EVENTO
			String id = "23ABC";
			LocalDate fecha = LocalDate.of(2025, 11, 5);
			Integer cupoMaximo=20;
			Integer duracion=1;
			
			Evento evento1 = new Taller(id, fecha,TipoSala.CHICA, "LOPEZ MARIA",cupoMaximo,duracion);
		
			 gestor.agregarEvento(evento1);
			 
			 gestor.agregarClienteAUnEvento(cliente1, evento1);
			 gestor.agregarClienteAUnEvento(cliente2, evento1);
			 gestor.agregarClienteAUnEvento(cliente3, evento1);
			 gestor.agregarClienteAUnEvento(cliente4, evento1);
			 gestor.agregarClienteAUnEvento(cliente5, evento1);
			 gestor.agregarClienteAUnEvento(cliente6, evento1);
			 gestor.agregarClienteAUnEvento(cliente7, evento1);
			 gestor.agregarClienteAUnEvento(cliente8, evento1);
			 gestor.agregarClienteAUnEvento(cliente9, evento1);
			 boolean seAgrego = gestor.agregarClienteAUnEvento(cliente10, evento1);
			 
		 assertTrue(seAgrego);
			 
			 Double resultadoEsperado = 250000D;
			 Double resultadoObtenido =  gestor.calcularPrecioFinal();

			 assertEquals(resultadoEsperado,resultadoObtenido);
	
	}
	
	@Test
	public void dadoQueExisteUnaEmpresaConEventos3ConferenciasObtengoUnaListaCon3Conferencias() throws EventoDuplicadoException {
		
		Cliente cliente1 = new Cliente(1234,"marcelo","lopez");
		 gestor.agregarCliente(cliente1);
		 

            //EVENTO
		String id = "23ABC";
		LocalDate fecha = LocalDate.of(2025, 11, 5);

		String id2 = "1672FFF";
		LocalDate fecha2 = LocalDate.of(2025, 11, 6);
		
		String id3 = "1212ABEL";
		LocalDate fecha3 = LocalDate.of(2025, 11, 8);
		
		Evento evento1 = new Conferencia(id, fecha,TipoSala.CHICA, "LOPEZ MARIA");
	    Evento evento2 = new Conferencia(id2,fecha2,TipoSala.MEDIANA, "CARLOS BAUTE");
	    Evento evento3 = new Conferencia(id3,fecha3,TipoSala.GRANDE, "ABEL PINTOS");
	    
	    gestor.agregarEvento(evento1);
	    gestor.agregarEvento(evento2);
	    gestor.agregarEvento(evento3);
	    
	    //EVENTO
		String id4 = "23ABC";
		LocalDate fecha4 = LocalDate.of(2025, 11, 12);
		Integer cupoMaximo=20;
		Integer duracion=1;
		
		Evento evento4 = new Taller(id4, fecha,TipoSala.CHICA, "LOPEZ MARIA",cupoMaximo,duracion);
	
		 gestor.agregarEvento(evento4);
	    
		
	    Integer resultadoEsperado = 3;
		Integer resultadoObtenido =  gestor.obtenerListadoDeConferencias().size();

		 assertEquals(resultadoEsperado,resultadoObtenido);
		
	}

	@Test
	
	public void dadoQueExisteUnaEmpresaConEventosCuandoConsultoLosParticipantesDeConferenciasObtengoUnMapaConLasConferenciasComoClaveYUnaColeccionDeParticipantesPorConferenciaOrdenadaPorApellido() throws EventoDuplicadoException, ClienteExistenteEnEventoException {
		
		Cliente cliente1 = new Cliente(1234,"marcelo","lopez");
		 gestor.agregarCliente(cliente1);
		 
		 Cliente cliente2 = new Cliente(4567,"marcela","mopez");
		 gestor.agregarCliente(cliente2);
		 
		 Cliente cliente3 = new Cliente(8910,"marcelo","abal");
		 gestor.agregarCliente(cliente3);
		 
		 Cliente cliente4 = new Cliente(1112,"mrcelo","cristian");
		 gestor.agregarCliente(cliente4);
	
           //EVENTO
		String id = "23ABC";
		LocalDate fecha = LocalDate.of(2025, 11, 5);

		String id2 = "1672FFF";
		LocalDate fecha2 = LocalDate.of(2025, 11, 6);
		
		String id3 = "1212ABEL";
		LocalDate fecha3 = LocalDate.of(2025, 11, 8);
		
		Evento evento1 = new Conferencia(id, fecha,TipoSala.CHICA, "LOPEZ MARIA");
	    Evento evento2 = new Conferencia(id2,fecha2,TipoSala.MEDIANA, "CARLOS BAUTE");
	    Evento evento3 = new Conferencia(id3,fecha3,TipoSala.GRANDE, "ABEL PINTOS");
	    
	    //EVENTO
		String id4 = "23ABC";
		LocalDate fecha4 = LocalDate.of(2025, 11, 12);
		Integer cupoMaximo=20;
		Integer duracion=1;
	    Evento evento4 = new Taller(id4, fecha,TipoSala.CHICA, "LOPEZ MARIA",cupoMaximo,duracion);
		
	    gestor.agregarEvento(evento1);
	    gestor.agregarEvento(evento2);
	    gestor.agregarEvento(evento3);
	    gestor.agregarEvento(evento4);
		
	    // AGREGAR CLIENTES A EVENTOS
	    
	    gestor.agregarClienteAUnEvento(cliente1, evento1);
	    gestor.agregarClienteAUnEvento(cliente1, evento3);
	    
	     gestor.agregarClienteAUnEvento(cliente2, evento1);
		 gestor.agregarClienteAUnEvento(cliente2, evento2);
		 
		 gestor.agregarClienteAUnEvento(cliente3, evento1);
		 gestor.agregarClienteAUnEvento(cliente3, evento4);
		 gestor.agregarClienteAUnEvento(cliente3, evento3);
		
		 // cliente 4 sin eventos 
		 
		 HashMap <Conferencia, TreeSet <Cliente>> reporteOrdenado = gestor.obtenerReporteDeConferencia();
		 
	    assertTrue(reporteOrdenado.containsKey(evento1));
		assertTrue(reporteOrdenado.containsKey(evento2));
	 
		 assertFalse(reporteOrdenado.containsKey(evento4));
		
		 assertEquals(cliente3.getApellido(),reporteOrdenado.get(evento1).first().getApellido());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


package ar.edu.unlam.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.dominio.*;

public class JuegosPruebaUnitaria {

	private ClubDeJuegos clubJuegos;
	private Torneo torneo;
	private JuegoDeMesa poker;
	private LocalDate fechaInicioPoker;
	
	@Before
	
	public void inicializacion() {
		fechaInicioPoker = LocalDate.of(2025, 01, 03);
		clubJuegos = new ClubDeJuegos();
		poker = new JuegoEstrategia("poker", fechaInicioPoker);
		torneo = new Torneo("POKER",poker,fechaInicioPoker);
		
		
	}
	
	@Test
	public void dadoQueExisteUnGestorDeJuegoAgregoUnTorneo() {
		
		Boolean seAgrego = clubJuegos.agregarTorneo(torneo);
		
		Torneo torneo2 = new Torneo("POKER",poker,fechaInicioPoker);
		
		Boolean seAgrego2 = clubJuegos.agregarTorneo(torneo2);
		assertTrue(seAgrego);
		assertFalse(seAgrego2);
	}
}

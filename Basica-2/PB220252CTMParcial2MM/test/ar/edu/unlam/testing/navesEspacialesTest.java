package ar.edu.unlam.testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.dominio.*;
import ar.edu.unlam.excepciones.IdDuplicadoException;
import ar.edu.unlam.excepciones.TonelajeDeCargaExcecidoException;
import ar.edu.unlam.menum.*;

public class navesEspacialesTest {

	private AgenciaDeNaves agencia;

	@Before
	public void inicializacion() {
		agencia = new AgenciaDeNaves();

	}

	@Test
	public void deberiaPermitirseElRegistroDeUnaNaveExploradoraDeLargoAlcance()
			throws TonelajeDeCargaExcecidoException, IdDuplicadoException {
		String IdNaveE1 = "E-456";
		String nombreNaveE1 = "Max";
		Nave naveExploradora1 = new NaveExploradora(IdNaveE1, nombreNaveE1, TipoAlcance.LARGO);
		Boolean seAgrego = agencia.agregarNave(naveExploradora1);
		assertTrue(seAgrego);

	}

	@Test(expected = TonelajeDeCargaExcecidoException.class)
	public void noDeberiaPermitirseElRegistroDeUnaNaveCargueraQueExcedaElTonelaje()
			throws TonelajeDeCargaExcecidoException, IdDuplicadoException {

		String IdNaveC1 = "C-123";
		String nombreNaveC1 = "GALACTICO";
		Double tonelajeDeCargaC1 = 31D; // Excede
		Double cilindradaDelMotorC1 = 1000D;

		NaveCarguera naveCarguera1 = new NaveCarguera(IdNaveC1, nombreNaveC1, tonelajeDeCargaC1, cilindradaDelMotorC1);
		agencia.agregarNave(naveCarguera1);

	}

	@Test (expected = IdDuplicadoException.class)
	public void noDeberiaPermitirseElRegistroDeUnaNaveSondaSiElIdentificadorYaExiste()
			throws TonelajeDeCargaExcecidoException, IdDuplicadoException {

		String IdNaveSonda1 = "S-789";
		String nombreSonda1 = "MARAVILLA";

		Nave naveSonda1 = new NaveSonda(IdNaveSonda1, nombreSonda1);
		agencia.agregarNave(naveSonda1);

		String IdNaveSonda2 = "S-789";
		String nombreSonda2 = "MAX";

		Nave naveSonda2 = new NaveSonda(IdNaveSonda2, nombreSonda2);
		agencia.agregarNave(naveSonda2);

	}

	@Test
	public void DeberiaPoderRegistrarseUnaMisionDe4HorasParaUnaNaveDeCortoAlcanceExistente()
			throws TonelajeDeCargaExcecidoException, IdDuplicadoException {
		String IdNaveE2 = "E-450";
		String nombreNaveE2 = "LoMax";
		Nave naveExploradora2 = new NaveExploradora(IdNaveE2, nombreNaveE2, TipoAlcance.CORTO);
		agencia.agregarNave(naveExploradora2);

		Integer horasMision = 4;
		Mision mision1 = new Mision(naveExploradora2, horasMision);
		Boolean seAgrego = agencia.realizarMision(mision1);
		assertTrue(seAgrego);
	}

	@Test

	public void deberiaPoderCalcularseElConsumoDeCombustibleDeUnaNaveCargueraExistenteParaUnaMisionDe8Horas()
			throws TonelajeDeCargaExcecidoException, IdDuplicadoException {

		String IdNaveC1 = "C-123";
		String nombreNaveC1 = "GALACTICO";
		Double tonelajeDeCargaC1 = 10D;
		Double cilindradaDelMotorC1 = 1000D;

		NaveCarguera naveCarguera1 = new NaveCarguera(IdNaveC1, nombreNaveC1, tonelajeDeCargaC1, cilindradaDelMotorC1);
		agencia.agregarNave(naveCarguera1);

		Integer horasMision = 8;
		Mision mision1 = new Mision(naveCarguera1, horasMision);

		Double resultadoEsperado = 480D;
		Double resultadoObtenido = mision1.obtenerConsulmoDeCombustiblePorMision();
		assertEquals(resultadoEsperado, resultadoObtenido);

	}

	@Test

	public void deberiaPoderCalcularseElConsumoDeCombustibleDeUnaNaveDeLargoAlcanceExistenteEnUnaMisionDe6Horas()
			throws TonelajeDeCargaExcecidoException, IdDuplicadoException {

		String IdNaveE1 = "E-456";
		String nombreNaveE1 = "Max";
		Nave naveExploradora1 = new NaveExploradora(IdNaveE1, nombreNaveE1, TipoAlcance.LARGO);
		agencia.agregarNave(naveExploradora1);

		Integer horasMision = 6;
		Mision mision1 = new Mision(naveExploradora1, horasMision);

		Double resultadoEsperado = 240D;
		Double resultadoObtenido = mision1.obtenerConsulmoDeCombustiblePorMision();
		assertEquals(resultadoEsperado, resultadoObtenido);

	}

	@Test
	public void deberiaPoderObtenerseUnaColeccionDeTodasLasNavesOrdenadasPorIdentificadPorAscendente()
			throws TonelajeDeCargaExcecidoException, IdDuplicadoException {
		String IdNaveE1 = "E-456";
		String nombreNaveE1 = "Max";
		Nave naveExploradora1 = new NaveExploradora(IdNaveE1, nombreNaveE1, TipoAlcance.LARGO);

		agencia.agregarNave(naveExploradora1);

		String IdNaveC1 = "C-123";
		String nombreNaveC1 = "GALACTICO";
		Double tonelajeDeCargaC1 = 20D;
		Double cilindradaDelMotorC1 = 1000D;

		NaveCarguera naveCarguera1 = new NaveCarguera(IdNaveC1, nombreNaveC1, tonelajeDeCargaC1, cilindradaDelMotorC1);

		agencia.agregarNave(naveCarguera1);

		String IdNaveSonda1 = "S-789";
		String nombreSonda1 = "MARAVILLA";

		Nave naveSonda1 = new NaveSonda(IdNaveSonda1, nombreSonda1);
		agencia.agregarNave(naveSonda1);

		String IdNaveSonda2 = "S-790";
		String nombreSonda2 = "LOS FUNDAMENTALISTAS";

		Nave naveSonda2 = new NaveSonda(IdNaveSonda2, nombreSonda2);
		agencia.agregarNave(naveSonda2);

		TreeSet<Nave> listaDeNavesOrdenadas = agencia.obtenerListadoDeNavesOrdenadasPorIDAsc();

		assertEquals(naveCarguera1, listaDeNavesOrdenadas.first());
		assertEquals(naveSonda2, listaDeNavesOrdenadas.last());

		assertEquals(naveCarguera1.getIdUnico(), listaDeNavesOrdenadas.first().getIdUnico());
		assertEquals(naveSonda2.getIdUnico(), listaDeNavesOrdenadas.last().getIdUnico());

	}

	@Test
	public void deberiaPoderObtenerseUnaColeccionDeLasNavesSondaOrdenadasPorNombreDescendente()
			throws TonelajeDeCargaExcecidoException, IdDuplicadoException {

		String IdNaveE1 = "E-456";
		String nombreNaveE1 = "VELOZ";
		Nave naveExploradora1 = new NaveExploradora(IdNaveE1, nombreNaveE1, TipoAlcance.LARGO);

		agencia.agregarNave(naveExploradora1);

		String IdNaveC1 = "C-123";
		String nombreNaveC1 = "GALACTICO";
		Double tonelajeDeCargaC1 = 20D;
		Double cilindradaDelMotorC1 = 1000D;

		NaveCarguera naveCarguera1 = new NaveCarguera(IdNaveC1, nombreNaveC1, tonelajeDeCargaC1, cilindradaDelMotorC1);

		agencia.agregarNave(naveCarguera1);

		String IdNaveSonda1 = "S-789";
		String nombreSonda1 = "MARAVILLA";

		Nave naveSonda1 = new NaveSonda(IdNaveSonda1, nombreSonda1);
		agencia.agregarNave(naveSonda1);

		String IdNaveSonda2 = "S-790";
		String nombreSonda2 = "LOS FUNDAMENTALISTAS";

		Nave naveSonda2 = new NaveSonda(IdNaveSonda2, nombreSonda2);
		agencia.agregarNave(naveSonda2);

		TreeSet<Nave> listaDeNavesOrdenadas = agencia.obtenerListadoDeNavesOrdenadasPorNombreDesc();

		assertEquals(naveCarguera1, listaDeNavesOrdenadas.last());
		assertEquals(naveExploradora1, listaDeNavesOrdenadas.first());

		assertEquals(naveCarguera1.getNombre(), listaDeNavesOrdenadas.last().getNombre());
		assertEquals(naveExploradora1.getNombre(), listaDeNavesOrdenadas.first().getNombre());
	}

	@Test
	public void deberiaPoderObtenerseUnReporteDeTodasLasMisionesRealizadasPorCadaNaveDeTodosLosGrupos()
			throws TonelajeDeCargaExcecidoException, IdDuplicadoException {
		String IdNaveE1 = "E-456";
		String nombreNaveE1 = "VELOZ";
		Nave naveExploradora1 = new NaveExploradora(IdNaveE1, nombreNaveE1, TipoAlcance.LARGO);

		agencia.agregarNave(naveExploradora1);

		String IdNaveC1 = "C-123";
		String nombreNaveC1 = "GALACTICO";
		Double tonelajeDeCargaC1 = 20D;
		Double cilindradaDelMotorC1 = 1000D;
		NaveCarguera naveCarguera1 = new NaveCarguera(IdNaveC1, nombreNaveC1, tonelajeDeCargaC1, cilindradaDelMotorC1);

		agencia.agregarNave(naveCarguera1);

		// NAVE SIN MISION
		String IdNaveSonda1 = "S-789";
		String nombreSonda1 = "MARAVILLA";
		Nave naveSonda1 = new NaveSonda(IdNaveSonda1, nombreSonda1);
		agencia.agregarNave(naveSonda1);

		String IdNaveSonda2 = "S-790";
		String nombreSonda2 = "LOS FUNDAMENTALISTAS";
		Nave naveSonda2 = new NaveSonda(IdNaveSonda2, nombreSonda2);
		agencia.agregarNave(naveSonda2);

		// MISIONES
		Integer horasMision = 4;
		Mision mision1 = new Mision(naveCarguera1, horasMision);
		agencia.realizarMision(mision1);
	
		Integer horasMision2 = 4;
		Mision mision2 = new Mision(naveSonda2, horasMision2);
		agencia.realizarMision(mision2);

		Integer horasMision3 = 4;
		Mision mision3 = new Mision(naveExploradora1, horasMision3);
		agencia.realizarMision(mision3);

		HashMap<Nave, ArrayList<Mision>> reporte = agencia.obtenerReporteDeLasMisiones();
	
		assertTrue(reporte.containsKey(naveCarguera1));
		assertTrue(reporte.containsKey(naveSonda2));
		assertFalse(reporte.containsKey(naveSonda1));

	}

}

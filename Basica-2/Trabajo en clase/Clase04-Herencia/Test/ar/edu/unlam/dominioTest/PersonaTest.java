package ar.edu.unlam.dominioTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import ar.edu.unlam.Asalariado;
import ar.edu.unlam.Persona;
import ar.edu.unlam.Voluntario;

public class PersonaTest {

	@Test

	public void dadoQueExisteUnaPersonaCuandoLaInstancioLosATributosSePuedenConsultar() {

		Persona persona = new Persona(127383, "Micaela", 30);

		assertEquals(127383, (int) persona.getDni());
		assertEquals("Micaela", persona.getNombre());
		assertEquals(30, (int) persona.getEdad());

	}

	@Test

	public void dadoQueExisteUnaPersonaAsalariadoCuandoLaInstancioLosATributosSePuedenConsultar() {

		Asalariado personaAsalariada = new Asalariado(127383, "Micaela", 30, 1000D);

		assertEquals(127383, (int) personaAsalariada.getDni());
		assertEquals("Micaela", personaAsalariada.getNombre());
		assertEquals(30, (int) personaAsalariada.getEdad());
		assertEquals("Soy una persona asalariada", personaAsalariada.toString());

	}

	@Test

	public void dadoQueExisteUnaPersonaVoluntariaCuandoLaInstancioLosATributosSePuedenConsultar() {

		Voluntario personaVoluntaria = new Voluntario(127383, "Micaela", 30, 4);

		assertEquals(127383, (int) personaVoluntaria.getDni());
		assertEquals("Micaela", personaVoluntaria.getNombre());
		assertEquals(30, (int) personaVoluntaria.getEdad());
		assertEquals(4, (int) personaVoluntaria.getHorasDisponibles());
		assertEquals("Soy una persona voluntaria", personaVoluntaria.toString());

	}

	@Test
	
	public void Test() {
		
		Persona asalariado = new Asalariado(127383, "Micaela", 30, 1000D);
		System.out.println(asalariado.toString());
		
		asalariado.ayudar();
		
		Asalariado otroAsalariado = new Asalariado(12345, "Sofia", 25, 100D);
		Voluntario voluntario = new Voluntario(127383, "Micaela", 30, 4);
		
		
		List <Persona> personas = new ArrayList<Persona>();
		personas.add(voluntario);
		personas.add(asalariado);
		
		for (Persona persona : personas) {
			if(persona instanceof Voluntario) {
				System.out.println("Voluntario: " + ((Voluntario)persona).getHorasDisponibles() + " Horas disponibles");
			}
		}
		
		for (Persona persona : personas) {
			if(persona instanceof Asalariado) {
				System.out.println("Persona : " + ((Asalariado)persona).getNombre() + " sueldo: " + ((Asalariado)persona).getSalario());
			}
		}
		
		
		ArrayList <Persona> personaDos = new ArrayList<>();
		personaDos.add(asalariado);
		personaDos.add(voluntario);
		
		personaDos.add(otroAsalariado);
		otroAsalariado.getSalario();
		otroAsalariado.getNombre();
		
		((Asalariado)asalariado).getSalario();
		
	}
}

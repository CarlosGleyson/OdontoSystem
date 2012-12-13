package br.com.engaplicada.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PacienteTest {
	
	private Paciente paciente;
	
	@Before
	public void setup(){
		this.paciente = new Paciente();
	}

	@Test
	public void testConstrutor() {
		// id; codigo
		this.paciente = new Paciente(2, "sicrano");
		assertEquals(paciente.getId(), 2);
		assertEquals(paciente.getNome(), "sicrano");
	}
	
	@Test
	public void testIdPaciente(){
		this.paciente.setId(10);
		assertEquals(paciente.getId(), 10);
	}
	
	@Test
	public void testNomePaciente(){
		this.paciente.setNome("joaoziho");
		assertEquals(paciente.getNome(), "joaozinho");
	}

}

package br.com.engaplicada.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MedicoTest {
	
	private Medico medico;

	@Before
	public void setup(){
		medico = new Medico();
	}
	
	@Test
	public void testConstrutor(){
		// id; nome
		medico = new Medico(1, "fulano");
		assertEquals(medico.getId(), 1);
		assertEquals(medico.getNome(), "fulano");
	}
	
	@Test
	public void testNomeMedico() {
		medico.setNome("fulano");
		assertEquals(medico.getNome(), "fulano");
	}

	@Test
	public void testIdMedico() {
		medico.setId(1);
		assertEquals(medico.getId(), 1);
	}

}

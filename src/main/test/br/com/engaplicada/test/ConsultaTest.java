package br.com.engaplicada.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class ConsultaTest {
	
	private Consulta consulta;
	
	@Before
	public void setup(){
		this.consulta = new Consulta();
	}

	
	@Test
	public void testConstrutor() {
		// DataCadastro; DataConsulta; idMedico, idPaciente
		this.consulta = new Consulta(new Date(2012, 11, 12, 20, 29), new Date(2012, 11, 12, 20, 30), 1, 1);
		if(consulta.getDataCadastro() > consulta.getDataConsulta())
			fail("Data inconsistente! A data de realização da consulta é inferior a data de marcação");
		assertEquals(consulta.getIdMedico(), 1);
		assertEquals(consulta.getIdPaciente(), 1);
	}
	
	@Test
	public void testIdMedico(){
		this.consulta.setIdMedico(1);
		assertEquals(consulta.getIdMedico(), 1);
	}
	
	@Test
	public void testIdPaciente(){
		this.consulta.setIdPaciente(1);
		assertEquals(consulta.getIdPaciente(), 1);
	}
}

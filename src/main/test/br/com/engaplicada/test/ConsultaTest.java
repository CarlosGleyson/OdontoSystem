package br.com.engaplicada.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import br.com.engaplicada.entity.Consulta;

public class ConsultaTest {
	
	private Consulta consulta;
	
	@Before
	public void setup(){
		this.consulta = new Consulta();
	}
	
//	@Test
//	public void testConstrutor() {
//		// DataCadastro; DataConsulta; idMedico, idPaciente
//		this.consulta = new Consulta(new Date(2012, 11, 12, 20, 29), new Date(2012, 11, 12, 20, 30), 1, 1);
//		if(consulta.getDataCadastro() > consulta.getDataConsulta())
//			fail("Data inconsistente! A data de realização da consulta é inferior a data de marcação");
//		assertEquals(consulta.getIdMedico(), 1);
//		assertEquals(consulta.getIdPaciente(), 1);
//	}
	
	@Test
	public void testAccessDataDoctor(){
		this.consulta.setDoctor("fulano");
		assertEquals(consulta.getDoctor(), "fulano");
	}
	
	@Test
	public void testAccessDataPatient(){
		this.consulta.setPatient("siclano");
		assertEquals(consulta.getPatient(), "siclano");
	}
}

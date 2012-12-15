/**
 * 
 */
package br.com.engaplicada.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import br.com.engaplicada.entity.Consulta;

/**
 * @author Smith
 *
 */
public class ConsultaDao extends OdontosystemGenericDaoImpl<Consulta>{

	
	/**
	 * @param entityClass
	 */
	public ConsultaDao() {
		super(Consulta.class);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Consulta> findAll() {
		Query myQuery = entityManager.createQuery("SELECT c from Consulta c order by c.schedulingDate");
		
		List<Consulta> consultas = (List<Consulta>)myQuery.getResultList();
		return consultas;
	}

/**Aqui a busca é relizada pela data de agendamento da consulta
 * 
 * Obs.: Consultas filtradas pelo nome do paciente*/
	@Override
	public Consulta findByName(String namePaciente) {
		Query myQuery = entityManager.createQuery("SELECT c from Consulta c where c.patient = name");
		myQuery.setParameter("name", namePaciente+"%");
		Consulta consulta = (Consulta) myQuery.getSingleResult();
		return consulta;
	}
	
	@SuppressWarnings("unchecked")
	public List<Consulta> findByNamePaciente(String namePaciente) {
		Query myQuery = entityManager.createQuery("SELECT c from Consulta c where c.patient = name");
		myQuery.setParameter("name", namePaciente+"%");
		List<Consulta> consultas = (List<Consulta>) myQuery.getResultList();
		return consultas;
	}
	
	@SuppressWarnings("unchecked")
	public List<Consulta> findByMedico(String nameMedico) {
		Query myQuery = entityManager.createQuery("SELECT c from Consulta c where c.doctor = ?");
		myQuery.setParameter(1, nameMedico);
		List<Consulta> consultas = (List<Consulta>) myQuery.getResultList();
		return consultas;
	}
	
	@SuppressWarnings("unchecked")
	public List<Consulta> findConsultaByDataConsulta(Date dataConsulta){
		Query myQuery = entityManager.createQuery("SELECT c FROM Consulta c where c.realizationDate = ?");
		myQuery.setParameter(1,dataConsulta);
		
		List<Consulta> consultas = (List<Consulta>) myQuery.getResultList();
		return consultas;
	}
	
	@SuppressWarnings("unchecked")
	public List<Consulta> findConsultaByDataAgendamento(Date dataAgendamento){
		Query myQuery = entityManager.createQuery("SELECT c FROM Consulta c where c.schedulingDate = ?");
		myQuery.setParameter(1,dataAgendamento);
		
		List<Consulta> consultas = (List<Consulta>) myQuery.getResultList();
		return consultas;
	}
	
	
}

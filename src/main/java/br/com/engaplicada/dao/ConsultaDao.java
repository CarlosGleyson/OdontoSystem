/**
 * 
 */
package br.com.engaplicada.dao;

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
	public List<Consulta> findAll() {
		Query myQuery = entityManager.createQuery("SELECT c from Consulta c order by c.schedulingDate");
		List<Consulta> consultas = (List<Consulta>)myQuery.getResultList();
		return consultas;
	}

/**Aqui a busca é relizada pela data de agendamento da consulta
 * 
 * Obs.: alterar esta forma de busca - pode haver várias consultas com mesma data de agendamento*/
	@Override
	public Consulta findByName(String name) {
		Query myQuery = entityManager.createQuery("SELECT c from Consulta c where schedulingDate = c.schedulingDate");
		myQuery.setParameter("schedulingDate", name+"%");
		Consulta consulta = (Consulta) myQuery.getSingleResult();
		return consulta;
	}

}

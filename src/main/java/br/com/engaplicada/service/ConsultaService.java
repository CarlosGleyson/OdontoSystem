/**
 * 
 */
package br.com.engaplicada.service;

import java.util.Date;
import java.util.List;

import br.com.engaplicada.dao.ConsultaDao;
import br.com.engaplicada.entity.Consulta;
import br.com.engaplicada.util.RNException;
import br.com.engaplicada.util.RepositoryException;

/**
 * @author Smith
 *
 */
public class ConsultaService {
	
	private ConsultaDao consultaDao; 
	
	public ConsultaService(){
		this.consultaDao = new ConsultaDao(); 
	}
	
	public Consulta getConsultaByParameter(String parameter){
		return this.consultaDao.findByName(parameter);
	}
	
	public boolean cadastrarConsulta(Consulta consulta) throws RNException{
		try {
			this.consultaDao.save(consulta);
			return true;
		} catch (RepositoryException e) {
			throw new RNException(" ERROR : Não foi possível cadastrar a consulta!");
		}
	}

	public boolean removerConsulta(Consulta consulta) throws RNException{
		try{
			this.consultaDao.delete(consulta);
			return true;
		}catch (Exception e) {
			throw new RNException(" ERROR : Não foi possível remover a consulta!");
		}
		
	}
	
	public boolean atualizarCosnulta(Consulta consulta) throws RNException{
		try{
			this.consultaDao.update(consulta);
			return true;
		}catch (Exception e) {
			throw new RNException(" ERROR : Não foi possível atualizar a consulta!");
		}
		
	}

	public List<Consulta> getAllConsultas(){
		return this.consultaDao.findAll();
	}
	
	public void setConsultaDao(ConsultaDao cd){
		this.consultaDao = cd;
	}

	public List<Consulta> getConsultasPorMedico(String nomeMedico) {
		return consultaDao.findByMedico(nomeMedico);
	}

	public List<Consulta> getConsultasPorDataAgendamento(Date schedulingData) {
		return consultaDao.findConsultaByDataAgendamento(schedulingData);
	}

	public List<Consulta> getConsultasPorDataConsulta(Date realizationData) {
		return consultaDao.findConsultaByDataConsulta(realizationData);
	}
}

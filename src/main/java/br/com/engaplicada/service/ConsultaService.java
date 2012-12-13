/**
 * 
 */
package br.com.engaplicada.service;

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
	
	private ConsultaDao consulta; 
	
	public ConsultaService(){
		this.consulta = new ConsultaDao(); 
	}
	
	public Consulta getConsultaByParameter(String parameter){
		return this.consulta.findByName(parameter);
	}
	
	public void cadastrarConsulta(Consulta consulta) throws RNException{
		try {
			this.consulta.save(consulta);
		} catch (RepositoryException e) {
			throw new RNException(" ERROR : Não foi possível cadastrar a consulta!");
		}
	}

	public void removerConsulta(Consulta consulta){
		this.consulta.delete(consulta);
	}
	
	public void atualizarCosnulta(Consulta consulta){
		this.consulta.update(consulta);
	}

	public List<Consulta> getAllConsultas(){
		return this.consulta.findAll();
	}
	
	public void setConsultaDao(ConsultaDao cd){
		this.consulta = cd;
	}
}

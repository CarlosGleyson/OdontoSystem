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
	
	public boolean cadastrarConsulta(Consulta consulta) throws RNException{
		try {
			this.consulta.save(consulta);
			return true;
		} catch (RepositoryException e) {
			throw new RNException(" ERROR : Não foi possível cadastrar a consulta!");
		}
	}

	public boolean removerConsulta(Consulta consulta) throws RNException{
		try{
			this.consulta.delete(consulta);
			return true;
		}catch (Exception e) {
			throw new RNException(" ERROR : Não foi possível remover a consulta!");
		}
		
	}
	
	public boolean atualizarCosnulta(Consulta consulta) throws RNException{
		try{
			this.consulta.update(consulta);
			return true;
		}catch (Exception e) {
			throw new RNException(" ERROR : Não foi possível atualizar a consulta!");
		}
		
	}

	public List<Consulta> getAllConsultas(){
		return this.consulta.findAll();
	}
	
	public void setConsultaDao(ConsultaDao cd){
		this.consulta = cd;
	}
}

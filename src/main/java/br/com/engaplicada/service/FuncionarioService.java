package br.com.engaplicada.service;

import java.io.Serializable;
import java.util.List;

import br.com.engaplicada.dao.FuncionarioDao;
import br.com.engaplicada.entity.Funcionario;
import br.com.engaplicada.util.RNException;

public class FuncionarioService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private FuncionarioDao dao;
	
	public FuncionarioService(){
		this.dao = new FuncionarioDao();
	}

	public Funcionario getFuncionarioByName(String parameter){
		return this.dao.findByName(parameter);
	}
	
	public Funcionario getFuncionarioByAdress(String adress){
		return this.dao.findByAdress(adress);
	}
	
	public List<Funcionario> getFuncionarios(){
		return this.dao.findAll();
	}

	
	public boolean atualizarFuncionario (Funcionario f) throws RNException{
		try{
			this.dao.update(f);
			return true;
		}catch(Exception e){
			throw new RNException("ERROR: Não foi possível atualizar dados do cliente");
		}
	}
	
	public boolean salvarFuncionario(Funcionario f) throws RNException{
		try{
			this.dao.save(f);
			return true;
		}catch(Exception e){
			throw new RNException("ERROR: Não foi possível salvar os dados do cliente");
		}
	}
	
	public boolean removerFuncionario(Funcionario f) throws RNException{
		try{
			this.dao.delete(f);
			return true;
		}catch(Exception e){
			throw new RNException("Error: Não foi possível apagar dados do cliente");
		}
	}
	
	public Funcionario buscarFuncionarioByName(String nome){
		return this.dao.findByName(nome);
	}
}

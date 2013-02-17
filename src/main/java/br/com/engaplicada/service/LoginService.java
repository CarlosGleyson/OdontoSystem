package br.com.engaplicada.service;

import java.io.Serializable;

import javax.persistence.NoResultException;

import br.com.engaplicada.dao.UsuarioDao;
import br.com.engaplicada.util.EventoLogin;
import br.com.engaplicada.util.RepositoryException;

/**
 * @author Paulo Neto
 *Classe que representa as regras referentes ao login do sistema.
 * **/
public class LoginService implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UsuarioDao dao;
	
	public LoginService() {
	 	dao = new UsuarioDao();
	}

	public boolean isAutenticar(EventoLogin el)throws RepositoryException{
		
		String umasenha = el.getSenha();
		String umLogin = el.getLogin();
		
		try{
		if(dao.athentication(umasenha, umLogin) != null){
			return true;	
		}
		}catch (NoResultException e) {
			throw new RepositoryException("Não existe Usuario com esses parametros !");
		}
		return false;
	}	
}
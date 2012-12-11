package br.com.engaplicada.service;

import java.util.List;

import br.com.engaplicada.dao.UsuarioDao;
import br.com.engaplicada.entity.Usuario;
import br.com.engaplicada.util.RNException;
import br.com.engaplicada.util.RepositoryException;


public class UsuarioService {
	
	private UsuarioDao dao;
	
	public UsuarioService(){
		this.dao = new UsuarioDao();
	}
	
	public List<Usuario> getAllUsuarios(){
		return dao.findAll();
	}
	
	public Usuario getUsuarioByNome(String nome){
		return dao.findByName(nome);
	}
	
	public boolean isCadastrar(Usuario usuario) throws RepositoryException, RNException{
		 try {
			dao.save(usuario);
			return true;
		} catch (RepositoryException e) {
				throw new RNException(" ERRO : Falha ao salvar o Usuario !");
		}
	}
	
	public boolean isAtualizar(Usuario usuario) throws RNException{
		try{
			dao.update(usuario);
			return true;
		}catch (Exception e) {
			throw new RNException(" ERRO : Falha ao atualizar o Usuario !");
		}
	}
	
	public boolean isRemover(Usuario usuario) throws RNException{
		try{
			dao.delete(usuario);
			return true;
		}catch (Exception e) {
			throw new RNException("ERRO : Falha ao remover Usuario !");
		}
	}

	public UsuarioDao getDao() {
		return dao;
	}

	public void setDao(UsuarioDao dao) {
		this.dao = dao;
	}
	
}

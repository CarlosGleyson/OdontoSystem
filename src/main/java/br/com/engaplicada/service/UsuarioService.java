package br.com.engaplicada.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.engaplicada.dao.UsuarioDao;
import br.com.engaplicada.entity.Usuario;
import br.com.engaplicada.util.RepositoryException;

@Service("usuarioService")
public class UsuarioService {
	@Autowired
	private UsuarioDao dao;
	
	public List<Usuario> getAllUsuarios(){
		return dao.findAll();
	}
	
	public Usuario getUsuarioByNome(String nome){
		return dao.findByName(nome);
	}
	
	public void createUsuario(Usuario usuario) throws RepositoryException{
		 dao.save(usuario);
	}
	
	public void updateUsuario(Usuario usuario){
		dao.update(usuario);
	}
	
	public void deleteUsuario(Usuario usuario){
		dao.delete(usuario);
	}

	public UsuarioDao getDao() {
		return dao;
	}

	public void setDao(UsuarioDao dao) {
		this.dao = dao;
	}
	
	
	
}

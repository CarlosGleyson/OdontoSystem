package br.com.engaplicada.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;

import br.com.engaplicada.entity.Usuario;


/**
 * @author Paulo Antonio
 * 
 */
//@Repository("usuarioDao")
public class UsuarioDao extends OdontosystemGenericDaoImpl<Usuario>{

	public UsuarioDao() {
		super(Usuario.class);
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("unchecked")
	//@Transactional(readOnly=true)
	public List<Usuario> findAll(){
		String hql = "SELECT u from Usuario u order by u.login";
		Query query = entityManager.createQuery(hql);
		List<Usuario> usuario = (List<Usuario>) query.getResultList();
		return usuario;
	}

	public Usuario findByName(String login) {
		String hql = "SELECT u from Usuario u where nome like:nome order by u.login";
		Query query = entityManager.createQuery(hql);
		query.setParameter("nome", login+"%");
		return (Usuario) query.getSingleResult();
	}
	
	public Usuario athentication(String senha, String login)throws NoResultException{
		return (Usuario) entityManager.createQuery("SELECT u FROM Usuario u where u.login  = '"+login+"' and  u.senha = '"+senha+"'").getSingleResult();
				
	}
	
	public Usuario findUsuarioByLogin(String login){
		Query q = entityManager.createQuery("select u from Usuario u where u.login = '"+login+"'");
		//q.setParameter("login",login+"%");
		return (Usuario) q.getSingleResult();
	}
}

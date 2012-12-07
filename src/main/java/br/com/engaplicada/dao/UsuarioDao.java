package br.com.engaplicada.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.engaplicada.entity.Usuario;


/**
 * @author Paulo Antonio
 * 
 */
@Repository("usuarioDao")
public class UsuarioDao extends OdontosystemGenericDaoImpl<Usuario>{

	public UsuarioDao(Class<Usuario> entityClass) {
		super(entityClass);
		// TODO Auto-generated constructor stub
	}


	@PersistenceContext(name="odontosystemPU")
	protected EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<Usuario> findAll(){
		String hql = "SELECT u from Usuario u order by u.nome";
		Query query = entityManager.createQuery(hql);
		List<Usuario> usuario = (List<Usuario>) query.getResultList();
		return usuario;
	}
	
	public void setEntityManeger(EntityManager entityManeger){
		this.entityManager = entityManeger;
	}

	public Usuario findByName(String name) {
		String hql = "SELECT u from Usuario u where nome like:nome order by u.nome";
		Query query = entityManager.createQuery(hql);
		query.setParameter("nome", name+"%");
		return (Usuario) query.getSingleResult();
	}
}

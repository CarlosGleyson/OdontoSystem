package br.com.engaplicada.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import br.com.engaplicada.util.HibernateUtil;
import br.com.engaplicada.util.RepositoryException;

/**
 * @author Paulo Antonio
 * 
 */
public abstract class OdontosystemGenericDaoImpl<T> implements OdontosystemGenericDao<T>, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected EntityManager entityManager;
	private Class<T> entityClass;

	public OdontosystemGenericDaoImpl(Class<T> entityClass) {
		this.entityClass = entityClass;
		this.entityManager = HibernateUtil.getInstance().getFactory().createEntityManager();
	}

	public void save(T entity) throws RepositoryException {
		try {
			
			entityManager.getTransaction().begin();
			entityManager.persist(entity);
			entityManager.getTransaction().commit();
			
		} catch (Exception e) {			
			entityManager.getTransaction().rollback();
			throw new RepositoryException("Error save: "+e.getMessage());
		}	
	}

	public void delete(T entity) {
		entityManager.getTransaction().begin();
		entityManager.remove(entity);
		entityManager.getTransaction().commit();
	}

	public void update(T entity) {
		entityManager.getTransaction().begin();
		entityManager.merge(entity);
		entityManager.getTransaction().commit();
	}

	public T findId(int entityID) {
		return entityManager.find(entityClass, entityID);
	}
	
	public abstract List<T> findAll();
	
	public abstract T findByName(String name);
	
	public void setEntityManeger(EntityManager entityManeger){
		this.entityManager = entityManeger;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
}

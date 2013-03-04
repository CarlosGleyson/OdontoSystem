package br.com.engaplicada.dao;

import java.util.List;
import br.com.engaplicada.util.RepositoryException;

/**
 * @author Paulo Neto
 * */
public interface OdontosystemGenericDao<T>{
	public void save(T entity)  throws RepositoryException;

	public void delete(T entity)throws RepositoryException;

	public void update(T entity)throws RepositoryException;

	public T findId(int entityID)throws RepositoryException;
	
	public List<T> findAll()throws RepositoryException;
	
	public T findByName(String name)throws RepositoryException;
}

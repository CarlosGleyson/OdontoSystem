package br.com.engaplicada.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.engaplicada.entity.Cliente;

/**
 * @author Smith Ascari
 *		
 */
public class ClienteDao extends OdontosystemGenericDaoImpl<Cliente>{

	
	/**
	 * @param entityClass
	 */
	public ClienteDao() {
		super(Cliente.class);
	}


	@Override
	@SuppressWarnings("unchecked")
	public List<Cliente> findAll() {
		Query myQuery = entityManager.createQuery("SELECT c from Cliente c order by c.nome");
		List<Cliente> clientes = (List<Cliente>)myQuery.getResultList();
		return clientes;
	}

	
	
	
	@Override
	public Cliente findByName(String name) {
		Query myQuery = entityManager.createQuery("SELECT c from Cliente c where c.nome = nome");
		myQuery.setParameter("nome", name+"%");
		return findByParameter(myQuery);
	}
	
	private Cliente findByParameter(Query q){
		Cliente cliente = (Cliente)q.getSingleResult();
		return cliente;
		
	}
	
	public Cliente findByAdress(String adress){
		Query myQuery = entityManager.createQuery("SELECT c from Cliente c where c.endereco = endereco");
		myQuery.setParameter("endereco", adress+"%");
		return findByParameter(myQuery);
		
	}
}

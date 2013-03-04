package br.com.engaplicada.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.engaplicada.entity.ItemDeEstoque;

/**
 * @author Joao Helis
 *		
 */

public class ItemDeEstoqueDAO extends OdontosystemGenericDaoImpl<ItemDeEstoque>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ItemDeEstoqueDAO() {
		super(ItemDeEstoque.class);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ItemDeEstoque> findAll() {		
		String hql = "SELECT item from ItemDeEstoque item order by item.codigo";
		Query query = entityManager.createQuery(hql);
		List<ItemDeEstoque> estoque = (List<ItemDeEstoque>) query.getResultList();
		return estoque;		
	}

	@Override
	public ItemDeEstoque findByName(String descricao){		
		String hql = "SELECT i from ItemDeEstoque i where i.descricao = desc";
		Query query = entityManager.createQuery(hql);
		query.setParameter("desc", descricao+"%");
		ItemDeEstoque item = (ItemDeEstoque) query.getSingleResult();
		return item;
		
	}

}

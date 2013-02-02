package br.com.engaplicada.service;

import java.util.List;

import br.com.engaplicada.dao.ItemDeEstoqueDAO;
import br.com.engaplicada.entity.ItemDeEstoque;
import br.com.engaplicada.util.RNException;
import br.com.engaplicada.util.RepositoryException;

/**
 * @author Joao Helis
 *		
 */

public class ItemDeEstoqueService {
	
	private ItemDeEstoqueDAO dao;
	
	public ItemDeEstoqueService(){
		this.dao = new ItemDeEstoqueDAO();
	}
	
	public List<ItemDeEstoque> getAllItensDeEstoque(){
		return dao.findAll();
	}
	
	public ItemDeEstoque getItemEstoqueByDescricao(String descricao){
		return dao.findByName(descricao);
	}
	
	public boolean cadastrar(ItemDeEstoque itemDeEstoque) throws RepositoryException, RNException{
		 try {
			dao.save(itemDeEstoque);
			return true;
		} catch (RepositoryException e) {
				throw new RNException("ERRO: Falha ao salvar o item no estoque!");
		}
	}
	
	public boolean atualizar(ItemDeEstoque itemDeEstoque) throws RNException{
		try{
			dao.update(itemDeEstoque);
			return true;
		}catch (Exception e) {
			throw new RNException("ERRO: Falha ao atualizar o item no estoque!");
		}
	}
	
	public boolean remover(ItemDeEstoque itemDeEstoque) throws RNException{
		try{
			dao.delete(itemDeEstoque);
			return true;
		}catch (Exception e) {
			throw new RNException("ERRO: Falha ao remover o item no estoque!");
		}
	}
}

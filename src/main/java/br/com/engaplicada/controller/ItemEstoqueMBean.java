package br.com.engaplicada.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import br.com.engaplicada.entity.ItemDeEstoque;
import br.com.engaplicada.entity.Usuario;
import br.com.engaplicada.service.ItemDeEstoqueService;
import br.com.engaplicada.util.RNException;
import br.com.engaplicada.util.RepositoryException;

@ManagedBean(name="itemEstoqueMBean")
@SessionScoped
public class ItemEstoqueMBean extends AbstractController{
	private static final long serialVersionUID = 1L;
	
	private ItemDeEstoque item;
	private List<ItemDeEstoque> itens;
	private ItemDeEstoqueService itemService;
	
	public ItemEstoqueMBean(){
		reset();
		this.itemService = new ItemDeEstoqueService();
	}

	private void reset() {
		this.item = new ItemDeEstoque();
	}
	
	public String salvarItem() throws RepositoryException, RNException{
		itemService.atualizar(item);
		reset();
		return null;
	}
	
	public void atualizar(RowEditEvent event) throws RNException{
		if(itemService.atualizar((ItemDeEstoque)event.getObject())){
			FacesMessage msg = new FacesMessage("Item Atualizado!", ((ItemDeEstoque) event.getObject()).getDescricao());  
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	        reset();
		}else{
			FacesMessage msg = new FacesMessage("Erro: Falha ao Atualizar Item!", ((ItemDeEstoque) event.getObject()).getDescricao());  
	        FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}
	
	public void remover(RowEditEvent event) throws RNException{
		if(itemService.remover((ItemDeEstoque)event.getObject())){
			FacesMessage msg = new FacesMessage("Item Removido!", ((ItemDeEstoque) event.getObject()).getDescricao());  
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	        reset();
		}else{
			FacesMessage msg = new FacesMessage("Erro: Falha ao Remover Item!", ((ItemDeEstoque) event.getObject()).getDescricao());  
	        FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}
	
	public String atualizarItem() throws RNException{
		itemService.atualizar(item);
		return null;
	}
	
	public String removerItem() throws RNException{
		itemService.remover(item);
		reset();
		return null;
	}
	
	public ItemDeEstoque getItem() {
		return item;
	}

	public void setItem(ItemDeEstoque item) {
		this.item = item;
	}

	public List<ItemDeEstoque> getItens() {
		return itemService.getAllItensDeEstoque();
	}

	public void setItens(List<ItemDeEstoque> itens) {
		this.itens = itens;
	}

	public ItemDeEstoqueService getItemService() {
		return itemService;
	}

	public void setItemService(ItemDeEstoqueService itemService) {
		this.itemService = itemService;
	}	
}

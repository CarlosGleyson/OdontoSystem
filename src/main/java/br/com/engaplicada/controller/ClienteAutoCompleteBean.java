package br.com.engaplicada.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.engaplicada.entity.Cliente;
import br.com.engaplicada.service.ClienteService;
import br.com.engaplicada.util.RNException;

@ManagedBean
@RequestScoped
public class ClienteAutoCompleteBean extends AbstractController{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Cliente cliente;
	
	private List<Cliente> clientes;
	
	private ClienteConverter converter;
	
	private ClienteService service;
	

	public ClienteAutoCompleteBean(){
		this.converter = new ClienteConverter();
		this.service = new ClienteService();
		clientes = converter.getClientes();
		reset();
	}
	
	

	private void reset() {
		this.cliente = new Cliente();
		
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public List<Cliente> completeCliente(String query) {  
        List<Cliente> suggestions = new ArrayList<Cliente>();  
          
        for(Cliente p : clientes) {  
            if(p.getNome().startsWith(query))  
                suggestions.add(p);  
        }  
          
        return suggestions;  
    }
	
	public ClienteConverter getConverter() {
		return converter;
	}

	public void setConverter(ClienteConverter converter) {
		this.converter = converter;
	}

	
	public String atualizar() throws RNException{
		if(this.service.atualizarCliente(cliente)){
			FacesMessage msg = new FacesMessage("Cliente atualizado com sucesso!", cliente.getNome());  
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	        reset();
	        return null;
		}else{
			FacesMessage msg = new FacesMessage("Erro: Falha ao atualizar cliente!", cliente.getNome());  
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	        reset();
	        return null;
		}
	}
}

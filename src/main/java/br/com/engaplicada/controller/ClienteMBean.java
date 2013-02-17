package br.com.engaplicada.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import br.com.engaplicada.entity.Cliente;
import br.com.engaplicada.service.ClienteService;
import br.com.engaplicada.util.RNException;

@ManagedBean
@RequestScoped
public class ClienteMBean extends AbstractController {
	private static final long serialVersionUID = 1L;
	
	private Cliente cliente;
	private ClienteService service;
	private List<Cliente> clientes;
	
	public ClienteMBean(){
		this.service = new ClienteService();
		reset();
	}

	private void reset() {
		this.cliente = new Cliente();
		
	}
	
	public String salvar() throws RNException{
		if(this.cliente != null){
			if(service.atualizarCliente(this.cliente)){
				FacesMessage msg = new FacesMessage("Cliente cadastrado com sucesso!", cliente.getNome());  
		        FacesContext.getCurrentInstance().addMessage(null, msg);
		        reset();
		        return null;
			}else{
				FacesMessage msg = new FacesMessage("Erro: Falha ao cadastrar cliente!", cliente.getNome());  
		        FacesContext.getCurrentInstance().addMessage(null, msg);
		        reset();
		        return null;
			}
		}else {
				FacesMessage msg = new FacesMessage("Erro: Falha ao cadastrar cliente, preencha os campos!", null);  
		        FacesContext.getCurrentInstance().addMessage(null, msg);
				return null;
		}
	}

	public String atualizar(RowEditEvent event) throws RNException{
		if(service.atualizarCliente((Cliente)event.getObject())){
			FacesMessage msg = new FacesMessage("Cliente atualizado com sucesso!", ((Cliente) event.getObject()).getNome());  
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	        reset();
	        return null;
		}else{
			FacesMessage msg = new FacesMessage("Erro: Falha ao atualizar cliente!", ((Cliente) event.getObject()).getNome());  
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	        reset();
	        return null;
		}
	}
	
	public String remover(RowEditEvent event) throws RNException{
		if(service.removerCliente((Cliente)event.getObject())){
			FacesMessage msg = new FacesMessage("Cliente removido com sucesso!", ((Cliente) event.getObject()).getNome());  
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	        reset();
	        return null;
		}else{
			FacesMessage msg = new FacesMessage("Erro: Falha ao remover cliente!", ((Cliente) event.getObject()).getNome());  
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	        reset();
	        return null;
		}
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ClienteService getService() {
		return service;
	}

	public void setService(ClienteService service) {
		this.service = service;
	}

	public List<Cliente> getClientes() {
		return service.getClientes();
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	

}

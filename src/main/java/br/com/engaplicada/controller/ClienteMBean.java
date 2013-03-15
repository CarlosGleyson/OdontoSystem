package br.com.engaplicada.controller;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.event.RowEditEvent;

import br.com.engaplicada.entity.Cliente;
import br.com.engaplicada.service.ClienteService;
import br.com.engaplicada.util.ConstantesDeNavegacao;
import br.com.engaplicada.util.RNException;

@ManagedBean
@SessionScoped
public class ClienteMBean extends AbstractController {
	private static final long serialVersionUID = 1L;
	
	private Cliente cliente;
	private Cliente clienteFiltrado; //cliente filtrado no autocolmplete
	private ClienteConverter converter;
	private ClienteService service;
	private List<Cliente> filteredClientes;
	private List<Cliente> clientes;
	
	public ClienteMBean(){
		this.setConverter(new ClienteConverter());
		this.service = new ClienteService(); 
		reset();
	}

	public void reset() {
		this.cliente = new Cliente();
		this.clienteFiltrado = new Cliente();
	
	}
	
	public List<Cliente> completeCliente(String query) {  
        List<Cliente> suggestions = new ArrayList<Cliente>();  
          
        for(Cliente p : clientes) {  
            if(p.getNome().startsWith(query))  
                suggestions.add(p);  
        }
        return suggestions;
	}
	
	public String salvar() throws RNException{
		if(this.cliente != null){
			if(service.atualizarCliente(this.cliente)){
				addMessageInfo("Cliente cadastrado com sucesso!", cliente.getNome());
		        reset();
		        return null;
			}else{
				addMessageInfo("Erro: Falha ao cadastrar cliente!", cliente.getNome());
		        reset();
		        return null;
			}
		}else {
			addMessageInfo("Erro: Falha ao cadastrar cliente, preencha os campos!", null);
				return null;
		}
	}

	public String atualizar(RowEditEvent event) throws RNException{
		if(service.atualizarCliente((Cliente)event.getObject())){
			addMessageInfo("Cliente atualizado com sucesso!", ((Cliente) event.getObject()).getNome());
	        reset();
	        return null;
		}else{
			addMessageInfo("Erro: Falha ao atualizar cliente!", ((Cliente) event.getObject()).getNome());
	        reset();
	        return null;
		}
	}
	
	public String remover(RowEditEvent event) throws RNException{
		if(service.removerCliente((Cliente)event.getObject())){
			addMessageInfo("Cliente removido com sucesso!", ((Cliente) event.getObject()).getNome());
	        reset();
	        return null;
		}else{
			addMessageInfo("Erro: Falha ao remover cliente!", ((Cliente) event.getObject()).getNome());
	        reset();
	        return null;
		}
	}
	
	
	public String entrarPesquisa(){
		filteredClientes = new ArrayList<Cliente>();
		if(clienteFiltrado != null){
			this.filteredClientes.add(clienteFiltrado);
			return null;
		}else{
			addMessageInfo("Escolha um Cliente","");
	        reset();
	        return null;
		}
	}
	
	public String resetarFiltrados(){
		this.filteredClientes = null;
		return "inicio";
	}
	
	@Deprecated	
	public String editarModal() throws RNException{
		if(service.atualizarCliente(((ClienteAutoCompleteBean)getMBean("clienteAutoCompleteBean")).getCliente())){
			addMessageInfo("Cliente atualizado com sucesso!", (cliente.getNome()));
	        reset();
	        return null;
		}else{
			addMessageInfo("Erro: Falha ao atualizar cliente!", (cliente.getNome()));
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
		this.clientes = service.getClientes();
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Cliente> getFilteredClientes() {
		return filteredClientes;
	}

	public void setFilteredClientes(List<Cliente> filteredClientes) {
		this.filteredClientes = filteredClientes;
	}

	public Cliente getClienteFiltrado() {
		return clienteFiltrado;
	}

	public void setClienteFiltrado(Cliente clienteFiltrado) {
		this.clienteFiltrado = clienteFiltrado;
	}

	public ClienteConverter getConverter() {
		return converter;
	}

	public void setConverter(ClienteConverter converter) {
		this.converter = converter;
	}
}

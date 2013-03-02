package br.com.engaplicada.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import br.com.engaplicada.entity.Funcionario;
import br.com.engaplicada.service.FuncionarioService;
import br.com.engaplicada.util.RNException;

@ManagedBean
@SessionScoped
public class FuncionarioMBean extends AbstractController{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Funcionario funcionario;
	
	private List<Funcionario> funcionarios;
	
	private Funcionario funcionarioFiltrado;
	
	private List<Funcionario> funcionariosFiltrados;
	
	private FuncionarioService service;
	
	private FuncionarioConverter converter;
	
	public FuncionarioMBean(){
		this.converter = new FuncionarioConverter();
		this.service = new FuncionarioService();
		reset();
	}

	private void reset() {
		this.funcionario = new Funcionario();
		this.funcionarioFiltrado = new Funcionario();
	}
	
	public List<Funcionario> completeFuncionario(String query) {  
        List<Funcionario> suggestions = new ArrayList<Funcionario>();  
          
        for(Funcionario f :funcionarios) {  
            if(f.getNome().startsWith(query))  
                suggestions.add(f);  
        }
        return suggestions;
	}
	
	public String salvar() throws RNException{
		if(this.funcionario != null){
			if(service.atualizarFuncionario(this.funcionario)){
				FacesMessage msg = new FacesMessage("Funcionario cadastrado com sucesso!", funcionario.getNome());  
		        FacesContext.getCurrentInstance().addMessage(null, msg);
		        reset();
		        return null;
			}else{
				FacesMessage msg = new FacesMessage("Erro: Falha ao cadastrar Funcionario!", funcionario.getNome());  
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
		if(service.atualizarFuncionario((Funcionario)event.getObject())){
			FacesMessage msg = new FacesMessage("Funcionario atualizado com sucesso!", ((Funcionario) event.getObject()).getNome());  
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	        reset();
	        
	        return null;
		}else{
			FacesMessage msg = new FacesMessage("Erro: Falha ao atualizar Funcionario!", ((Funcionario) event.getObject()).getNome());  
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	        reset();
	        return null;
		}
	}
	
	public String remover(RowEditEvent event) throws RNException{
		if(service.removerFuncionario((Funcionario)event.getObject())){
			FacesMessage msg = new FacesMessage("Funcionario removido com sucesso!", ((Funcionario) event.getObject()).getNome());  
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	        reset();
	        return null;
		}else{
			FacesMessage msg = new FacesMessage("Erro: Falha ao remover Funcionario!", ((Funcionario) event.getObject()).getNome());  
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	        reset();
	        return null;
		}
	}
	
	
	public String entrarPesquisa(){
		funcionariosFiltrados = new ArrayList<Funcionario>();
		if(funcionarioFiltrado != null){
			this.funcionariosFiltrados.add(funcionarioFiltrado);
			return null;
		}else{
			FacesMessage msg = new FacesMessage("Escolha um Funcionario","");  
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	        reset();
	        return null;
		}
	}
	
	
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<Funcionario> getFuncionarios() {
		this.funcionarios = service.getFuncionarios();
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public Funcionario getFuncionarioFiltrado() {
		return funcionarioFiltrado;
	}

	public void setFuncionarioFiltrado(Funcionario funcionarioFiltrado) {
		this.funcionarioFiltrado = funcionarioFiltrado;
	}

	public List<Funcionario> getFuncionariosFiltrados() {
		return funcionariosFiltrados;
	}

	public void setFuncionariosFiltrados(List<Funcionario> funcionariosFiltrados) {
		this.funcionariosFiltrados = funcionariosFiltrados;
	}

	public FuncionarioService getService() {
		return service;
	}

	public void setService(FuncionarioService service) {
		this.service = service;
	}

	public FuncionarioConverter getConverter() {
		return converter;
	}

	public void setConverter(FuncionarioConverter converter) {
		this.converter = converter;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}

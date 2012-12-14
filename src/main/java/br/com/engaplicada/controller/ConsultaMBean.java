/**
 * 
 */

package br.com.engaplicada.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.engaplicada.entity.Consulta;
import br.com.engaplicada.service.ConsultaService;
import br.com.engaplicada.util.RNException;
import br.com.engaplicada.util.RepositoryException;

/**
 * @author Smith
 *
 */

@ManagedBean(name="ConsultaMBean")
@RequestScoped
public class ConsultaMBean {
	private Consulta consulta;
	private ConsultaService cService;
	
	
	public ConsultaMBean(){
		this.consulta = new Consulta();
		this.cService = new ConsultaService();
	}
	
//	Método retorna o nome da página de consulta - consulta.xhtml
	public String novaConsulta(){
		return "consulta";
	}
	
	public String forward(){
		return "inicio";
	}
	
	public List<Consulta> listarConsultas()throws RepositoryException{
		return this.cService.getAllConsultas();
	}
	
	public String removerConsulta() throws RNException,RepositoryException{
		FacesContext obj = FacesContext.getCurrentInstance();
		if(this.cService.removerConsulta(this.consulta)){
			return "removerConsulta";
		}else{
			FacesMessage mensagem = new FacesMessage("ERROR : Falha ao remover consulta");
			obj.addMessage(null, mensagem);
		}return "erro";
	}
	
	public String cadastrarConsulta() throws RNException,RepositoryException{
		FacesContext obj = FacesContext.getCurrentInstance();
		if(this.cService.cadastrarConsulta(this.consulta)){
			FacesMessage mensagem = new FacesMessage("Consulta Cadastrada com sucesso");
			obj.addMessage(null, mensagem);
			return null;
		}else{
			FacesMessage mensagem = new FacesMessage("ERROR : Falha ao salvar a consulta");
			obj.addMessage(null, mensagem);
			return "erro";
		}
	}
	
	public String atualizarConsulta() throws RNException{
		FacesContext obj = FacesContext.getCurrentInstance();
		if(this.cService.atualizarCosnulta(this.consulta)){
			return "atualizarConsulta";
		}else{
			FacesMessage mensagem = new FacesMessage(" ERROR : Falha ao atualizar a consulta");
			obj.addMessage(null, mensagem);
		return "erro";
		}
	}
	
	
//	>>>>>>>>>>>>>>>>>>>>>>  Getters and Setters  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	
	public Consulta getConsulta() {
		return consulta;
	}
	
	
	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}


	public ConsultaService getcService() {
		return cService;
	}


	public void setcService(ConsultaService cService) {
		this.cService = cService;
	}
	
	
	

}

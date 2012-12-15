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

@ManagedBean(name="consultaMBean")
@RequestScoped
public class ConsultaMBean {
	private Consulta consulta;
	private ConsultaService cService;
	private List<Consulta> consultas;
	
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
	
	public List<Consulta> getlistarConsultas()throws RepositoryException{
		return this.cService.getAllConsultas();
	}
	
	public String removerConsulta() throws RNException,RepositoryException{
		FacesContext obj = FacesContext.getCurrentInstance();
		if(this.cService.removerConsulta(this.consulta)){
			return null;
		}else{
			FacesMessage mensagem = new FacesMessage("ERROR : Falha ao remover consulta");
			obj.addMessage(null, mensagem);
		}return null;
	}
	
	public String agendarConsulta() throws RNException,RepositoryException{
		FacesContext obj = FacesContext.getCurrentInstance();
		if(this.cService.cadastrarConsulta(this.consulta)){
			FacesMessage mensagem = new FacesMessage("Consulta Cadastrada com sucesso");
			obj.addMessage(null, mensagem);
			return null;
		}else{
			FacesMessage mensagem = new FacesMessage("ERROR : Falha ao salvar a consulta");
			obj.addMessage(null, mensagem);
			return null;
		}
	}
	
	public String atualizarConsulta() throws RNException{
		FacesContext obj = FacesContext.getCurrentInstance();
		if(this.cService.atualizarCosnulta(this.consulta)){
			return null;
		}else{
			FacesMessage mensagem = new FacesMessage(" ERROR : Falha ao atualizar a consulta");
			obj.addMessage(null, mensagem);
		return null;
		}
	}
	
	private void listarPorMedico(){
		this.consultas =  cService.getConsultasPorMedico(this.consulta.getDoctor());
	}
	
	private void listarPorDataAgendamento(){
		this.consultas = cService.getConsultasPorDataAgendamento(this.consulta.getSchedulingData());
	}
	
	private void listarPorDataConsulta(){
		this.consultas = cService.getConsultasPorDataConsulta(this.consulta.getRealizationData());
	}
	
	public String entrarPorMedico(){
		listarPorMedico();
		return null;
	}
	
	public String entarPorDataAgendamento(){
		listarPorDataAgendamento();
		return null;
	}
	
	public String entarPorDataConsulta(){
		listarPorDataConsulta();
		return null;
	}
	
//	>>>>>>>>>>>>>>>>>>>>>>  Getters and Setters  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	
	
	
	public Consulta getConsulta() {
		return consulta;
	}
	
	
	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
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

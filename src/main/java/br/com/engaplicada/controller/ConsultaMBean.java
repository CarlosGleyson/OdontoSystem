/**
 * 
 */

package br.com.engaplicada.controller;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.engaplicada.entity.Consulta;
import br.com.engaplicada.entity.Usuario;
import br.com.engaplicada.service.ConsultaService;
import br.com.engaplicada.util.RNException;
import br.com.engaplicada.util.RepositoryException;

/**
 * @author Smith
 *
 */

@ManagedBean(name="consultaMBean")
@RequestScoped
public class ConsultaMBean extends AbstractController{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Consulta consulta;
	private ConsultaService cService;
	private List<Consulta> consultas;
	
	public ConsultaMBean(){
		reset();
		this.cService = new ConsultaService();
	}
	
	public void reset(){
		consulta = new Consulta();
	}
//	Método retorna o nome da página de consulta - consulta.xhtml
	public String novaConsulta(){
		return "consulta";
	}
	
	public String forward(){
		return "inicio";
	}
	
	public List<Consulta> getlistarConsultas()throws RepositoryException{
		return this.consultas = cService.getAllConsultas();
	}
	
	public String removerConsulta() throws RNException,RepositoryException{
		if(this.cService.removerConsulta(this.consulta)){
			FacesMessage msg = new FacesMessage("Consulta removida com sucesso!", null);  
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	        reset();
			return null;
		}else{
			FacesMessage mensagem = new FacesMessage("ERROR : Falha ao remover consulta");
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
			return null;
		}
	}
	
	public String agendarConsulta() throws RNException,RepositoryException{
		FacesContext obj = FacesContext.getCurrentInstance();
		if(validaDataConsulta()){
			if(this.cService.cadastrarConsulta(this.consulta)){
				FacesMessage msg = new FacesMessage("Consulta Cadastrada com sucesso!", " ");  
				obj.addMessage(null, msg);
		        reset();
		        return null;
			}else{
				FacesMessage mensagem = new FacesMessage("ERROR : Falha ao salvar a consulta"," ");
				obj.addMessage(null, mensagem);
				reset();
				return null;
			}
		}else{
			FacesMessage mensagem = new FacesMessage("ERROR : Verifique as Datas !"," ");
			obj.addMessage(null, mensagem);
			reset();
			return null;
		}
	}

	private boolean validaDataConsulta(){
		Date agendamento = this.consulta.getSchedulingData();
		Date realizacao = this.consulta.getRealizationData();

		if((agendamento.after(realizacao) || realizacao.before(agendamento))||(agendamento.equals(realizacao))){
			return false;
		}
		return true;
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
	
	public String atualizarStatusConsultas() throws RNException{
		FacesContext obj = FacesContext.getCurrentInstance();
		Consulta consultaBD;
		boolean atualizou = false;
		for(Consulta c : consultas){
			consultaBD = cService.getConsultaPorId(c.getIdConsulta());
			if(c.isRealizada() == consultaBD.isRealizada()){
				cService.atualizarCosnulta(c);
				atualizou = true;
			}
		}
		
		if(atualizou){
			FacesMessage mensagem = new FacesMessage("Consultas Atualizadas com sucesso!",null);
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
			return null;
		}else{
			FacesMessage mensagem = new FacesMessage("Não ocorreram atualizações nas Consultas !",null);
			obj.addMessage(null, mensagem);
			reset();
			return null;
		}
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

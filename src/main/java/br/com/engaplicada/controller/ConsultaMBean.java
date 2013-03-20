/**
 * 
 */

package br.com.engaplicada.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

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
public class ConsultaMBean extends AbstractController{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Consulta consulta;
	private Consulta consultaSelecionada;
	private ConsultaService cService;
	private List<Consulta> consultas;
	private List<Consulta> consultasDeHoje;
	
	public ConsultaMBean(){
		reset();
		this.cService = new ConsultaService();
		Date hoje = new Date();
		hoje.setHours(0);
		hoje.setMinutes(0);
		hoje.setSeconds(0);
		getConsultasDeHoje(hoje);
	}
	
	public void reset(){
		consulta = new Consulta();
		this.setConsultaSelecionada(new Consulta());
		this.consultasDeHoje = new ArrayList<Consulta>();
	}
	
	private void getConsultasDeHoje(Date data){
		this.consultasDeHoje = cService.getConsultasPorDataConsulta(data);
	}
	
	public String forward(){
		return "inicio";
	}
	
	public List<Consulta> getlistarConsultas()throws RepositoryException{
		return this.consultas = cService.getAllConsultas();
	}
	
	public String removerConsulta() throws RNException,RepositoryException{
		if(this.cService.removerConsulta(this.consulta)){
			addMessageInfo("Consulta removida com sucesso!", null);
	        reset();
			return null;
		}else{
			addMessageInfo("ERROR : Falha ao remover consulta","");
			return null;
		}
	}
	
	public String agendarConsulta() throws RNException,RepositoryException{
		if(validaDataConsulta()){
			if(this.cService.cadastrarConsulta(this.consulta)){
				addMessageInfo("Consulta Cadastrada com sucesso!", " ");
		        reset();
		        return null;
			}else{
				addMessageInfo("ERROR : Falha ao salvar a consulta"," ");
				reset();
				return null;
			}
		}else{
			addMessageInfo("ERROR : Verifique as Datas !"," ");
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
		if(this.cService.atualizarCosnulta(this.consulta)){
			return null;
		}else{
			addMessageInfo(" ERROR : Falha ao atualizar a consulta","");
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
			addMessageInfo("Consultas Atualizadas com sucesso!",null);
			return null;
		}else{
			addMessageInfo("Não ocorreram atualizações nas Consultas !",null);
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

	public List<Consulta> getConsultasDeHoje() {
		return consultasDeHoje;
	}

	public void setConsultasDeHoje(List<Consulta> consultasDeHoje) {
		this.consultasDeHoje = consultasDeHoje;
	}

	public Consulta getConsultaSelecionada() {
		return consultaSelecionada;
	}

	public void setConsultaSelecionada(Consulta consultaSelecionada) {
		this.consultaSelecionada = consultaSelecionada;
	}
}

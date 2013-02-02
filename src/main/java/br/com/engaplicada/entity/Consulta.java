/**
 * 
 */
package br.com.engaplicada.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * @author Smith
 *
 */

@Entity
public class Consulta implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//	Identicador único da entidade Usuario (PK)
	@Id
	@GeneratedValue
	private int idConsulta;
	
	//	Usuario(funcionário) responsável pelo agendamento da consulta
	@JoinColumn(name="usuario_id")
	@OneToOne(targetEntity=Usuario.class)
	private Usuario user;
	
	@Column(name="paciente")
	private String patient;
	
	@Column(name="medico")
	private String doctor;

	//	data de agendamento	
	@Column(name="d_agendamento")
	private Date schedulingDate;

	//	data de realização
	@Column(name="d_realizacao")
	private Date realizationDate;
	
	@Column(name="status_realizada")
	private boolean realizada;
	
//	>>>>>>>>>>>>>>>>>>>>>>>  Getters and Setters  <<<<<<<<<<<<<<<<<<<<<<<<<<<
	public Usuario getUser() {
		return user;
	}
	public void setUser(Usuario user) {
		this.user = user;
	}
	public String getPatient() {
		return patient;
	}
	public void setPatient(String patient) {
		this.patient = patient;
	}
	public Date getSchedulingData() {
		return schedulingDate;
	}
	
	public void setSchedulingData(Date schedulingData) {
		this.schedulingDate = schedulingData;
	}
	public Date getRealizationData() {
		return realizationDate;
	}
	
	
	
	/** Formata a Data de realização da Consulta que esta no BD para exibição dd/MM/yyy**/
	public String getDataRealizacao(){
		Date data = getRealizationData();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(data);
	}
	
	/** Formata a Data de agendamento da Consulta que esta no BD para exibição dd/MM/yyy**/
	public String getDataAgendamento(){
		Date data = getSchedulingData();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(data);
	}
	
	public void setRealizationData(Date realizationData) {
		this.realizationDate = realizationData;
	}
	public int getIdConsulta() {
		return idConsulta;
	}
	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	
	public boolean isRealizada(){
		return this.realizada;
	}
	
	public void setRealizada(boolean status){
		this.realizada = status;
	}
}

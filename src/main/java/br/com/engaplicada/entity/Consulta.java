/**
 * 
 */
package br.com.engaplicada.entity;

import java.io.Serializable;
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

	//	Identicador �nico da entidade Usuario (PK)
	@Id
	@GeneratedValue
	private Integer idConsulta;
	
	//	Usuario(funcion�rio) respons�vel pelo agendamento da consulta
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

	//	data de realiza��o
	@Column(name="d_realizacao")
	private Date realizationDate;
	
	
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
	public void setRealizationData(Date realizationData) {
		this.realizationDate = realizationData;
	}
	public Integer getIdConsulta() {
		return idConsulta;
	}
	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	
	
	

}

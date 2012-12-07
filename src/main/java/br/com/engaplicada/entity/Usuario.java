package br.com.engaplicada.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.CollectionOfElements;

@Entity
@Table(name="usuarios")
public class Usuario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_usuario")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idUsuario;
	
	@Column(name="nome", nullable=false)
	private String nome;
	
	@Column(name="email", nullable=false)
	private String email;
	
	@Column(name="senha", nullable=false)
	private String senha;
	
	@Column(name="login",nullable=false)
	private String login;
	
	@Column(name="celular",nullable=false)
	private String celular;
	
	@Column(name="ativo",nullable=false)
	private boolean ativo;
	
	@CollectionOfElements  
	@JoinTable(
			name="usuario_permissao",
			uniqueConstraints = {@UniqueConstraint(columnNames = {"usuario","permissao"})},
			joinColumns = @JoinColumn(name="usuario"))
	@Column(name="permissao",length=50)
	private Set<String> permissao = new HashSet<String>();
	
	public Usuario(){}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Set<String> getPermissao() {
		return permissao;
	}

	public void setPermissao(Set<String> permissao) {
		this.permissao = permissao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}

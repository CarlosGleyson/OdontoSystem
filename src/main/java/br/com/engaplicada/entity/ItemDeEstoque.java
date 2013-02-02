package br.com.engaplicada.entity;

import java.io.Serializable;

import javax.persistence.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

/**
 * @author Smith Ascari
 *		
 */

@Entity
@Table(name="estoque")
public class ItemDeEstoque implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer idItemEstoque;
	
	@Column(nullable = false) //obriga o preenchimento deste campo
	private int codigo;
	
	@Column(nullable=false)
	private int qtde;
	
	@Column(nullable=false)
	private String descricao;
	
	
	//====================== GETTERS AND SETTERS =======================

	/**
	 * @return the idItemEstoque
	 */
	public Integer getIdItemEstoque() {
		return idItemEstoque;
	}

	/**
	 * @param idItemEstoque the idItemEstoque to set
	 */
	public void setIdItemEstoque(Integer idItemEstoque) {
		this.idItemEstoque = idItemEstoque;
	}

	/**
	 * @return the codigo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the qtde
	 */
	public int getQtde() {
		return qtde;
	}

	/**
	 * @param qtde the qtde to set
	 */
	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}

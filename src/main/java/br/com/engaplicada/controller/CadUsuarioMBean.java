package br.com.engaplicada.controller;


import javax.faces.bean.ManagedBean;

import br.com.engaplicada.entity.Usuario;
import br.com.engaplicada.service.UsuarioService;
import br.com.engaplicada.util.RNException;
import br.com.engaplicada.util.RepositoryException;

@ManagedBean
public class CadUsuarioMBean extends AbstractController{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	private String confirmaSenha;
	private UsuarioService service;
	
	public CadUsuarioMBean(){
		this.service = new UsuarioService();
		reset();
	}

	private void reset() {
		this.usuario = new Usuario();
		this.usuario.setPermissao("ROLE_USER");
	}
	
	public String cadastrar()throws RNException, RepositoryException{
		if(this.confirmaSenha.equals(usuario.getSenha())){
			if(service.isCadastrar(usuario)){
				addMessageInfo("Usuário Cadastrado com Sucesso!",usuario.getLogin());
				reset();
				return null;
			}else{
				addMessageInfo("ERRO : Falha ao salvar o Usuario ","");
				reset();
				return null;
			}
		}else{
			addMessageInfo("ERRO : Falha na confirmação da senha ! ","");
			reset();
			return null;
		}

	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getConfirmaSenha() {
		return confirmaSenha;
	}

	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}
}

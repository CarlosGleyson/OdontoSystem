package br.com.engaplicada.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.engaplicada.service.LoginService;
import br.com.engaplicada.util.ConstantesDeNavegacao;
import br.com.engaplicada.util.EventoLogin;
import br.com.engaplicada.util.RepositoryException;


@ManagedBean(name="loginMBean")
@SessionScoped
public class LoginMBean extends AbstractController{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LoginService loginService; 
	private String login;
	private String senha;
	
	public LoginMBean(){
		loginService = new LoginService();
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String novoUsuario(){
		return "cadastroUsuario";
	}

	public String efetuarLogin(){
		
		FacesContext obj = FacesContext.getCurrentInstance();
		EventoLogin evento = new EventoLogin(this.getLogin(),this.getSenha());
		
		try {
			if(loginService.isAutenticar(evento)){
				return ConstantesDeNavegacao.INICIO;
			}
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
		FacesMessage message = new FacesMessage(" FALHA NA VALIDAÇÃO : Certifique-se que você informou os dados corretamente ou cadastre-se !!");
		obj.addMessage(null, message);
		return "loginFail";
	}
	
	public String forward(){
		return "login";
	}
}
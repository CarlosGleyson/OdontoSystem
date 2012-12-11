package br.com.engaplicada.util;

public class EventoLogin {
	String login,senha;
	
	public EventoLogin(String umLogin,String umaSenha){
		this.login = umLogin;
		this.senha = umaSenha;
	}
	
	public EventoLogin(){
		this.login = " ";
		this.senha = " ";
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
}

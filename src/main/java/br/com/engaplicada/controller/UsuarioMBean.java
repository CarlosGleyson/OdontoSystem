package br.com.engaplicada.controller;

/**
 * @author Paulo Neto
 * **/

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import br.com.engaplicada.entity.Usuario;
import br.com.engaplicada.service.UsuarioService;
import br.com.engaplicada.util.ConstantesDeNavegacao;
import br.com.engaplicada.util.RNException;
import br.com.engaplicada.util.RepositoryException;

@ManagedBean(name="usuarioMBean")
@RequestScoped
public class UsuarioMBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	private String confirmaSenha;
	private UsuarioService service;
	private String destino;
	
	
	public UsuarioMBean(){	
		destino = "";
		this.service = new UsuarioService();
		reset();
		SecurityContext context = SecurityContextHolder.getContext();
        if (context instanceof SecurityContext){
            Authentication authentication = context.getAuthentication();
            if (authentication instanceof Authentication){
                usuario.setLogin((((User)authentication.getPrincipal()).getUsername()));
                usuario = service.getUsuarioByLogin(usuario.getLogin());
            }
        }
	}
	
	public void reset(){
		this.usuario = new Usuario();
		this.usuario.setAtivo(true);
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
	
	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String cadastrar()throws RNException, RepositoryException{
		FacesContext obj = FacesContext.getCurrentInstance();
		if(this.confirmaSenha.equals(usuario.getSenha())){
			if(service.isCadastrar(usuario)){
				FacesMessage mensagem = new FacesMessage("Usuário Cadastrado com Sucesso!",usuario.getLogin());
				obj.addMessage(null, mensagem);
				reset();
				return null;
			}else{
				FacesMessage mensagem = new FacesMessage("ERRO : Falha ao salvar o Usuario ");
				obj.addMessage(null, mensagem);
				reset();
				return "erro";
			}
		}else{
			FacesMessage mensagem = new FacesMessage("ERRO : Falha na confirmação da senha ! ");
			obj.addMessage(null, mensagem);
			reset();
			return null;
		}

	}
	
	public String atualizarUsuario()throws RNException{
		FacesContext obj = FacesContext.getCurrentInstance();
		if(service.isAtualizar(usuario)){
			FacesMessage mensagem = new FacesMessage("Usuário Atualizado com Sucesso !","");
			obj.addMessage(null, mensagem);
			reset();
			return null;
		}else{
			FacesMessage mensagem = new FacesMessage(" ERRO : Falha ao atualizar o Usuario !","");
			obj.addMessage(null, mensagem);
			reset();
		return null;
		}
	}
	
	public void atualizar(RowEditEvent event) throws RNException{
		if(service.isAtualizar((Usuario)event.getObject())){
			FacesMessage msg = new FacesMessage("Usuario Atualizado!", ((Usuario) event.getObject()).getLogin());  
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	       
		}else{
			FacesMessage msg = new FacesMessage("Erro: Falha ao Atualizar Usuario!", ((Usuario) event.getObject()).getLogin());  
	        FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}
	
	public List<Usuario> getLista()throws RepositoryException{
		return service.getAllUsuarios();
	}
	
	
	public String remover(RowEditEvent event) throws RNException{
		
		SecurityContext context = SecurityContextHolder.getContext();
		String login = "";
        if (context instanceof SecurityContext){
            Authentication authentication = context.getAuthentication();
            if (authentication instanceof Authentication){
                login = (((User)authentication.getPrincipal()).getUsername());
            }
        }
		
        if(login.equals(((Usuario) event.getObject()).getLogin())){
        	if(service.isRemover((Usuario)event.getObject())){
			    reset();
			    return "excluirUsuarioLogado";
    	  }else{
				FacesMessage msg = new FacesMessage("Erro: Falha ao Remover Usuario!", ((Usuario) event.getObject()).getLogin());  
			    FacesContext.getCurrentInstance().addMessage(null, msg);
			    return null;
		   }
        }else if(service.isRemover((Usuario)event.getObject())){
			    	FacesMessage msg = new FacesMessage("Usuario Removido!", ((Usuario) event.getObject()).getLogin());  
				    FacesContext.getCurrentInstance().addMessage(null, msg);
				    reset();
				    return null;
        	  }else{
					FacesMessage msg = new FacesMessage("Erro: Falha ao Remover Usuario!", ((Usuario) event.getObject()).getLogin());  
				    FacesContext.getCurrentInstance().addMessage(null, msg);
				    return null;
			   }
	}
	
	@Deprecated
	public String removerUsuario()throws RNException, RepositoryException{
		FacesContext obj = FacesContext.getCurrentInstance();
		if(service.isRemover(usuario)){
			FacesMessage mensagem = new FacesMessage("Usuario Removido !!");
			obj.addMessage(null, mensagem);
			reset();
			return null;
		}else{
			FacesMessage mensagem = new FacesMessage("ERRO : Falha ao Remover Usuario");
			obj.addMessage(null, mensagem);
		}
		reset();
		return null;
	}
	
	public String atualizar(){
		return destino;
	}
	
	
	public String forward(){
		return "inicio";
	}
	
	public String entrarCadastroUsuario(){
		return "cadastro";
	}
	
}

package br.com.engaplicada.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.engaplicada.entity.Funcionario;
import br.com.engaplicada.service.FuncionarioService;

@FacesConverter(forClass=Funcionario.class,value="funcionarioConverter")
public class FuncionarioConverter extends AbstractController implements Converter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Funcionario> funcionarios;
	private FuncionarioService service;
	
	public FuncionarioConverter(){
		this.service = new FuncionarioService();
		this.getFuncionarios();
	}
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String submittedValue) {
		if (submittedValue.trim().equals("")) {  
            return null;  
        } else {  
            try {  
  
                for (Funcionario f : funcionarios) {  
                    if (f.getNome().equals(submittedValue)) {  
                        return f;  
                    }  
                }  
  
            } catch(NumberFormatException exception) {  
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro de Conversão", "Não é um Cliente válido"));  
            }  
        }  
  
        return null;  
    }  

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		 if (value == null || value.equals("")) {  
	            return "";  
	        } else {  
	            return String.valueOf(((Funcionario) value).getNome());  
	        }    
	}

	public List<Funcionario> getFuncionarios() {
		this.funcionarios = service.getFuncionarios();
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
}

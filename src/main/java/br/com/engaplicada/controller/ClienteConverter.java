package br.com.engaplicada.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.engaplicada.entity.Cliente;
import br.com.engaplicada.service.ClienteService;

@FacesConverter(forClass=Cliente.class,value="clienteConverter") 
public class ClienteConverter extends AbstractController implements Converter{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Cliente> clientes;
	private ClienteService service;
	
	public ClienteConverter(){
		this.service = new ClienteService();
		this.getClientes();
	}
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String submittedValue) {
		if (submittedValue.trim().equals("")) {  
            return null;  
        } else {  
            try {  
  
                for (Cliente c : clientes) {  
                    if (c.getNome().equals(submittedValue)) {  
                        return c;  
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
	            return String.valueOf(((Cliente) value).getNome());  
	        }    
	}

	public List<Cliente> getClientes() {
		this.clientes = service.getClientes();
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

}

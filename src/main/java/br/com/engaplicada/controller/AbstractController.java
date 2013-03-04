package br.com.engaplicada.controller;

import java.io.Serializable;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;




/**
 * @author Paulo Antonio
 * 
 */
public class AbstractController implements Serializable {

	private static final long serialVersionUID = 1L;

	protected void addErrorMessage(String componentId, String errorMessage) {
		addMessage(componentId, errorMessage, FacesMessage.SEVERITY_ERROR);
	}

	protected void addErrorMessage(String errorMessage) {
		addErrorMessage(null, errorMessage);
	}

	protected void addInfoMessage(String componentId, String infoMessage) {
		addMessage(componentId, infoMessage, FacesMessage.SEVERITY_INFO);
	}

	protected void addInfoMessage(String infoMessage) {
		addInfoMessage(null, infoMessage);
	}
	
	protected void addMessageInfo(String mensagem, String param){
		FacesMessage msg = new FacesMessage(mensagem, param);  
        FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	private void addMessage(String componentId, String errorMessage,
			Severity severity) {
		FacesMessage message = new FacesMessage(errorMessage);
		message.setSeverity(severity);
		FacesContext.getCurrentInstance().addMessage(componentId, message);
	}
	
	public static Object getMBean(String nomeMBean) {  
		Object o = getSessionAttribute(nomeMBean);  
		if (o != null) {  
		  return o;  
		} else {  
		  return null;  
		}      
	}
	
	public static Object getSessionAttribute(String attributeName) {  
		try {  
		    ExternalContext ec = getExternalContext();  
		    if (ec != null){  
		        Map<String, Object> attrMap = ec.getSessionMap();     
		        if (attrMap != null) {  
		            return attrMap.get(attributeName);  
		        } else {  
		            return null;  
		        }  
		    } else {  
		        return null;  
		    }  
		} catch (Exception e) {  
		    e.printStackTrace();  
		    return null;  
		}  
	}
	
	
	public static void setSessionAttribute(String attributeName, Object attributeValue) {  
		try {  
		    ExternalContext ec = getExternalContext();  
		    if (ec != null){  
		        Map<String, Object> attrMap = ec.getSessionMap();     
		        if (attrMap != null) {  
		            attrMap.put(attributeName, attributeValue);  
		        }   
		    }   
		} catch (Exception e) {  
		    e.printStackTrace();  
		}  
	} 
	
	public static ExternalContext getExternalContext() {  
		try {  
		    FacesContext facesContext = FacesContext.getCurrentInstance();  
		    if (facesContext == null) {  
		        return null;  
		    } else {  
		        return facesContext.getExternalContext();  
		    }  
		} catch (Exception e) {  
		    e.printStackTrace();  
		    return null;  
		   }      
	}

	
    private Object getBean(String ref) {    
    	FacesContext facesContext = FacesContext.getCurrentInstance();
    	return null;
    }  

}

package br.com.engaplicada.service;

import java.util.List;

import br.com.engaplicada.dao.ClienteDao;
import br.com.engaplicada.entity.Cliente;
import br.com.engaplicada.util.RNException;

/**
 * @author Smith Ascari
 *		
 */
public class ClienteService {
	
	private ClienteDao clienteDAO;
	
	public ClienteService(){
		this.clienteDAO = new ClienteDao();
	}
	
	public Cliente getClienteByName(String parameter){
		return this.clienteDAO.findByName(parameter);
	}
	
	public Cliente getClienteByAdress(String adress){
		return this.clienteDAO.findByAdress(adress);
	}
	
	public List<Cliente> getClientes(){
		return this.clienteDAO.findAll();
	}

	
	public boolean atualizarCliente (Cliente c) throws RNException{
		try{
			this.clienteDAO.update(c);
			return true;
		}catch(Exception e){
			throw new RNException("ERROR: Não foi possível atualizar dados do cliente");
		}
	}
	
	public boolean salvarCliente(Cliente c) throws RNException{
		try{
			this.clienteDAO.save(c);
			return true;
		}catch(Exception e){
			throw new RNException("ERROR: Não foi possível salvar os dados do cliente");
		}
	}
	
	public boolean removerCliente(Cliente c) throws RNException{
		try{
			this.clienteDAO.delete(c);
			return true;
		}catch(Exception e){
			throw new RNException("Error: Não foi possível apagar dados do cliente");
		}
	}
	
}

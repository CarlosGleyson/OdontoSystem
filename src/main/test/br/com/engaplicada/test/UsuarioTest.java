package br.com.engaplicada.test;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {
	
	private Usuario user;
	
	@Before
	public void setup(){
		this.user = new Usuario();
	}
	
	@Test
	public void testConstrutor() {
		user = new Usuario("Fulano");
		assertEquals(user.getNome(),Fulano);
	}
	
	@Test 
	public void testConstrutor2(){
		// nome; login; senha; e-mail
		user = new Usuario("Fulano", "fulano", "12345678", "fulano@dce.ufpb.br");
		assertEquals(user.getNome(), "Fulano");
		assertEquals(user.getLogin(), "fulano");
		assertEquals(user.getSenha(), "12345678");
		assertEquals(user.getEmail(), "fulano@dce.ufpb.br");		
	}
	
	@Test
	public void testLogin(){		
		user.setLogin("fulano");
		assertEquals(user.getLogin(), "fulano");
	}
	
	@Test
	public void testSenha(){
		user.setSenha("12345678");
		assertEquals(user.getSenha(), "12345678");
	}
	
	@Test
	public void testEmail(){
		Usuario user = new Usuario("Fulano");
		user.setSenha
	}
	

}

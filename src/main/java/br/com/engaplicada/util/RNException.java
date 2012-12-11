package br.com.engaplicada.util;

/**
 *@author Paulo Neto 
 */

public class RNException extends Exception {

	private static final long serialVersionUID = -873909889120248679L;

	public RNException(String msg){
		super(msg);
	}
	
	public RNException(String msg, Throwable cause){
		super(msg,cause);
	}
	
	public RNException(){
		super();
	}
	
	public RNException(Throwable cause){
		super(cause);
	}
}

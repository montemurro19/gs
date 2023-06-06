package br.com.fiap.gs.exception;

@SuppressWarnings("serial")
public class EntidadeNaoEcontradaException extends Exception {
	
	public EntidadeNaoEcontradaException() {
		super("Entidade não encontrada");
	}
	
	public EntidadeNaoEcontradaException(String msg) {
		super(msg);
	}

}

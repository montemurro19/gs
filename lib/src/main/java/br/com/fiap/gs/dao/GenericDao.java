package br.com.fiap.gs.dao;

import java.util.List;

import br.com.fiap.gs.exception.CommitException;
import br.com.fiap.gs.exception.EntidadeNaoEcontradaException;

public interface GenericDao<E,K> {

	void salvar(E entidade);
	void deletar(K id) throws EntidadeNaoEcontradaException;
	E buscar(K id) throws EntidadeNaoEcontradaException;
	void commit() throws CommitException;
	
	List<E> listar();
	
}
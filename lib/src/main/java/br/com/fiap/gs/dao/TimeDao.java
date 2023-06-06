package br.com.fiap.gs.dao;

import java.util.List;

import br.com.fiap.gs.entity.Time;

public interface TimeDao extends GenericDao<Time, Integer> {
	List<Time> listarTodos();
}

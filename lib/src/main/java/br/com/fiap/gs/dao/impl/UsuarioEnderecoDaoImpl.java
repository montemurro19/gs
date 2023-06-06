package br.com.fiap.gs.dao.impl;

import br.com.fiap.gs.dao.UsuarioEnderecoDao;
import br.com.fiap.gs.entity.UsuarioEndereco;
import jakarta.persistence.EntityManager;

public class UsuarioEnderecoDaoImpl  extends GenericDaoImpl<UsuarioEndereco, Integer> implements UsuarioEnderecoDao {

	public UsuarioEnderecoDaoImpl(EntityManager em) {
		super(em);
	}
}

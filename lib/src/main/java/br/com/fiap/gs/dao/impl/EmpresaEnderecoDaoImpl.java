package br.com.fiap.gs.dao.impl;

import br.com.fiap.gs.dao.EmpresaEnderecoDao;
import br.com.fiap.gs.entity.EmpresaEndereco;
import jakarta.persistence.EntityManager;

public class EmpresaEnderecoDaoImpl  extends GenericDaoImpl<EmpresaEndereco, Integer> implements EmpresaEnderecoDao {

	public EmpresaEnderecoDaoImpl(EntityManager em) {
		super(em);
	}
}

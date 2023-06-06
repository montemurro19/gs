package br.com.fiap.gs.dao.impl;

import br.com.fiap.gs.dao.EmpresaDao;
import br.com.fiap.gs.entity.Empresa;
import jakarta.persistence.EntityManager;

public class EmpresaDaoImpl  extends GenericDaoImpl<Empresa, Integer> implements EmpresaDao {

	public EmpresaDaoImpl(EntityManager em) {
		super(em);
	}
}

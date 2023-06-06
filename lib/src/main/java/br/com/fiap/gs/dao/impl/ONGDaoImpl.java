package br.com.fiap.gs.dao.impl;

import br.com.fiap.gs.dao.ONGDao;
import br.com.fiap.gs.entity.ONG;
import jakarta.persistence.EntityManager;

public class ONGDaoImpl  extends GenericDaoImpl<ONG, Integer> implements ONGDao {

	public ONGDaoImpl(EntityManager em) {
		super(em);
	}
}

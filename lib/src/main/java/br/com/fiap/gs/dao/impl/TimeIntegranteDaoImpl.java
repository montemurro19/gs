package br.com.fiap.gs.dao.impl;

import br.com.fiap.gs.dao.TimeIntegranteDao;
import br.com.fiap.gs.entity.TimeIntegrante;
import jakarta.persistence.EntityManager;

public class TimeIntegranteDaoImpl  extends GenericDaoImpl<TimeIntegrante, Integer> implements TimeIntegranteDao {

	public TimeIntegranteDaoImpl(EntityManager em) {
		super(em);
	}
}

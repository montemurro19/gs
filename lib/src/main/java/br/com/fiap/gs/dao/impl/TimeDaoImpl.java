package br.com.fiap.gs.dao.impl;

import java.util.List;
import br.com.fiap.gs.dao.TimeDao;
import br.com.fiap.gs.entity.Time;
import jakarta.persistence.EntityManager;

public class TimeDaoImpl  extends GenericDaoImpl<Time, Integer> implements TimeDao {

	public TimeDaoImpl(EntityManager em) {
		super(em);
	}
	
	public List<Time> listarTodos() {
		return em.createQuery("from Time t ORDER BY t.regiaoAtuacao DESC", Time.class)
				.getResultList();
	}
}

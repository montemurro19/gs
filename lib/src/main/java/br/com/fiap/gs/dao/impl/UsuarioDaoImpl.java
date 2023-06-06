package br.com.fiap.gs.dao.impl;

import br.com.fiap.gs.dao.UsuarioDao;
import br.com.fiap.gs.entity.Usuario;
import jakarta.persistence.EntityManager;

public class UsuarioDaoImpl  extends GenericDaoImpl<Usuario, Integer> implements UsuarioDao {

	public UsuarioDaoImpl(EntityManager em) {
		super(em);
	}
	
	public Usuario findByEmail(String email) {
		return em.createQuery("from Usuario u where u.email = :email", Usuario.class)
				.setParameter("email", email)
				.getSingleResult();
	}
}

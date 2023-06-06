package br.com.fiap.gs.dao.impl;

import br.com.fiap.gs.dao.UsuarioDocumentoDao;
import br.com.fiap.gs.entity.UsuarioDocumento;
import jakarta.persistence.EntityManager;

public class UsuarioDocumentoDaoImpl  extends GenericDaoImpl<UsuarioDocumento, Integer> implements UsuarioDocumentoDao {

	public UsuarioDocumentoDaoImpl(EntityManager em) {
		super(em);
	}
	
	public UsuarioDocumento findByCPF(String cpf) {
		return em.createQuery("from UsuarioDocumento u where u.cpf = :CPF", UsuarioDocumento.class)
				.setParameter("CPF", cpf)
				.getSingleResult();
	}
}

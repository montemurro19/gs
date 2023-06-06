package br.com.fiap.gs.dao;

import br.com.fiap.gs.entity.UsuarioDocumento;

public interface UsuarioDocumentoDao extends GenericDao<UsuarioDocumento, Integer> {
	
	UsuarioDocumento findByCPF(String cpf);
	
}

package br.com.fiap.gs.dao;


import br.com.fiap.gs.entity.Usuario;

public interface UsuarioDao extends GenericDao<Usuario, Integer> {
	
	Usuario findByEmail(String Email);

	
}

package br.com.fiap.gs.dao;

import br.com.fiap.gs.entity.Empresa;

public interface EmpresaDao extends GenericDao<Empresa, Integer> {
	
    Empresa findByEmail(String Email);
    
}

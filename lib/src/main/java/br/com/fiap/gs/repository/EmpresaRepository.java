package br.com.fiap.gs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.gs.entity.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa,Integer>{

}
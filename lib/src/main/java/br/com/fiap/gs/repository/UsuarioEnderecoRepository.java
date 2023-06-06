package br.com.fiap.gs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.gs.entity.UsuarioEndereco;

@Repository
public interface UsuarioEnderecoRepository extends JpaRepository<UsuarioEndereco,Integer>{

}
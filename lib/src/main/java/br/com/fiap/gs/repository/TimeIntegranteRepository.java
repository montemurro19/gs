package br.com.fiap.gs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.fiap.gs.entity.TimeIntegrante;

@Repository
public interface TimeIntegranteRepository extends JpaRepository<TimeIntegrante,Integer>{

}
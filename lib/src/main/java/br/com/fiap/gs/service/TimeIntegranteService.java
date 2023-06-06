package br.com.fiap.gs.service;

import java.util.List;
import br.com.fiap.gs.exception.CommitException;
import br.com.fiap.gs.exception.EntidadeNaoEcontradaException;
import br.com.fiap.gs.dao.TimeIntegranteDao;
import br.com.fiap.gs.dao.impl.TimeIntegranteDaoImpl;
import br.com.fiap.gs.entity.TimeIntegrante;
import br.com.fiap.gs.singleton.EntityManagerFactorySingleton;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;

@Service
public class TimeIntegranteService {

	private TimeService timeService = new TimeService();
	
	private EntityManager em = EntityManagerFactorySingleton
			.getInstance().createEntityManager();
	
	private TimeIntegranteDao dao = new TimeIntegranteDaoImpl(em);
	
	public List<TimeIntegrante> listarTodos(){
		List<TimeIntegrante> usuarioList = dao.listar();
		return usuarioList;
	}
	
	public TimeIntegrante salvar(TimeIntegrante newTimeIntegrante) {
		try {
			dao.salvar(newTimeIntegrante);
			dao.commit();
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		return newTimeIntegrante;
	}
	
	public TimeIntegrante salvar(Integer id, TimeIntegrante newTimeIntegrante) {
		newTimeIntegrante.setTime(timeService.findById(id));
		try {
			dao.salvar(newTimeIntegrante);
			dao.commit();
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		return newTimeIntegrante;
	}
	
	public TimeIntegrante atualizar(TimeIntegrante newTimeIntegrante) {
		try {
			dao.salvar(newTimeIntegrante);
			dao.commit();
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		return newTimeIntegrante;
	}
	
	public TimeIntegrante findById(int id ) {
		TimeIntegrante usuario = null;
		try {
			usuario = dao.buscar(id);
		} catch (EntidadeNaoEcontradaException e) {
			
			e.printStackTrace();
		}
		return usuario;
	}
	
	public void deletar(int id) {
		try {
			dao.deletar(id);
			dao.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
}

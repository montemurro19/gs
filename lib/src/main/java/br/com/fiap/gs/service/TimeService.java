package br.com.fiap.gs.service;

import java.util.List;
import br.com.fiap.gs.exception.CommitException;
import br.com.fiap.gs.exception.EntidadeNaoEcontradaException;
import br.com.fiap.gs.dao.TimeDao;
import br.com.fiap.gs.dao.impl.TimeDaoImpl;
import br.com.fiap.gs.entity.Time;
import br.com.fiap.gs.singleton.EntityManagerFactorySingleton;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;

@Service
public class TimeService {

	private EntityManager em = EntityManagerFactorySingleton
			.getInstance().createEntityManager();
	
	private TimeDao dao = new TimeDaoImpl(em);
	
	public List<Time> listarTodos(){
		List<Time> usuarioList = dao.listar();
		return usuarioList;
	}
	
	public Time salvar(Time newTime) {
		try {
			dao.salvar(newTime);
			dao.commit();
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		return newTime;
	}
	
	public Time findById(int id ) {
		Time usuario = null;
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

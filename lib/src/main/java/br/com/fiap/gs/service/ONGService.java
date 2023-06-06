package br.com.fiap.gs.service;

import java.util.List;
import br.com.fiap.gs.exception.CommitException;
import br.com.fiap.gs.exception.EntidadeNaoEcontradaException;
import br.com.fiap.gs.dao.ONGDao;
import br.com.fiap.gs.dao.impl.ONGDaoImpl;
import br.com.fiap.gs.entity.ONG;
import br.com.fiap.gs.singleton.EntityManagerFactorySingleton;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;

@Service
public class ONGService {

	private EntityManager em = EntityManagerFactorySingleton
			.getInstance().createEntityManager();
	
	private ONGDao dao = new ONGDaoImpl(em);
	
	public List<ONG> listarTodos(){
		List<ONG> usuarioList = dao.listar();
		return usuarioList;
	}
	
	public ONG salvar(ONG newONG) {
		try {
			dao.salvar(newONG);
			dao.commit();
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		return newONG;
	}
	
	public ONG findById(int id ) {
		ONG usuario = null;
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

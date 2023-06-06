package br.com.fiap.gs.service;

import java.util.List;
import br.com.fiap.gs.exception.CommitException;
import br.com.fiap.gs.exception.EntidadeNaoEcontradaException;
import br.com.fiap.gs.dao.EmpresaDao;
import br.com.fiap.gs.dao.impl.EmpresaDaoImpl;
import br.com.fiap.gs.entity.Empresa;
import br.com.fiap.gs.singleton.EntityManagerFactorySingleton;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {

	private EntityManager em = EntityManagerFactorySingleton
			.getInstance().createEntityManager();
	
	private EmpresaDao dao = new EmpresaDaoImpl(em);
	
	public List<Empresa> listarTodos(){
		List<Empresa> usuarioList = dao.listar();
		return usuarioList;
	}
	
	public Empresa salvar(Empresa newEmpresa) {
		try {
			dao.salvar(newEmpresa);
			dao.commit();
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		return newEmpresa;
	}
	
	public Empresa findById(Integer id ) {
		Empresa usuario = null;
		try {
			usuario = dao.buscar(id);
		} catch (EntidadeNaoEcontradaException e) {
			
			e.printStackTrace();
		}
		return usuario;
	}
	
	public void deletar(Integer id) {
		try {
			dao.deletar(id);
			dao.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
}

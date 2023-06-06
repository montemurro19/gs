package br.com.fiap.gs.service;

import java.util.List;
import br.com.fiap.gs.exception.CommitException;
import br.com.fiap.gs.exception.EntidadeNaoEcontradaException;
import br.com.fiap.gs.dao.EmpresaEnderecoDao;
import br.com.fiap.gs.dao.impl.EmpresaEnderecoDaoImpl;
import br.com.fiap.gs.entity.EmpresaEndereco;
import br.com.fiap.gs.singleton.EntityManagerFactorySingleton;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;

@Service
public class EmpresaEnderecoService {

	private EmpresaService empresaService = new EmpresaService();	
	
	private EntityManager em = EntityManagerFactorySingleton
			.getInstance().createEntityManager();
	
	private EmpresaEnderecoDao dao = new EmpresaEnderecoDaoImpl(em);
	
	public List<EmpresaEndereco> listarTodos(){
		List<EmpresaEndereco> usuarioList = dao.listar();
		return usuarioList;
	}
	
	public EmpresaEndereco salvar(Integer id, EmpresaEndereco newEmpresaEndereco) {
		newEmpresaEndereco.setEmpresa(empresaService.findById(id));
		try {
			dao.salvar(newEmpresaEndereco);
			dao.commit();
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		return newEmpresaEndereco;
	}
	
	public EmpresaEndereco atualizar(EmpresaEndereco newUsuarioEndereco) {
		try {
			dao.salvar(newUsuarioEndereco);
			dao.commit();
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		return newUsuarioEndereco;
	}
	
	public EmpresaEndereco findById(int id ) {
		EmpresaEndereco usuario = null;
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

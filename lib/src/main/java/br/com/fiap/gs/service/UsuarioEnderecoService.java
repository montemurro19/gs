package br.com.fiap.gs.service;

import java.util.List;
import br.com.fiap.gs.exception.CommitException;
import br.com.fiap.gs.exception.EntidadeNaoEcontradaException;
import br.com.fiap.gs.dao.UsuarioEnderecoDao;
import br.com.fiap.gs.dao.impl.UsuarioEnderecoDaoImpl;
import br.com.fiap.gs.entity.UsuarioEndereco;
import br.com.fiap.gs.singleton.EntityManagerFactorySingleton;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;

@Service
public class UsuarioEnderecoService {

	private UsuarioService usuarioService = new UsuarioService();
	
	private EntityManager em = EntityManagerFactorySingleton
			.getInstance().createEntityManager();
	
	private UsuarioEnderecoDao dao = new UsuarioEnderecoDaoImpl(em);
	
	public List<UsuarioEndereco> listarTodos(){
		List<UsuarioEndereco> usuarioList = dao.listar();
		return usuarioList;
	}
	
	public UsuarioEndereco salvar(Integer id, UsuarioEndereco newUsuarioEndereco) {
		newUsuarioEndereco.setUsuario(usuarioService.findById(id));
		try {
			dao.salvar(newUsuarioEndereco);
			dao.commit();
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		return newUsuarioEndereco;
	}
	
	public UsuarioEndereco atualizar(UsuarioEndereco newUsuarioEndereco) {
		try {
			dao.salvar(newUsuarioEndereco);
			dao.commit();
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		return newUsuarioEndereco;
	}
	
	public UsuarioEndereco findById(int id ) {
		UsuarioEndereco usuario = null;
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

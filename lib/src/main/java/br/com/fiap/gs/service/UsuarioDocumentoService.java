package br.com.fiap.gs.service;

import java.util.List;
import br.com.fiap.gs.exception.CommitException;
import br.com.fiap.gs.exception.EntidadeNaoEcontradaException;
import br.com.fiap.gs.dao.UsuarioDocumentoDao;
import br.com.fiap.gs.dao.impl.UsuarioDocumentoDaoImpl;
import br.com.fiap.gs.entity.UsuarioDocumento;
import br.com.fiap.gs.singleton.EntityManagerFactorySingleton;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDocumentoService {

	private UsuarioService usuarioService = new UsuarioService();
	
	private EntityManager em = EntityManagerFactorySingleton
			.getInstance().createEntityManager();
	
	private UsuarioDocumentoDao dao = new UsuarioDocumentoDaoImpl(em);
	
	public List<UsuarioDocumento> listarTodos(){
		List<UsuarioDocumento> usuarioList = dao.listar();
		return usuarioList;
	}
	
	public UsuarioDocumento salvar(Integer id, UsuarioDocumento newUsuarioDocumento) {
		newUsuarioDocumento.setUsuario(usuarioService.findById(id));
		try {
			dao.salvar(newUsuarioDocumento);
			dao.commit();
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		return newUsuarioDocumento;
	}
	
	public UsuarioDocumento atualizar(UsuarioDocumento newUsuarioDocumento) {
		try {
			dao.salvar(newUsuarioDocumento);
			dao.commit();
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		return newUsuarioDocumento;
	}
	
	public UsuarioDocumento findById(int id ) {
		UsuarioDocumento usuario = null;
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

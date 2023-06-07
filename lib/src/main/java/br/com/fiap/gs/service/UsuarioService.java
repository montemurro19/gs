package br.com.fiap.gs.service;

import java.util.List;
import java.util.Optional;

import br.com.fiap.gs.exception.CommitException;
import br.com.fiap.gs.exception.EntidadeNaoEcontradaException;
import br.com.fiap.gs.dao.UsuarioDao;
import br.com.fiap.gs.dao.impl.UsuarioDaoImpl;
import br.com.fiap.gs.entity.Usuario;
import br.com.fiap.gs.singleton.EntityManagerFactorySingleton;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

	private EntityManager em = EntityManagerFactorySingleton
			.getInstance().createEntityManager();
	
	private UsuarioDao dao = new UsuarioDaoImpl(em);
	
	public List<Usuario> listarTodos(){
		List<Usuario> usuarioList = dao.listar();
		return usuarioList;
	}
	
	public Usuario salvar(Usuario newUsuario) {
		Usuario usuario = new Usuario();
		try {
			dao.salvar(newUsuario);
			dao.commit();
			usuario.setCodigo(dao.findByEmail(newUsuario.getEmail()).getCodigo());
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		return usuario;
	}
	
	public Usuario findById(int id ) {
		Usuario usuario = null;
		try {
			usuario = dao.buscar(id);
		} catch (EntidadeNaoEcontradaException e) {
			
			e.printStackTrace();
		}
		return usuario;
	}
	
	public Optional<Usuario> findByEmail(String email ) {
		Usuario usuario = null;
		usuario = dao.findByEmail(email);
		return Optional.ofNullable(usuario);
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

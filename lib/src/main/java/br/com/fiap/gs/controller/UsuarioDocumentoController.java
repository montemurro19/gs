package br.com.fiap.gs.controller;

import org.springframework.web.bind.annotation.*;
import br.com.fiap.gs.service.UsuarioDocumentoService;
import br.com.fiap.gs.entity.UsuarioDocumento;

@CrossOrigin(origins = "http://localhost:19006")
@RequestMapping("/api/login/usuario/documento")
@RestController
public class UsuarioDocumentoController {

	private UsuarioDocumentoService usuarioDocumentoService = new UsuarioDocumentoService();	

	@PostMapping("/{id}")
	public UsuarioDocumento newUsuarioDocumento(@PathVariable Integer id, @RequestBody UsuarioDocumento newUsuarioDocumento) {		
		return usuarioDocumentoService.salvar(id, newUsuarioDocumento);
	}

	@GetMapping("/{id}")
	public UsuarioDocumento one(@PathVariable Integer id) {
		return usuarioDocumentoService.findById(id);
	}

	@PutMapping
	public UsuarioDocumento replaceUsuarioDocumento(@RequestBody UsuarioDocumento newUsuarioDocumento) {
		return usuarioDocumentoService.atualizar(newUsuarioDocumento);
	}

	@DeleteMapping("/{id}")
	public void deleteUsuarioDocumento(@PathVariable Integer id) {
		usuarioDocumentoService.deletar(id);
	}
}

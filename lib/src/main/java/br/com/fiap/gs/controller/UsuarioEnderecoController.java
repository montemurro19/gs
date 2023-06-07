package br.com.fiap.gs.controller;


import org.springframework.web.bind.annotation.*;
import br.com.fiap.gs.service.UsuarioEnderecoService;
import br.com.fiap.gs.entity.UsuarioEndereco;


@CrossOrigin(origins = "http://localhost:19006")
@RequestMapping("/api/login/usuario/endereco")
@RestController
public class UsuarioEnderecoController {

	private UsuarioEnderecoService usuarioEnderecoService = new UsuarioEnderecoService();
	
	@PostMapping("/{id}")
	public UsuarioEndereco newUsuarioEndereco(@PathVariable Integer id, @RequestBody UsuarioEndereco newUsuarioEndereco) {		
		return usuarioEnderecoService.salvar(id, newUsuarioEndereco);
	}

	@GetMapping("/{id}")
	public UsuarioEndereco one(@PathVariable Integer id) {
		return usuarioEnderecoService.findById(id);
	}

	@PutMapping
	public UsuarioEndereco replaceUsuarioEndereco(@RequestBody UsuarioEndereco newUsuarioEndereco) {
		return usuarioEnderecoService.atualizar(newUsuarioEndereco);
	}

	@DeleteMapping("/{id}")
	public void deleteUsuarioEndereco(@PathVariable Integer id) {
		usuarioEnderecoService.deletar(id);
	}
}

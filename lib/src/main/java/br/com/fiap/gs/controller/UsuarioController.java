package br.com.fiap.gs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.fiap.gs.service.TokenService;
import br.com.fiap.gs.service.UsuarioService;
import jakarta.validation.Valid;
import br.com.fiap.gs.entity.Usuario;
import br.com.fiap.gs.model.Credencial;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.authentication.AuthenticationManager;


@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:19006")
@RestController
public class UsuarioController {	
		
	@Autowired
	private UsuarioService usuarioService;	
	
    @Autowired
    AuthenticationManager manager;

    @Autowired
    PasswordEncoder encoder;
	
    @Autowired
    TokenService tokenService;
    
	@GetMapping("/login")
	public List<Usuario> all() {		
		return usuarioService.listarTodos();
	}

    @PostMapping("/registrar")
    public ResponseEntity<Usuario> registrar(@RequestBody @Valid Usuario usuario){
        usuario.setSenha(encoder.encode(usuario.getSenha()));        
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.salvar(usuario));
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody @Valid Credencial credencial){
        manager.authenticate(credencial.toAuthentication());
        var token = tokenService.generateToken(credencial);
        return ResponseEntity.ok(token);
    }
	
	@GetMapping("/login/{id}")
	public Usuario one(@PathVariable Integer id) {
		return usuarioService.findById(id);
	}

	@PutMapping("/login")
	public Usuario replaceUsuario(@RequestBody Usuario newUsuario) {		
		return usuarioService.salvar(newUsuario);
	}

	@DeleteMapping("/login/{id}")
	public void deleteUsuario(@PathVariable Integer id) {
		usuarioService.deletar(id);
	}
}

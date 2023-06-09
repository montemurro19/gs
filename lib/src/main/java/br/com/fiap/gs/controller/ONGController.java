package br.com.fiap.gs.controller;


import java.util.List;
import org.springframework.web.bind.annotation.*;

import br.com.fiap.gs.service.ONGService;
import jakarta.validation.Valid;
import br.com.fiap.gs.entity.ONG;


@CrossOrigin(origins = "http://localhost:19006")
@RequestMapping("/api/ong")
@RestController
public class ONGController {

	private ONGService ongService = new ONGService();	

	@GetMapping
	public List<ONG> all() {		
		return ongService.listarTodos();
	}

	@PostMapping
	public ONG newONG(@Valid @RequestBody ONG newONG) {		
		return ongService.atualizar(newONG);
	}

	@GetMapping("/{id}")
	public ONG one(@PathVariable Integer id) {
		return ongService.findById(id);
	}

	@PutMapping
	public ONG replaceONG(@RequestBody ONG newONG) {		
		return ongService.atualizar(newONG);
	}

	@DeleteMapping("/{id}")
	public void deleteONG(@PathVariable Integer id) {
		ongService.deletar(id);
	}
}

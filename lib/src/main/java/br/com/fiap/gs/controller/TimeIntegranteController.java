package br.com.fiap.gs.controller;


import org.springframework.web.bind.annotation.*;
import br.com.fiap.gs.service.TimeIntegranteService;
import jakarta.validation.Valid;
import br.com.fiap.gs.entity.TimeIntegrante;


@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/login/time/integrante")
@RestController
public class TimeIntegranteController {

	private TimeIntegranteService timeIntegranteService = new TimeIntegranteService();	

	@PostMapping
	public TimeIntegrante newTimeIntegrante(@Valid @RequestBody TimeIntegrante newTimeIntegrante) {		
		return timeIntegranteService.salvar(newTimeIntegrante);
	}

	@GetMapping("/{id}")
	public TimeIntegrante one(@PathVariable Integer id) {
		return timeIntegranteService.findById(id);
	}

	@PutMapping("/{id}")
	public TimeIntegrante replaceTimeIntegrante(@RequestBody TimeIntegrante newTimeIntegrante) {		
		return timeIntegranteService.atualizar(newTimeIntegrante);
	}

	@DeleteMapping("/{id}")
	public void deleteTimeIntegrante(@PathVariable Integer id) {
		timeIntegranteService.deletar(id);
	}
}

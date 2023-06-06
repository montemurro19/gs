package br.com.fiap.gs.controller;


import java.util.List;
import org.springframework.web.bind.annotation.*;

import br.com.fiap.gs.service.TimeService;
import jakarta.validation.Valid;
import br.com.fiap.gs.entity.Time;


@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/time")
@RestController
public class TimeController {

	private TimeService timeService = new TimeService();	

	@GetMapping
	public List<Time> all() {		
		return timeService.listarTodos();
	}

	@PostMapping
	public Time newTime(@Valid @RequestBody Time newTime) {		
		return timeService.salvar(newTime);
	}

	@GetMapping("/{id}")
	public Time one(@PathVariable Integer id) {
		return timeService.findById(id);
	}

	@PutMapping
	public Time replaceTime(@RequestBody Time newTime) {		
		return timeService.salvar(newTime);
	}

	@DeleteMapping("/{id}")
	public void deleteTime(@PathVariable Integer id) {
		timeService.deletar(id);
	}
}

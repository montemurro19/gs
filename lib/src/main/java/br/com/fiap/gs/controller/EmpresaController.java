package br.com.fiap.gs.controller;


import java.util.List;
import org.springframework.web.bind.annotation.*;
import br.com.fiap.gs.service.EmpresaService;
import jakarta.validation.Valid;
import br.com.fiap.gs.entity.Empresa;


@CrossOrigin(origins = "http://localhost:19006")
@RequestMapping("/api/empresa")
@RestController
public class EmpresaController {

	private EmpresaService empresaService = new EmpresaService();	

	@GetMapping
	public List<Empresa> all() {		
		return empresaService.listarTodos();
	}

	@PostMapping
	public Empresa newEmpresa(@Valid @RequestBody Empresa newEmpresa) {		
		return empresaService.salvar(newEmpresa);
	}

	@GetMapping("/{id}")
	public Empresa one(@PathVariable Integer id) {
		return empresaService.findById(id);
	}

	@PutMapping
	public Empresa replaceEmpresa(@PathVariable Integer id, @RequestBody Empresa newEmpresa) {		
		return empresaService.salvar(newEmpresa);
	}

	@DeleteMapping("/{id}")
	public void deleteEmpresa(@PathVariable Integer id) {
		empresaService.deletar(id);
	}
}
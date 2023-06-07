package br.com.fiap.gs.controller;


import org.springframework.web.bind.annotation.*;
import br.com.fiap.gs.service.EmpresaEnderecoService;
import br.com.fiap.gs.entity.EmpresaEndereco;


@CrossOrigin(origins = "http://localhost:19006")
@RequestMapping("/api/empresa/endereco")
@RestController
public class EmpresaEnderecoController {

	private EmpresaEnderecoService empresaEnderecoService = new EmpresaEnderecoService();	

	@PostMapping("/{id}")
	public EmpresaEndereco newEmpresaEndereco(@PathVariable Integer id, @RequestBody EmpresaEndereco newEmpresaEndereco) {		
		return empresaEnderecoService.salvar(id, newEmpresaEndereco);
	}

	@GetMapping("/{id}")
	public EmpresaEndereco one(@PathVariable Integer id) {
		return empresaEnderecoService.findById(id);
	}

	@PutMapping
	public EmpresaEndereco replaceEmpresaEndereco(@RequestBody EmpresaEndereco newEmpresaEndereco) {		
		return empresaEnderecoService.atualizar(newEmpresaEndereco);
	}

	@DeleteMapping("/{id}")
	public void deleteEmpresaEndereco(@PathVariable Integer id) {
		empresaEnderecoService.deletar(id);
	}
}

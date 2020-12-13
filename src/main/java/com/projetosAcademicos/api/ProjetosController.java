package com.projetosAcademicos.api;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetosAcademicos.domain.Projeto;
import com.projetosAcademicos.domain.ProjetoService;
import com.projetosAcademicos.domain.dto.ProjetoDTO;

@RestController
@RequestMapping("/api/v1/projetos")
public class ProjetosController {
	
	@Autowired
	private ProjetoService service;
	
	@GetMapping
	public ResponseEntity<List<ProjetoDTO>> get() {
		return ResponseEntity.ok(service.getProjetos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Projeto> get(@PathVariable("id") Long id) {
		Optional<Projeto> projeto = service.getProjetoById(id);
		return projeto.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
		
	}
	
	/*@GetMapping("/matricula/{matricula}")
	public ResponseEntity<List<AlunoDTO>> getCarrosByTipo(@PathVariable("matricula") String matricula) {
		List<AlunoDTO> listaProjetos = service.getAlunoByMatricula(matricula);
		return listaProjetos.isEmpty() ? 
				ResponseEntity.noContent().build() :
				ResponseEntity.ok(listaAlunos);
	}*/
	
	@PostMapping
	public String cadastrarProjeto(@RequestBody Projeto projeto) {
		Projeto c = service.cadastrar(projeto);
		return "Projeto salvo com sucesso: " + c.getId();
	}
	
	@PutMapping("/{id}")
	public String atualizarProjeto(@PathVariable("id") Long id, @RequestBody Projeto projeto) {
		Projeto c = service.atualizar(projeto, id);
		
		return "Projeto atualizado com sucesso: " + c.getId();
	}
	
	@DeleteMapping("/{id}")
	public String removerProjeto(@PathVariable("id") Long id) {
		service.remover(id);
		return "Projeto removido com sucesso. ";
	}
	
}

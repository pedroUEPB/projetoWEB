package com.projetosAcademicos.domain;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetosAcademicos.domain.dto.ProjetoDTO;

@Service
public class ProjetoService {
	
	@Autowired
	private ProjetoRepository projetoRepository;
	
	//@Autowired
	//private CadastroAlunoRepository car;
	
	public List<ProjetoDTO> getProjetos(){
		return projetoRepository.findAll().stream().map(ProjetoDTO::new).collect(Collectors.toList());
	}
	
	public Optional<Projeto> getProjetoById(Long id) {
		return projetoRepository.findById(id);
	}
	
	//verificar depois
	/*public List<ProjetoDTO> getProjetoByMatricula(String matricula) {
		return projetoRepository.findByMatricula(matricula).stream().map(ProjetoDTO::new).collect(Collectors.toList());
	}*/
	
	public Projeto cadastrar(Projeto projeto) {
		
		return projetoRepository.save(projeto);
	}
	
	public Projeto atualizar(Projeto projeto, Long id) {
		
		Optional<Projeto> optional = getProjetoById(id);
		System.out.println("ID Aluno: " + projeto.getAlunos().get(0).getId());
		if (optional.isPresent()) {
			Projeto projetoBD = optional.get();
			projetoBD.setArea_do_projeto(projeto.getArea_do_projeto());
			projetoBD.setTitulo_do_projeto(projeto.getTitulo_do_projeto());
			projetoBD.setResumo(projeto.getResumo());
			projetoBD.setPalavra_chave1(projeto.getPalavra_chave1());
			projetoBD.setPalavra_chave2(projeto.getPalavra_chave2());
			projetoBD.setPalavra_chave3(projeto.getPalavra_chave3());
			projetoBD.setUrl_documento(projeto.getUrl_documento());
			projetoBD.setAlunos(projeto.getAlunos());
			
			projetoRepository.save(projetoBD);
			return projetoBD;
		}
		else {
			throw new RuntimeException("Não foi possível atualizar o projeto informado");
		}
	}
	
	public void remover(Long id) {
		Optional<Projeto> professor = getProjetoById(id);
		if(professor.isPresent()) {
			projetoRepository.deleteById(id);
		}
	}

}

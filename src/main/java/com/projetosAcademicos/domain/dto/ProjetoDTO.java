package com.projetosAcademicos.domain.dto;

import java.util.List;

import com.projetosAcademicos.domain.Aluno;
import com.projetosAcademicos.domain.Professor;

import lombok.Data;

import com.projetosAcademicos.domain.Projeto;

@Data
public class ProjetoDTO {
	private Long id;
	private String titulo_do_projeto;
	private String area_do_projeto;
	private String resumo;
	private String palavra_chave1;
	private String palavra_chave2;
	private String palavra_chave3;
	private String url_documento;
	private Professor professor;
	private List<Aluno> alunos;
	
	public ProjetoDTO(Projeto c) {
		this.id = c.getId();
		this.titulo_do_projeto = c.getTitulo_do_projeto();
		this.area_do_projeto = c.getArea_do_projeto();
		this.resumo = c.getResumo();
		this.palavra_chave1 = c.getPalavra_chave1();
		this.palavra_chave2 = c.getPalavra_chave2();
		this.palavra_chave3 = c.getPalavra_chave3();;
		this.professor = c.getProfessor();
		this.alunos = c.getAlunos();
	}
}

package com.projetosAcademicos.domain.dto;

import com.projetosAcademicos.domain.Professor;

import lombok.Data;

import com.projetosAcademicos.domain.Endereco;

@Data
public class ProfessorDTO {
	private Long id;
	private String nome;
	private String matricula;
	private String curso;
	private Endereco endereco;
	
	public ProfessorDTO(Professor c) {
		this.id = c.getId();
		this.matricula = c.getMatricula();
		this.nome = c.getNome();
		this.curso = c.getCurso();
		this.endereco = c.getEndereco();
	}
}

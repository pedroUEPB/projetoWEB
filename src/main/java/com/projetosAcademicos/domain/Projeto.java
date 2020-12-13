package com.projetosAcademicos.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "projeto")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Projeto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToMany	
	@JoinTable(name = "cadastroaluno",
			   joinColumns = @JoinColumn(name = "fk_projeto"),
			   inverseJoinColumns = @JoinColumn(name = "fk_aluno"))
	private List<Aluno> alunos = new ArrayList<>();
	
	@Column(name = "titulo_do_projeto")
	private String titulo_do_projeto;
	
	@Column(name = "area_do_projeto")
	private String area_do_projeto;
	
	@Column(name = "resumo")
	private String resumo;
	
	@Column(name = "palavra_chave1")
	private String palavra_chave1;
	
	@Column(name = "palavra_chave2")
	private String palavra_chave2;
	
	@Column(name = "palavra_chave3")
	private String palavra_chave3;
	
	@Column(name = "url_documento")
	private String url_documento;
	
	//@NotNull()
	//@ManyToOne(cascade=CascadeType.ALL)
    //@JoinColumn(name = "fk_professor", foreignKey = @ForeignKey(name = "fk_professor"), referencedColumnName = "id")
	@NotNull
	@ManyToOne
	@JoinColumn(name = "fk_professor")
	private Professor professor;
	
	@JsonBackReference
	public Professor getProfessor() {
		return professor;
	}

}
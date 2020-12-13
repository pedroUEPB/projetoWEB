package com.projetosAcademicos.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "professor")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Professor {
	
	//@JsonIgnore
	@OneToMany(mappedBy = "professor")
	@JsonManagedReference
	private List<Projeto> projetos = new ArrayList<>();
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "matricula")
	private String matricula;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "curso")
	private String curso;
	
	@NotNull()
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "fk_endereco", foreignKey = @ForeignKey(name = "fk_endereco"), referencedColumnName = "id")
	private Endereco endereco;

}
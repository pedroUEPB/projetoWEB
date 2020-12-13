package com.projetosAcademicos.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Long>{

	//List<Projeto> findByMatricula(String matricula);
	

}
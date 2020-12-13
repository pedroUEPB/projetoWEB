create schema `api_projetos_academicos`;

use `api_projetos_academicos`;

CREATE TABLE `endereco`(
	`id` INT NOT NULL AUTO_INCREMENT,
	`rua` VARCHAR(100) NOT NULL,
	`numero` INT NOT NULL,
	`cep` VARCHAR(9) NOT NULL,
	`cidade` VARCHAR(100) NOT NULL,
	`estado` VARCHAR(2) NOT NULL,
	`pais` VARCHAR(2) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `professor`(
	`id` INT NOT NULL AUTO_INCREMENT,
	`nome` VARCHAR(50) NOT NULL ,
	`matricula` VARCHAR(11),
	`curso` VARCHAR(50) NOT NULL ,
	`fk_endereco` INT NOT NULL,
	PRIMARY KEY (`id`),
	INDEX `fk_professor_endereco_idx` (`fk_endereco` ASC),
	CONSTRAINT `fk_professor_endereco`
		FOREIGN KEY (`fk_endereco`)
		REFERENCES `endereco` (`id`)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
);

CREATE TABLE `aluno`(
	`id` INT NOT NULL AUTO_INCREMENT,
	`matricula` VARCHAR(11),
	`nome` VARCHAR(50) NOT NULL ,
	`cpf` VARCHAR(14) NOT NULL ,
	`curso` VARCHAR(50) NOT NULL,
	`fk_endereco` INT NOT NULL,
    	PRIMARY KEY (`id`),
	INDEX `fk_aluno_endereco_idx` (`fk_endereco` ASC),
	CONSTRAINT `fk_aluno_endereco`
		FOREIGN KEY (`fk_endereco`)
		REFERENCES `endereco` (`id`)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
);

CREATE TABLE `projeto`(
	`id` INT NOT NULL AUTO_INCREMENT,
	`titulo_do_projeto` VARCHAR(255) NOT NULL,
	`fk_professor` INT NOT NULL,
	`area_do_projeto` VARCHAR(255) NOT NULL,
	`resumo` VARCHAR(3000) NOT NULL,
	`palavra_chave1` VARCHAR(50) NOT NULL,
	`palavra_chave2` VARCHAR(50) NOT NULL,
	`palavra_chave3` VARCHAR(50) NOT NULL,
	`url_documento` VARCHAR(255) NOT NULL,
    	PRIMARY KEY (`id`),
	INDEX `fk_projeto_professor_idx` (`fk_professor` ASC),
	CONSTRAINT `fk_projeto_professor`
		FOREIGN KEY (`fk_professor`)
		REFERENCES `professor` (`id`)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
);

CREATE TABLE `cadastroaluno`(
	`id` INT NOT NULL AUTO_INCREMENT,
	`fk_aluno` INT NOT NULL,
	`fk_projeto` INT NOT NULL,
	PRIMARY KEY (`id`),
	INDEX `fk_cadastroaluno_aluno_idx` (`fk_aluno` ASC),
	CONSTRAINT `fk_cadastroaluno_aluno`
		FOREIGN KEY (`fk_aluno`)
		REFERENCES `aluno` (`id`)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION,
	INDEX `fk_cadastroalunoprojeto_idx` (`fk_projeto` ASC),
	CONSTRAINT `fk_notaP_projeto`
		FOREIGN KEY (`fk_projeto`)
		REFERENCES `projeto` (`id`)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
);
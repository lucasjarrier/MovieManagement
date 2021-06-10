DROP IF EXISTS SCHEMA treinamento;

CREATE SCHEMA treinamento AUTHORIZATION postgres;

CREATE TABLE treinamento.usuario (
	id SERIAL PRIMARY KEY,
	nome VARCHAR(100) NOT NULL,
	sobrenome VARCHAR(100),
	sexo VARCHAR(20) NOT NULL,
	data_nascimento TIMESTAMP NOT NULL,
	email VARCHAR(100) NOT NULL
);

CREATE TABLE treinamento.diretor (
	id SERIAL PRIMARY KEY,
	nome VARCHAR(100) NOT NULL,
	sobrenome VARCHAR(100) NOT NULL
);

CREATE TABLE treinamento.filme (
	id SERIAL PRIMARY KEY,
	nome VARCHAR(100) NOT NULL,
	genero VARCHAR(20) NOT NULL,
	lancamento TIMESTAMP NOT NULL,
	id_diretor INTEGER NOT NULL,
	CONSTRAINT fk_id_diretor FOREIGN KEY(id_diretor) REFERENCES treinamento.diretor(id)
);

CREATE TABLE treinamento.rel_usuario_filme (
	id_usuario INTEGER,
	id_filme INTEGER,
	CONSTRAINT pk_rel_usuario_filme PRIMARY KEY(id_usuario, id_filme),
	CONSTRAINT fk_id_usuario FOREIGN KEY(id_usuario) REFERENCES treinamento.usuario(id),
	CONSTRAINT fk_id_filme FOREIGN KEY(id_filme) REFERENCES treinamento.filme(id)
);
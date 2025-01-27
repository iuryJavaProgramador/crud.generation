package com.crud.aluno.generation_teste.repository;

import com.crud.aluno.generation_teste.model.Aluno;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    List<Aluno> findByNome(String nome);
}

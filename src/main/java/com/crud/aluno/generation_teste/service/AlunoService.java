package com.crud.aluno.generation_teste.service;

import com.crud.aluno.generation_teste.exception.ResourceNotFoundException;
import com.crud.aluno.generation_teste.model.Aluno;
import com.crud.aluno.generation_teste.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> getAllAlunos() {
        return alunoRepository.findAll();
    }

    public Aluno getAlunoById(Long id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado com ID: " + id));
    }

    public Aluno saveAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Aluno updateAluno(Long id, Aluno alunoDetails) {
        Aluno aluno = getAlunoById(id);
        aluno.setNome(alunoDetails.getNome());
        aluno.setIdade(alunoDetails.getIdade());
        aluno.setNotaPrimeiroSemestre(alunoDetails.getNotaPrimeiroSemestre());
        aluno.setNotaSegundoSemestre(alunoDetails.getNotaSegundoSemestre());
        aluno.setNomeProfessor(alunoDetails.getNomeProfessor());
        aluno.setNumeroSala(alunoDetails.getNumeroSala());
        return alunoRepository.save(aluno);
    }

    public void deleteAluno(Long id) {
        Aluno aluno = getAlunoById(id);
        alunoRepository.delete(aluno);
    }

    public List<Aluno> saveAlunos(List<Aluno> alunos) {
        return alunoRepository.saveAll(alunos);
    }
}

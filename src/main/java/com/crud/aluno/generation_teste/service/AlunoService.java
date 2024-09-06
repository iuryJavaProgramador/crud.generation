package com.crud.aluno.generation_teste.service;

import com.crud.aluno.generation_teste.exception.ResourceNotFoundException;
import com.crud.aluno.generation_teste.exception.TooManyAlunosException;
import com.crud.aluno.generation_teste.model.Aluno;
import com.crud.aluno.generation_teste.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class AlunoService {
    
    private static final Logger logger = LoggerFactory.getLogger(AlunoService.class);

    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> getAllAlunos() throws TooManyAlunosException {
        List<Aluno> alunos = alunoRepository.findAll();
        if (alunos.size() > 8) {
            logger.error("Too many alunos found: {}", alunos.size());
            throw new TooManyAlunosException("Número de alunos excede o limite permitido de 8.");
        }
        logger.info("Fetching all alunos");
        return alunos;
    }

    public Aluno getAlunoById(Long id) {
        logger.info("Fetching aluno with ID: {}", id);
        return alunoRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("Aluno not found with ID: {}", id);
                    return new ResourceNotFoundException("Aluno não encontrado com ID: " + id);
                });
    }

    public Aluno saveAluno(Aluno aluno) {
        validateAluno(aluno);
        logger.info("Saving aluno: {}", aluno);
        return alunoRepository.save(aluno);
    }

    public Aluno updateAluno(Long id, Aluno alunoDetails) {
        logger.info("Updating aluno with ID: {}", id);
        Aluno aluno = getAlunoById(id);
        if (alunoDetails.getNome() != null) aluno.setNome(alunoDetails.getNome());
        if (alunoDetails.getIdade() != null) aluno.setIdade(alunoDetails.getIdade());
        if (alunoDetails.getNotaPrimeiroSemestre() != null) aluno.setNotaPrimeiroSemestre(alunoDetails.getNotaPrimeiroSemestre());
        if (alunoDetails.getNotaSegundoSemestre() != null) aluno.setNotaSegundoSemestre(alunoDetails.getNotaSegundoSemestre());
        if (alunoDetails.getNomeProfessor() != null) aluno.setNomeProfessor(alunoDetails.getNomeProfessor());
        if (alunoDetails.getNumeroSala() != null) aluno.setNumeroSala(alunoDetails.getNumeroSala());
        return alunoRepository.save(aluno);
    }

    public void deleteAluno(Long id) {
        logger.info("Deleting aluno with ID: {}", id);
        Aluno aluno = getAlunoById(id);
        alunoRepository.delete(aluno);
    }

    public List<Aluno> saveAlunos(List<Aluno> alunos) {
        alunos.forEach(this::validateAluno);
        logger.info("Saving batch of alunos");
        return alunoRepository.saveAll(alunos);
    }

    private void validateAluno(Aluno aluno) {
    }
}

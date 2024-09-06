package com.crud.aluno.generation_teste.controller;

import com.crud.aluno.generation_teste.model.Aluno;
import com.crud.aluno.generation_teste.service.AlunoService;
import com.crud.aluno.generation_teste.exception.ResourceNotFoundException;
import com.crud.aluno.generation_teste.exception.TooManyAlunosException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api-generationescola/alunos")
public class AlunoGeneration {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<Aluno>> getAllAlunos() {
        List<Aluno> alunos = alunoService.getAllAlunos();
        return ResponseEntity.ok(alunos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> getAlunoById(@PathVariable Long id) {
        Aluno aluno = alunoService.getAlunoById(id); // Deixe o service lidar com a exceção
        return ResponseEntity.ok(aluno);
    }

    @PostMapping
    public ResponseEntity<Aluno> createAluno(@RequestBody Aluno aluno) {
        Aluno createdAluno = alunoService.saveAluno(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAluno);
    }

    @PostMapping("/batch")
    public ResponseEntity<List<Aluno>> createAlunos(@RequestBody List<Aluno> alunos) {
        List<Aluno> createdAlunos = alunoService.saveAlunos(alunos);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAlunos);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Aluno> updateAluno(@PathVariable Long id, @RequestBody Aluno alunoDetails) {
        Aluno updatedAluno = alunoService.updateAluno(id, alunoDetails);
        return ResponseEntity.ok(updatedAluno);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAluno(@PathVariable Long id) {
        alunoService.deleteAluno(id);
        return ResponseEntity.noContent().build();
    }


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }


    @ExceptionHandler(TooManyAlunosException.class)
    public ResponseEntity<String> handleTooManyAlunosException(TooManyAlunosException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }
}

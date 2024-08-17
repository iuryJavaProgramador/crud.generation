package com.crud.aluno.generation_teste.controller;

import com.crud.aluno.generation_teste.model.Aluno;
import com.crud.aluno.generation_teste.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api-generationescola/alunos")
public class AlunoGeneration {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<Aluno> getAllAlunos() {
        return alunoService.getAllAlunos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> getAlunoById(@PathVariable Long id) {
        return ResponseEntity.ok(alunoService.getAlunoById(id));
    }

    @PostMapping
    public Aluno createAluno(@RequestBody Aluno aluno) {
        return alunoService.saveAluno(aluno);
    }
    @PostMapping("/{id}")
    public List<Aluno> createAlunos(@RequestBody List<Aluno> alunos) {
        return alunoService.saveAlunos(alunos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> updateAluno(@PathVariable Long id, @RequestBody Aluno alunoDetails) {
        return ResponseEntity.ok(alunoService.updateAluno(id, alunoDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAluno(@PathVariable Long id) {
        alunoService.deleteAluno(id);
        return ResponseEntity.noContent().build();
    }
}
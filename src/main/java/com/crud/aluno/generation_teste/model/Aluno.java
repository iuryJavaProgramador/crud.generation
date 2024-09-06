package com.crud.aluno.generation_teste.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Aluno {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 1, max = 120, message = "O nome deve ter entre 1 e 120 caracteres")
    private String nome;

    @NotNull(message = "A idade é obrigatória")
    @Min(value = 1, message = "A idade deve ser maior que zero")
    private Integer idade;

    @NotNull(message = "A nota do primeiro semestre é obrigatória")
    @DecimalMax(value = "10.0", message = "A nota máxima permitida é 10.0")
    private Double notaPrimeiroSemestre;

    @NotNull(message = "A nota do segundo semestre é obrigatória")
    @DecimalMax(value = "10.0", message = "A nota máxima permitida é 10.0")
    private Double notaSegundoSemestre;

    @NotBlank(message = "O nome do professor é obrigatório")
    private String nomeProfessor;

    @NotNull(message = "O número da sala é obrigatório")
    @Min(value = 1, message = "O número da sala deve ser maior que zero")
    private Integer numeroSala;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Double getNotaPrimeiroSemestre() {
        return notaPrimeiroSemestre;
    }

    public void setNotaPrimeiroSemestre(Double notaPrimeiroSemestre) {
        this.notaPrimeiroSemestre = notaPrimeiroSemestre;
    }

    public Double getNotaSegundoSemestre() {
        return notaSegundoSemestre;
    }

    public void setNotaSegundoSemestre(Double notaSegundoSemestre) {
        this.notaSegundoSemestre = notaSegundoSemestre;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public Integer getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(Integer numeroSala) {
        this.numeroSala = numeroSala;
    }
}

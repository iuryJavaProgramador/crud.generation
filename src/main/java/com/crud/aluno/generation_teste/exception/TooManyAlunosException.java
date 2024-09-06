package com.crud.aluno.generation_teste.exception;

public class TooManyAlunosException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public TooManyAlunosException(String message) {
        super(message);
    }
}

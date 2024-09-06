package com.crud.aluno.generation_teste.exception;

public class ResourceNotFoundException extends RuntimeException {
    /**
	 * @author IURY
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String message) {
        super(message);
    }
}

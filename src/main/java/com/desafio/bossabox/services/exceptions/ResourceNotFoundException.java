package com.desafio.bossabox.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Object tag) {
		super("Ferramenta não encontrada ID:"+tag);
	}
}

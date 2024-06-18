package com.desafio.bossabox.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.desafio.bossabox.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandler {
	
	@org.springframework.web.bind.annotation.ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Error> resourceNotFoundException(ResourceNotFoundException e,HttpServletRequest request){
		String error = "Ferramenta não encontrada ";
		HttpStatus status = HttpStatus.NOT_FOUND;
		Error errorform = new Error(Instant.now(),status.value(),error,e.getMessage(),request.getRequestURI());
		
		return ResponseEntity.status(status).body(errorform);
	}
	

}

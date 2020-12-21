package com.friday.adress.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {
	
	@ExceptionHandler(value = {MissingFileException.class})
	public ResponseEntity<Object> handleObjetoNaoEncontradoException(MissingFileException e){
		HttpStatus notFound = HttpStatus.NOT_FOUND;
		ApiException apiException = new ApiException(
				e.getMessage(),
                e, 
				notFound, 
				ZonedDateTime.now(ZoneId.of("Z"))
		);
		return new ResponseEntity<>(apiException, notFound);
	}
	
	@ExceptionHandler(value = {PatternNotFoundException.class})
	public ResponseEntity<Object> handleObjetoNaoEncontradoException(PatternNotFoundException e){
		HttpStatus notFound = HttpStatus.NOT_FOUND;
		ApiException apiException = new ApiException(
				e.getMessage(),
                e, 
				notFound, 
				ZonedDateTime.now(ZoneId.of("Z"))
		);
		return new ResponseEntity<>(apiException, notFound);
	}

}

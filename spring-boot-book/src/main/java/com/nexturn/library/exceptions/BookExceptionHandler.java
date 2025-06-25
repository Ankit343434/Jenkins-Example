package com.nexturn.library.exceptions;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookExceptionHandler {
	@ExceptionHandler(value = BookIdAlreadyExistsException.class)
	public ResponseEntity<String> bookIdAlreadyExistsException(
					BookIdAlreadyExistsException ex){
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = BookNotFoundException.class)
	public ResponseEntity<String> bookNotFoundException(
			BookNotFoundException ex){
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = EmptyResultDataAccessException.class)
	public ResponseEntity<String>deleteBookNotFound(
			EmptyResultDataAccessException ex){
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_IMPLEMENTED);
	}
	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<String> userNotFound(UserNotFoundException ex){
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
}
